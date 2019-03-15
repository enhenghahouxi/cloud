<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>G13-SkyCloud云存储－help</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"> 
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Josefin+Sans:400,700,700italic,600'>
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
    <link rel="stylesheet" type="text/css" href="mycss.css">
	<style>
		<%int seconds = (int) (Math.floor(Math.random()*10)); %>
		.bg {display: table;width: 100%;height: 100%;padding: 100px 0;text-align: center;color: #fff;background: url(https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky<%=seconds%>.jpeg) no-repeat center center;
				background-color: #000;background-size: cover;}
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
            <a class="navbar-brand" href="#" style="font-size: 24px; ">SkyCloud</a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav">
            		<li> <a href="${pageContext.request.contextPath}/index.jsp" >首页</a></li>
      			<li> <a href="${pageContext.request.contextPath}/autologin.action?user_name=${user_name}" >我的主页</a></li>      			
      			<li>	 <a href="${pageContext.request.contextPath}/aboutus.jsp">关于我们</a></li> 
      			<li> <a href="${pageContext.request.contextPath}/login.jsp" >用户登录</a> </li>
       			<li>	 <a href="${pageContext.request.contextPath}/adminrequestin.action" >管理员登录</a> </li>      
            </ul>
        </div>
    </div>
</nav> 



<div class="bg" >
    <div class="bg-div"></div>
	 <br/><br/> 
    <font style="font-size: 30px;"> 1.网页的兼容问题</font><br/>
   <font style="font-size: 25px; background-color: silver;">skycloud主要兼容firefox和chrome，上传和下载文件也请尽量使用这两种浏览器</font><br/>
   <font style="font-size: 30px;"> 2.编码的兼容问题</font><br/>
   <font style="font-size: 25px; background-color: silver;">skycloud暂不兼容除英文外的其他语言，所以取名请尽量使用英语，否则可能用户名会变成乱码</font><br/>
   <font style="font-size: 30px;"> 3.如何上传或者下载文件？</font><br/>
   <font style="font-size: 25px; background-color: silver">任何人均可以下载他人共享的文件，如果想上传文件，您必须先注册并登陆</font><br/><br/>
   <font style="font-size: 30px;"> 4.上传的文件会被别人看到并下载吗？</font><br/>
   <font style="font-size: 25px; background-color: silver">您上传的文件默认是私有的，上传之后您可以选择共享文件，共享的文件可以被搜索到</font><br/>
   <font style="font-size: 30px;"> 5.上传的文件的编码格式问题</font><br/>
   <font style="font-size: 25px; background-color: silver;">skycloud以utf-8为编码格式，请尽量以英文名的形式上传</font><br/>
   <font style="font-size: 30px;"> 6.忘记密码怎么办？</font><br/>
   <font style="font-size: 25px; background-color: silver;">您可以发email至740490553@qq.com询问，后续会开通密码找回功能</font><br/>
   <font style="font-size: 30px;"> 7.上传文件有什么限制吗？</font><br/>
   <font style="font-size: 25px; background-color: silver;">普通用户单次上传文件不能超过20Mb，VIP用户不能超过50Mb</font><br/>
   <font style="font-size: 25px; background-color: silver;">在个人空间，一般上传总最大容量为每人100mb，在群组空间总容量暂定为200mb</font><br/>
   <font style="font-size: 30px;"> 8.群组的邀请码是什么东西？</font><br/>
   <font style="font-size: 25px; background-color: silver;">群组邀请码是别人加入你的群组的暗号，只有通过这个才能加入</font><br/>
   <font style="font-size: 30px;"> 9.手机注册发送验证码没有收到短信？</font><br/>
   <font style="font-size: 25px; background-color: silver;">由于短信接口受到限制，用户不能频繁获得验证码短信，如果没有收到请稍后再试</font><br/>
   <font style="font-size: 30px;"> 10.群组内如何看到其他群成员？</font><br/>
   <font style="font-size: 25px; background-color: silver;">暂时还不能，后续会开通群成员基本信息显示和群组聊天功能</font><br/>
   <font style="font-size: 30px;"> 11.可以更改自己的密码以及找回密码吗？</font><br/>
   <font style="font-size: 25px; background-color: silver;">暂时还不能，后续会开通修改个人信息功能以及找回密码功能</font><br/>
   <font style="font-size: 30px;"> 12.欢迎加入我们</font><br/>
   <font style="font-size: 25px; background-color: silver;">如果有任何意见和建议，请联系我们。skycloud欢迎每一个自由的分享者</font><br/>
 </div> 
 
    <script>
    $(window).scroll(function () {
        if ($(".navbar").offset().top > 5) {$(".navbar-fixed-top").addClass("top-nav");
        }else {$(".navbar-fixed-top").removeClass("top-nav");}
    })</script>

 
</script>
</body>
</html>