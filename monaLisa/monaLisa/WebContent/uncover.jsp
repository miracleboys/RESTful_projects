<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=basePath%>/js/jquery-3.1.0.min.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>解密蒙拉丽莎</title>
</head>
<body>
蒙拉丽莎24位BMP：<input type="file" name="monaLisaFile" id="monaLisaFile"><button id="submitMonaLisa">开始解密</button>
<div id="fileDownLoad"></div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		 $("#submitMonaLisa").click(function () {
			 var formData = new FormData();
			 var monaLisaFile = document.getElementById("monaLisaFile").files[0]; 
			 
			formData.append("file", monaLisaFile);
			 
             $.ajax({
                 url: "<%=basePath%>/monaLisa/uncover",
                 data: formData,
                 type: "post",                 
                 cache: false,
                 processData: false,
                 contentType: "monaLisa/input",
                 success: function (data) {
                	 $("#fileDownLoad").html("");	 
                	 var downloadLink = $("<a>");
                	 downloadLink.attr('href','data:application/octet-stream;base64,'+data);    
                	 downloadLink.attr('target','_blank');    
                	 downloadLink.text("下载解密后的文件");
                     $("#fileDownLoad").append(downloadLink);
                	                    
                 }
             })
		 });
	});
</script>
</html>