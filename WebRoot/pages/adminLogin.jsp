﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>管理员登陆</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="stylesheet" type="text/css" href="assets/css/cloud-admin.css" >

		<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">

	</head>
	<body class="login">
		<!-- PAGE -->
		<section id="page">
			<!-- HEADER -->
			<header>
				<!-- NAV-BAR -->
				<div class="container" style="position:absolute; top: 20px;">
					<div class="row">
						<div class="col-md-4 col-md-offset-4">
							<div id="logo">
								<a href="login.html"><img
									src="assets/img/login_logo.png" height="80" alt="登陆主页" /></a>
							</div>
						</div>
					</div>
				</div>
				<!--/NAV-BAR -->
			</header>
			<!--/HEADER -->
			<!-- LOGIN -->
			<section id="login" class="visible">
<div class="container" style="margin-top: 100px; z-index: -1;">
<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-box-plain">
			<h2 class="bigintro">管理员登陆</h2>
			<div class="divide-40"></div>
			<form role="form" action='#' method='get'>
				<div class="form-group">
					<label
						for="userName"><strong>用户名</strong></label>
					<input type="text" class="form-control" id="userName" value='用户名'>
					<br>
					<span id='userClue' class='clue'></span>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1"><strong>密码</strong></label>
					<input type="text" class="form-control" value='密码' id='userPass'>
					<br>
					<span id='passClue' class='clue'> </span>
					<span id='returnClue' class='clue'> </span>
				</div>
				<div class="form-actions">
					<button id="btnLogin" type="submit" class="btn btn-danger"><strong>登陆</strong></button>
				</div>
			</form>
		</body>
</html>

<script type="text/javascript" src='assets/js/jquery-3.1.0.js' charset="utf-8"></script>
<script type="text/javascript" src='assets/js/login.js' charset="utf-8"></script>
<script type="text/javascript" src='assets/js/layer/layer.js' charset="utf-8"></script>