<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/login/css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/login/css/demo.css"/>
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="${ctx}/static/login/css/component.css"/>
    <!--[if IE]>
    <script src="${ctx}/static/login/js/html5.js"></script>
    <![endif]-->
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>教材管理系統</h3>
                <form class="login-form" id="loginForm" role="form" action="" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="username" class="text" style="color: #FFFFFF !important" type="text"
                               placeholder="请输入账户">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="password" class="text"
                               style="color: #FFFFFF !important; position:absolute; z-index:100;" value=""
                               type="password" placeholder="请输入密码">
                    </div>
                    <div class="mb2">
                        <li id="btn_login"
                            class="act-but submit" style="color: #FFFFFF">登录
                        </li>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="${ctx}/static/login/js/TweenLite.min.js"></script>
<script src="${ctx}/static/login/js/EasePack.min.js"></script>
<script src="${ctx}/static/login/js/rAF.js"></script>
<script src="${ctx}/static/login/js/demo-1.js"></script>
<%@include file="./common/common_js.jsp"%>
<script type="text/javascript">
    $(function () {
        $(document).keyup(function (event) {
            if (event.key === "Enter") {
                $("#btn_login").trigger("click");
            }
        });
        $("#btn_login").click(function () {
            $.ajax({
                url: "${ctx}/account/login",
                type: "POST",
                dataType: "json",
                data: $(".login-form").serialize(),
                success: function (data) {
                    if (data.status === 200) {
                        //alert("success");
                        window.location.href = '${ctx}/account/main';
                        //rt("success");
                    } else {
                        alert(data.msg);
                    }
                },
                error: function (data) {
                    alert("error");
                }
            });
            return false;
        });
    });
</script>
</body>
</html>