<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- 파일 업로드 기능이 포함된 form 은 반드시 enctype="multipart/form-data" 옵션을 추가해주어야 합니다. -->
    <form name="frm" action="upload.do" method="post" enctype="multipart/form-data">
        writer : <input type="text" name="name" id="name" > <br>
        title : <input type="text" name="title" id="title" > <br>
        file : <input type="file" name="uploadFile"> <br>
        <input type="submit" value="send">
    </form>
</body>
</html>