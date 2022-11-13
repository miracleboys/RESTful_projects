<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + 
                                      request.getServerName() + ":" +
                                      request.getServerPort() + path;
%>    
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/main.css" />
<script type="text/javascript" src="<%=basePath%>/js/jquery.min.js"></script>
</head>
<body>
	<audio id="openBoxSnd" src="<%=basePath%>/sound/openBox.mp3"></audio>
	<audio id="keyGlowSnd" src="<%=basePath%>/sound/keyGlow.mp3"></audio>   
	<audio id="hahaSnd" src="<%=basePath%>/sound/haha.mp3"></audio>
	<audio id="growlSnd" src="<%=basePath%>/sound/growl.mp3"></audio>
	<audio id="beginSnd" src="<%=basePath%>/sound/begin.mp3"></audio>
	<audio id="surpriseSnd" src="<%=basePath%>/sound/surprise.mp3"></audio>
	<audio id="heavyCloseSnd" src="<%=basePath%>/sound/heavyClose.mp3"></audio>
	<audio id="saveMeSnd" src="<%=basePath%>/sound/saveMe.mp3"></audio>
	
	<div id="gamer" style="width:800px;height:800px">
	    <div id="boxContainer"></div>
	    <div id="magicRing"></div>
	    <div id="shining" ></div>
	    <div id="keyGlow" ></div>
	</div>
</body>
<script>	
	$(window).resize(function(){ 
	    var gamer = $('#gamer');
	    gamer.css({
	    	zIndex:0,
			position:'absolute', 
			left: ($(window).width() -gamer.outerWidth())/2, 
			top: ($(window).height() -gamer.outerHeight())/4
		});
	}); 

    var boxs=[
        {"top":45,"left":310,"question":"<%=basePath%>/box/question1"},
        {"top":220,"left":530,"question":"<%=basePath%>/box/question2"},
        {"top":495,"left":450,"question":"<%=basePath%>/box/question3"},
        {"top":495,"left":170,"question":"<%=basePath%>/box/question4"},
        {"top":230,"left":70,"question":"<%=basePath%>/box/question5"}
    ];
    var curBox ;
    $(document).ready(function () {
    	var openBoxSnd = $("#openBoxSnd")[0];
    	var keyGlowSnd = $("#keyGlowSnd")[0];
    	var hahaSnd = $("#hahaSnd")[0];
    	var growlSnd = $("#growlSnd")[0];
    	var beginSnd = $("#beginSnd")[0];
    	var surpriseSnd = $("#surpriseSnd")[0];
    	var heavyCloseSnd= $("#heavyCloseSnd")[0];
    	
        var boxContainer = $("#boxContainer");
        for(var boxIndex = 1;boxIndex<6;boxIndex++){
            var box = $("<div>");
            var boxData = boxs[boxIndex-1];
            box.addClass("box");
            box.css("zIndex",boxIndex*10);
            box.css("top",boxData.top);
            box.css("left",boxData.left);
            box.css("background-image","url(../css/images/box"+boxIndex+".png)");
            box.attr("boxIndex",boxIndex);
            box.attr("question",boxData.question);
            box.hover(function () {
                $(this).css("background-image","url(../css/images/box"+$(this).attr("boxIndex")+"glow.png)");
            },function () {
                $(this).css("background-image","url(../css/images/box"+$(this).attr("boxIndex")+".png)");
            });

            box.click(function(){
                curBox = $(this);
                request("post",curBox.attr("question"),{},boxGetQuestionSuccess,serverError,false);
            });
            boxContainer.append(box);
        }
        $(window).resize();
    });

    function request(method,url,data,successCallBack,errorCallBack,async){
        $.ajax({
            url: url,
            async:async,
            data: data,
            method: method
        }).success(successCallBack).error(errorCallBack);
    }

    function boxGetQuestionSuccess(data){
        console.log("boxGetQuestionSuccess",data);
        if(data.code==0) {
            var answer = prompt(data.description,"");
            if(answer){
                request("post","<%=basePath%>"+data.nextAction,{"answer":answer},boxGetAnswerSuccess,serverError,true);
            }
        }else if(data.code==-20){
        	growlSnd.play();
        	showMessage(data);  
            var username = prompt("你的名字，不要欺骗我的智慧：","");
            if(username){
            	request("post","<%=basePath%>"+data.nextAction,{"username":username},showMessage,serverError,true);
            	beginSnd.play();
          }
        }else if(data.code==-10){
        	hahaSnd.play(); 
        	showMessage(data);        	 
        }
    }

    function boxGetAnswerSuccess(data){
    	console.log("boxGetAnswerSuccess",data);
        if(data.code==0){
        	surpriseSnd.play();
        	curBox.off("click");
            curBox.off("mouseenter").unbind("mouseleave");
            curBox.css("background-image", "url(../css/images/box" + curBox.attr("boxIndex") + "open.png)");
            curBox.css("cursor", "default");            
            showMessage(data);
            openBoxSnd.play();
        }else if(data.code==-10){
        	showMessage(data);
        	hahaSnd.play();
        }else if(data.code==10){
        	surpriseSnd.play();
        	curBox.off("click");
            curBox.off("mouseenter").unbind("mouseleave");
            curBox.css("background-image", "url(../css/images/box" + curBox.attr("boxIndex") + "open.png)");
            curBox.css("cursor", "default");
            showMessage(data);
            heavyCloseSnd.play();
        	request("post","<%=basePath%>"+data.nextAction,{},showMessage,serverError,true);
        	$("#keyGlow").css("display","block");
        	$("#shining").css("display","block");
        	$("#magicRing").css("filter","blur(5px)");
        	$(".box").css("filter","blur(5px)");
        	keyGlowSnd.play();  
			setTimeout(function(){saveMeSnd.play();},1000);
        }
        
    }
    
    function showMessage(data){
    	console.log("showMessage",data);
    	alert(data.description);
    }

    function serverError(XMLHttpRequest, textStatus){
        console.log("responseText:",XMLHttpRequest.responseText);
        console.log("status:",XMLHttpRequest.status);
        console.log("textStatus:",textStatus);
        console.log("readyState:",XMLHttpRequest.readyState);
        alert("网络都出问题还想挖宝？按F12键看看发生了什么吧！");
    }
</script>
</html>