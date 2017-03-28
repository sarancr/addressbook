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
  <a href="addcontact.do" id="link" style="margin-top:15px;display:inline-block;">Add Contact</a>
</div>

<div id="content">
  <table>
    <tr>
      <th>Name</th>
      <th>Edit</th>
      <th>Delete</th>
    </tr>
    <c:forEach var="contact" items="${contacts}">
	     <tr>
	      <td>${contact.firstname} ${contact.lastname}</td>
	      <td><a href="contactdetail.do?id=${contact.id}">Edit</a></td>
	      <td><a href="deletecontact.do?id=${contact.id}">Delete</a></td>
	    </tr>
	    <tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
