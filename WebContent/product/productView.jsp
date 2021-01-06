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
        <h1>상품 상세 - 관리자 페이지</h1>
        <table>
            <tr>
                <td width="220">
                    <c:choose>
                        <c:when test="${empty product.pictureurl}">
                            <img src="fileUpload/noname.jpg">
                        </c:when>
                        <c:otherwise>
                        	<img src="fileUpload/${product.pictureurl}">
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <table>
                        <tr><th style="width: 80px;">product name</th><td>${product.name}</td></tr>
                        <tr><th>price</th><td>${product.price}원</td></tr>
                        <tr><th>description</th><td><div style="height:220px; width:100%;"><pre>${product.description}</pre></div></td></tr>
                    </table>
                </td>
            </tr>
        </table>
        <br>
        <input type="button" value="list" onclick="location.href='productlist.do'">
    </div>
</body>
</html>