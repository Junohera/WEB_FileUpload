<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/shopping.css">
</head>
<body>
    <div id="wrap" align="center">
        <h1>product list - admin page</h1>
        <table class="list">
            <tr>
                <td colspan="5" style="border: white; text-align: right;">
                    <a href="productwrite.do">add</a>
                </td>
            </tr>
            <tr>
                <th>num</th>
                <th>name</th>
                <th>price</th>
                <th>change</th>
                <th>delete</th>
            </tr>
            <c:forEach var="product" items="${productList}">
                <tr class="record">
                    <td align="center">${product.code}</td>
                    <td><a href="view.do?code=${product.code}">${product.name}</a></td>
                    <td align="right">${product.price} 원</td>
                    <td align="center"><a href="productupdate.do?code=${product.code}">update</a></td>
                    <td align="center"><a href="productdelete.do?code=${product.code}">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>