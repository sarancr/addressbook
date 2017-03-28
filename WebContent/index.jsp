<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="com.adb.model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Address Book Application</title>
<link href="resources/css/app.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div id="header">
	<h1 id="logo">AddressBook</h1>
</div>
<form method="post" action="logon.do" id="logon-form">

	<div id="row">
		 <div id="label">Login name:</div>
		<input type="text" name="logonName"/>
	</div>

	<div id="row">
		<div id="label">Password:</div>
		<input type="password" name="password"/>
	</div>

	<div>
	<input type="submit"/>
	</div>

	<div id="err-row" >
		${message}
	</div>

</form>
</body>
</html>
