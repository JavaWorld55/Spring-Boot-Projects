<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color:red;text-align:center">User Address Details Page</h1>
<table bgcolor="cyan" align="center" border="1">

<form:form action="saveAddress" modelAttribute="addressDetails">
<tr>
<td>Address Line 1::</td>
<td><form:input path="address1"/></td>
</tr>
<tr>
<td>Address Line 2::</td>
<td><form:input path="address2"/></td>
</tr>
<tr>
<td>State::</td>
<td><form:input path="state"/></td>
</tr>
<tr>
<td>City::</td>
<td><form:input path="city"/></td>
</tr>
<tr>
<td>Pincode::</td>
<td><form:input path="pincode"/></td>
</tr>
<tr>
<td colspan="2"><a href="editForm?pid=${personId}">Previous</a>&nbsp&nbsp&nbsp&nbsp
<input type="submit" value="Next"></td> 
</tr>
</form:form>
</table>