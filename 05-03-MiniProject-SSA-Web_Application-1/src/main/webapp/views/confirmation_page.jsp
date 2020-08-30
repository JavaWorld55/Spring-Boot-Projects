<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 style="color:green;text-align:center">Confirmation Page</h1>

<c:choose>
   <c:when test="${!empty details}">
 <table height="50%" width="50%" bgcolor="cyan" align="center" border="1">
 <tr>
 <td width="25%">
 <th><b>Person Details</b></th></tr>
 <tr>
 <td>First Name::</td>
 <td>${details.firstName}</td>
 </tr>
 <tr>
 <td>Last Name::</td>
 <td>${details.lastName}</td>
 </tr>
 <tr>
 <td>DOB::</td>
 <td>${details.dob}</td>
 </tr>
 <tr>
 <td>Gender::</td>
 <td>${details.gender}</td>
 </tr>

 <tr>
 <td width="25%">
 <th><b>Address Details</b></th>
 <tr>
 <td>Address Line 1::</td>
 <td>${address.address1}</td>
 </tr>
 <tr>
 <td>Address Line 2</td>
 <td>${address.address2}</td>
 </tr>
 <tr>
 <td>State::</td>
 <td>${address.state}</td>
 </tr>
 <tr>
 <td>City::</td>
 <td>${address.city}</td>
 </tr>
 <tr>
 <td>Pincode::</td>
 <td>${address.pincode}</td>
 </tr>
 </table>  
</c:when>
</c:choose><br><br>
<center>
<a href="saveAadhar">Confirm</a>
</center><br><br>
<a href="userForm">Home</a>
