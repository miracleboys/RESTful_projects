<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + 
                                      request.getServerName() + ":" +
                                      request.getServerPort() + path;
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>指令操作</title>
</head>
<body>
<form action="<%=basePath%>/data/readCommand" method="post" enctype='application/json'>
	<textarea name="command" rows="30" cols="50">
	[{
	"zoneCode":"T54218",
	"targetPosX":5428.29,
	"targetPosY":651.13,
	"targetPosZ":785.91,
	"power":19548236,
	"duration":5426
	},
	{
	"zoneCode":"S542187",
	"targetPosX":3654.12,
	"targetPosY":8421.36,
	"targetPosZ":9857.57,
	"power":52487532,
	"duration":65428
	}]</textarea>
	<br>
	<input type="submit" value="提交查询">
</form>

</body>
</html>