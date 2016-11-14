appMod
	.controller("StudentCtrl", ['$http', '$routeParams', '$location', '$window', 
	function($http, $routeParams, $location, $window) {
		var self = this;
		//console.log($routeParams);
		self.student_data = convertFromJson();
		self.id = self.student_data["id"];

		$http.get('http://localhost:8080/students/student')
			.then(function(resp){
				self.students = resp.data;
			},function(err) {

			});

		$http.get('http://localhost:8080/students/student/'+self.id)
			.then(function(resp){
				self.student = resp.data;

				$http.get("http://localhost:8080/school_years/school_year")
					.then(function(resp) {
						self.semesters = resp.data;	
						self.semesters.selected = self.student.first_semester.id;		
					}, function(err) {
					
					});

				$http.get("http://localhost:8080/majors/major")
					.then(function(resp) {
						self.majors = resp.data;

						if(self.student.major_id == null) {
							self.student.major_id = self.majors[0];
						}

						self.majors.selected = self.student.major_id.id;
					}, function(err) {
						
					});

				},function(err) {

			});

		self.clear = function(student) {
			student.first_name = "";
			student.last_name = "";
			student.first_semester = "";
			student.gpa = "";
		};

		self.addupdStudent = function(func, id, first_name, last_name, first_semester, gpa, major_id) {
			var student = {};
			student.id = id;
			student.first_name = first_name;
			student.last_name = last_name;
			student.first_semester = self.semesters[first_semester-1];
			student.gpa = gpa;
			student.major_id = self.majors[major_id - 1];
			
			var method = func == 'add' ? 'POST' : 'PUT';
			$http({
					method: method,
					url: 'http://localhost:8080/students/student', 
					data: student
				})
				.then(function(resp){
					console.log('SUCCESS:', resp);
					$location.path('/student');
				},function(err) {
					console.log('FAILURE:', err);
				});
		};

		self.addStudent = function(id, first_name, last_name, first_semester, gpa, major_id) {
			self.addupdStudent('add', id, first_name, last_name, first_semester.selected, gpa, major_id.selected);
		};

		self.updateStudent = function(id, first_name, last_name, first_semester, gpa, major_id) {
			console.log("Update student with id=", id, " first_name=", first_name, " last_name=", last_name, 
			" first_semester=", first_semester.selected, " gpa=", gpa, " major_id=", major_id.selected);
			self.addupdStudent('upd', id, first_name, last_name, first_semester.selected, gpa, major_id.selected);
		};

		self.deleteStudent = function(id) {
			$http.delete('http://localhost:8080/students/student/'+id)
				.then(function(resp){
					console.log("SUCCESS: ", resp);
					$location.path('/student');
				},function(err) {
					console.log('FAILURE:', err);
				});
		};

		self.get_first_semester = function(first_semester) {
			if(first_semester == null) {
				return "N/A";
			} else {
				return first_semester.semester;
			}
		}

		self.get_major_description = function(major_id) {
			if(major_id == null) {
				return "General Studies";
			} else {
				return major_id.name;
			}
		}

		self.format_gpa = function(gpa) {
			return gpa.toFixed(2);
		}

		function convertFromJson() {
			if($window.localStorage["student"] != "") {
				return JSON.parse($window.localStorage["student"]);
			} else {
				return "";
			}
		}

			
	}]) // end controller
	

;// end all 