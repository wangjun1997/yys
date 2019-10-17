<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到万物嘤嘤师留言板区域</title>
<link rel="stylesheet" href="css/xz.css" />
<style type="text/css">
	div{
		width:1000px;
		position: relative;
		margin: 0px auto;
		padding-left: 470px;
    	padding-top: 50px;
	}
	#tijiao{
		width: 50px;
	    position: relative;
	    margin-left: 100px;
	}
	form{
		 margin-left: 100px;
	}
</style>
<script type="text/javascript" src="js/jquery-2.2.0.min.js"></script>
<c:if test="${!empty zt }">
<script type="text/javascript">
	alert('${zt}');
</script>
</c:if>
<script type="text/javascript">
	function isName() {
		var a = $('#uname').val();
		if(a==''){
			$('#uname1').html('用户名不能为空').css({'color':'red'});
			return false;
		}else{
			$('#uname1').html('');
			return true;
		}
	};
	function isContent() {
		var a = $('#content').val();
		if(a==''){
			$('#content1').html('留言内容不能为空').css({'color':'red'});
			return false;
		}else{
			$('#content1').html('');
			return true;
		}
	};
	$(function() {
		$('#uname').blur(function() {
			isName();
		});
		$('#content').blur(function() {
			isContent()
		});
		$('form').submit(function(e) {
			var a = isName();
			var b = isContent();
			return a&&b;
		});
		$('.fy').click(function() {
			console.log("fuck");
			var curr = $(this).next().val();
			console.log(curr);
			var count = $('#totalPages').val();
			if(curr>0&&curr<=count){
				console.log("fuck22");
				$.ajax({
					type:"get",
					url:"LiuyanServlet",
					data:{"action":"load","curr":curr},
					success:function(result){
						$('#fu').html(result);
					}
				});
			}
		});
	});
	
</script>
</head>
<body>
<div>
<table border="1" id="fu">
	
<c:forEach var="ly" items="${liuyanList1 }">
				<tr>
				<td>${ly.id }</td>
				<td>${ly.content }</td>
				<td>${ly.name }</td>
				<td>${ly.date }</td>
				</tr>
</c:forEach>
	<tr>
		<td><input type="button" class='fy' value="首页" />
		<input type="hidden" name='curr' value='1' /></td>
		<td colspan="2">
			<input type="button" class='fy' value="上一页" <c:if test="${page.currPage ==1}">disabled="disabled"</c:if> />
			<input type="hidden" name='curr' value='${page.currPage -1}'   />
			当前在第${page.currPage }页
			<input type="button" class='fy' value="下一页" <c:if test="${page.currPage ==page.totalPages}">disabled="disabled"</c:if> />
			<input type="hidden" name='curr' value='${page.currPage +1}' />
		</td>
		<td><input type="button" class='fy' value="尾页" />
		<input type="hidden" name='curr' id="totalPages" value='${page.totalPages }' /></td>
	</tr>
	<tr>
		<td colspan="4">
			<c:forEach step="1" begin="1" end="${page.totalPages }" varStatus="st">
				<a href="javascript:void(0)" class="fy">${st.index }</a><input type="hidden" name='curr' value='${st.index }' />
			</c:forEach>
			<span style="float: right;">
			<input type="button" class="fy" value="GO"/>
			<input type="text" style="width:25px;" name="curr"/>
			</span>
		</td>
	</tr>
</table>
</div>
<div>
<form action="LiuyanServlet?action=add" method="post" >
<table>
	<tr>
		<td>留言内容</td>
		<td><textarea rows="3" cols="20" name="content" id="content"></textarea></td>
		<td id="content1"></td>
	</tr>
	<tr>
		<td>您的大名</td>
		<td><input type="text" name="uname" id='uname'/></td>
		<td id="uname1"></td>
	</tr>
</table>
<input type="submit" value="留言" id="tijiao"/>
</form>
</div>
</body>

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
</html>