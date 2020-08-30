<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color:blue;text-align:center">Get Aadhar Card Details</h1>

<table bgcolor="cyan" border="1" align="center">
<form:form action="getAadhar" modelAttribute="aadhar">
<tr>
<td>Enter Aadhar No::</td>
<td><form:input path="aadharNo"/></td>
</tr>
<tr>
<td><input type="submit" value="Submit"/></td>
</tr>
</form:form>

</table>