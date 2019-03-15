<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>G13-SkyCloud云存储－用户群组</title>
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
			     <li> <a href="${pageContext.request.contextPath}/requestout.action" >注销</a> </li>
			    	 <li> <a href="${pageContext.request.contextPath}/index.jsp" >首页</a> </li>
			     <li> <a href="${pageContext.request.contextPath}/help.jsp">帮助</a> </li>
			     <li> <a href="${pageContext.request.contextPath}/autologin.action?user_name=${user_name}" >我的主页</a> </li>
			     <li> <a href="${pageContext.request.contextPath}/grouphome.action" >我的群组</a></li>
			     
		</ul>
	</div>	
	</div>
	</nav>
	
<div class="bg">
  	 <br/>
  	 <br/>
   	 <div style="font-size: 30px ; color: white; font-style: italic;"><font>Files In SkyCloud of this Group</font></div>
   	 <div style="font-size: 20px; font-style: oblique; float:inherit;
   	 		color:#3B89F5 ">${group_name}</div>
   	 <div style="font-size: 20px; font-style: oblique; float:inherit;
   	 		color:#3B89F5 ">Admin: ${admin_name}</div>
     <br/>
     <br/>
	 <style type="text/css">
   		.even{background-color: pink}
    		.old{background-color: yellow}
  	</style>
  	 <table frame="border" width="100%" align="center">
     <tr>
    		<td>文件名</td>
    		<td>文件大小</td>
    		<td>上传日期</td>
    		<td>下载文件</td>
    		<td>是否共享</td>
    		<td>操作</td>
    	 <tr>
    	
    	<c:forEach var="c" items="${requestScope.pagebean_groupfile.list}" varStatus="stat">
    		<tr class="${stat.count%2==0?'even':'old'}">
	    		<td>${c.filename }</td>
	    		<td>${c.filesize }</td>
	    		<td>${c.createtime }</td>
	    		<td>
	    			<a href="${pageContext.request.contextPath}/download.action?id=${c.id }&filename=${c.filename}">下载</a>
	    		</td>
	    		<td>
	    		<form>
	    		      <select  id="${c.id}" onchange="gochange(${pagebean_groupfile.currentpage},${c.id})" >
	    		         <c:if test="${c.canshare==0 }">
    					         <option value="0">私有</option> 
    					         <option value="1" >共享</option> 
    					 </c:if>
	    		         <c:if test="${c.canshare==1 }">
   						         <option value="1" selected="selected">共享</option>
    					         <option value="0" >私有</option> 
 					  </c:if>
 					  </select>
 			    </form>
	    		</td>
	    		<td>
                  <a href="javascript:void(0)" onclick="godelete(${pagebean_groupfile.currentpage},${c.id})">删除文件</a>
	    		</td>
    		<tr>
    	</c:forEach>
    	
    </table>
     <br/>
       共[${requestScope.pagebean_groupfile.totalrecord}]条记录,
     每页 <input type="text" id = "pagesize" value="${pagebean_groupfile.pagesize }" onchange="gotopage(${pagebean_groupfile.currentpage})" style="width:100px;color:#3B89F5;" maxlength="5">条
       共[${requestScope.pagebean_groupfile.totalpage}]页,
       当前是第[${requestScope.pagebean_groupfile.currentpage}]页
       </br>
      <a href="javascript:void(0)" onclick="gotopage(1)">回到首页</a>
      <a href="javascript:void(0)" onclick="gotopage(${requestScope.pagebean_groupfile.previouspage})">上一页</a> 
           <c:forEach var="pagenum" items="${requestScope.pagebean_groupfile.pagebar}">
               <c:if test="${pagenum==pagebean_groupfile.currentpage }">
                   <font color="red">${pagenum }</font>
		       </c:if>
		        <c:if test="${pagenum!=pagebean_groupfile.currentpage }">
                  <a href="javascript:void(0)" onclick="gotopage(${pagenum})">${pagenum}</a>
		       </c:if>
           </c:forEach>
      <a href="javascript:void(0)" onclick="gotopage(${requestScope.pagebean_groupfile.nextpage})">下一页</a>   
      <input type="button" style="background-color: #3B89F5;border-color: #3B89F5;" value="跳转至第" onclick="gotopage1(document.getElementById('pagenum').value)" />
      <input type="text" style="width:100px;color:#3B89F5;" maxlength="5" id="pagenum">页
