<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<h1 style="color:red;text-align:center">Aadhar Registration Page</h1>

<table bgcolor="cyan" border="1" align="center">
 
 <form:form action="saveUser?personId=${userDetails.personId}" modelAttribute="userDetails">
 <tr>
 <td>First Name::</td>
 <td><form:input path="firstName"/></td>
 </tr>
 <tr>
 <td>Last Name::</td>
 <td><form:input path="lastName"/></td>
 </tr>
 <tr>
 <td>Date of birth::</td>
 <td><form:input type="date" path="dob"/></td>
 </tr>
 <tr>
 <td>Gender::</td>
 <td>Male<form:radiobutton path="gender" value="male"/>
  Female<form:radiobutton path="gender" value="female"/></td>
 </tr>
 <tr>
  <td colspan="2"><input type="reset" value="Reset"/>&nbsp&nbsp&nbsp&nbsp
  <input type="submit" value="Next"/></td>
  </tr>
 </form:form> 
 </table>
 <br><br>
 <center>
 <h2 style="color:blue;text-align">If you have already Aadhar number so click on below link to get your aadhar details</h2> 
  <a href="aadharForm">Get_Aadhar_Card</a></center>