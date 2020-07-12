<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- <h2>Save Contact</h2>
 -->
<p><font color='green'>${succMsg}</font></p>
<p><font color='red'>${errMsg}</font></p>

<h4>Save Contact Form...</h4>

<form:form action="saveContact" modelAttribute="contact" method="POST">
<table>
	<tr>
		<form:hidden path="contactId"/>
		<td>Contact Name : </td>
		<td><form:input path="contactName" /></td>
	</tr>
	<tr>
		<td>Contact Email :</td>
		<td><form:input path="contactEmail" /></form></td>
	</tr>
	<tr>
		<td>Contact Number :</td>
		<td><form:input path="contactNumber" /></form></td>
	</tr>
	<tr>
		<td><input type="reset" value="reset" /></td>
		<td><input type="submit" value="save" /></td>
	</tr>
		
</table>
<a href="viewContacts">View All Contacts Details</a>

</form:form>


</body>
</html>