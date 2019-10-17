<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>万物嘤嘤师</title>
<link rel="stylesheet" href="css/xz.css" />
<script type="text/javascript" src="js/jquery-2.2.0.min.js"></script>
</head>
<body>
	<form action="">
	<!-- <table border="1"> -->
		<c:forEach var="user" items="${userList1 }">
			<tr>
			<!-- 
				<td><img src="${user.icon }" width="100px" height="100px" /></td>
				<td>${user.name }</td>
				<td>${user.level }</td>
				 -->
				 <dl style="width:200px;margin:0;padding:0;text-align:center; float:left;">
				 	<dd><img src="${user.icon }" width="100px" height="100px" /></dd>
				 	<dd>${user.name }</dd>
				 	<dd>${user.level }</dd>
				 </dl>
				
			</tr>
		</c:forEach>
	<!-- </table> -->
	</form>
	
	
	<script type="text/javascript" >
	var a_idx = 0;
	var b_idx = 0; 
	/*   文字和颜色数组 */
	var a = new Array("万物嘤嘤师", "❤", "万物嘤嘤师", "❤", "❤", "万物嘤嘤师" ,"❤", "❤", "万物嘤嘤师", "❤", "❤","❤"); 
	var b = new Array("#FD7E33","#E37487","#C97067","#C48F9F","#FD7E33","#E37487","#C97067","#C48F9F","#FD7E33","#E37487","#C97067","#C48F9F");
	jQuery(document).ready(function($) { 
	    $("body").click(function(e) {     
	        var $i = $("<span></span>").text(a[a_idx]); 
	          a_idx=parseInt(12*Math.random()); //文字随机数
	          b_idx=parseInt(14*Math.random()); //颜色随机数
	        var x = e.pageX, 
	        y = e.pageY; 
	        $i.css({ 
	            "z-index": 999, 
	            "font-family":"Kaiti",
	            "font-size":"1.3em",            //字体大小
	            "top": y - 20, 
	            "left": x, 
	            "position": "absolute", 
	            "font-weight": "bold", 
	            "color": b[b_idx] 
	        }); 
	        $("body").append($i); 
	        $i.animate({ 
	            "top": y - 180, 
	            "opacity": 0 
	        }, 
	        1500, 
	        function() { 
	            $i.remove(); 
	        }); 
	    }); 
	}); 
	
	!function(){
	 function color_bg(){
	      var rgb=Math.floor(Math.random()*255)+',' 
	      +Math.floor(Math.random()*255)+','  
	      +Math.floor(Math.random()*255);
	      return rgb;
	    }
	function n(n,e,t){
	 
	return n.getAttribute(e)||t
	 
	}
	 
	function e(n){
	 
	return document.getElementsByTagName(n)
	 
	}
	 
	function t(){
	 
	var t=e("script"),o=t.length,i=t[o-1];
	 
	return{
	 
	l:o,z:n(i,"zIndex",-1),o:n(i,"opacity",.5),c:n(i,"color",color_bg()),n:n(i,"count",250)
	 
	}
	 
	}
	 
	function o(){
	 
	a=m.width=window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth,
	 
	c=m.height=window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight
	 
	}
	 
	function i(){
	 
	r.clearRect(0,0,a,c);
	 
	var n,e,t,o,m,l;
	 
	s.forEach(function(i,x){
	 
	for(i.x+=i.xa,i.y+=i.ya,i.xa*=i.x>a||i.x<0?-1:1,i.ya*=i.y>c||i.y<0?-1:1,r.fillRect(i.x-.5,i.y-.5,1,1),e=x+1;e<u.length;e++)n=u[e],
	 
	null!==n.x&&null!==n.y&&(o=i.x-n.x,m=i.y-n.y,
	 
	l=o*o+m*m,l<n.max&&(n===y&&l>=n.max/2&&(i.x-=.03*o,i.y-=.03*m),
	 
	t=(n.max-l)/n.max,r.beginPath(),r.lineWidth=t/2,r.strokeStyle="rgba("+d.c+","+(t+.2)+")",r.moveTo(i.x,i.y),r.lineTo(n.x,n.y),r.stroke()))
	 
	}),
	 
	x(i)
	 
	}
	 
	var a,c,u,m=document.createElement("canvas"),
	 
	d=t(),l="c_n"+d.l,r=m.getContext("2d"),
	 
	x=window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||window.oRequestAnimationFrame||window.msRequestAnimationFrame||
	 
	function(n){
	 
	window.setTimeout(n,1e3/45)
	 
	},
	 
	w=Math.random,y={x:null,y:null,max:2e4};m.id=l,m.style.cssText="position:fixed;top:0;left:0;z-index:"+d.z+";opacity:"+d.o,e("body")[0].appendChild(m),o(),window.onresize=o,
	 
	window.onmousemove=function(n){
	 
	n=n||window.event,y.x=n.clientX,y.y=n.clientY
	 
	},
	 
	window.onmouseout=function(){
	 
	y.x=null,y.y=null
	 
	};
	 
	for(var s=[],f=0;d.n>f;f++){
	 
	var h=w()*a,g=w()*c,v=2*w()-1,p=2*w()-1;s.push({x:h,y:g,xa:v,ya:p,max:6e3})
	 
	}
	 
	u=s.concat([y]),
	 
	setTimeout(function(){i()},100)
	 
	}()
	</script>
</body>
</html>