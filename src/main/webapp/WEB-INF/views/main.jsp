<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>教材管理系统V1.0</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${ctx}/static/ui/css/font.css">
    <link rel="stylesheet" href="${ctx}/static/ui/css/xadmin.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/Swiper/3.4.2/css/swiper.min.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/Swiper/3.4.2/js/swiper.jquery.min.js"></script>
    <script src="${ctx}/static/ui/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/static/ui/js/xadmin.js"></script>
    <style>
        iframe {
            width: 100%;
            height: 650px;
        }
        .selected{
            background-color: rgba(0, 0, 0, 0.3)!important;
        }
    </style>
</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="${ctx}/account/main">教材管理系统V1.0</a></div>
    <div class="open-nav"><i class="iconfont">&#xe699;</i></div>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">${sessionScope.currentUser.realName}</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a href="">修改密码</a></dd>
<%--                <dd><a href="${ctx}/account/logout">退出</a></dd>--%>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="${ctx}/account/logout">退出</a></li>
    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<div class="wrapper">
    <!-- 左侧菜单开始 -->
    <div class="left-nav">
        <div id="side-nav">
            <ul id="nav">
                <c:forEach var="menu" items="${sessionScope.userMenu}"
                           varStatus="status">
                    <c:choose>
                        <c:when test="${menu.children!=null}">
                            <dl class="list">
                                <dt>
                                    <a href="javascript:;"><i class="iconfont">&#xe70b;</i>${menu.menuName}</a>
                                </dt>
                                <dd>
                                    <ul class="sub-menu">
                                        <c:forEach var="subMenu" items="${menu.children}" varStatus="status">
                                            <li>
                                                <a href="javascript:;" _link="${ctx}/${subMenu.menuPath}">
                                                    <i class="iconfont">&#xe6a7;</i>${subMenu.menuName}
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </dd>

                            </dl>
                        </c:when>
                        <c:otherwise>
                            <dl class="list">
                                <dt class="eps">
                                    <a href="javascript:;" _link="${ctx}/${menu.menuPath}"><i class="iconfont">&#xe761;</i>${menu.menuName}
                                    </a>
                                </dt>
                            </dl>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </ul>
        </div>
    </div>
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="content">
            <!-- 右侧内容框架，更改从这里开始 -->
<%--            <fieldset class="layui-elem-field layui-field-title site-title">--%>
                <iframe src="${ctx}/account/main" id="main" name="main" frameborder="0"
                        scrolling="auto" allowtransparency="true"></iframe>
<%--            </fieldset>--%>

            <!-- 右侧内容框架，更改从这里结束 -->
        </div>
    </div>
    <!-- 右侧主体结束 -->
</div>

<!-- 底部结束 -->
<!-- 背景切换开始 -->
<div class="bg-changer">
    <div class="swiper-container changer-list">
        <div class="swiper-wrapper">
            <div class="swiper-slide"><img class="item" src="${ctx}/static/ui/images/a.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${ctx}/static/ui/images/b.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${ctx}/static/ui/images/c.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${ctx}/static/ui/images/d.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${ctx}/static/ui/images/e.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${ctx}/static/ui/images/f.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${ctx}/static/ui/images/g.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${ctx}/static/ui/images/h.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${ctx}/static/ui/images/i.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${ctx}/static/ui/images/j.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${ctx}/static/ui/images/k.jpg" alt=""></div>
            <div class="swiper-slide"><span class="reset">初始化</span></div>
        </div>
    </div>
    <div class="bg-out"></div>
    <div id="changer-set"><i class="iconfont">&#xe696;</i></div>
</div>
<!-- 背景切换结束 -->
<script>
$(function () {
    var $ref=$(".sub-menu").find("li").eq(0).find("a").attr("_link");
    //alert($ref)
    $("#main").attr("src",$ref);
})
</script>
<script>
    //百度统计可去掉
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();

    $(".left-nav #nav  li").click(function(){
        var index=$(this).index();
        var link=$(this).find("a").attr("_link");
        $("#main").attr("src",link);
        //alert(link)
    });

    $(".left-nav #nav dl .eps").click(function(){
        var _link = $(this).children("a").attr('_link');
        $("#main").attr('src',_link);
        //alert(_link);
    })


    $('.left-nav #nav dl dt').on('click',function(e){
        $('.left-nav #nav dl dt').removeClass('selected');  // 删除其他兄弟元素的样式
        $('.left-nav #nav dl li').removeClass('selected');
        $(this).addClass('selected');             // 添加当前元素的样式
    })

    $('.left-nav #nav dl ul li').on('click',function(e){
        $('.left-nav #nav dl dt').removeClass('selected');
        $('.left-nav #nav dl li').removeClass('selected');  // 删除其他兄弟元素的样式
        $(this).addClass('selected');             // 添加当前元素的样式
       // alert($(this).attr("class"));
    })

</script>
</body>
</html>