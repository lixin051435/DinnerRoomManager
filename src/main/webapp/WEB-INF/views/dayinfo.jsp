<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${APP_CONTEXT}/common/layui/css/layui.css">
    <script src="${APP_CONTEXT}/js/jquery-1.8.3.js"></script>
    <script src="${APP_CONTEXT}/common/layui/layui.js"></script>
    <jsp:include page="common/css.jsp"/>
</head>
<body>
<div class="main-content">
    <div class="row">
        <div class="col-lg-3">
            <span>昨日详情</span>
            <table style="width: 80%;" class="layui-table" id="tabs" lay-filter="tab">
                <tr>
                    <td>收入</td>
                    <td>${yestoday.totalPrice}元</td>
                </tr>
                <tr>
                    <td>接待人数</td>
                    <td>${yestoday.totalPersonNumber}人</td>
                </tr>
                <tr>
                    <td>订单数目</td>
                    <td>${yestoday.totalOrderNumber}</td>
                </tr>
            </table>

            <span>今日详情</span>
            <table style="width: 80%;" class="layui-table"  lay-filter="tab">
                <tr>
                    <td>收入</td>
                    <td>${today.totalPrice}元</td>
                </tr>
                <tr>
                    <td>接待人数</td>
                    <td>${today.totalPersonNumber}人</td>
                </tr>
                <tr>
                    <td>订单数目</td>
                    <td>${today.totalOrderNumber}</td>
                </tr>
            </table>



        </div>
    </div>
</div>
<jsp:include page="common/js.jsp"/>
</body>
</html>
