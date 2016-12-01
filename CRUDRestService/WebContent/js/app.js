var app=angular.module('myApp',['ngRoute'])
app.config(function($routeProvider){
	console.log('entering app configuration')
	$routeProvider
	.when('/createPerson',{
		controller:'PersonController',
		templateUrl:'pages/createPersons.html'
	})
	.when('/listOfPerson',{
		controller:'PersonController',
		templateUrl:'pages/ListOfPersons.html'
	})
	.when('/',{templateUrl:'pages/home.html'})
})