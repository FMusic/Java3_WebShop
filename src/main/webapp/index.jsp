<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>TI Store</title>
</head>
<body>
<div style="min-height: 100vh;">
    <%@include file="jsps/navigation.jsp" %>
    <div class="jumbotron">
        <h1 class="display-4">TI Store</h1>
        <p class="lead">
            Dobrodosli na web stranice TI Store, ugodan shopping!
        </p>
    </div>
    <%@include file="jsps/categories.jsp" %>
    <%@include file="jsps/products.jsp" %>
</div>
<%@include file="jsps/footer.jsp" %>
</body>
</html>