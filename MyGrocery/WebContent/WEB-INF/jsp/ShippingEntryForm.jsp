<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form modelAttribute="shipping" method="post" action="submitShipping">
 <table>
 <tr>
 	<td> Name </td>
 	<td> <form:input path="name"/> </td>
 </tr>
 
 <tr>
 	<td> Address Line 1 </td>
 	<td> <form:input path="addressLine1" /> </td>
 </tr>
 
 <tr>
 	<td> Address Line 2 </td>
 	<td> <form:input path="addressLine2"/> </td>
 </tr>
 
 <tr>
 	<td> City </td>
 	<td> <form:input path="city"/> </td>
 </tr>
 
 <tr>
 	<td> State </td>
 	<td> <form:input path="state"/> </td>
 </tr>
 
 <tr>
 	<td> Zip Code </td>
 	<td> <form:input path="zip"/> </td>
 </tr>
  
</table> 
<input type = "submit">
</form:form>

<jsp:include page="footer.jsp"/>
</body>
</html>