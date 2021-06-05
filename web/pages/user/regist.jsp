<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员注册页面</title>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("#username").blur(function () {
				var username = this.value;
				$.getJSON("${basePath}userServlet","action=ajaxExistsUsername&username="+username,function (date) {
					if(date.existsUsername){
						$("span.errorMsg").text("用户名已存在!");
					} else{
						$("span.errorMsg").text("用户名可用!");
					}
				});
			});
			//给验证码的图片绑定单机事件
			$("#code_img").click(function () {
				this.src = "${basePath}kaptcha.jpg?d="+new Date()
			})
			$("#sub_btn").click(function () {
				var username = $("#username").val();
				var usernameP = /^\w{5,12}$/
				if(!usernameP.test(username)){
					$(".errorMsg").html("用户名不合法")
					return false;
				}
				var passwordP= /^\w{5,12}$/
				var password = $("#password").val();
				if(!passwordP.test(password)){
					$(".errorMsg").html("密码不合法")
					return false;
				}
				var repwd = $("#repwd").val();
				if (repwd != password){
					$(".errorMsg").html("两次密码不一致")
					return false;
				}
				var email = $("#email").val();
				var emaliP = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				if(!emaliP.test(email)){
					$(".errorMsg").html("邮箱不合法")
					return false;
				}
				var code = $("#code").val()
				code = $.trim(code);
				if(code==null || code==""){
					$(".errorMsg").html("验证码错误")
					return false;
				}

				$(".errorMsg").html("")
			})
		})

	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.jpg" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册会员</h1>
								<span class="errorMsg" >${requestScope.msg}</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"
										   value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email"
										   value="${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 80px;" name="code" id="code" />
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 60px;width: 110px;height: 30px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>