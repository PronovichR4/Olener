<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 02.06.2020
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #dddddd;
    }
</style>

<html>
<head>
    <title>Личный кабинет</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="secondHeader.jsp"></jsp:include>

<h2>Личные данные</h2>
<table>
    <tr>
        <th>Логин</th>
        <th>${sessionScope.customer.login}</th>
    </tr>
    <tr>
        <td>Email</td>
        <td>
            <c:if test="${ empty sessionScope.customer.email}">
                ----
            </c:if>
            <c:if test="${ not empty sessionScope.customer.email}">
                ${sessionScope.customer.email}</td>
        </c:if>
    </tr>
    <tr>
        <td>Имя</td>
        <td>
            <c:if test="${ empty sessionScope.customer.name}">
                ----
            </c:if>
            <c:if test="${ not empty sessionScope.customer.name}">
                ${sessionScope.customer.name}</td>
        </c:if>
    </tr>
    <tr>
        <td>Фамилия</td>
        <td>
            <c:if test="${ empty sessionScope.customer.lastName}">
                ----
            </c:if>
            <c:if test="${ not empty sessionScope.customer.lastName}">
                ${sessionScope.customer.lastName}</td>
        </c:if>
    </tr>
    <tr>
        <td>Телефон</td>
        <td>
            <c:if test="${sessionScope.customer.phoneNumber==0}">
                ----
            </c:if>
            <c:if test="${ sessionScope.customer.phoneNumber !=0}">
                ${sessionScope.customer.phoneNumber}</td>
        </c:if>
    </tr>
    <tr>
        <td>Адресс</td>
        <td>
            <c:if test="${ empty sessionScope.customer.address}">
                ----
            </c:if>
            <c:if test="${ not empty sessionScope.customer.address}">
                ${sessionScope.customer.address}</td>
        </c:if>
    </tr>
</table>
<div>

    <form action="/profile" method="post" style="display: inline">
        <button type="submit" name="command" value="user_change_info_form"
                style="background: green; border-radius: 10px; color: white; height: 40px; width:auto">
            ИЗМЕНИТЬ
        </button>
    </form>

    <form action="/profile" method="post" style="display: inline">
        <button type="submit" name="command" value="logout"
                style="background:red; border-radius: 10px; color: white; height: 40px; width:70px">
            ВЫЙТИ
        </button>
    </form>
    <form action="/profile" method="post" style="display: inline">
        <button type="submit" name="command" value="history"
                style="background:deepskyblue; border-radius: 10px; color: white; height: 40px; width:auto">
            ИСТОРИЯ ЗАКАЗОВ
        </button>
    </form>
</div>


</body>
</html>