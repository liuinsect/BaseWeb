<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>欢迎使用山区道路建设与维护技术重庆市重点实验室后台管理系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css"
			href="misc/module/jquery-easyui-core/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="misc/module/jquery-easyui-core/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="misc/css/styles.css">

		<link rel="icon" href="favicon.ico" mce_href="favicon.ico" type="image/x-icon"> 
		<link rel="shortcut icon" href="favicon.ico" mce_href="favicon.ico" type="image/x-icon">
		
		<script type="text/javascript"
			src="misc/module/jquery-easyui-core/jquery-1.4.4.min.js" charset="utf-8"></script>
		<script type="text/javascript"
			src="misc/module/jquery-easyui-core/jquery.easyui.min.js" charset="utf-8"></script>
		<script type="text/javascript"
			src="misc/module/jquery-easyui-core/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
		<script type="text/javascript" src="misc/js/json2.js"></script>
		<script type="text/javascript" src="misc/js/login.js"
			charset="utf-8"></script>

	</head>

	<body style="text-align: center; overflow: hidden;">
		<!-- 在ff中，如果div id="input"采用margin-top，div id="background"不加border-style: solid; border-color: white; 布局会出错-->
		<div id="background"
			style="background-image: url('misc/images/login.jpg'); background-position: center; height: 600px; width: 1024px; margin-left: auto; margin-right: auto; background-repeat: no-repeat; border-style: solid; border-color: white;">
			<div id="input"
				style="margin: auto; margin-top: 270px; font-size: 12px;">
				<p>
					帐号：
					<input name="account" class="easyui-validatebox" required="true"
						style="width: 132px;">
				</p>
				<p>
					密码：
					<input name="password" type="password" class="easyui-validatebox"
						required="true" style="width: 132px;">
				</p>
				<div
					style="padding: 1px; text-align: center; border-color: yellow; border-width: 2px">
					<a href="javascript:void(0)" class="easyui-linkbutton" plain="true"
						icon="icon-ok" id="login">登录</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" plain="true"
						icon="icon-cancel" id="cancel">取消</a>
				</div>
			</div>
			<div id="copyright"
				style="margin-left: auto; margin-right: auto; margin-top: 180px; font-size: 12px;">
				 建议使用IE7+,firefox,chrome浏览器,并在1280x800及以上分辨率操作软件
			</div>
		</div>
		<div
			style="position: absolute; bottom: 0px; right: 0px; margin-right: 50px;">
			build id: 20120425
		</div>

	</body>
</html>
