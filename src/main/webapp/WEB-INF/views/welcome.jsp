
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="common/css.jsp"/>
</head>
<body>
<div class="main-content">
    <div class="row">
        <div class="col-lg-9">
            <div class="card alert">
                <div class="card-header">
                    <h4>顾客流量</h4>
                    <div class="card-header-right-icon">
                        <ul>
                            <li class="card-close" data-dismiss="alert"><i class="ti-close"></i></li>
                        </ul>
                    </div>
                </div>
                <div class="sales-chart">
                    <canvas id="team-chart" height="136"></canvas>
                </div>
            </div>
        </div><!-- /# column -->
        <div class="col-lg-3">
            <div class="card alert nestable-cart single-card">
                <div class="card-header">
                    <h4>Today Visit</h4>
                </div>
                <div class="sparkline-box">
                                <span id="sparklinedash"><canvas width="67" height="30"
                                                                 style="display: inline-block; width: 67px; height: 30px; vertical-align: top;"></canvas></span>
                </div>
                <div class="visit-count">
                    8.23K
                </div>
            </div>

            <div class="card alert nestable-cart single-card">
                <div class="card-header">
                    <h4>Unique Visitor</h4>
                </div>
                <div class="sparkline-box">
                                <span id="sparklinedash3"><canvas width="67" height="30"
                                                                  style="display: inline-block; width: 67px; height: 30px; vertical-align: top;"></canvas></span>
                </div>
                <div class="visit-count">
                    4.5K
                </div>
            </div>
            <div class="card alert nestable-cart single-card">
                <div class="card-header">
                    <h4>Total Page View</h4>
                </div>
                <div class="sparkline-box">
                                <span id="sparklinedash2"><canvas width="67" height="30"
                                                                  style="display: inline-block; width: 67px; height: 30px; vertical-align: top;"></canvas></span>
                </div>
                <div class="visit-count">
                    92.5K
                </div>
            </div>

            <div class="card alert nestable-cart">
                <div class="card-header">
                    <h4>Site Traffic</h4>
                </div>
                <div class="sparkline-box">
                    <div id="sparkline9">
                        <canvas width="269" height="50"
                                style="display: inline-block; width: 269px; height: 50px; vertical-align: top;"></canvas>
                    </div>
                </div>
            </div>

        </div>
    </div><!-- /# row -->
</div>
<jsp:include page="common/js.jsp"/>
</body>
</html>
