appMod
	.controller("MainCtrl", ['$http', '$routeParams', '$location', '$window', '$timeout', 
	function($http, $routeParams, $location, $window, $timeout) {
		var self = this;
		self.no_student = false;

		if($window.localStorage["student"] == undefined) {
            $window.localStorage["student"] = ""; 
            }       




		if($window.localStorage["student"] != "") {
			self.student_session = convertToJson();
		} else {
			self.student_session = "";
		}

		self.login_logout_label = "LOGIN"; 

		if(self.student_session != "") {	
			self.login_logout_label = "LOGOUT"
		}

		self.login_logout_link = function() {
			if(self.login_logout_label == "LOGIN") {
				return "#/login";
			} else {
				return "#/logout";
			}
		}

		self.submit = function() {
			console.log(self.username, self.password);
			var account = {};
			account.username = self.username;
			account.password = self.password;

			$http({
				method: "POST",
				url: "http://localhost:8080/accounts/login",
				data: account
			}).then(function(resp){
				self.username = "";
				self.password = "";

				if(resp.data) {
					self.no_student = false;

					$window.localStorage["student"] = JSON.stringify(resp.data); 
					$timeout(function() {
						self.login_logout_label = "LOGOUT";
						$location.path('#');
					}, 0);					
				} else {
					self.no_student = true;
					$("#uname").focus();
				}
			}, function(err){
				console.log("FAILURE:", err);
			})
		}

		self.logout = function() {
			self.login_logout_label = "LOGIN";
			self.student_session = "";
			$window.localStorage["student"] = "";
			$location.path('#');
		}

		self.printName = function() {
			var student_data = convertToJson();

			if(student_data != "") {
				return(student_data["first_name"] + " " + student_data["last_name"]);
			} else {
				return("Guest");
			}
		}

		self.isLoggedIn = function() {
			return ($window.localStorage["student"] != "");
		}

		self.getStudentLink = function() {
			var student_data = convertToJson();
			return "#/student/portal/" + student_data["id"];
		}

		function convertToJson() {
			if($window.localStorage["student"] != "") {
				return JSON.parse($window.localStorage["student"]);
			} else {
				return "";
			}
		}

	}]) // end controller
	

;// end all 