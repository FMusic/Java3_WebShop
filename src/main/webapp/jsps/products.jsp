<%@ page import="org.fm.utils.Constants" %>
<html>
<head>
    <link rel="stylesheet" href="style/product.css">
</head>
<body>

<div class="container container-products">
    <h2 class="section-title">Najpopularniji proizvodi</h2>
    <div class="row">
        <c:set var="items" value="${requestScope[Constants.MOST_POPULAR_ITEMS]}"/>
        <c:forEach var="i" begin="0" end="${items.size() - 1}">
        <c:if test="${i%3==0}">
    </div>
    <div class="row">
        </c:if>
        <div class="product col-lg-4 col-md-6 col-sm-12">
            <c:set var="product" value="${items.get(i)}"/>
            <a href="product?${Constants.PRODUCT_ID_PARAM}=${product.idProduct}">
                <div class="img-box">
                    <img src="assets/products/<c:out value="${product.picPath}"/>" class="product-img"/>
                </div>
                <h3 class="product-title">
                    <c:out value="${product.productName}"/>
                </h3>
                <h5>
                    <c:out value="${product.price}"/> <c:out value="${requestScope[Constants.MONEY_TYPE]}"/>
                </h5>
            </a>
        </div>
        </c:forEach>
    </div>
</div>
</body>
</html>