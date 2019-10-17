<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发送邮件</title>
<script type="text/javascript" src="js/jquery-2.2.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#fs').click(function() {
			var mail = $('#mail').val();
			if(mail==''){
				alert("邮箱不能为空");
			}else{
				$.ajax({
					type:"get",
					url:"EmailServlet",
					data:{"method":"sendMail","mail":mail},
					success:function(result){
						var time = 5;
						var dsq = setInterval(function() {
							
							$('#fs').attr("disabled",true);
							$('#fs').attr("value","重新发送("+(time-1)+'s)');
							time = time-1;
							if(time==0){
								clearInterval(dsq);
								$('#fs').attr("disabled",false);
								$('#fs').attr("value","再次发送");
							}
						}, 1000);
					}
				});
			}
		});
		$('#yz').click(function() {
			var incode = $('#incode').val();
			if(incode==''){
				alert("验证码不能为空");
			}else{
				$.ajax({
					type:"get",
					url:"EmailServlet",
					data:{"method":"check","incode":incode},
					success:function(result){
						result;
					}
				});
			}
		});
	});
</script>
</head>
<body>
<form action="EmailServlet">
<input type="text" name="mail" id="mail"/>
<input type="button" value="发送" id="fs"  /><br />
<input type="text" name="incode" id="incode"/>
<input type="button" value="验证" id="yz"  />
</form>
<!-- <a href="EmailServlet">发送邮件</a> -->
</body>
</html>