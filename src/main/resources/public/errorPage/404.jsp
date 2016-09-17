<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<link rel="stylesheet" href="<%= path%>/static/bootstrap 3.3.5/css/bootstrap.min.css">
		<style type="text/css">
			body{
				background-color: #f5f5f5;	
			}
		</style>
	</head>
	<body>
		<div class="jumbotron well">
		  <div class="alert alert-danger" role="alert"><h1>${title }</h1>
		  <p>${msg }</p></div>
		  <p><a class="btn btn-info" href="<%=path%>/app/index" role="button">回到首页</a></p>
		</div>
	</body>
</html>

