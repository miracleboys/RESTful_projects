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
<title>首页</title>
</head>
<body>
	<h3>李俊传给张华的cipher1数据：</h3>
	<h3>2770d0b53955accfd6b97b160c699ebe7e0aeb843f1fff9cfd9498e8c6ae50358ffd37174f3880efcab8523ef692fcdd</h3>
	<hr>
	<a href="<%=basePath%>/jsp/decodeKey.jsp" target="_blank">张华对李俊的cipher1进行解码</a>
	<hr>
	<a href="<%=basePath%>/jsp/createKey.jsp" target="_blank">张华创建自己的密钥</a>
	<hr>
	<a href="<%=basePath%>/jsp/cipher.jsp" target="_blank">张华利用自己的密钥加密明文</a>
	<hr>
	<a href="<%=basePath%>/jsp/decodeText.jsp" target="_blank">李俊收到张华的密文后进行解码</a>
	<hr>

</body>
</html>