<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>G13-SkyCloud云存储－aboutus</title>
    <meta charset="utf-8" />
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
		.sparkley {
			  background: #3e5771;
			  color: white;
			  border: none;
			  padding: 16px 36px;
			  font-weight: normal;
			  border-radius: 3px;
			  transition: all 0.25s ease;
			  box-shadow: 0 38px 32px -23px black;
			  margin: 0 1em 1em;
		}
		.sparkley:hover {
		  background: #2c3e50;
		  color: rgba(255, 255, 255, 0.2);
		}
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
      			<li>	 <a href="${pageContext.request.contextPath}/help.jsp">帮助</a></li> 
       			<li>	 <a href="${pageContext.request.contextPath}/adminrequestin.action" >管理员登录</a> </li>      
            </ul>
        </div>
    </div>
</nav> 



 <div class="bg" >
    <div class="bg-div"></div>
    <h1> 我们 <span> 是 </span> G13 </h1>
	<h1> 2018年3月中旬 <span> 我们G13 </span> 创立了!</h1>

	<button class="sparkley">以下是我们的版本更新记录!!</button>
	<button class="sparkley last">欢迎各位提出意见和建议!!</button>
	
	<br/>
	<br/>
	<h1><span style="color:#FFFF00;">版本0.1</span> <span> 项目demo确定并基本成型 </span>［2018.3.25］</h1>
	<br/>
	<h1><span style="color:#00FFFF;">版本1.0</span> 项目demo成功在eclipse上运行 </span>［2018.4.23］</h1>
	<h1><span style="color:#00FFFF;">版本1.2</span> 实现基本的登录注册和文件操作功能 </span>［2018.4.25］</h1>
	<br/>
	<h1 ><span style="color:#FF4500;">版本2.0</span> 引入了spring框架重构代码 </span>［2018.4.30］</h1>
	<h1 ><span style="color:#FF4500;">版本2.1</span> 增加了群组模块，包括群组的创建和搜索以及加入 </span>［2018.5.3］</h1>
	<h1 ><span style="color:#FF4500;">版本2.2</span> 完善了群组功能，包括群组的退出和创建人的显示 </span>［2018.5.4］</h1>
	<h1 ><span style="color:#FF4500;">版本2.3</span> 完善了群组功能，包括群组空间的进入和相关的文件操作 </span>［2018.5.6］</h1>
	<br/>
	<h1 ><span style="color:#FF00FF;">版本3.0</span><span> 改进了包括背景在内的css样式;优化数据库结构;增加了管理员登录模块 </span>［2018.5.18］</h1>
	<br/>
	<h1><span style="color:#1E90FF;">版本4.0</span><span> 项目成功部署于阿里云服务器；改进了登录和注册功能 </span>［2018.5.22］</h1>
	<h1><span style="color:#1E90FF;">版本4.1</span>版本4.1 <span> 修复了菜单栏的漏洞 </span>［2018.5.23］</h1>
	<h1><span style="color:#1E90FF;">版本4.2</span><span> 添加了一些跳转页面,并修改了原有的跳转页面 </span>［2018.5.24］</h1>
	<h1><span style="color:#1E90FF;">版本4.3</span><span> 统一了css；实现了多个高清背景的随机出现 </span>［2018.5.26］</h1>
	<h1><span style="color:#1E90FF;">版本4.4</span><span> 完善了群组功能，包括群组的解散 </span>［2018.5.27］</h1>
	<h1><span style="color:#1E90FF;">版本4.5</span> <span> 实现了全站的对象存储oss化 </span>［2018.6.3］</h1>
	<h1><span style="color:#1E90FF;">版本4.6</span><span> 添加了动态首页；添加了帮助页面 </span>［2018.6.6］</h1>
	<br/>
	<h1><span style="color:#00FF00;">版本5.1</span> <span> 实现短信注册功能 </span>［2018.6.8］</h1>
	<h1><span style="color:#00FF00;">版本5.2</span><span> 修复了全局搜索操作的漏洞;完善了管理员的用户管理功能 </span>［2018.6.9］</h1>
	<h1><span style="color:#00FF00;">版本5.3</span><span> 修复了短信注册的漏洞 </span>［2018.6.12］</h1>
	<h1><span style="color:#00FF00;">版本5.4</span> <span> 添加了查看群组成员信息功能;完善了管理员的文件管理功能 </span>［2018.6.19］</h1>
	<h1><span style="color:#00FF00;">版本5.5</span> <span> 增加文件搜索结果的显示项(用于标明文件的来源) </span>［2018.6.21］</h1>
	<h1><span style="color:#00FF00;">版本5.6</span> <span> 编写了stories页面;改进了短信注册的功能 </span>［2018.6.23］</h1>
	
	 </div> 
	 
	 	<script language="javascript">
	$(window).scroll(function () {
		if ($(".navbar").offset().top > 5) {$(".navbar-fixed-top").addClass("top-nav");
		}else {$(".navbar-fixed-top").removeClass("top-nav");}
	})	
	</script>
 <script type="text/javascript">
 $(function() {

	  // default is varying levels of transparent white sparkles
	  $(".sparkley:first").sparkleh();

	  // rainbow as a color generates random rainbow colros
	  // count determines number of sparkles
	  // overlap allows sparkles to migrate... watch out for other dom elements though.
	  $(".sparkley:last").sparkleh({
	    color: "rainbow",
	    count: 100,
	    overlap: 10
	  });

	  // here we create fuscia sparkles
	  $("h1").sparkleh({
	    count: 80,
	    color: "#ff0080"
	  });

	  $("p").sparkleh({
	    count: 20,
	    color: "#00ff00"
	  });

	  // an array can be passed, too for colours
	  // for an image, the image needs to be fully loaded to set
	  // the canvas to it's height/width.
	  $("#image").imagesLoaded( function() {
	    $(".img").sparkleh({
	      count: 25,
	      color: ["#00afec","#fb6f4a","#fdfec5"]
	    });
	  });

	});

	$.fn.sparkleh = function( options ) {

	  return this.each( function(k,v) {

	    var $this = $(v).css("position","relative");

	    var settings = $.extend({
	      width: $this.outerWidth(),
	      height: $this.outerHeight(),
	      color: "#FFFFFF",
	      count: 30,
	      overlap: 0
	    }, options );

	    var sparkle = new Sparkle( $this, settings );

	    $this.on({
	      "mouseover focus" : function(e) {
	        sparkle.over();
	      },
	      "mouseout blur" : function(e) {
	        sparkle.out();
	      }
	    });

	  });

	}

	function Sparkle( $parent, options ) {
	  this.options = options;
	  this.init( $parent );
	}

	Sparkle.prototype = {

	  "init" : function( $parent ) {

	    var _this = this;

	    this.$canvas = 
	      $("<canvas>")
	        .addClass("sparkle-canvas")
	        .css({
	          position: "absolute",
	          top: "-"+_this.options.overlap+"px",
	          left: "-"+_this.options.overlap+"px",
	          "pointer-events": "none"
	        })
	        .appendTo($parent);

	    this.canvas = this.$canvas[0];
	    this.context = this.canvas.getContext("2d");
	    this.sprite = new Image();

	    this.canvas.width = this.options.width + ( this.options.overlap * 2);
	    this.canvas.height = this.options.height + ( this.options.overlap * 2);

	    this.sprites = [0,6,13,20];
	    this.particles = this.createSparkles( this.canvas.width , this.canvas.height );

	    this.anim = null;
	    this.fade = false;

	  },

	  "createSparkles" : function( w , h ) {

	    var holder = [];

	    for( var i = 0; i < this.options.count; i++ ) {

	      var color = this.options.color;

	      if( this.options.color == "rainbow" ) {
	        color = '#'+Math.floor(Math.random()*16777215).toString(16);
	      } else if( $.type(this.options.color) === "array" ) {
	        color = this.options.color[ Math.floor(Math.random()*this.options.color.length) ];
	      }

	      holder[i] = {
	        position: {
	          x: Math.floor(Math.random()*w),
	          y: Math.floor(Math.random()*h)
	        },
	        style: this.sprites[ Math.floor(Math.random()*4) ],
	        delta: {
	          x: Math.floor(Math.random() * 1000) - 500,
	          y: Math.floor(Math.random() * 1000) - 500
	        },
	        size: parseFloat((Math.random()*2).toFixed(2)),
	        color: color
	      };

	    }

	    return holder;

	  },

	  "draw" : function( time, fade ) {

	    var ctx = this.context;
	    var img = this.sprite;
	        img.src = this.datauri;

	    ctx.clearRect( 0, 0, this.canvas.width, this.canvas.height );

	    for( var i = 0; i < this.options.count; i++ ) {

	      var derpicle = this.particles[i];
	      var modulus = Math.floor(Math.random()*7);

	      if( Math.floor(time) % modulus === 0 ) {
	        derpicle.style = this.sprites[ Math.floor(Math.random()*4) ];
	      }

	      ctx.save();
	      ctx.globalAlpha = derpicle.opacity;
	      ctx.drawImage(img, derpicle.style, 0, 7, 7, derpicle.position.x, derpicle.position.y, 7, 7);

	      if( this.options.color ) {  

	        ctx.globalCompositeOperation = "source-atop";
	        ctx.globalAlpha = 0.5;
	        ctx.fillStyle = derpicle.color;
	        ctx.fillRect(derpicle.position.x, derpicle.position.y, 7, 7);

	      }

	      ctx.restore();

	    }

	  },

	  "update" : function() {

	     var _this = this;

	     this.anim = window.requestAnimationFrame( function(time) {

	       for( var i = 0; i < _this.options.count; i++ ) {

	         var u = _this.particles[i];

	         var randX = ( Math.random() > Math.random()*2 );
	         var randY = ( Math.random() > Math.random()*3 );

	         if( randX ) {
	           u.position.x += (u.delta.x / 1500); 
	         }        

	         if( !randY ) {
	           u.position.y -= (u.delta.y / 800);         
	         }

	         if( u.position.x > _this.canvas.width ) {
	           u.position.x = -7;
	         } else if ( u.position.x < -7 ) {
	           u.position.x = _this.canvas.width; 
	         }

	         if( u.position.y > _this.canvas.height ) {
	           u.position.y = -7;
	           u.position.x = Math.floor(Math.random()*_this.canvas.width);
	         } else if ( u.position.y < -7 ) {
	           u.position.y = _this.canvas.height; 
	           u.position.x = Math.floor(Math.random()*_this.canvas.width);
	         }

	         if( _this.fade ) {
	           u.opacity -= 0.02;
	         } else {
	           u.opacity -= 0.005;
	         }

	         if( u.opacity <= 0 ) {
	           u.opacity = ( _this.fade ) ? 0 : 1;
	         }

	       }

	       _this.draw( time );

	       if( _this.fade ) {
	         _this.fadeCount -= 1;
	         if( _this.fadeCount < 0 ) {
	           window.cancelAnimationFrame( _this.anim );
	         } else {
	           _this.update(); 
	         }
	       } else {
	         _this.update();
	       }

	     });

	  },

	  "cancel" : function() {

	    this.fadeCount = 100;

	  },

	  "over" : function() {

	    window.cancelAnimationFrame( this.anim );

	    for( var i = 0; i < this.options.count; i++ ) {
	      this.particles[i].opacity = Math.random();
	    }

	    this.fade = false;
	    this.update();

	  },

	  "out" : function() {

	    this.fade = true;
	    this.cancel();

	  },

	  "datauri" : "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABsAAAAHCAYAAAD5wDa1AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyRpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMC1jMDYxIDY0LjE0MDk0OSwgMjAxMC8xMi8wNy0xMDo1NzowMSAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNS4xIE1hY2ludG9zaCIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDozNDNFMzM5REEyMkUxMUUzOEE3NEI3Q0U1QUIzMTc4NiIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDozNDNFMzM5RUEyMkUxMUUzOEE3NEI3Q0U1QUIzMTc4NiI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjM0M0UzMzlCQTIyRTExRTM4QTc0QjdDRTVBQjMxNzg2IiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOjM0M0UzMzlDQTIyRTExRTM4QTc0QjdDRTVBQjMxNzg2Ii8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+jzOsUQAAANhJREFUeNqsks0KhCAUhW/Sz6pFSc1AD9HL+OBFbdsVOKWLajH9EE7GFBEjOMxcUNHD8dxPBCEE/DKyLGMqraoqcd4j0ChpUmlBEGCFRBzH2dbj5JycJAn90CEpy1J2SK4apVSM4yiKonhePYwxMU2TaJrm8BpykpWmKQ3D8FbX9SOO4/tOhDEG0zRhGAZo2xaiKDLyPGeSyPM8sCxr868+WC/mvu9j13XBtm1ACME8z7AsC/R9r0fGOf+arOu6jUwS7l6tT/B+xo+aDFRo5BykHfav3/gSYAAtIdQ1IT0puAAAAABJRU5ErkJggg=="

	}; 

	// $('img.photo',this).imagesLoaded(myFunction)
	// execute a callback when all images have loaded.
	// needed because .load() doesn't work on cached images

	// mit license. paul irish. 2010.
	// webkit fix from Oren Solomianik. thx!

	// callback function is passed the last image to load
	//   as an argument, and the collection as `this`

	$.fn.imagesLoaded = function(callback){
	  var elems = this.filter('img'),
	      len   = elems.length,
	      blank = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///ywAAAAAAQABAAACAUwAOw==";

	  elems.bind('load.imgloaded',function(){
	      if (--len <= 0 && this.src !== blank){ 
	        elems.unbind('load.imgloaded');
	        callback.call(elems,this); 
	      }
	  }).each(function(){
	     // cached images don't fire load sometimes, so we reset src.
	     if (this.complete || this.complete === undefined){
	        var src = this.src;
	        // webkit hack from http://groups.google.com/group/jquery-dev/browse_thread/thread/eee6ab7b2da50e1f
	        // data uri bypasses webkit log warning (thx doug jones)
	        this.src = blank;
	        this.src = src;
	     }  
	  }); 

	  return this;
	};
	
</script>
</body>
</html>