appMod

	.controller("CLCtrl", ['$http', '$routeParams', '$location', function($http, $routeParams, $location) {
		var self = this;
		//console.log($routeParams);
		self.id = $routeParams.deptId;

		$http.get('http://localhost:8080/class_list')
			.then(function(resp){
				self.class_list = resp.data;
				//console.log(self.class_list);

				self.print_days = function(mon, tues, wed, thurs, fri, sat, onl) {
					return printDays(mon, tues, wed, thurs, fri, sat, onl);
				}

				self.parse_time = function(begin, end) {
					return parseTime(begin, end);
				}

			},function(err) {

			});

		if(self.id != undefined) {
			$http.get("http://localhost:8080/class_list/list_by_department/" +self.id)
				.then(function(resp){
					self.class_listing = resp.data;

					var old_class = "";
					var new_class = "";
					var class_nums = [];
					var class_name;
				
					self.department_class_listing = [];
					
					var idx = 0;
					while(idx < self.class_listing.length) {
						var sections = [];
						new_class = self.class_listing[idx];

						if(old_class != new_class.class_id.id) {
							old_class = new_class.class_id.id;
							class_name = new_class.class_id.department_id.code + ' ' + new_class.class_id.num
						}
					
						while(idx < self.class_listing.length && (old_class == new_class.class_id.id)) {
							sections.push(new_class);
							idx++;
							if(idx < self.class_listing.length) {
								new_class = self.class_listing[idx];
							}
						}

						self.department_class_listing.push({
							"name": class_name,
							"sections": sections
						});
					}

					console.log(self.department_class_listing);

				},function(err) {

				});			
		}

		self.print_days = function(mon, tues, wed, thurs, fri, sat, onl) {
			return printDays(mon, tues, wed, thurs, fri, sat, onl);
		}

		self.parse_time = function(begin, end) {
			return parseTime(begin, end)
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
	



function formatAMPM(date) {
  var hours = date.getHours();
  var minutes = date.getMinutes();
  var ampm = hours >= 12 ? 'pm' : 'am';
  hours = hours % 12;
  hours = hours ? hours : 12; // the hour '0' should be '12'
  minutes = minutes < 10 ? '0'+minutes : minutes;
  var strTime = hours + ':' + minutes + ' ' + ampm;
  return strTime;
}

