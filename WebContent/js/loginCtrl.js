app.controller('loginCtrl', function($scope, $window){
	$scope.user = {email: "", password: ""};
	$scope.login = function(){
		//add login later, for now assume true
		email = $scope.user.email;
		$window.location.href = '/login_ticketing/#!/overview';
	}
});