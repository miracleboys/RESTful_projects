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
<form action="<%=basePath%>/data/refresh" method="post" enctype='application/json'>
	S:<input type="text" name="sCode" value=><br>
	X:<input type="text" name="xCode"><br>
	R:<input type="text" name="rCode"><hr>
	<textarea name="refreshData" rows="30" cols="50">
	[{
	"zoneCode":"R98542",
	"targetPosX":4122.54,
	"targetPosY":9547.76,
	"targetPosZ":12548.69,
	"power":521456,
	"duration":6412},
	{
	"zoneCode":"R652485",
	"targetPosX":95482.36,
	"targetPosY":7845.85,
	"targetPosZ":9847.37,
	"power":741785,
	"duration":6482},
	{
	"zoneCode":"R742545",
	"targetPosX":16982.93,
	"targetPosY":85623.17,
	"targetPosZ":4872.27,
	"power":34528,
	"duration":342
	}]
	</textarea><br>
	<input type="submit" value="提交查询" >
</form>
</body>
</html>