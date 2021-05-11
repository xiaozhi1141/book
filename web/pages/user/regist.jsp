<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("#sub_btn").click(function () {
				var username = $("#username").val();
				var usernameP = /^\w{5,12}$/
				if(!usernameP.test(username)){
					$(".errorMsg").jsp("用户名不合法")
					return false;
				}
				var passwordP= /^\w{5,12}$/
				var password = $("#password").val();
				if(!passwordP.test(password)){
					$(".errorMsg").jsp("密码不合法")
					return false;
				}
				var repwd = $("#repwd").val();
				if (repwd != password){
					$(".errorMsg").jsp("两次密码不一致")
					return false;
				}
				var email = $("#email").val();
				var emaliP = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				if(!emaliP.test(email)){
					$(".errorMsg").jsp("邮箱不合法")
					return false;
				}
				var code = $("#code").val()
				code = $.trim(code);
				if(code==null || code==""){
					$(".errorMsg").jsp("验证码错误")
					return false;
				}

				$(".errorMsg").jsp("")
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
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg" >${requestScope.msg==null?"":requestScope.msg}</span>
							</div>
							<div class="form">
								<form action="registServlet" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"
										   value="${requestScope.username==null?"":requestScope.username}"/>
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
										   value="${requestScope.email==null?"":requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" id="code" />
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
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