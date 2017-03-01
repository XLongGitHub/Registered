<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>register</title>
<style>
table {
	width: 200px;
	height: 100px;
	background-color: #ccddff;
	border: 1px solid black;
}

caption {
	width: 200px;
	font-size: 20px;
	align: center;
}
</style>
</head>
<body>
	<table>
		<caption>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;register</caption>
		<form action="register" method="post" onsubmit="return check(this);">
			<tr>
				<td style="font-size: 20px;">username:</td>
				<td><input type="text" name="username" onfocus=true /></td>
			</tr>
			<tr>
				<td style="font-size: 20px;">password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td style="font-size: 20px;">confirm password:</td>
				<td><input type="password" name="password2" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit" onclick="check" /></td>
				<td><input type="reset" value="reset"></td>
			</tr>
		</form>
	</table>

	<script>
		String.prototype.trim = function() {
			return this.replace(/^\s*/, "").replace(/\s*$/, "");
		}

		var check = function() {

			var form = document.forms[0];
			var errstr = "";
			if (form.username.value == null || form.username.value.trim() == "") {
				errstr += "username can't be empty \n";
				form.username.focus();
			}
			if (form.password.value == null || form.password.value.trim() == "") {
				errstr += "passwor can't be empty \n";
				form.password.focus();
			}
			if (form.password2.value == null
					|| form.password2.value.trim() == "") {
				errstr += "passwor can't be empty \n";
				form.password2.focus();
			}
			/* 		if (form.password.value != form.password2.vaule) {
			 errstr += "password must be simlar to ";	
			 alert(form.password.value);
			 alert(form.password2.value);
			 } */
			if (errstr != "") {
				alert(errstr);
				return false;
			}
			return true;
		}
	</script>
</body>
</html>