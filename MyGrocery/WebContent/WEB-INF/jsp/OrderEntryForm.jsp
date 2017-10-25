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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${item.name}
<form:form modelAttribute="order" method="post" action="purchase/submitItems">
 <table>
 <tr>
 	
 	<td> Name </td>
 	<td> Quantity </td>
 </tr>
  <c:forEach items="${order.items}" var="item" varStatus="i">
    <tr>
    <%-- <jsp:useBean id="inventory" scope= "page | request | session | application" 
    class= "edu.osu.cse5234.business.InventoryServiceBean"/> --%>

    <td><form:input path = "items[${i.index }].name" value = "${item.name }"/></td>
    <td><form:input path = "items[${i.index }].quantity" value = "${item.quantity }"/></td>
    
    </tr>
  </c:forEach>
</table> 
<input type = "submit">
</form:form>

<form action="purchase/showInventory">
<input type="checkbox" name="showInventory" value="showInventory"> Show Inventory
<input type="submit" value="Submit">
</form>


<jsp:include page="footer.jsp"/>

</body>
</html>