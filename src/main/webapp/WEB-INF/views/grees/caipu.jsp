<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>查看菜谱</title>
    <script src="${APP_CONTEXT}/common/layui/layui.all.js"></script>
    <link rel="stylesheet" href="${APP_CONTEXT}/common/layui/css/layui.css">
    <script src="${APP_CONTEXT}/js/jquery-1.8.3.js"></script>
    <script src="${APP_CONTEXT}/common/layui/layui.js"></script>
    <style type="text/css">
        .layui-table-cell {
            height: 100%;
            line-height: 100%;
        }
    </style>
    <script src="${APP_CONTEXT}/common/js/caipu.js"></script>
</head>
<body>
<header style="width: 100%;height: 40px;background-color: #E3E3E3;">
    <h2 style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;"><b>查看菜谱</b></h2>
</header>
<form class="layui-form">
    <section style="width: 600px;height: 45px;margin-left: 25px;margin-top: 17px;">
        菜名：
        <div class="layui-inline" style="margin-right: 15px;">
            <input class="layui-input" name="m_name" id="m_name" placeholder="请输入菜名" autocomplete="off">
        </div>
        类型：
        <div class="layui-inline" style="width: 130px;">
            <select id="m_type" name="m_type" class="layui-select">
                <option value="-1">请选择类型</option>
                <option value="3">饮品</option>
                <option value="2">凉菜</option>
                <option value="1">热菜</option>
            </select>
        </div>
        <button id="search" type="button" class="layui-btn" style="margin-left: 10px;">搜索</button>
    </section>
</form>
<table class="layui-hide" id="tabs" lay-filter="tab"></table>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="menuType">
    {{#  if( d.typeId ==1){ }}
    <a>热菜</a>
    {{# }if(d.typeId ==2) { }}
    <a>凉菜</a>
    {{# }if(d.typeId ==3) { }}
    <a>饮品</a>
    {{#  } }}
</script>
<script type="text/html" id="img">
    {{#  if(d.imagePath == '无' || d.imagePath == ''){ }}
    <div><img height="118px" width="118px" src="${APP_CONTEXT}/common/icon/image.png"></div>
    {{#  } else { }}
    <div><img height="118px" width="118px" src="<%=request.getContextPath() %>${'/upload/'}{{d.imagePath}}"></div>
    {{# } }}

</script>
</body>
</html>
