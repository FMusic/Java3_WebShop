<%@ page import="org.fm.model.*" %>
<%@ page import="java.util.List" %>
<%@ page import="org.fm.utils.Constants" %>
<html>
<head>
</head>
<body>
<div style="margin: 0 auto;">
    <ul class="nav justify-content-center">
        <li class="nav-item"><h4>Kategorije proizvoda:</h4></li>
        <c:forEach items="${requestScope[Constants.CATEGORIES_PARAM]}" var="cat">
            <c:set var="hasSubs" scope="page" value="${cat.categoriesByIdCategory != null &&  !cat.categoriesByIdCategory.isEmpty()}" />
            <c:if test="${hasSubs == true}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                        <c:out value="${cat.categoryName}" />
                    </a>
                    <div class="dropdown-menu">
                        <c:forEach items="${cat.categoriesByIdCategory}" var="subcat">
                            <a class="dropdown-item" href="#">
                                <c:out value="${subcat.categoryName}" />
                            </a>
                        </c:forEach>
                    </div>
                </li>
            </c:if>
            <c:if test="${hasSubs == false}">
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <c:out value="${cat.categoryName}" />
                    </a>
                </li>
            </c:if>
        </c:forEach>
    </ul>
</div>
</body>
</html>