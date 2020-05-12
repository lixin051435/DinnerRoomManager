<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>餐饮管理系统</title>
    <link rel="stylesheet" href="${APP_CONTEXT}/js/bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="${APP_CONTEXT}/css/commonDiv.css">
    <script src="${APP_CONTEXT}/js/jquery-3.2.1.js"></script>
    <script src="${APP_CONTEXT}/js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script src="${APP_CONTEXT}/js/diancan.js"></script>
</head>
<body>
<div class="container">
    <h1>订餐</h1>
    <nav class="navbar navbar-inverse">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#navbar-menu"
                    aria-expanded="false">
                <span class="sr-only">Toggle</span> <span class="icon-bar"></span>
                <span class="icon-bar"></span> <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">导航</a>

        </div>
        <div id="navbar-menu" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#" onclick="ShowMain('OrderMenu')">菜谱</a></li>
                <li><a href="#" onclick="ShowMain('OrderInfo')">订单信息</a></li>
                <li class=""><a href="#" onclick="ShowMain('orderJieSuan')">订单结算</a></li>
                <li><a href="#" onclick="ShowMain('canzuosyqk')">餐桌使用情况</a></li>
                <li><a style="margin-left: 100px" href="javascript:;">欢迎【${uLoginname}】员工登入!</a></li>
                <li><a style="margin-left: 100px" href="${APP_CONTEXT}/logout">点击退出</a></li>
            </ul>
        </div>
    </nav>
    <div id="mainbody"
         style="width: 100%;height: 100%;">
        <iframe src="OrderMenu" frameborder="0" id="main"
                style="width: 100%;height: 100%;" onload="initIframeHeight(300);"></iframe>
    </div>
</div>
</body>
</html>