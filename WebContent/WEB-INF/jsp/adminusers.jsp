<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>G13-SkyCloud云存储系统－管理员管理</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Josefin+Sans:400,700,700italic,600'>
	<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="mycss.css">
	<style>
		.bg {display: table;width: 100%;height: 100%;padding: 100px 0;text-align: center;color: #fff;background: url(https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky111.png) no-repeat center center;background-color: #000;background-size: cover;}
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
			<li> <a href="${pageContext.request.contextPath}/login.jsp" >退出</a></li>
			<li> <a href="${pageContext.request.contextPath}/adminhome.action" >管理菜单</a></li>
		</ul>
	</div>	
	</div>
	</nav>
	
<div class="bg">
	
 <div style="font-size: 30px ; color: white; font-style: italic;"><font>All Users In SkyCloud</font></div>
   	  <div style="font-size: 20px; font-style: oblique; float:inherit;
   	 		color:#3B89F5 ">Admin: ${admin_name}</div>
     <br/>
     <br/>
	 <style type="text/css">
    		.even{background-color: pink}
    		.old{background-color: yellow}
  	 </style>


  	 <table frame="border" width="100%" align="center">
	   	 <tr >
	    		<td>用户账号</td>
	    		<td>用户密码</td>
	    		<td>创建日期</td>
	    		<td>已使用容量</td>
	    		<td>总容量</td>
	    		<td>进入该用户空间</td>
	    		
	    		<td>用户电话号码</td>
	     <tr>
    	
	    	<c:forEach var="c" items="${requestScope.pagebean_user.list}" varStatus="stat">
	    		<tr class="${stat.count%2==0?'even':'old'}">
		    		<td>${c.username }</td>
		    		<td>${c.password } </td>
		    		<td>${c.createtime }</td>
		    		<td>${c.usedcapa }</td>
		    		<td>${c.totalcapa }</td>
		    		<td>
		    			<a href="${pageContext.request.contextPath}/enteruserhome.action?username=${c.username}">进入</a>
		    		</td>
		    		
				<td>${c.phone }</td>
	    		<tr>
	    	</c:forEach>
    	
    </table>
    
     <br/>
       共[${requestScope.pagebean_user.totalrecord}]条记录,
     每页 <input type="text" id = "pagesize" value="${pagebean_user.pagesize }" onchange="gotopage(${pagebean_user.currentpage})" style="width:100px;color:#3B89F5;" maxlength="5">条
       共[${requestScope.pagebean_user.totalpage}]页,
       当前是第[${requestScope.pagebean_user.currentpage}]页
      <a href="javascript:void(0)" onclick="gotopage(1)">回到首页</a>
      <a href="javascript:void(0)" onclick="gotopage(${requestScope.pagebean_user.previouspage})">上一页</a> 
           <c:forEach var="pagenum" items="${requestScope.pagebean_user.pagebar}">
               <c:if test="${pagenum==pagebean_user.currentpage }">
                   <font color="red">${pagenum }</font>
		       </c:if>
		        <c:if test="${pagenum!=pagebean_user.currentpage }">
                  <a href="javascript:void(0)" onclick="gotopage(${pagenum})">${pagenum}</a>
		       </c:if>
           </c:forEach>
      <a href="javascript:void(0)" onclick="gotopage(${requestScope.pagebean_user.nextpage})">下一页</a>   
      <input type="button" style="background-color: #3B89F5;border-color: #3B89F5;" value="跳转至第" onclick="gotopage1(document.getElementById('pagenum').value)" />
      <input type="text" style="width:100px;color:#3B89F5;" maxlength="5" id="pagenum">页
      
</div>
        
  <script type="text/javascript">
		
      
      function deleteuser(currentpage,groupid){
	    	  var pagesize = document.getElementById("pagesize").value;
	    	  
	    	  if(pagesize > 10 || pagesize >= ${pagebean_user.totalrecord - pagebean_user.pagesize * ( pagebean_user.currentpage - 1 )}){
	    		  pagesize = Math.min(pagesize,${pagebean_user.totalrecord});
	    		  currentpage = 1 ;
	    	  }else if(pagesize < 1){
	    		  pagesize = 1;
	    	  }
    	  
	    	  var r=confirm("确认删除?");
	    	  if(r==true){
	        	  window.location.href = '${pageContext.request.contextPath}/delectuser.action?currentpage='+currentpage+'&pagesize='+ pagesize+'&groupid='+groupid;
	    	  }else{
	    		  return false;
	    	  }
  }
      
  </script>  
      
  <script type="text/javascript">
      function gotopage(currentpage){
    	  
	    	  var pagesize = document.getElementById("pagesize").value;
	    	  
	    	  if(pagesize > 10 || pagesize >= ${pagebean_user.totalrecord - pagebean_user.pagesize * ( pagebean_user.currentpage - 1 )}){
	    		  pagesize = Math.min(10,${pagebean_user.totalrecord});
	    		  currentpage = 1 ;
	    	  }else if(pagesize < 1){
	    		  pagesize = 1;
	    	  }
	    	  window.location.href = '${pageContext.request.contextPath}/adminusers.action?currentpage='+currentpage+'&pagesize='+ pagesize;
	    	  
	  }
  
      function gotopage1(currentpage){
    	  
	    	  var pagesize = document.getElementById("pagesize").value;
	    	  
	    	  if(currentpage > ${pagebean_user.totalpage}){
	    		  currentpage = ${pagebean_user.totalpage};
	    		  pagesize = ${pagebean_user.pagesize};
	    	  }else if(currentpage < 1){
	    		  currentpage = 1 ;
	    		  pagesize = ${pagebean_user.pagesize};
	    	  }
    	  
    	  	window.location.href = '${pageContext.request.contextPath}/adminusers.action?currentpage='+currentpage+'&pagesize='+ pagesize;
      }
  </script>
  
</body>
</html>




		
		
		





		
		