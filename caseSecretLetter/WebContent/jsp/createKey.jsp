<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  

    String path = request.getContextPath();  

    String basePath = request.getScheme() + "://" +   

                                      request.getServerName() + ":" +  

                                      request.getServerPort() + path;  

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建张华的密钥</title>
</head>
<body>
	<form action="<%=basePath%>/letter/createCipherKey" method="post">
		<h3>张华的学号：</h3>
		<input type="text" name="code">
		<h3>张华将李俊的密文解码后得到的明文：</h3>
		<textarea rows="5" cols="100" name="key"></textarea>
		<br> <input type="submit" value="创建张华的密钥">
	</form>
</body>
</html>