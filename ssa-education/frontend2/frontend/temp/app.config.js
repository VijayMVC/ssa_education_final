appMod

	.config(['$routeProvider', function($routeProvider) {

		$routeProvider
		.when('/', {
			templateUrl: 'views/home.view.html'

		}).when('/student', {
			templateUrl: 'views/students/students.html',
			controller: 'StudentCtrl',
			controllerAs: 'ctrl'

		}).when('/student/:studentId', {
			templateUrl: 'views/students/details.html',
			controller: 'StudentCtrl',
			controllerAs: 'ctrl'

		}).when('/student/portal/:studentId', {
			templateUrl: 'views/students/portal.html',
			controller: 'PortalCtrl',
			controllerAs: 'ctrl'

		}).when('/student/transcript/:studentId', {
			templateUrl: 'views/students/transcript.html',
			controller: 'PortalCtrl',
			controllerAs: 'ctrl'

		}).when('/student/register/:studentId', {
			templateUrl: 'views/students/registration.html',
			controller: 'RegisterCtrl',
			controllerAs: 'ctrl'
			
		}).when('/student/audit/:studentId', {
			templateUrl: 'views/students/audit.html',
			controller: 'AuditCtrl',
			controllerAs: 'ctrl'	

		}).when('/major', {
			templateUrl: 'views/majors/majors.html',
			controller: 'MajorCtrl',
			controllerAs: 'ctrl'	

		}).when('/major/:majorId', {
			templateUrl: 'views/majors/details.html',
			controller: 'MajorCtrl',
			controllerAs: 'ctrl'	

		}).when('/major/classes_for_major/:majorId', {
			templateUrl: 'views/majors/classes_for_major.html',
			controller: 'MajorCtrl',
			controllerAs: 'ctrl'	

		}).when('/school_year', {
			templateUrl: 'views/school_years/school_years.html',
			controller: 'SYCtrl',
			controllerAs: 'ctrl'	

		}).when('/school_year/:syId', {
			templateUrl: 'views/school_years/details.html',
			controller: 'SYCtrl',
			controllerAs: 'ctrl'	

		}).when('/department', {
			templateUrl: 'views/departments/departments.html',
			controller: 'DeptCtrl',
			controllerAs: 'ctrl'	

		}).when('/department/:deptId', {
			templateUrl: 'views/departments/details.html',
			controller: 'DeptCtrl',
			controllerAs: 'ctrl'	

		}).when('/class', {
			templateUrl: 'views/classes/classes.html',
			controller: 'ClassCtrl',
			controllerAs: 'ctrl'	

		}).when('/class/:classId', {
			templateUrl: 'views/classes/details.html',
			controller: 'ClassCtrl',
			controllerAs: 'ctrl'
				
		}).when('/class/prereqs/:classId', {
			templateUrl: 'views/classes/prereqs.html',
			controller: 'ClassCtrl',
			controllerAs: 'ctrl'	

		}).when('/instructor', {
			templateUrl: 'views/instructors/instructors.html',
			controller: 'InstCtrl',
			controllerAs: 'ctrl'	

		}).when('/instructor/:instId', {
			templateUrl: 'views/instructors/details.html',
			controller: 'InstCtrl',
			controllerAs: 'ctrl'	

		}).when('/class_list', {
			templateUrl: 'views/class_list/class_list.html',
			controller: 'CLCtrl',
			controllerAs: 'ctrl'	

		}).when('/class_list/:deptId', {
			templateUrl: 'views/class_list/class_listings_by_department.html',
			controller: 'CLCtrl',
			controllerAs: 'ctrl'	

		}).when('/login', {
			templateUrl: 'views/login.html'
		
		}).when('/logout', {
			templateUrl: 'views/logout.html'
		
		}).when('/about', {
			templateUrl: 'views/about.view.html'
		})
		.otherwise({redirectTo: '/'});

	}]) // end config

; 