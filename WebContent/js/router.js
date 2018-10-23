var email;

var app = angular.module("ticketing", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "templates/login.htm",
		controller: "loginCtrl"
    })
    .when("/overview", {
        templateUrl : "templates/overview.htm",
		controller: "overviewCtrl"
    });
});