<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 23.06.2020
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="px" %>


<html>
<head>
    <title>ЗАКАЗЫ</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="secondHeader.jsp"></jsp:include>
<%@include file="language.jsp" %>
<style>
    table {
        font-family: arial, sans-serif;
        width: 60%;
    }

    th {
        border: 1px solid #dddddd;
        text-align: -moz-center;
        padding: 8px;
    }
</style>
<table>
    <tr style="background-color: #dddddd">
        <th>
            НОМЕР ЗАКАЗА
        </th>
        <th>
            ДАТА
        </th>
        <th>
            СТАТУС ЗАКАЗА
        </th>
    </tr>


    <c:forEach items="${requestScope.productBookings}" var="productBooking">
        <tr>
            <th>
                    ${productBooking.booking.id}
            </th>
            <th>
                    ${productBooking.booking.date}
            </th>
            <th>
                    ${productBooking.booking.bookingStatus.description}
            </th>
            <th>
                <form action="${pageContext.request.contextPath}/admin-page" method="post">
                    <input type="hidden" name="bookingId" value="${productBooking.booking.id}">
                    <select name="status">
                        <c:forEach var="status" items="${requestScope.status}">
                            <option value="${status}">${status.description}</option>
                        </c:forEach>
                    </select>
                    <button type="submit" name="command" value="update_status"
                            style="background: green; color: white">
                        ОБНОВИТЬ
                    </button>
                </form>

            </th>
        </tr>
        <tr>
            <th>
                    ${productBooking.booking.customer.name}
            </th>
            <th>
                    ${productBooking.booking.customer.lastName}
            </th>
            <th>
                    ${productBooking.booking.customer.email}
            </th>
            <th>
                    ${productBooking.booking.customer.phoneNumber}
            </th>
            <th>
                    ${productBooking.booking.customer.address}
            </th>
        </tr>

        <c:forEach items="${productBooking.products}" var="product">
            <tr>
                <th><img height="60" width="60" src="${product.img}"></th>
                <th> ${product.model}</th>
                <th> ${product.description}</th>
                <th><fmt:formatNumber value="${product.price}" type="CURRENCY" currencySymbol="р."/></th>
            </tr>
        </c:forEach>

        <tr>
            <th style="background-color: #dddddd">
                СУММА <px:priceSumTag products="${productBooking.products}"/>
            </th>
        </tr>


    </c:forEach>
</table>

</body>
</html>