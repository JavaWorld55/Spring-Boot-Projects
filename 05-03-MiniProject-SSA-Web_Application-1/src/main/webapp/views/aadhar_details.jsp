<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

 <h1 style="color:blue;text-align:center">Aadhar Card Details</h1>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <c:choose>
   <c:when test="${!empty aadhar}">
   <table height="50%" width="50%" bgcolor="cyan" align="center" border="1">
   <tr>
   <td>Aadhar No::</td>
   <td>${aadhar.aadharNo}</td>
   </tr>
   <tr>
   <td>First Name::</td>
   <td>${person.firstName}</td>
   </tr>
   <tr>
   <td>Last Name::</td>
   <td>${person.lastName}</td>
   </tr>
   <tr>
   <td>DOB::</td>
   <td>${person.dob}</td>
   </tr>
   <tr>
   <td>Gender::</td>
   <td>${person.gender}</td>
   </tr>
   <tr>
   <td>Address Line 1::</td>
   <td>${address.address1}</td>
   </tr>
   <tr>
   <td>Address Line 2::</td>
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
    </c:choose> 
    <br><br>
    <a href="userForm">Home</a> 