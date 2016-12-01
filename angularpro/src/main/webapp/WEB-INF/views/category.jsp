<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<title>Category Page</title>
</head>
<body>
<div ng-app="myApp" ng-controller="namesCtrl">
<div class="container-fluid" style="align:center; margin: 40px 0px 0px 150px" >
<div class="col-md-4">
  <div class="row-fluid">
   <div class="span12">
   

<h2><center>ADD CATEGORY</center></h2>
<c:url var="addAction"  value="/category/add"></c:url>

<form:form action="${addAction }" commandName="category">
<table class="table table-condensed">
	<tr bgcolor=#F0F8FF>
		<td><form:label style="color:#000000" path="c_ID"><spring:message text="CATEGORY_ID"/></form:label></td>
		
		
		<c:choose>
			<c:when test="${!empty category.c_ID }">
				<td><form:input ng-model="CATEGORY_ID" class="form-control" style="background-color:#F5F5DC;border:0.25px solid black" path="c_ID" disabled="true" readonly="true"/></td>
			</c:when>
			<c:otherwise>
				<td><form:input ng-model="CATEGORY_ID" class="form-control" style="background-color:#F5F5DC;border:0.25px solid black" path="c_ID"  pattern=".{4,7}" required="true" title="id should be between 4 to 7 characters"/></td>
			</c:otherwise>
		</c:choose>
	 </tr>
				
				<tr bgcolor="#F0F8FF"> 
				<form:input path="c_ID" hidden="true"/>
				
				<td><form:label style="color:#000000" path="c_Name"> <spring:message text="CATEGORY_NAME"/></form:label></td>
        		<td><form:input ng-model="CATEGORY_NAME" class="form-control" style="background-color:#F5F5DC;border:0.25px solid black" path="c_Name" required="true" /></td> 
				</tr>
				
				<tr bgcolor="#F0F8FF">
				<td><form:label style="color:#000000" path="c_Description" ><spring:message text="CATEGORY_DESCRIPTION"/></form:label></td>
				<td><form:input ng-model="CATEGORY_DESCRIPTION" class="form-control" style="background-color:#F5F5DC;border:0.25px solid black" path="c_Description" required="true"/></td>
				</tr>
				
				<tr bgcolor="#F0F8FF">
				<td align="right" colspan="2"><c:if test="${!empty category.c_Name }">
									<input style= "align:middle" class="btn btn-primary btn-md" type="submit" value="<spring:message text="Edit Category"/>"/>
								</c:if>
								<c:if test="${empty category.c_Name }">
									<input style= "align:middle" ng-click="add()" class="btn btn-primary btn-md" type="submit" value="<spring:message text="Add Category"/>"/>
								</c:if>
				</td>
				</tr> 
</table>
</form:form>
</div>

	</div>
	</div>
	</div>
<br>
<div class="container" >
<h1>Search tag</h1>
<p><input type="text" ng-model="test"></p>
<h3><center>CATEGORY LIST</center></h3>
<br>
<script>
angular.module('myApp', []);
app.controller('namesCtrl', function($scope,$http) {
	    $scope.names=[];
	    $http.get("${categoryList}").success(function(result)
	    {
	    	$scope.names=result;
	    });
	      $scope.add = function(){
			$scope.names.push({ 'CATEGORY_ID':$scope.CATEGORY_ID, 'CATEGORY_NAME': $scope.CATEGORY_NAME, 'CATEGORY_DESCRIPTION':$scope.CATEGORY_DESCRIPTION });
			
			CATEGORY_ID=$scope.CATEGORY_ID;
			CATEGORY_NAME=$scope.CATEGORY_NAME;
			CATEGORY_DESCRIPTION=$scope.CATEGORY_DESCRIPTION;
	               };   
	               
	              
	               
	            
});
</script>
	<table  class="table" align="center" bordercolor="#800080" BORDER=10>
	<thead>
			<tr bgcolor="#F0F8FF">
				<th class="CATEGORY_ID" style="color:black" width="125" bgcolor="#F0F8FF" align="center"><a href="" ng-click="orderByField='CATEGORY_ID'; reverseSort = !reverseSort">CATEGORY_ID</a></th>
				<th class="CATEGORY_NAME" style="color:black" width="125" align="center"><a href="" ng-click="orderByField='CATEGORY_NAME'; reverseSort = !reverseSort">CATEGORY_NAME</a></th>
				<th class="CATEGORY_DESCRIPTION" style="color:black" width="190" align="center"><a href="" ng-click="orderByField='CATEGORY_NAME'; reverseSort = !reverseSort">CATEGORY_DESCRIPTION</a></th>
				<th style="color:black" width="100" align="center">EDIT</th>
				<th style="color:black" width="100" align="center">DELETE</th> 
			</tr>
			</thead>
			<tbody>
					<!--<c:forEach items="${categoryList}" var="category"> -->
				<tr bgcolor="#FFFFFF" ng-repeat="x in names |filter:test | orderBy:orderByField:reverseSort">
					<td  style="color:#000000;font-size:120%" align="center">{{x.CATEGORY_ID}}</td>
					<td  style="color:#000000;font-size:120%" align="center">{{x.CATEGORY_NAME}}</td>
					<td style="color:#000000;font-size:120%" align="center">{{x.CATEGORY_DESCRIPTION}}</td>
					<td style="color:#000000;font-size:120%" align="center"><a href="<c:url value='category/edit/${category.c_ID}' />"><button type="button" class="btn btn-warning">Edit</button></a></td>
					<td style="color:#000000;font-size:120%" align="center"><a href="<c:url value='category/remove/${category.c_ID}' />"><button type="button" class="btn btn-danger">Delete</button></a></td> 
				</tr>
				</tbody>
			<!--</c:forEach> -->
		</table>

	</div>

</div>

</body>
</html>