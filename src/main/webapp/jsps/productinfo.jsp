<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="org.fm.utils.Constants" %>
<%--
  Created by IntelliJ IDEA.
  User: frane
  Date: 6/22/2020
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style/productinfo.css">
    <c:set var="product" value="${requestScope[Constants.PRODUCT_INFO_PARAM]}"/>
    <title>
        <c:out value="${product.productName}"/>
    </title>
</head>
<body>
<%@include file="navigation.jsp" %>
<div class="container product-container">
    <div class="row">
        <div class="col-lg-6 col-md-12">
            <img style="width:100%;" src="assets/products/<c:out value="${product.picPath}"/>"/>
        </div>
        <div class="col-lg-6 col-md-12 p-info-box flex-col">
            <h1>
                <c:out value="${product.productName}"/>
            </h1>
            <h4>
                Cijena: <c:out value="${product.price}"/>
            </h4>
            <div class="row cart-container">
                <label for="quantity">Kolicina:</label>
                <input type="number" id="quantity" name="quantity" min="1" max="99"/>
                <button class="btn-cart" id="add" type="submit">
                    <img src="assets/ico/add-to-cart.png" />
                    Dodaj
                </button>
            </div>
        </div>
    </div>
    <div class="p-desc-box flex-col">
        <h2>Opis proizvoda:</h2>
        <p class="p-desc">
            <c:out value="${product.description}"/>
        </p>
    </div>
</div>
<script language="JavaScript">
    $(document).ready(function() {
        $.ajax({
            url: "/addCartServlet?${Constants.PRODUCT_ID_PARAM}=${product.idProduct}&${Constants.PRODUCT_QUANTITY_PARAM}=$(\"#quantity\")",
            success: function () {
                alert('ok');
            }
        });
    });
</script>
<%@include file="footer.jsp" %>
</body>
</html>
