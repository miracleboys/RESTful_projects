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
<title>解码张华的密文</title>
</head>
<body>
	<form action="<%=basePath%>/letter/decodeCipherText" method="post">
		<h3>张华的密钥：</h3>
		<textarea rows="5" cols="100" name="newKey"></textarea>
		<h3>张华的密文：</h3>
		<textarea rows="5" cols="100" name="cipher2"></textarea>
		<br> <input type="submit" value="解码张华的密文">
	</form>
</body>
</html>