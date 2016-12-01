app.controller('PersonController',function($scope,PersonService){
	console.log('entering the controller')
	$scope.categorys;
	$scope.category={c_ID:'',c_Name:'',c_Description:''}
	function fetchAllPersons()
	{
		console.log('entering fetchall persons in controller')
		PersonService.fetchAllPersons()
		.then(
				function(d)
				{
					console.log('entered to d')
					$scope.categorys=d;
				},
				function(error)
				{
					console.log(error);
				}
				)
	}
	fetchAllPersons();
	$scope.save=function()
	{
		console.log('entering function save in category controller')
		//$scope.category-values entered by the client in the form
		PersonService.savePerson($scope.category).then(
		  function(d)
		  {
			  console.log(d.status)
			 // fetchAllPersons();
		  },
		  function(d)
		  {
			  console.log(d.status)
		  });
	}
})