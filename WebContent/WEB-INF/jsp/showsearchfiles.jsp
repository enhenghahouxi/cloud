<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>SkyGroup云存储-文件搜索结果</title>
    <meta charset="utf-8" />
    <link href="styles1.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>

    <script language="javascript" type="text/javascript" src="jquery.js"></script>
    <script language="javascript" type="text/javascript" src="jquery.bstablecrosshair.js"></script>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   	<link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="mycss.css">
	<style>
		<%int seconds = (int) (Math.floor(Math.random()*10)); %>
		.bg {display: table;width: 100%;height: 100%;padding: 100px 0;text-align: center;color: #fff;background: url(https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky<%=seconds%>.jpeg) no-repeat center center;background-color: #000;background-size: cover;}
	</style>
</head>
<body >
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
					<li> <a href="${pageContext.request.contextPath}/index.jsp" >首页</a></li>
					<li>	 <a href="${pageContext.request.contextPath}/help.jsp">帮助</a></li>
				</ul>
			</div>	
		</div>
	</nav>
	
	
	<div class="bg">
		<style type="text/css">
    	   	.even{background-color: #436EEE}
    		.old{background-color: #FF4040}	
		</style>
		  
		<br/>
		<font size="60px">SkyCloud搜索结果</font><br/><br/>
	    
	    <table frame="border" width="100%" align="center">
	    	<tr>
	    		<td>文件名</td>
	    		<td>文件大小</td>
	    		<td>创建日期</td>
	    		<td>文件来源</td>
	    		<td>下载文件</td>
    		<tr>
    	
    	<c:forEach var="c" items="${requestScope.pagebean.list}" varStatus="stat">
    		<tr class="${stat.count%2==0?'even':'old'}">
	    		<td>${c.filename }</td>
	    		<td>${c.filesize } kb</td>
	    		<td>${c.createtime }</td>
	    		<td>${c.filepath }</td>
	    		<td>
	    			<a href="${pageContext.request.contextPath}/download.action?id=${c.id }&filename=${c.filename }" style="color:black;">->下载</a>
	    		</td>
    		<tr>
    	</c:forEach>
    	
    </table>
    <br/>
       共[${requestScope.pagebean.totalrecord}]条记录,
     每页 <input type="text" id = "pagesize" value="${pagebean.pagesize }" onchange="gotopage(${pagebean.currentpage})" style="width:100px;color:#3B89F5;" maxlength="5">条
       共[${requestScope.pagebean.totalpage}]页,
       当前是第[${requestScope.pagebean.currentpage}]页,
      <a href="javascript:void(0)" onclick="gotopage(1)">回到首页</a>
      <a href="javascript:void(0)" onclick="gotopage(${requestScope.pagebean.previouspage})">上一页</a> 
           <c:forEach var="pagenum" items="${requestScope.pagebean.pagebar}">
               <c:if test="${pagenum==pagebean.currentpage }">
                   <font color="red">${pagenum }</font>
		       </c:if>
		        <c:if test="${pagenum!=pagebean.currentpage }">
                  <a href="javascript:void(0)" onclick="gotopage(${pagenum})">${pagenum}</a>
		       </c:if>
           </c:forEach>
      <a href="javascript:void(0)" onclick="gotopage(${requestScope.pagebean.nextpage})">下一页</a>   
      <input type="button" value="跳转至第" onclick="gotopage1(document.getElementById('pagenum').value)" />
      <input type="text" style="width:100px;color:#3B89F5;" maxlength="5" id="pagenum">页
      
      <input type="hidden" id="searchcontent" value="${searchcontent}">
   </div>
    	<script language="javascript">
	$(window).scroll(function () {
		if ($(".navbar").offset().top > 5) {$(".navbar-fixed-top").addClass("top-nav");
		}else {$(".navbar-fixed-top").removeClass("top-nav");}
	})	
	</script>  
  <script type="text/javascript">
      function gotopage(currentpage){
    	  
    	  var pagesize = document.getElementById("pagesize").value;
    	  var searchcontent = document.getElementById("searchcontent").value;
    	  
    	  if(pagesize > 10 || pagesize >= ${pagebean.totalrecord - pagebean.pagesize * ( pagebean.currentpage - 1 )}){
    		  pagesize = Math.min(pagesize,${pagebean.totalrecord});
    		  currentpage = 1 ;
    	  }else if(pagesize < 1){
    		  pagesize = 1;
    	  }
    	  
    	  window.location.href = '${pageContext.request.contextPath}/listfiles.action?currentpage='+currentpage+'&pagesize='+ pagesize+'&searchcontent='+searchcontent;
      }
  
      function gotopage1(currentpage){
    	  
    	  var pagesize = document.getElementById("pagesize").value;
    	  var searchcontent = document.getElementById("searchcontent").value;
    	  
    	  if(currentpage > ${pagebean.totalpage}){
    		  currentpage = ${pagebean.totalpage};
    		  pagesize = ${pagebean.pagesize};
    	  }else if(currentpage < 1){
    		  currentpage = 1 ;
    		  pagesize = ${pagebean.pagesize};
    	  }
    	  
    	  window.location.href = '${pageContext.request.contextPath}/listfiles.action?currentpage='+currentpage+'&pagesize='+ pagesize+'&searchcontent='+searchcontent;
      }
  </script>
  </div>
  </body>
</html>
