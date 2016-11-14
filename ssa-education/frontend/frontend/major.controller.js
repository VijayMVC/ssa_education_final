appMod

	.controller("MajorCtrl", ['$http', '$routeParams', '$location', function($http, $routeParams, $location) {
		var self = this;
		//console.log($routeParams);
		self.id = $routeParams.majorId;

		$http.get('http://localhost:8080/majors/major')
			.then(function(resp){
				self.majors = resp.data;
			},function(err) {

			});

		if(self.id != undefined) {
			$http.get('http://localhost:8080/majors/major/'+self.id)
				.then(function(resp){
					self.major = resp.data;
				},function(err) {

				});

			$http.get('http://localhost:8080/majors/list_major_classes/' + self.id)
				.then(function(resp) {
					self.class_major = resp.data;
				},function(err){
					
				})
		}

		self.generateClassLink = function(class_id) {
			return "#/class/" + class_id;
		}

		self.addupdMajor = function(func, id, name, req_credits, description) {
			var major = {};
			major.id = id;
			major.name = name;
			major.req_credits = req_credits;
			major.description = description;
			
			var method = func == 'add' ? 'POST' : 'PUT';
			$http({
					method: method,
					url: 'http://localhost:8080/majors/major', 
					data: major
				})
				.then(function(resp){
					console.log('SUCCESS:', resp);
					$location.path('/major');
				},function(err) {
					console.log('FAILURE:', err);
				});
		};

		self.addMajor = function(id, name, req_credits, description) {
			self.addupdMajor('add', id, name, req_credits, description);
		};

		self.updateMajor = function(id, name, req_credits, description) {
			self.addupdMajor('upd', id, name, req_credits, description);
		};

		self.deleteMajor = function(id) {
			$http.delete('http://localhost:8080/majors/major/'+id)
				.then(function(resp){
					console.log("SUCCESS: ", resp);
					$location.path('/major');
				},function(err) {
					console.log('FAILURE:', resp);
				});

		};

	}]) // end controller
	

;// end all 