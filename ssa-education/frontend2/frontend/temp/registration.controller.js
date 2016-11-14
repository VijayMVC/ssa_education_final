appMod
	.controller("RegisterCtrl", ['$http', '$routeParams', '$location', '$timeout', '$window', '$scope',
	function($http, $routeParams, $location, $timeout, $window, $scope) {
		var self = this;
		self.id = $routeParams.studentId;
		self.show_class = false;
		self.search_class = false;
		self.conflict = false;

		self._classes = [];
		self.added_classes = [];
		self.total_classes_semester = [];
		self.semester_student_classes_taken_list = [];
		self.semester_class_list = [];
		self.nums;

		// Load the classes. User first chooses the department, which then loads the class numbers,
		// which finall loads the section numbers
		$http.get("http://localhost:8080/departments/department")
			.then(function(resp) {
				
				self.departments = resp.data;

				clearByClass();
				$("#department").change(function(){
					
					$http.get("http://localhost:8080/classes/class_by_department_current/" + self.selected_department + "/" + self.id)
						.then(function(resp) {
							self.nums = resp.data;

							$("#nums").change(function() {
						
								$http.get("http://localhost:8080/class_list/sections_by_class_id/" + self.selected_num)
									.then(function(resp) {
										self.sections = resp.data;
										$("#sect").change(function() {
											
										})
									});
							});
						});
				});

			}, function(err) {
						
			});

		// Gets all the classes taken by the student
		$http.get("http://localhost:8080/academics/student/" + self.id)
			.then(function(resp) {
				self.classes_taken = resp.data;
			});

		// Gets the classes the student has registered for in the current semester
		$http.get("http://localhost:8080/academics/student_semester/" + self.id)
			.then(function(resp) {
				self.semester_student_classes_taken_list = resp.data;
				getSemesterClasses(self.semester_student_classes_taken_list);
			});


		// Clicking the "Search For Class" button		
		self.submit = function() {
			self.show_class = false;
			self.show_crn_not_found = false;
			self.show_repeat = false;

			// If searching by class
			if(self.search_class) {
				if(self.selected_sect == "") { self.selected_sect = 0; }

				$http.get("http://localhost:8080/class_list/" + self.selected_sect)
					.then(function(resp) {
						self._class = resp.data;

						if(self._class) { self.show_class = true; console.log("Search by class", self._class); } 					
					}, function(err) {
						console.log("No CRN found!");
					});

			} else { // If searching by crn
				if(self.crn == undefined) { self.crn = 0; }

				$http.get("http://localhost:8080/class_list/class_by_crn/" + self.crn)
					.then(function(resp){
						self._class = resp.data;
						if(self._class) { 
							self.show_class = true; 
							console.log("Search by crn", self._class); 
						} else {
							self.show_crn_not_found = true;
						}	
					});
			}
			
		}

		self.print_days = function(mon, tues, wed, thurs, fri, sat, onl) {
			return printDays(mon, tues, wed, thurs, fri, sat, onl);	
		}

		self.parse_time = function(begin, end) {
			return parseTime(begin, end);
		}

		// Adds the searched class into the student's temporary class queue.
		// Also clears out the crn and resets the class search dropdowns
		$("#enroll_button").click(function() {

			$timeout(function() {
				var conflicting_class_registered;
				var conflicting_class_potential;

				var conflicting_classes = {};
				conflicting_classes["registered"] = checkForTimeConflicts(self.semester_class_list, self._class, false);
				conflicting_classes["added"] = checkForTimeConflicts(self.added_classes, self._class, true);
				var data_string = conflictingClassesString(conflicting_classes["registered"], conflicting_classes["added"]);

				var conf = true;
				var sct_delete_list = [];

				console.log("conflicting classes", conflicting_classes);

				if(checkForRepeats(self.added_classes, self._class)) {
					self.show_repeat = true;	
				} else if(conflicting_classes["registered"].length > 0 || conflicting_classes["added"].length > 0) {
					conf = confirm("Adding this class to the current schedule would cause a time conflict. Replace:\n\n" +
										data_string);
					if(conf) {
						// delete from the database
						if(conflicting_classes["registered"].length > 0) {
							deleteFromDb(conflicting_classes["registered"])							
						}

						if(conflicting_classes["added"].length > 0) {
							deleteFromAdded(conflicting_classes["added"]);
						}

						self.added_classes.push(self._class);
					} 
				} else {
					self.added_classes.push(self._class);
				}


				clear();
			}, 0);
		});

		// Removes the selected class from the temporary class queue.
		// User is prompted to confirm the removal.
		$(document).on('click', "button.remove", function() {
			var proceed = confirm("Are you sure that you want to delete this class? This action cannot be undone.");
					
			if(proceed) {
 		   		var currRow = $(this).closest("tr");       
    			var currCrn = currRow.find("td").eq(1).text();
			    		
				$timeout(function() {
					self.added_classes.splice(searchAddedCoursesForIndex(self.added_classes, currCrn, true), 1);
				}, 0);
			}
		});

		// Searches by CRN (Course Registration Number) and clears and disables the 
		// class dropdown lists
		$("#by_crn").click(function(){
			$timeout(function(){
    			self.search_class = false;
    			clearByClass();
			}, 0);
		});

		// Searches by class and clears and disables the crn text field
		$("#by_class").click(function(){
			$timeout(function(){
    			self.search_class = true;
    			clearByCrn();
			}, 0);
		});

		// Takes the classes found in the student's temporary queue and attempts to add
		// them to the schedule, one by one.
		//
		// 1) Search for repeats - students are not allowed to repeat classes already taken from
		//    previous semesters or the current semester.
		// 2) Will not add a class that conflicts timewise with another class
		// 3) Will not add a class where the prerequisites are not met
		$("#register").click(function(){
			var semester_sct = [];
			var student = JSON.parse($window.localStorage["student"]);

			for(var idx = 0; idx < self.added_classes.length; idx++) {
				semester_sct.push({
					"student_id": student,
					"class_list_id": self.added_classes[idx],
					"grade": null
				})
			}

			console.log("Registering", semester_sct);

			$http({
				method: "POST",
				url: 'http://localhost:8080/academics', 
				data: semester_sct
				}).then(function(resp){
					console.log('SUCCESS:', resp);
					$location.path('/student/portal/' + student["id"]);
				},function(err) {
					console.log('FAILURE:', err);
				});			
		});

		function conflictingClassesString(registered, added) {
			var ccs = "";

			for(var idx = 0; idx < registered.length; idx++) {
				ccs += "Course #" + registered[idx].crn + ": " + 
									registered[idx].class_id.department_id.code + " " +
									registered[idx].class_id.num;
				if((idx < registered.length - 1) || added.length > 0) {
				//((idx < registered.length - 2) && added.length == 0)) {
					ccs += "\n";
				}
			}

			for(var idx = 0; idx < added.length; idx++) {
				ccs += "Course #" + added[idx].crn + ": " + 
									added[idx].class_id.department_id.code + " " +
									added[idx].class_id.num;
				if(idx < added.length - 1) {
					ccs += "\n";
				}
			}

			ccs += "?";

			return ccs;
		}

		function deleteFromDb(registered) {
			var sct_delete_list = deleteFromClassList(registered, false);

			if(sct_delete_list.length > 0) {
				var delete_string = "";
				for(var idx = 0; idx < sct_delete_list.length; idx++) {
					delete_string += sct_delete_list[idx];

					if(idx < sct_delete_list.length - 1) {
						delete_string += ",";
					}
				}

				console.log("Data string is", delete_string);

				$http({
					method: "DELETE",
					url: 'http://localhost:8080/academics/' + delete_string
				}).then(function(resp){
					console.log('SUCCESS:', resp);
					
				},function(err) {
					console.log('FAILURE:', err);
				});
			}	
		}

		function deleteFromAdded(added) {
			deleteFromClassList(added, true);
		}

		function deleteFromClassList(classes, isAddedClass) {
			var delete_list = [];

			for(var idx = 0; idx < classes.length; idx++) {
				var erase_index;

				if(isAddedClass) {
					erase_index = searchAddedCoursesForIndex(self.added_classes, classes[idx].crn, true);
					self.added_classes.splice(erase_index, 1);
				} else {
					erase_index = searchAddedCoursesForIndex(self.semester_class_list, classes[idx].crn, false);
					delete_list.push(self.semester_class_list[erase_index].id);
					self.semester_class_list.splice(erase_index, 1);
				}
			}

			return delete_list;
		}

		function clear() {
			self.show_class = false;
			self.selected_sect = 0;
			
			clearByCrn();
			clearByClass();
		}

		function clearByCrn() {
			self.crn = "";
		}		

		function clearByClass() {
    		self.selected_department = "";
    		self.selected_num = "";
    		self.selected_sect = "";

    		$("#nums").empty();
    		$("#sect").empty();
		}

		// Combines any previously registered classes with the list of added classes
		// Needed to detect time conflicts
		function getSemesterClasses(previouslyRegistered) {
			self.semester_class_list = [];

			for(var idx = 0; idx < previouslyRegistered.length; idx++) {
				self.semester_class_list.push({
					"id": previouslyRegistered[idx].id,
					"class": previouslyRegistered[idx].class_list_id
				});
			}
		}

	}]) // end controller
	