</div>

  
  
 	<script language="javascript">
	$(window).scroll(function () {
		if ($(".navbar").offset().top > 25) {$(".navbar-fixed-top").addClass("top-nav");
		}else {$(".navbar-fixed-top").removeClass("top-nav");}
	})	
	</script>
  <script type="text/javascript">
      
      function godelete(currentpage,fileid){
    	  var pagesize = document.getElementById("pagesize").value;
    	  
    	  if(pagesize > 10 || pagesize >= ${pagebean_groupfile.totalrecord - pagebean_groupfile.pagesize * ( pagebean_groupfile.currentpage - 1 )}){
    		  pagesize = Math.min(pagesize,${pagebean_groupfile.totalrecord});
    		  currentpage = 1 ;
    	  }else if(pagesize < 1){
    		  pagesize = 1;
    	  }
    	  
    	  var r=confirm("确认删除文件？");
    	  if(r==true){
        	  window.location.href = '${pageContext.request.contextPath}/groupdeletefile.action?currentpage='+currentpage+'&pagesize='+ pagesize+'&id='+fileid;
    	  }else{
    		  return false;
    	  }
      }
      
      function gochange(currentpage,fileid){
    	  
    	  var canshare = document.getElementById(fileid).value;
    	  var pagesize = document.getElementById("pagesize").value;
    	  var r=confirm("如果设置共享，您的文件将可以被其他人搜索到");
    	  if (r==true){
        	  window.location.href = '${pageContext.request.contextPath}/groupchangefilestatus.action?currentpage='+currentpage+'&pagesize='+ pagesize+'&id='+fileid+'&canshare='+canshare;
    	  }else{
    		  location.reload();
    	  }
      }
      
  </script>  
      
  <script type="text/javascript">
      function gotopage(currentpage){
    	  
    	  var pagesize = document.getElementById("pagesize").value;
    	  
    	  if(pagesize > 10 || pagesize >= ${pagebean_groupfile.totalrecord - pagebean_groupfile.pagesize * ( pagebean_groupfile.currentpage - 1 )}){
    		  pagesize = Math.min(10,${pagebean_groupfile.totalrecord});
    		  currentpage = 1 ;
    	  }else if(pagesize < 1){
    		  pagesize = 1;
    	  }
    	  window.location.href = '${pageContext.request.contextPath}/searchGroupfile.action?currentpage='+currentpage+'&pagesize='+ pagesize;
    	  
      }
  
      function gotopage1(currentpage){
    	  
    	  var pagesize = document.getElementById("pagesize").value;
    	  
    	  if(currentpage > ${pagebean_groupfile.totalpage}){
    		  currentpage = ${pagebean_groupfile.totalpage};
    		  pagesize = ${pagebean_groupfile.pagesize};
    	  }else if(currentpage < 1){
    		  currentpage = 1 ;
    		  pagesize = ${pagebean_groupfile.pagesize};
    	  }
    	  
    	  window.location.href = '${pageContext.request.contextPath}/searchGroupfile.action?currentpage='+currentpage+'&pagesize='+ pagesize;
      }
  </script>
  
    <script type="text/javascript">
        var vipmaxsize = 50*1024*1024 ;
        var normalmaxsize = 20*1024*1024 ;
        var viperrMsg = "VIP用户上传的附件文件不能超过50M！！！";
        var normalerrMsg = "普通用户上传的附件文件不能超过20M！！！";
        var tipMsg = "建议使用chrome firefox ie等浏览器";  
        var  browserCfg = {};
        //下面一段鉴别使用者的浏览器
        var ua = window.navigator.userAgent;
        if (ua.indexOf("MSIE")>=1){
            browserCfg.ie = true;
        }else if(ua.indexOf("Firefox")>=1){  
            browserCfg.firefox = true;  
        }else if(ua.indexOf("Chrome")>=1){  
            browserCfg.chrome = true;  
        }  
        function checkfile(){  
            try{  
                var obj_file = document.getElementById("fileupload"); 
                var isvip = ${isvip};
                if(obj_file.value==""){  
                    alert("请先选择上传文件");  
                    return;  
               } 
                var filesize = 0;  
                if(browserCfg.firefox || browserCfg.chrome ){  
                    filesize = obj_file.files[0].size;  //chrome等浏览器支持这个方法拿到文件大小
                }else if(browserCfg.ie){  
                    var obj_img = document.getElementById('tempimg');  
                    obj_img.dynsrc=obj_file.value;  
                    filesize = obj_img.fileSize;  
                }else{  
                    alert(tipMsg);  
                return false;  
                }  
                if(filesize==-1){  
                    alert(tipMsg);  
                    return false;  
                }else if(isvip==1 && filesize>vipmaxsize){  
                    alert(viperrMsg);  
                    return false;  
                }else if(isvip==0 && filesize>normalmaxsize){
                    alert(normalerrMsg);  
                    return false;  
                }else{  
                    return true;  
                }  
            }catch(e){  
                alert(e); 
                return false; 
            } 
           }
  </script>
  
  </div>
             
  
  </div>
</body>
</html>




		
		
		