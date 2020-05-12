<%--
  Created by IntelliJ IDEA.
  User: linSir
  Date: 2020/2/20
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="nano-content">
    <ul>
        <li class="label">Main</li>
        <li><a href="${APP_CONTEXT}/index"><i class="ti-home"></i> 首页 </a></li>

        <li><a class="sidebar-sub-toggle"><i class="ti-panel"></i> 餐桌管理 <span
                class="sidebar-collapse-icon ti-angle-down"></span></a>
            <ul>
                <li><a href="${APP_CONTEXT}/canzhuo" target="iframe_a">餐桌列表</a></li>
                <li><a href="${APP_CONTEXT}/addcanzhuo" target="iframe_a">添加餐桌</a></li>
            </ul>
        </li>


        <li><a class="sidebar-sub-toggle"><i class="ti-layout-grid4-alt"></i> 订单管理 <span
                class="sidebar-collapse-icon ti-angle-down"></span></a>
            <ul>
                <li><a href="${APP_CONTEXT}/dingdan" target="iframe_a">订单列表</a></li>
            </ul>
        </li>

        <li><a class="sidebar-sub-toggle"><i class="ti-heart"></i> 菜谱管理 <span
                class="sidebar-collapse-icon ti-angle-down"></span></a>
            <ul>
                <li><a href="${APP_CONTEXT}/caipu" target="iframe_a">查看菜谱</a></li>
                <li><a href="${APP_CONTEXT}/addcaipu" target="iframe_a">添加菜谱</a></li>
                <li><a href="${APP_CONTEXT}/caiputype" target="iframe_a">菜谱类型</a></li>
            </ul>
        </li>


        <li><a href="${APP_CONTEXT}/chart" target="iframe_a"><i class="ti-view-list-alt"></i> 报表统计 </a></li>


        <li>
            <a class="sidebar-sub-toggle" target="iframe_a"><i class="ti-layout"></i>系统管理<span
                    class="sidebar-collapse-icon ti-angle-down"></span></a>
            <ul>
                <li><a href="${APP_CONTEXT}/addyuangong" target="iframe_a">添加员工</a></li>
                <li class="active"><a href="${APP_CONTEXT}/yuangong" target="iframe_a">员工管理</a></li>
                <li><a href="${APP_CONTEXT}/updataPwd" target="iframe_a">修改密码</a></li>
                <li><a href="${APP_CONTEXT}/systemInfo" target="iframe_a">系统信息</a></li>
            </ul>
        </li>
    </ul>
</div>
