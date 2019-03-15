<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>G13-SkyCloud云存储－注册</title>
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
			<li> <a href="${pageContext.request.contextPath}/autologin.action?user_name=${user_name}" >我的主页</a></li>
			<li> <a href="${pageContext.request.contextPath}/login.jsp" >用户登录</a> </li>
			<li>	 <a href="${pageContext.request.contextPath}/index.jsp" >首页</a> </li>
			<li>	 <a href="${pageContext.request.contextPath}/help.jsp">帮助</a></li>
		</ul>
	</div>
	</div>
</nav>

<div class="bg">
	<div class="bg-div"></div>
	<div class="signin">

	<div class="box">

	<form action="${pageContext.request.contextPath}/logup.action"  class="signin-form" method="post">
		<div >
			<input class="form-control form-input" placeholder="用户名(英文或数字6-20位)" type="text" name="username"/>
		</div>
		<div class="" style="margin: 20px 0;">
			<input class="form-control form-input" placeholder="密  码(英文或数字6-20位)" type="password" name="password"/>
		</div>
		<div class="" style="margin: 20px 0;">
			<input class="form-control form-input" placeholder="确认密码(英文或数字6-20位)" type="password" name="password2"/>
		</div>
			<div class="" style="margin: 20px 0;">
			 <input class="form-control form-input" placeholder="手机号(中国区手机号11位)" id="phone" type="text" name="phone" value="" maxlength="11"/>
			 </div> 
	         <div class="" style="margin: 10px 0;">
	         	<input class="form-control form-input" placeholder="验证码" type="text" name="code">  
	         	<input type="hidden" id="yanzheng">
	         	<input type="button" name="huoquYanzhengma" id="btnSendCode" value="免费获取验证码" onclick="sendMessage()"/> 
	         	<div class="colorwhite" >（注意：若没收到短信，可能是今日短信发送已达上限）</div> 		
			</div>
		<div class="colorwhite" >${usernameerror}</div>
		<div class="colorwhite" >${passworderror}</div>
		<div class="colorwhite" >${codeerror}</div>
		<div><input type="submit" class="btn btn-primary btn-submit" value="注&nbsp;&nbsp;册" ></div>
	</form>
	</div>
	</div>
	
</div>


	<script language="javascript">
	$(window).scroll(function () {
		if ($(".navbar").offset().top > 25) {$(".navbar-fixed-top").addClass("top-nav");
		}else {$(".navbar-fixed-top").removeClass("top-nav");}
	})	
	</script>
<script type="text/javascript"> 


/*-------------------------------------------*/  
var InterValObj; //timer变量，控制时间  
var count = 120; //间隔函数，1秒执行  
var curCount;//当前剩余秒数  
var code = ""; //验证码  
var codeLength = 6;//验证码长度  
function sendMessage() {  
    curCount = count;  
    var phone=$("#phone").val();//手机号码  
    if(phone != ""){  
        //产生验证码  
        for (var i = 0; i < codeLength; i++) {  
            code += parseInt(Math.random() * 9).toString();  
        }  
        //设置button效果，开始计时  
        if(getCookie("curCount")==null){
       		setCookie("curCount", 120);
        }
        else{
        		setCookie("curCount", curCount);
        }
        $("#btnSendCode").attr("disabled", "true");  
        $("#btnSendCode").val("请在" + getCookie("curCount") + "秒内输入验证码");  
        InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次  
    //向后台发送处理数据  
        $.ajax({  
            type: "POST", //用POST方式传输  
            dataType: "text", //数据格式:JSON    
	        url:"sendsms.action",//目标地址  
            data: "phone=" + phone + "&code=" + code,  
            error: function (XMLHttpRequest, textStatus, errorThrown) {alert(" 错误，无法发送短信")	 },  
            success: function (msg){ alert("SKYCLOUD--<%=session.getAttribute("globalmessage")%>")}  
        });  
    }else{  
        alert("手机号码不能为空！");  
    }  
}  
//timer处理函数  
function SetRemainTime() {  
    if (curCount <= 0) {   
      	delCookie("curCount"); 
        window.clearInterval(InterValObj);//停止计时器  
        $("#btnSendCode").removeAttr("disabled");//启用按钮  
        $("#btnSendCode").val("重新发送验证码");  
        code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效      
    }  
    else {  
        curCount--; 
        setCookie("curCount", curCount); 
        $("#btnSendCode").val("请在" + curCount + "秒内输入验证码");  
    }  
}  


//设计Cookie的值  
function setCookie(name,value){   
    var Days = 30;   
    var exp = new Date();   
    exp.setTime(exp.getTime() + Days*24*60*60*1000);   
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();   
}  
  
//获取Cookie的值  
function getCookie(name){   
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");  
   
    if(arr=document.cookie.match(reg))  
        return unescape(arr[2]);   
    else   
        return null;   
}  
  
//删除Cookie中的值  
function delCookie(name){   
    var exp = new Date();   
    exp.setTime(exp.getTime() - 1);   
    var cval=getCookie(name);   
    if(cval!=null)   
        document.cookie= name + "="+cval+";expires="+exp.toGMTString();   
}  
	
</script>  
    
   
      

    
	
	
	</body>
</html>
