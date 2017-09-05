<%--
  Created by IntelliJ IDEA.
  User: Godwei
  Date: 2017/8/7
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">
<head>
    <meta charset="utf-8">
    <title>SSM_login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel="stylesheet" href="assets/css/reset.css">
    <link rel="stylesheet" href="assets/css/supersized.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>

    <![endif]-->

</head>

<body>

<div class="page-container">
    <h1>登录</h1>
    <form action=""  method="post">
        <input type="text" id="userName" name="userName" class="username" placeholder="用户名">
        <input type="password" id="passWord" name="passWord" class="password" placeholder="密码">
        <button type="button" onclick="login()">提交</button>
        <div class="error"><span>+</span></div>
    </form>
</div>

<!-- Javascript -->
<script src="assets/js/jquery-1.8.2.min.js"></script>
<script src="assets/js/supersized.3.2.7.min.js"></script>
<script src="assets/js/supersized-init.js"></script>
<script src="assets/js/scripts.js"></script>
<script src="assets/js/user/login.js"></script>

</body>

</html>


