<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 09.06.2020
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="language.jsp" %>
<html>
<head>
    <title><fmt:message key="form.addProdcut"/></title>
    <style>
        div {
            width: 500px;
            height: auto; /* Размеры */
            outline: 1px solid darkgrey; /* Чёрная рамка */
            border: 25px solid #fff; /* Белая рамка */
            border-radius: 20%; /* Радиус скругления */
            margin: auto;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div>
    <a style="text-decoration: none" href="${pageContext.request.contextPath}/olener">
        <img src="${pageContext.servletContext.contextPath}/images/logo.jpg" style="margin-top: 20px">
    </a>

    <form action="${pageContext.request.contextPath}/adminpage" method="post">
        <p><span style="color: red; margin: 70px; font-size: x-large"><fmt:message key="form.changenInfo"/></span></p>

        <input type="hidden" value="${requestScope.product.id}" name="productId">

        <p>
            <label><fmt:message key="form.category"/> <br>
                <select name="catalogId">
                    <c:forEach var="catalog" items="${requestScope.catalog}">
                        <option value="${catalog.id}">${catalog.description}</option>
                        <option selected
                                value="${requestScope.product.catalog.id}">${requestScope.product.catalog.description} </option>
                    </c:forEach>
                </select>
            </label>
        </p>
        <p>
            <label><fmt:message key="form.brand"/> <br>
                <select name="brandId">
                    <c:forEach var="brand" items="${requestScope.brands}">
                        <option value="${brand.id}">${brand.name}</option>
                        <option selected
                                value="${requestScope.product.brand.id}">${requestScope.product.brand.name}</option>
                    </c:forEach>
                </select>
            </label>
        </p>
        <p>
            <label><fmt:message key="form.model"/><br>
                <input type="text" style="font-size: x-large" name="model" value="${requestScope.product.model}">
            </label>
        </p>
        <p>
            <label><fmt:message key="form.description"/>
                <textarea style="font-size: x-large" cols=40 rows=10 name="description">
                    ${requestScope.product.description}
                </textarea>
            </label>
        </p>
        <p>
            <label><fmt:message key="form.price"/><br>
                <input type="text" style="font-size: x-large" name="price" value="${requestScope.product.price}">
            </label>
        </p>
        <p>
            <label><fmt:message key="form.image"/><br>
                <input type="text" style="font-size: x-large" name="img" value="${requestScope.product.img}">
            </label>
        </p>
        <p>
            <label><fmt:message key="form.quantity"/><br>
                <input type="text" style="font-size: x-large" name="quantity" value="${requestScope.product.quantity}">
            </label>
        </p>

        <button type="submit" name="command" value="save_product_changes"
                style="background: green; border-radius: 10px; color: white; height: 40px; width:auto">
            <fmt:message key="ok"/>
        </button>
    </form>
</div>

</body>
</html>
