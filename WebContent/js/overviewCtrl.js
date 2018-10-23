app.controller('overviewCtrl', function($scope, $http){
	$scope.newTicket = false;
	$scope.ticket = {
		ticketId: -1,
		userEmail: email,
		title: "",
		description: "",
		active: 1
	};
	
	$scope.startNewTicket = function(){
		$scope.newTicket = !$scope.newTicket;
	};
	
	$scope.submitNewTicket = function(){
		if($scope.ticket.title == "" || $scope.ticket.description == ""){
			alert("Please fill out both title and description. Thank you.");
		}else{
			$.ajax({
				url: "localhost:8080/login_ticketing/rest/authService/ticketing_tickets/" + email + "/ticket",
				type: "POST",
				contentType:"application/json",
				data: JSON.stringify($scope.ticket),
				success: function(data) {
					console.log(data);
				},
				error: function(data) {
					console.log(data);
				}
			});
			
			$scope.startNewTicket();
		}
	}
});