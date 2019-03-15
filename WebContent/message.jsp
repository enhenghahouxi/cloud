<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>G13-SkyCloud云存储系统-错误</title>
<style>
		.bg {display: table;width: 100%;height: 100%;padding: 100px 0;text-align: center;color: #fff;background: url(https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky999.jpeg) no-repeat center center;background-color: #000;background-size: cover;}
</style>
</head>
<body>
    <div class="bg">
	<script type="text/javascript">
		var time = 5; //时间,秒
		function Redirect() {
		    window.location = "${pageContext.request.contextPath}/searchUserfile.action";
		}
		var i = 0;
		function dis() {
		    document.all.s.innerHTML = "****** 错误信息： ${globalmessage} ******   " + (time - i) + "秒后自动跳往主页";
		    i++;
		}
		timer = setInterval('dis()', 1000); //显示时间
		timer = setTimeout('Redirect()', time * 1000); //跳转
	</script>
      <span id="s"></span>
    </div>
</body>
</html>
