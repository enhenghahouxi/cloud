<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb 
hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius 
boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d 
csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg
 inlinesvg smil svgclippaths">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta name="viewport" content="width=1280, maximum-scale=1.0" />	
		<!-- <base href = "http://blacknegative.com/" > -->
		<link href="http://blacknegative.com/skins/blacknegative/css/min.css" media="screen" rel="stylesheet" type="text/css" >
		<style type="text/css">
        		html, body {width:100%;height:100%;} /*非常重要的样式让背景图片100%适应整个屏幕*/
        		a {
    				color: white;
    				text-decoration: none
    				
			}
			.div1 { text-transform:uppercase;font-size: 30px; font-family:'GeosansLightRegular';}
			.div1:hover { font-size: 42px; }
			#skycloud-caption {
			    position: absolute;
			    bottom: 70px;
			    left: 50%;
			    width: 158px;
			    height: 32px;
			    margin-left: -79px;
			    background-image: url("http://blacknegative.com/skins/blacknegative/images/whoweare/whoweare.png");
			    background-position: center center;
			    background-repeat: no-repeat
			}
        </style>
		<title>G13-Skycloud</title>
		<script  type="text/javascript" async src="http://www.google-analytics.com/ga.js" ></script>
		<script type="text/javascript" src="http://blacknegative.com/js/min.js"></script>
		<script type="text/javascript" src="http://blacknegative.com/js/init.js"></script>		
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta property="og:image" content="http://www.blacknegative.com/images/thumb.jpg" />
		<meta property="og:type" content="website" />
		<meta property="og:url" content="http://www.blacknegative.com" />
		<meta property="og:title" content="blacknegative" />
</head>


<body style="cursor:auto;">
	
		<div id="whoweare-loop" style="opacity:1;">			
			<div id="whoweare-loop-vedio" >
					<video autoplay loop style="width: 100%; height: auto; left: 0px; top:auto;">
						<script language="JavaScript">
						  var _gaq = _gaq || [];
						  _gaq.push(['_setAccount', 'UA-31695580-1']);
						  _gaq.push(['_trackPageview']);
						
						  (function() {
						    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
						    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
						    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
						  })();
						 var ss = new Array("http://blacknegative.com/uploads/section/client/loop",
								 "http://blacknegative.com/uploads/section/whoweare/loop",
								 "http://blacknegative.com/uploads/section/contact/loop"
								);					
						 var num = parseInt(Math.random() * ss.length);  
						 document.write("<source src="+ss[num]+".mp4" )
						 document.write(" type=\"video/mp4\">" )
						 document.write("<source src="+ss[num]+".webm" )
						 document.write(" type=\"video/webm\">" )
						 document.write("<source src="+ss[num]+".ogg" )
						 document.write(" type=\"video/ogg\">" )
					</script>
				</video>
			</div>
			
		</div>
		    
		<div id="whoweare-mask"></div>
		
		<div id="whoweare-section-container" style="margin-top:-67px;">
			<center >	
				
			<div class="whoweare-section hover" id="telling">
				<div class="whoweare-title" style="height:32px;margin-top:0px;margin-bottom:0px;">
					<div class="div1">
					<a href="${pageContext.request.contextPath}/login.jsp" style="display: block;">LOG IN</a>
					</div>
				</div>
			</div>
			
			<div class="whoweare-section-separation"></div>
			
			<div class="whoweare-section hover" id="fascinating">
				<div class="whoweare-title" style="height:32px;margin-top:0px;margin-bottom:0px;">
					<div class="div1">
					<a href="${pageContext.request.contextPath}/help.jsp" style="display: block;">HELP</a>
					</div>
				</div>
			</div>
			
			<div class="whoweare-section-separation" ></div>
			
			<div class="whoweare-section hover" id="story">
				<div class="whoweare-title" style="height:32px;margin-top:0px;margin-bottom:none;">
					<div class="div1">
					<a href="${pageContext.request.contextPath}/aboutus.jsp" style="display: block;">STORIES</a>
					</div>
				</div>
			</div>
				
		</center>
		</div>
			<div id="skycloud-caption"></div>					
		<div>			
		
			<script type="text/javascript">
			<!--//--><![CDATA[//><!--
            var images = new Array()
            function preload() {
                for (i = 0; i < preload.arguments.length; i++) {
                    images[i] = new Image()
                    images[i].src = preload.arguments[i]
                }
            }
            preload(
                "https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky0.jpeg",
                "https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky1.jpeg",
                "https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky2.jpeg",
                "https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky3.jpeg",
                "https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky4.jpeg",
                "https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky5.jpeg",
                "https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky6.jpeg",
                "https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky7.jpeg",
                "https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky8.jpeg",
                "https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky9.jpeg",
                "https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky666.jpeg",
                "https://skycloudpic.oss-cn-hangzhou.aliyuncs.com/sky999.jpeg"    
            )
             //--><!]]>
       	 </script>
        </div>
</body>
</html>