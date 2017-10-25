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
<form:form modelAttribute="payment" method="post" action="submitPayment">
 <table>
 <tr>
 	<td> Card holder </td>
 	<td> <form:input path="cardHolder"/> </td>
 </tr>
 
 <tr>
 	<td> Credit card number </td>
 	<td> <form:input path="creditCardNumber" /> </td>
 </tr>
 
 <tr>
 	<td> CVV Code </td>
 	<td> <form:input path="cvvCode"/> </td>
 </tr>
 
 <tr>
 	<td> Expiration date </td>
 	<td> <form:input path="expirationDate"/> </td>
 </tr>
  
</table> 
<input type = "submit">
</form:form>
<jsp:include page="footer.jsp"/>
</body>
</html>