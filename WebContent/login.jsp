<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>G13-SkyCloud云存储－登录</title>
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
	            <a class="navbar-brand" href="#" >SkyCloud</a>
	        </div>
	        <div class="collapse navbar-collapse" id="example-navbar-collapse">
	            <ul class="nav navbar-nav">
	            		<li> <a href="${pageContext.request.contextPath}/searchfile.jsp" >全站搜索文件</a></li>
	            		<li> <a href="${pageContext.request.contextPath}/index.jsp" >首页</a></li>
	      			<li> <a href="${pageContext.request.contextPath}/autologin.action?user_name=${user_name}" >我的主页</a></li> 
	      			<li>	 <a href="${pageContext.request.contextPath}/help.jsp">帮助</a></li> 
	       			<li>	 <a href="${pageContext.request.contextPath}/adminrequestin.action" >管理员登录</a> </li>   
	       			<li>	 <a href="http://101.132.135.234:8080/SKYCLOUD-ENGLISH/login.jsp" >英文版</a> </li>    
	            </ul>
	        </div>
	    </div>
	</nav> 



<div class="bg" >
    <div class="bg-div"></div>
	<br/>
	<br/>
    <div class="signin">
   
        <div class="box">
            <form action="${pageContext.request.contextPath}/login.action" id="loginForm" class="signin-form" method="post">

                <div >
                    <input id="username" class="form-control form-input" placeholder="用户名" type="text" name="username"/>
                </div>
                <div class="" style="margin: 20px 0;">
                    <input id="password" class="form-control form-input" placeholder="密   码" type="password" name="password"/>
                </div>
           		<div style="color:white;">${error}</div>
                <div class="save-div">
                		<label><input id="remember" type="checkbox">记住密码</label><br>
                    <!--  <input type="checkbox" class="save-checkbox" id="remember"  />
                    <span class="save-pass">记住密码</span>-->
                </div>
                <input type="submit" class="btn btn-primary btn-submit" value="登&nbsp;&nbsp;录" >
                <span class="signup">还没有账户，立即
                		<a class="signup-a" href="${pageContext.request.contextPath}/requestup.action">注册</a>
                </span>
            </form>
 
        </div>
    </div>
 </div> 
 
	<script language="javascript">
	$(window).scroll(function () {
		if ($(".navbar").offset().top > 5) {$(".navbar-fixed-top").addClass("top-nav");
		}else {$(".navbar-fixed-top").removeClass("top-nav");}
	})	
	</script>

 <script language="javascript">
	function clicklogin()
	{
		if(tableLogin.login.value=="")
		{
			window.alert("用户名不能为空！");
			tableLogin.login.focus();
			return;
		}
	}
	
	//记住密码
	window.onload = function(){
	    var oForm = document.getElementById('loginForm');
	    var oUser = document.getElementById('username');
	    var oPswd = document.getElementById('password');
	    var oRemember = document.getElementById('remember');
	    //页面初始化时，如果帐号密码cookie存在则填充
	    if(getCookie('username') && getCookie('password')){
	      oUser.value = getCookie('username');
	      oPswd.value = getCookie('password');
	      oRemember.checked = true;
	    }
	    //复选框勾选状态发生改变时，如果未勾选则清除cookie
	    oRemember.onchange = function(){
	      if(!this.checked){
	        delCookie('username');
	        delCookie('password');
	      }
	    };
	    //表单提交事件触发时，如果复选框是勾选状态则保存cookie
	    oForm.onsubmit = function(){
	      if(remember.checked){ 
	        setCookie('username',oUser.value,7); //保存帐号到cookie，有效期7天
	        setCookie('password',oPswd.value,7); //保存密码到cookie，有效期7天
	      }
	    };
	  };
	  //设置cookie
	  function setCookie(name,value,day){
	    var date = new Date();
	    date.setDate(date.getDate() + day);
	    document.cookie = name + '=' + value + ';expires='+ date;
	  };
	  //获取cookie
	  function getCookie(name){
	    var reg = RegExp(name+'=([^;]+)');
	    var arr = document.cookie.match(reg);
	    if(arr){
	      return arr[1];
	    }else{
	      return '';
	    }
	  };
	  //删除cookie
	  function delCookie(name){
	    setCookie(name,null,-1);
	  };
</script>
</body>
</html>