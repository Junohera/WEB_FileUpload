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
        <h1>product update - admin page</h1>
        <form name="frm" action="productupdate.do" method="post" enctype="multipart/form-data">
        <input type="hidden" name="code" value="${product.code }">
        <input type="hidden" name="nonUpdateImg" value="${product.pictureurl}">
            <table>
                <tr>
                	<td>
                        <c:choose>
                            <c:when test="${empty product.pictureurl}">
                                <img src="fileUpload/noname.jpg" width="220" height="300">
                            </c:when>
                            <c:otherwise>
                                <img src="fileUpload/${product.pictureurl}" width="220" height="300">
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <table border="1">
                            <tr><th style="width:80px">name</th><td><input type="text" name="name" id="name" value="${product.name}"></td></tr>
                            <tr><th>price</th><td><input type="text" name="price" id="price" value="${product.price}">&nbsp;원</td></tr>
                            <tr><th>picture</th><td><input type="file" name="pictureurl" id="pictureurl" value=${product.pictureurl }><br><small>(주의사항 : 이미지를 변경하고자 할때만 선택하세요)</small></td></tr>
                            <tr><th>description</th><td><textarea name="description" id="" cols="80" rows="10">${product.description }</textarea></td></tr>
                        </table>
                    </td>
                </tr>
            </table>
            <br>
            <input type="submit" value="send">
            <input type="reset" value="clear">
            <input type="button" value="list" onclick="location.href='productlist.do'">
        </form>
    </div>
</body>
</html>