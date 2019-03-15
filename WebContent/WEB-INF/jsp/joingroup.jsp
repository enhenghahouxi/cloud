<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>G13-SkyCloud云存储－申请加入群组</title>
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
					<li> <a href="${pageContext.request.contextPath}/grouprequestup.action" >创建新的群组</a></li>
					<li> <a href="${pageContext.request.contextPath}/index.jsp" >首页</a></li>
					<li>	 <a href="${pageContext.request.contextPath}/help.jsp">帮助</a></li>
					<li> <a href="${pageContext.request.contextPath}/grouphome.action" >我的群组</a></li>
					<li>	 <a href="${pageContext.request.contextPath}/autologin.action?user_name=${user_name}" >我的主页</a>  </li>
				</ul>
			</div>	
		</div>
	</nav>
	
	<div class="bg">
		<div class="bg-div"></div>
		<div class="signin">

		<div class="box">
			<form action="${pageContext.request.contextPath}/joingroup.action?groupname=${groupname}"  class="signin-form" method="post">

				<div class="" style="margin: 20px 0;">
					<input class="form-control form-input" placeholder="请输入该群组的暗号" type="password" name="invitecode"/>
				</div>
				<div class="colorwhite">${groupnameerror}</div>
				<div class="colorwhite">${invitecodeerror}</div>
				<div><input type="submit" class="btn btn-primary btn-submit" value="申请加入" ></div>
			</form>
		</div>
	</div>
	</div>
		<script>

	$(window).scroll(function () {
		if ($(".navbar").offset().top > 25) {$(".navbar-fixed-top").addClass("top-nav");
		}else {$(".navbar-fixed-top").removeClass("top-nav");}
		})
		
	</script>

	<script src="http://www.w2bc.com/scripts/2bc/_gg_980_90.js" type="text/javascript"></script>
	
</body>
</html>