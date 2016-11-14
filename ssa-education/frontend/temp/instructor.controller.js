appMod

	.controller("InstCtrl", ['$http', '$routeParams', '$location', function($http, $routeParams, $location) {
		var self = this;
		//console.log($routeParams);
		self.id = $routeParams.instId;

		$http.get('http://localhost:8080/instructors/instructor')
			.then(function(resp){
				self.instructors = resp.data;
			},function(err) {

			});

		if(self.id != undefined) {
			$http.get('http://localhost:8080/instructors/instructor/'+self.id)
				.then(function(resp){
					self.instructor = resp.data;

					$http.get('http://localhost:8080/departments/department')
						.then(function(resp) {
							self.departments = resp.data;
							self.departments.selected = self.instructor.department_id.id;

						}, function(err) {
							
						});

				},function(err) {

				});

		}

		self.interpretIsTenured = function(is_tenured) {
			if(is_tenured == "1") {
				return("Professor");
			} else {
				return("Associate Professor");
			}
		};

		self.addupdInstructor = function(func, id, first_name, last_name, year_hired, is_tenured, department_id) {
			var instructor = {};
			instructor.id = id;
			instructor.first_name = first_name;
			instructor.last_name = last_name;
			instructor.year_hired = year_hired;
			instructor.is_tenured = is_tenured;
			instructor.department_id = self.departments[department_id - 1];

			var method = func == 'add' ? 'POST' : 'PUT';
			$http({
					method: method,
					url: 'http://localhost:8080/instructors/instructor', 
					data: instructor
				})
				.then(function(resp){
					console.log('SUCCESS:', resp);
					$location.path('/instructor');
				},function(err) {
					console.log('FAILURE:', err);
				});
		};

		self.addInstructor = function(id, first_name, last_name, year_hired, is_tenured, department_id) {
			self.addupdInstructor('add', id, first_name, last_name, year_hired, is_tenured, department_id.selected);
		};

		self.updateInstructor = function(id, first_name, last_name, year_hired, is_tenured, department_id) {
			self.addupdInstructor('upd', id, first_name, last_name, year_hired, is_tenured, department_id.selected);
		};

		self.deleteInstructor = function(id) {
			$http.delete('http://localhost:8080/instructors/instructor/'+id)
				.then(function(resp){
					console.log("SUCCESS: ", resp);
					$location.path('/instructor');
				},function(err) {
					console.log('FAILURE:', err);
				});

		};

	}]) // end controller
	

;// end all 