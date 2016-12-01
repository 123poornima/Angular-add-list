app.factory('PersonService',function($http){
	var BASE_URL="http://localhost:8080/angularpro";
	var personService=this;
	personService.fetchAllPersons=function(){
		console.log('entering fetchallpersons in service')
		return $http.get("http://localhost:8080/angularpro/category")
		.then(function(response){
			//response is an object returened from the back end
			//data,status,headers,statustext
			//data-list of person
			console.log(response.data)
			console.log(response.status)
			return response.data
		},
		function(response)
		{
			console.log(response.data)
			return response.data
		})
	};
	personService.savePerson=function(category){
		console.log('entering save category in service')
		return $http.post(BASE_URL+"/category/add",category)
		.then(function(response){
			console.log(response.status)
			console.log(response.headers)
			return response.status
		},function(response){
			console.log(response.status)
			return response.status
		})
	}
	return personService;
})