appMod
	.controller("AuditCtrl", ['$http', '$routeParams', '$location', '$window', function($http, $routeParams, $location, $window) {
		var self = this;
		self.student_data = convertFromJson();

		self.id = self.student_data["id"];

		$http.get("http://localhost:8080/students/student/" + self.id)
			.then(function(student_resp) {
				self.student = student_resp.data;

				getMajorCoursesCompleted();
				getElectiveCoursesCompleted();	
				getMajorCoursesInProgress();
				getMajorCoursesRemaining();
			});
		
		self.showMcc = function() {
			return self.major_courses_completed.length > 0;
		}

		self.showEcc = function() {
			return self.elective_courses_completed.length > 0;
		}

		self.showMcip = function() {
			return self.major_courses_in_progress.length > 0;
		}

		self.showMcr = function() {
			return self.major_courses_remaining.length > 0;
		}

		function getMajorCoursesCompleted() {
			$http.get("http://localhost:8080/academics/student_major_classes_completed/" + self.student.id)
				.then(function(major_courses_completed_resp) {
					self.major_courses_completed = major_courses_completed_resp.data;
				});
		}

		function getElectiveCoursesCompleted() {
			$http.get("http://localhost:8080/academics/student_elective_classes_completed/" + self.student.id)
				.then(function(elective_courses_completed_resp) {
					self.elective_courses_completed = elective_courses_completed_resp.data;
				});
		}

		function getMajorCoursesInProgress() {
			$http.get("http://localhost:8080/academics/student_major_classes_in_progress/" + self.student.id)
				.then(function(major_courses_in_progress_resp) {
					self.major_courses_in_progress = major_courses_in_progress_resp.data;
				});
		}

		function getMajorCoursesRemaining() {
			$http.get("http://localhost:8080/majors/list_major_classes_remaining/" + self.id)
				.then(function(major_courses_remaining_resp) {
					self.major_courses_remaining = major_courses_remaining_resp.data;
				});
		}

		function convertFromJson() {
			if($window.localStorage["student"] != "") {
				return JSON.parse($window.localStorage["student"]);
			} else {
				return "";
			}
		}

	}]) // end controller
	


