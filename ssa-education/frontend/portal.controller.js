appMod
	.controller("PortalCtrl", ['$http', '$routeParams', '$location', '$timeout', '$window', 
	function($http, $routeParams, $location, $timeout, $window) {
		var self = this;

		self.student_data = convertFromJson();
		self.id = self.student_data["id"];
		console.log(self.id);

		//self.schedule = "";
		//self.course_list_ids = "";

		$http.get('http://localhost:8080/students/student/' + self.id)
			.then(function(student_data) {
				self.student = student_data.data;

				$http.get('http://localhost:8080/school_years/semesters_since/' + self.student.first_semester.id)
					.then(function(semester_data) {
						self.semesters = semester_data.data;

						self.transcript = [];
						$http.get('http://localhost:8080/academics/student/' + self.id)
							.then(function(classes_taken_data) {
								self.classes_taken = classes_taken_data.data;
								
								self.semester_array = [];
								for(var idx = 0; idx < self.semesters.length; idx++) {										
									self.semester_array[self.semesters[idx].semester] = [];
								}
									
								for(var idx = 0; idx < self.classes_taken.length; idx++) {
									var course_name = self.classes_taken[idx].class_list_id.class_id.department_id.code +
										" " + self.classes_taken[idx].class_list_id.class_id.num;

									self.semester_array[self.classes_taken[idx].class_list_id.semester.semester].push(
										{
											"crn": self.classes_taken[idx].class_list_id.crn,
											"course": course_name,
											"name": self.classes_taken[idx].class_list_id.class_id.name,
											"section": self.classes_taken[idx].class_list_id.sect,
											"credits": self.classes_taken[idx].class_list_id.class_id.credits,
											"grade": self.classes_taken[idx].grade
										}					
									);
								}


								for(var idx = 0; idx < self.semesters.length; idx++) {
									var gpaStats = calculateGpa(self.semester_array[self.semesters[idx].semester]);

									self.transcript.push(
										{
											"semester": self.semesters[idx].semester,
											"courses": self.semester_array[self.semesters[idx].semester],
											"sem_gpa": gpaStats["sem_gpa"],
											"sem_points": gpaStats["sem_points"],
											"sem_credits": gpaStats["sem_credits"]
										}

									);
								}

								console.log(self.transcript);	
								self.cumm_gpa = calculateCummulativeGpa(self.semester_array, self.semesters)["cummulative_gpa"];

								if(self.student.gpa != self.cumm_gpa) {
									console.log("GPA needs to be updated!");
									self.student.gpa = self.cumm_gpa;

									$http({
										method: "PUT",
										url: "http://localhost:8080/students/student",
										data: self.student
									});
								}
									
								self.calculate_total_points = function() {
									return calculateCummulativeGpa(self.semester_array, self.semesters)["total_points"];
								}

								self.calculate_total_credits = function() {
									return calculateCummulativeGpa(self.semester_array, self.semesters)["total_credits"];
								}

								self.calculate_cummulative_gpa = function() {
									return calculateCummulativeGpa(self.semester_array, self.semesters)["cummulative_gpa"];									
								}
								
								self.print_class_name = function(_class_name) {
									return formatClassName(_class_name);
								}

								self.print_days = function(mon, tues, wed, thurs, fri, sat, onl) {
									return printDays(mon, tues, wed, thurs, fri, sat, onl);	
								}

								self.parse_time = function(begin, end) {
									return parseTime(begin, end);
								}

								self.print_room = function(classroom) {
									return formatClassroom(classroom);
								}

								self.print_seats = function(classroom) {
									return formatSeats(classroom, self.num_enrolled);
								}

								self.print_instructor = function(instructor) {
									return formatInstructor(instructor);
								}
				
																
							});
					});
			});


		$http.get("http://localhost:8080/academics/student_semester/" + self.id)
			.then(function(resp) {
				self.schedule = [];
				self.course_list_ids = [];

				for(var idx = 0; idx < resp.data.length; idx++) {
					self.schedule.push(resp.data[idx].class_list_id);
					self.course_list_ids.push(resp.data[idx].id);
				}

				console.log(self.schedule);
			});

		self.showSchedule = function() {
			if(self.schedule == undefined) { return 0; }
			else { return self.schedule.length > 0 };
		}				
		
		self.print_days = function(mon, tues, wed, thurs, fri, sat, onl) {
			return printDays(mon, tues, wed, thurs, fri, sat, onl);
		}

		self.parse_time = function(begin, end) {
			return parseTime(begin, end);
		}

		self.print_grade = function(grade) {
			if(grade != null) {
				return grade;
			} else {
				return "NG";
			}
		}

		function convertFromJson() {
			if($window.localStorage["student"] != "") {
				return JSON.parse($window.localStorage["student"]);
			} else {
				return "";
			}
		}

	}]); // end controller

	function calculateGpa(courses) {
		var total_credits = 0;
		var total_points = 0;

		var gpaInfo = [];

		for(var idx = 0; idx < courses.length; idx++) {
			var credits = courses[idx].credits;
			var grade = courses[idx].grade;
			var grade_value;

			if(grade == "A") { grade_value = 4; }
			else if(grade == "B") { grade_value = 3; }
			else if(grade == "C") { grade_value = 2; }
			else if(grade == "D") { grade_value = 1; }
			else if(grade == "F") { grade_value = 0; }
			else                  { grade_value = 0; credits = 0; }

			total_points += (grade_value * credits);
			total_credits += credits;
		}

		var gpa;

		if(isNaN(total_points)) {
			total_points = 0;
			total_credits = 0;
			gpa = 0;
		} else if(total_credits != 0) {
			gpa = total_points / total_credits;
		} else {
			gpa = 0;
		}

		gpaInfo["sem_points"] = total_points;
		gpaInfo["sem_credits"] = total_credits;
		gpaInfo["sem_gpa"] = gpa.toFixed(2);

		//return gpa.toFixed(2);
		return gpaInfo;
	}

	function calculateCummulativeGpa(all_courses, semesters) {
		var total_credits = 0;
		var total_points = 0;

		var gpa_stats;
		var cummulative_gpa;
		var cummulative_gpa_stats = [];

		console.log(semesters);
		for(var idx = 0; idx < semesters.length - 1; idx++) {
			gpa_stats = calculateGpa(all_courses[semesters[idx].semester]);
			total_credits += gpa_stats["sem_credits"];
			total_points += gpa_stats["sem_points"];
		}

		if(total_credits != 0) {
			cummulative_gpa = total_points / total_credits;
		} else {
			cummulative_gpa = 0;
		}

		cummulative_gpa_stats["cummulative_gpa"] = cummulative_gpa.toFixed(2);
		cummulative_gpa_stats["total_points"] = total_points;
		cummulative_gpa_stats["total_credits"] = total_credits;

		console.log(cummulative_gpa_stats);

		return cummulative_gpa_stats;
	}

	function generateTranscriptV1(classes_taken) {
		transcriptV1 = [];

		for(var idx = 0; idx < classes_taken.length; idx++) {
			var curr_semester = classes_taken[idx].class_list_id.semester.semester;

			var classes_semester = [];

			while(idx < classes_taken.length && (curr_semester == 
				classes_taken[idx].class_list_id.semester.semester)) 
			{
				var course_name = classes_taken[idx].class_list_id.class_id.department_id.code +
										" " + classes_taken[idx].class_list_id.class_id.num;
				classes_semester.push(
					{
						"crn": classes_taken[idx].class_list_id.crn,
						"course": course_name,
						"name": classes_taken[idx].class_list_id.class_id.name,
						"section": classes_taken[idx].class_list_id.sect,
						"credits": classes_taken[idx].class_list_id.class_id.credits,
						"grade": classes_taken[idx].grade
					});

				if((idx+1) < classes_taken.length && (curr_semester == classes_taken[idx+1].class_list_id.semester.semester)) {	
					idx++;
				} else {
					break;
				}
			}

			transcriptV1.push(
				{
					"semester": curr_semester,
					"courses": classes_semester										
				}
			);
		}

		console.log(transcriptV1);
		return transcriptV1;
	}

	function generateFinalTranscript(semesters, transcriptV1) {
		var transcriptV2 = [];

		for(var idx = 0; idx < semesters.length; idx++) {
			var curr_semester = semesters[idx].semester;
			transcriptV2.push(semesterPresent(transcriptV1, curr_semester));
		}			

		return transcriptV2;
	}

	function semesterPresent(transcript, semester) {
		for(var idx = 0; idx < transcript.length; idx++) {
			if(semester == transcript[idx].semester) {
				return transcript[idx];
			}				
		}

		return {"semester": semester};
	}

;// end all 