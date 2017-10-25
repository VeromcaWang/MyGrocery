<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>
<jsp:include page="header.jsp"/>

<form:form method="post" action="confirmOrder" ModelAttribute="confirm">
<table>
<tr><td>Items your have purchased:</td></tr>
 <tr>
 	<td> Name </td>
 	<td> Quantity </td>
 </tr>
  <c:forEach items="${order.items}" var="item" varStatus="i">
    <tr>
    
    <td><input type = "text" value = "${item.name }"/></td>
    <td><input type = "text" value = "${item.quantity }"/></td>
    </tr>
  </c:forEach>
  
  <tr><td>Payment</td></tr>
  <tr>
 	<td> Card holder </td>
 	<td> <input type = "text" value = "${payment.cardHolder}"/> </td>
 </tr>
 
 <tr>
 	<td> Credit card number </td>
 	<td> <input type = "text" value = "${payment.creditCardNumber}"/> </td>
 </tr>
 
 <tr>
 	<td> CVV Code </td>
 	<td> <input type = "text" value = "${payment.cvvCode}"/> </td>
 </tr>
 
 <tr>
 	<td> Expiration date </td>
 	<td> <input type = "text" value = "${payment.expirationDate}"/> </td>
 </tr>
 
 <tr><td>Shipping</td></tr>
 <tr>
 	<td> Name </td>
 	<td> <input type = "text" value = "${shipping.name}"/>  </td>
 </tr>
 
 <tr>
 	<td> Address Line 1 </td>
 	<td> <input type = "text" value = "${shipping.addressLine1}"/> </td>
 </tr>
 
 <tr>
 	<td> Address Line 2 </td>
 	<td> <input type = "text" value = "${shipping.addressLine2}"/> </td>
 </tr>
 
 <tr>
 	<td> City </td>
 	<td> <input type = "text" value = "${shipping.city}"/> </td>
 </tr>
 
 <tr>
 	<td> State </td>
 	<td> <input type = "text" value = "${shipping.state}"/> </td>
 </tr>
 
 <tr>
 	<td> Zip Code </td>
 	<td> <input type = "text" value = "${shipping.zip}"/> </td>
 </tr>
 
</table> 
<input type = "submit" value = "confirm"/>
</form:form>
<jsp:include page="footer.jsp"/>
</body>
</html>