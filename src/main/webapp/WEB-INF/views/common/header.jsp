<%--
  Created by IntelliJ IDEA.
  User: linSir
  Date: 2020/2/20
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
    <div class="pull-left">
        <div class="logo" id="sideLogo">
            <a href="index.html">
                <img class="full-logo" src="assets/images/logo-big.png" alt="SimDahs">
                <img class="small-logo" src="assets/images/logo-small.png" alt="SimDahs">
            </a>
        </div>
        <div class="hamburger sidebar-toggle">
            <span class="ti-menu"></span>
        </div>
    </div>

    <div class="pull-right p-r-15">
        <ul>
            <li class="header-icon dib"><img class="avatar-img" src="assets/images/avatar/1.jpg" alt=""/> <span
                    class="user-avatar">${uLoginname} ~ ${uName} <i class="ti-angle-down f-s-10"></i></span>
                <div class="drop-down dropdown-profile">
                    <div class="dropdown-content-body">
                        <ul>
                            <li><a href="${APP_CONTEXT}/logout"><i class="ti-power-off"></i> <span>退出登入</span></a></li>
                        </ul>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>
