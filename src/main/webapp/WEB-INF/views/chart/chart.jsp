<%--
  Created by IntelliJ IDEA.
  User: linSir
  Date: 2020/2/21
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售报表统计</title>
    <script src="${APP_CONTEXT}/common/layui/layui.all.js"></script>
    <link rel="stylesheet" href="${APP_CONTEXT}/common/layui/css/layui.css">
    <script src="${APP_CONTEXT}/common/layui/layui.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
</head>


<body style="height: 100%; margin: 0">
<!-- 搜索条件开始 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>请输入按时间查询</legend>
</fieldset>

<form class="layui-form" method="post" id="searchFrm">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">选择时间:</label>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" class="layui-input" id="day1" readonly="readonly" placeholder="yyyy"
                       style="height: 30px;border-radius: 10px">
            </div>
            <div class="layui-input-inline" style="padding: 5px">
                <input type="text" class="layui-input" id="day2" readonly="readonly" placeholder="yyyy"
                       style="height: 30px;border-radius: 10px">
            </div>
            <button type="button"
                    class="layui-btn layui-btn-normal layui-icon layui-icon-search layui-btn-radius layui-btn-sm"
                    id="doSearch" style="margin-top: 4px">查询
            </button>
            <button type="reset"
                    class="layui-btn layui-btn-warm layui-icon layui-icon-refresh layui-btn-radius layui-btn-sm"
                    style="margin-top: 4px">重置
            </button>
        </div>
    </div>
</form>
<div id="container" style="height: 75%;width: 90%"></div>
<script type="text/javascript" src="${APP_CONTEXT}/js/echarts/js/echarts.min.js"></script>
<script type="text/javascript" src="${APP_CONTEXT}/js/echarts/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">

    layui.use(['jquery', 'layer', 'form', 'table', 'laydate'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;
        var dtree = layui.dtree;
        var laydate = layui.laydate;

        laydate.render({
            elem: '#day1',
            type: 'date',
            value: new Date()
        });
        laydate.render({
            elem: '#day2',
            type: 'date',
            value: new Date()
        });

        $("#doSearch").click(function () {
            getData();
        });

        function getData() {
            var day1 = $("#day1").val();
            if (day1 === "") {
                day1 = new Date().getFullYear();
            }
            var day2 = $("#day2").val();
            if (day2 === "") {
                day2 = new Date().getFullYear();
            }
            $.get("${APP_CONTEXT}/stat/loadOpernamedateTime", {day1: day1, day2: day2}, function (data) {
                var dom = document.getElementById("container");
                var myChart = echarts.init(dom);
                var app = {};
                option = null;
                app.title = '坐标轴刻度与标签对齐';

                option = {
                    title: {
                        text: '销售报表统计',
                        x: 'center'
                    },
                    color: ['#3398DB'],
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                        }
                    },
                    grid: {
                        top: '20%',
                        left: '3%',
                        right: '4%',
                        bottom: '1%',
                        containLabel: true
                    },
                    xAxis: [
                        {
                            type: 'category',
                            data: ['星期一','星期二','星期三','星期四','星期五','星期六','星期天'],
                            axisTick: {
                                alignWithLabel: true
                            }
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value'
                        }
                    ],
                    series: [
                        {
                            name: '销售额',
                            type: 'bar',
                            barWidth: '30%',
                            data: data.data
                        }
                    ]
                };
                ;
                if (option && typeof option === "object") {
                    myChart.setOption(option, true);
                }
            });
        }

        getData();
    });

</script>
</body>
</html>
