app.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "index.html"
	}).when("/home", {
		templateUrl : "./templates/home.html"
	}).when("/page2", {
		templateUrl : "./templates/page2.html"
	}).when("/page3", {
		templateUrl : "./templates/page3.html"
	});
});