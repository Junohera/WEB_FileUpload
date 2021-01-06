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
        <h1>product add - admin page</h1>
        <form name="frm" action="productwrite.do" method="post" enctype="multipart/form-data">
            <table>
                <tr><th>product name</th><td><input type="text" name="name" id="name" size="80"></td></tr>
                <tr><th>price</th><td><input type="text" name="price" id="price">&nbsp;원</td></tr>
                <tr><th>picture</th><td><input type="file" name="pictureurl" id="pictureurl" ></td></tr>
                <tr><th>description</th><td><textarea name="description" id="" cols="80" rows="10"></textarea></td></tr>
            </table>
            <br>
            <input type="submit" value="send">
            <input type="reset" value="clear">
            <input type="button" value="list" onclick="location.href='productlist.do'">
        </form>
    </div>
</body>
</html>