;// end all 

// Check for repeats
function checkForRepeats(classes_taken, _class) {
	for(var idx = 0; idx < classes_taken.length; idx++) {
		if(classes_taken[idx].class_id.id == _class.class_id.id) {
			return true;
		}
	}

	return false;
}

// Check for time conflicts
function checkForTimeConflicts(_classes, _class, isAddedClass) {
	var conflicted_class_list = [];
	
	for(var idx = 0; idx < _classes.length; idx++) {
		if(isAddedClass && doDaysOverlap(_classes[idx], _class) && 
		   doesTimeConflictExist(_classes[idx], _class) && 
		   (_class.crn != _classes[idx].crn)
		) {
			conflicted_class_list.push(_classes[idx]);
		} else if(!isAddedClass && doDaysOverlap(_classes[idx].class, _class) && 
		   doesTimeConflictExist(_classes[idx].class, _class) && 
		   (_class.crn != _classes[idx].class.crn)) {
			conflicted_class_list.push(_classes[idx].class);	
		}
	}

	return conflicted_class_list;
}

function doDaysOverlap(_class1, _class2) {
	return (
		(_class1.mon == true && _class2.mon == true) ||
		(_class1.tues == true && _class2.tues == true) ||
		(_class1.wed == true && _class2.wed == true) ||
		(_class1.thurs == true && _class2.thurs == true) ||
		(_class1.fri == true && _class2.fri == true) ||
		(_class1.sat == true && _class2.sat == true)
	);
}

function doesTimeConflictExist(_class1, _class2) {
	var _class1_begin = new Date("December 12, 1981 " + _class1.begin_time);
	var _class1_end = new Date("December 12, 1981 " + _class1.end_time);
	var _class2_begin = new Date("December 12, 1981 " + _class2.begin_time);
	var _class2_end = new Date("December 12, 1981 " + _class2.end_time);

	return !(
		(_class1_begin > _class2_end) || (_class1_end < _class2_begin)
	);
}

// Used for finding which row to remove from the temporary class queue 
function searchAddedCoursesForIndex(courses, crn, isAddedClass) {
	for(var idx = 0; idx < courses.length; idx++) {
    	if(isAddedClass && courses[idx].crn == crn) {
    		return idx;
    	} else if(!isAddedClass && courses[idx].class.crn == crn) {
    		return idx;
    	}
    }

    return -1;
}



