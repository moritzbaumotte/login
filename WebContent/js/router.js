var email = "";

var app = angular.module("ticketing", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "templates/login.htm",
		controller: "loginCtrl"
    })
    .when("/overview", {
        templateUrl : "templates/overview.htm",
        resolve: {
        	check: function($window){
        		if(email != ""){
        			//all good
        		}else{
        			alert("Please login first.");
        			$window.location.href = "/login_ticketing/#!/";
        		}
        	}
        },
		controller: "overviewCtrl"
    });
});