<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>G13-SkyCloud云存储－搜索文件</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Josefin+Sans:400,700,700italic,600'>
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="mycss.css">
	<style>
		<%int seconds = (int) (Math.floor(Math.random()*10)); %>
		.bg {display: table;width: 100%;height: 100%;padding: 100px 0;text-align: center;color: #fff;background: url(https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky<%=seconds%>.jpeg) no-repeat center center;background-color: #000;background-size: cover;}
	</style>
        
</head>


<body>
   
	<nav class="navbar navbar-fixed-top my-navbar" role="navigation">  
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#example-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>	
            <a class="navbar-brand" href="#">SkyCloud</a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav">
      			<li> <a href="${pageContext.request.contextPath}/index.jsp" >首页</a></li>
      			<li> <a href="${pageContext.request.contextPath}/autologin.action?user_name=${user_name}" >我的主页</a></li> 
      			<li> <a href="${pageContext.request.contextPath}/grouphome.jsp" >我的群组</a></li>
      			<li>	 <a href="${pageContext.request.contextPath}/help.jsp">帮助</a></li>      
            </ul>
        </div>
    </div>
	</nav> 

<div class="bg">
	<div class="bg-div"></div>
	<div class="signin">

	<div class="box">
		<div style="font-size: 20px ; color: white; font-style: italic;color:white;">在 SkyCloud 中搜索你想要的文件吧～</div>
   	    <form action="${pageContext.request.contextPath}/searchfile.action" method="post" onsubmit='return validation();'  style="margin: 10px">
    			 <div class="" style="margin: 20px 0;">
              <input class="form-control form-input" placeholder="输入文件名" type="test" id="searchcontent" name="searchcontent"/>
              </div>
           	<div class="colorwhite">${searchcontentmessage}</div>
    			<input type="submit" class="btn btn-primary btn-submit" value="搜&nbsp;&nbsp;索" >
   		</form>
	</div>
	</div>
</div>

 
    <script>
    $(window).scroll(function () {
        if ($(".navbar").offset().top > 5) {$(".navbar-fixed-top").addClass("top-nav");
        }else {$(".navbar-fixed-top").removeClass("top-nav");}
    })</script>
<script src="http://www.w2bc.com/scripts/2bc/_gg_980_90.js" type="text/javascript"></script>
 <script language="javascript">
	function validation()
	{
		var searchcontent=document.getElementById('searchcontent').value;
		if(searchcontent==''){
			alert('请输入搜索的内容！');
			return false;
		}
	}
</script>
</body>
</html>

