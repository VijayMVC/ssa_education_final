appMod

	.controller("SYCtrl", ['$http', '$routeParams', '$location', function($http, $routeParams, $location) {
		var self = this;
		//console.log($routeParams);
		self.id = $routeParams.syId;

		$http.get('http://localhost:8080/school_years/school_year')
			.then(function(resp){
				self.school_years = resp.data;
			},function(err) {

			});

		if(self.id != undefined) {
			$http.get('http://localhost:8080/school_years/school_year/'+self.id)
				.then(function(resp){
					self.school_year = resp.data;
				},function(err) {

				});
		}

		self.clear = function(school_year) {
			school_year.semester = "";
		};

		self.addupdMajor = function(func, id, semester) {
			var school_year = {};
			school_year.id = id;
			school_year.semester = semester;
			
			var method = func == 'add' ? 'POST' : 'PUT';
			$http({
					method: method,
					url: 'http://localhost:8080/school_years/school_year', 
					data: school_year
				})
				.then(function(resp){
					console.log('SUCCESS:', resp);
					$location.path('/school_year');
				},function(err) {
					console.log('FAILURE:', err);
				});
		};

		self.addSchoolYear = function(id, semester) {
			self.addupdMajor('add', id, semester);
		};

		self.updateSchoolYear = function(id, semester) {
			self.addupdMajor('upd', id, semester);
		};

		self.deleteSchoolYear = function(id) {
			$http.delete('http://localhost:8080/school_years/school_year/'+id)
				.then(function(resp){
					console.log("SUCCESS: ", resp);
					$location.path('/school_year');
				},function(err) {
					console.log('FAILURE:', err);
				});

		};

	}]) // end controller
	

;// end all 