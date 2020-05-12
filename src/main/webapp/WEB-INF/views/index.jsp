<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="common/css.jsp"/>
</head>

<body>

<div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
    <div class="nano">
        <jsp:include page="common/menu.jsp"></jsp:include>
    </div>
</div><!-- /# sidebar -->


<jsp:include page="common/header.jsp"></jsp:include>

<div class="content-wrap">
    <div class="main">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-8 p-0">
                    <div class="page-header">
                        <div class="page-title">
                            <h1>餐饮管理系统</h1>
                        </div>
                    </div>
                </div><!-- /# column -->
                <div class="col-lg-4 p-0">
                    <div class="page-header">
                        <div class="page-title">
                            <ol class="breadcrumb text-right">
                                <li><a href="#">餐饮管理系统</a></li>
                                <li class="active">首页</li>
                            </ol>
                        </div>
                    </div>
                </div><!-- /# column -->
            </div><!-- /# row -->
            <iframe style="zoom: 0.6;" name="iframe_a" height="1000" src="welcome" frameBorder="0" width="99.6%">

            </iframe>

            <jsp:include page="common/foot.jsp"></jsp:include>
        </div><!-- /# container-fluid -->
    </div><!-- /# main -->
</div>
<!-- /# content wrap -->
<jsp:include page="common/js.jsp"/>
</body>
</html>