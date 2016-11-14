appMod

	.controller("DeptCtrl", ['$http', '$routeParams', '$location', function($http, $routeParams, $location) {
		var self = this;
		//console.log($routeParams);
		self.id = $routeParams.deptId;

		$http.get('http://localhost:8080/departments/department')
			.then(function(resp){
				self.departments = resp.data;
			},function(err) {

			});

		if(self.id != undefined) {
			$http.get('http://localhost:8080/departments/department/'+self.id)
				.then(function(resp){
					self.department = resp.data;

					},function(err) {

				});

		}

		self.clear = function(department) {
			department.code = "";
			department.name = "";
		};

		self.addupdDepartment = function(func, id, code, name) {
			var department = {};
			department.id = id;
			department.code = code;
			department.name = name;

			var method = func == 'add' ? 'POST' : 'PUT';
			$http({
					method: method,
					url: 'http://localhost:8080/departments/department', 
					data: department
				})
				.then(function(resp){
					console.log('SUCCESS:', resp);
					$location.path('/department');
				},function(err) {
					console.log('FAILURE:', err);
				});
		};

		self.addDepartment = function(id, code, name) {
			self.addupdDepartment('add', id, code, name);
		};

		self.updateDepartment = function(id, code, name) {
			self.addupdDepartment('upd', id, code, name);
		};

		self.deleteDepartment = function(id) {
			$http.delete('http://localhost:8080/departments/department/'+id)
				.then(function(resp){
					console.log("SUCCESS: ", resp);
					$location.path('/department');
				},function(err) {
					console.log('FAILURE:', err);
				});

		};

	}]) // end controller
	

;// end all 