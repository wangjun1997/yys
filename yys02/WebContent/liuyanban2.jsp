<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到万物嘤嘤师留言板区域</title>
<link rel="stylesheet" href="css/xz.css" />
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
			<input type="button" class='fy' value="上一页"  />
			<input type="hidden" name='curr' value='${page.currPage -1}'  <c:if test="${page.currPage ==1}">disabled="disabled"</c:if> />
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


</body>
</html>