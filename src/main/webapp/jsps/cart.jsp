<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: frane
  Date: 7/14/2020
  Time: 2:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Webshop Cart</title>
</head>
<body>
<%@include file="navigation.jsp" %>

<div class="container">
    <div class="container">
        <c:forEach var="item" items="${requestScope[Constants.CART_ATTRIBUTE]}">
            <div class="ui-item">
                <div class="row">
                    <c:set value="${item.productByProductId}" var="product" />
                    <c:out value="${product.productName}" />
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
