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
  <div id="right">
    <span class="wlcm-txt">Welcome Sarav!</span>
    <a href="signout.do" id="link">SignOut</a>
  </div>
</div>

<div id="menubar">
  <a href="welcome.do" id="link" style="margin-top:15px;display:inline-block;">Home</a>
  <a href="addcontact.do" id="link" style="margin-top:15px;display:inline-block;">Add Contact</a>
</div>

<form method="post" action="savecontact.do" id="contact-form">
	<div id="row">
		 <div id="label">First name:</div>
		<input type="text" name="firstname" value="${contact.firstname}"/>
		<input type="hidden" name="id" value="${contact.id}"/>
	</div>

	<div id="row">
		 <div id="label">Last name:</div>
		<input type="text" name="lastname" value="${contact.lastname}"/>
	</div>
	
	<div id="row">
		 <div id="label">Email:</div>
		<input type="text" name="email" value="${contact.email}"/>
	</div>

	<div id="row">
		 <div id="label">Address:</div>
		<input type="text" name="address" value="${contact.address}"/>
	</div>
	
	<div id="row">
		 <div id="label">Phone:</div>
		<input type="text" name="phone" value="${contact.phone}"/>
	</div>

	<div>
	<input type="submit"/>
	</div>

</form>
</body>
</html>
