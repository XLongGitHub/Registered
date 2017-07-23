<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style>
		table {
			border:1px solid black;
			width:600px;
			height:100px;
			vertical-align: center;
			align-content: center;
			text-align: center;
		}

		div {
			align-self: center;
		}
		a:link {
			text-decoration: none;
		}

		div>a {
			display: inline-block;
			text-align:center; 
			width:120px;
			padding: 8px;
			background-color: #eee;
			border: 2px solid black;
			border-radius: 20px;
		}

		@-webkit-keyframes 'fisheye' {
			0% {
				-webkit-transform:scale(1);
				background-color:#eee;
				border-radius:10px;
			}
			40% {
				-webkit-transform:scale(1.2);
				backgroung-color:#eee;
				border-radius:10px;
			}
			100% {
				-webkit-transform:scale(1);
				background-color:#eee;
				boder-radius:10px;
			}
		}

		div>a:hover {
			-webkit-animation-name: 'fisheye';
			-webkit-animation-duration: 3s;
			-webkit-animation-iteration-count: infinite;
		}

	</style>
</head>
<body>
<!--<table> <tr> <td><a href="#">个人主页</a></td> <td><a href="#">课表信息</a></td> <td><a href="#">选课</a></td> <td><a href="#">退课</a></td> </tr> </table>-->
<div>
<!-- 均配置在struts中 -->
	<a href="personDetail">个人信息</a>
	<a href="getClass">课表信息</a>
	<a href="listMyAction">选课主页</a>
	<a href="#">公司信息</a>
	<a href="loginOut">退出登录</a>
</div>
</body>
</html>