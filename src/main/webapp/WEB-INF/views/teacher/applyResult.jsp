<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<!doctype html>
<html>
<head>
    <%@include file="../common/common_css.jsp" %>
    <style>
        .layui-badge{
            width: 120px;
        }
    </style>
</head>
<body>


<%--<div class="container">
    <ul class="time-horizontal">
        <li><b></b>成立</li>
        <li><b></b>合作</li>
        <li><b></b>发展</li>
        <li><b></b>共赢</li>
    </ul>
</div>--%>

<ul class="layui-timeline" style="padding-left: 40px;">
    <li class="layui-timeline-item">
        <i class="layui-icon layui-timeline-axis"></i>
        <div class="layui-timeline-content layui-text">
            <div class="layui-timeline-title">提交申请</div>
        </div>
    </li>
    <li class="layui-timeline-item">
        <i class="layui-icon layui-timeline-axis"></i>
        <div class="layui-timeline-content layui-text">
            <div class="layui-timeline-title">教学秘书审核</div>
        </div>
    </li>
    <li class="layui-timeline-item">
        <i class="layui-icon layui-timeline-axis"></i>
        <div class="layui-timeline-content layui-text">
            <div class="layui-timeline-title">学生选取</div>
        </div>
    </li>
    <li class="layui-timeline-item">
        <i class="layui-icon layui-timeline-axis"></i>
        <div class="layui-timeline-content layui-text">
            <div class="layui-timeline-title">确认订单</div>
        </div>
    </li>
    <li class="layui-timeline-item">
        <i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop layui-timeline-axis"></i>
        <div class="layui-timeline-content layui-text">
            <div class="layui-timeline-title">发放及领取</div>
        </div>
    </li>
    <li class="layui-timeline-item">
        <i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop layui-timeline-axis"></i>
        <div class="layui-timeline-content layui-text">
            <div class="layui-timeline-title">结束</div>
        </div>
    </li>
</ul>
<%--搜索区域--%>
<div class="demoTable" style="float: left">
    <div class="layui-inline">
        <input class="layui-input" name="keyWord" id="keyWord" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>
<div class="" style="float: right;margin-right: 50px;color: red;">
    <span class="">教材选取截止时间：${bookdate.fDictionaryContent}</span>
</div>
<%--图书列表展示--%>
<table class="layui-table"  lay-filter="test" id="bookList"></table>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<%@include file="../common/common_js.jsp" %>
<script type="text/html" id="myToolbarDemo">
</script>
<script type="text/html" id="myToolbarDemo">
    <div class="layui-btn-container">
        {{# if(d.fState == '1'){ }}
        <button class="layui-btn layui-btn-sm" lay-event="delete">退选</button>
        {{# } else if(d.fState=="2"){ }}
        <button class="layui-btn layui-btn-sm" lay-event="">查看</button>
        {{# } else if(d.fState=="3"){ }}
            {{# if(d.number == '0'){ }}
            <button class="layui-btn layui-btn-sm layui-bg-red" lay-event="exit">结束订单</button>
            {{# } else{ }}
             <button class="layui-btn layui-btn-sm" lay-event="order">提交订单</button>
            {{# } }}
        {{# } }}
    </div>
</script>
<script type="text/html" id="stateToolbarDemo">
    <div class="layui-btn-container">
         {{# if(d.fState == '1'){ }}
        <span class="layui-badge layui-bg-orange">待审核</span>
        {{# } else if(d.fState=="2"){ }}
        <span class="layui-badge layui-bg-green">学生待选取,已选:{{d.number}}</span>
        {{# } else if(d.fState=="3"){ }}
                {{# if(d.number == '0'){ }}
                <span class="layui-badge layui-bg-red">选取结束,已选:{{d.number}}</span>
                {{# } else{ }}
                <span class="layui-badge layui-bg-red">选取结束,已选:{{d.number}}</span>
                {{# } }}
        {{# } else if(d.fState=="7"){}}
        <span class="layui-badge layui-bg-gray">已结束,已选:{{d.number}}</span>
        {{# } else if(d.fState=="8"){}}
        <span class="layui-badge layui-bg-green">教材备货中</span>
        {{# } else if(d.fState=="9"){}}
        <span class="layui-badge layui-bg-green">可领取</span>
        {{# } }}
    </div>
</script>
<script type="text/html" id="iswriteToolbarDemo">
    <div class="layui-btn-container">
        {{# if(d.fBookIswrite ==true){ }}
        <span style="width:50px" class="layui-badge layui-bg-orange">是</span>
        {{# } else{ }}
        <span style="width:50px"  class="layui-badge layui-bg-green">否</span>
        {{# } }}
    </div>
</script>
<script>
    var cols = [[
        {field: 'fBookName', title: '图书名称', sort: 'true'},
        {field: 'fBookEditor', title: '主编',width:150},
        {field: 'fBookEdtion', title: '版次', sort: 'true', width: 100},
        {field: 'fCourseName', title: '课程名称', sort: 'true', width: 120},
        {field: 'fCourseAttribute', title: '课程性质', sort: 'true', width: 100},
        {field: 'fClass', title: '选用班级', sort: 'true'},
        {field: 'fApplyYear', title: '学年学期', sort: 'true'},
        {field: 'fBookIswrite', title: '是否自编', toolbar: '#iswriteToolbarDemo',sort: 'true',width: 100,align:'center、、'},
        {field: 'fState', title: '状态', toolbar: '#stateToolbarDemo',sort: 'true', width: 150},
        {field: '', title: '操作', toolbar: '#myToolbarDemo', align: 'center'}
    ]];
    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element'], function () {
        var laydate = layui.laydate //日期
            , laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , form = layui.form


        var $table=table.render({
            elem: '#bookList',
            url: '${ctx}/teacher/showApplyResult',
            cols: cols,
            page: true, //开启分页，true为开启，false为关闭
            even: true, //隔行背景
            loading: true,//加载等待
            toolbar: '#toolbarDemo',
            //cellMinWidth: 100, //全局定义常规单元格的最小宽度
            // done: doneCallback,
            parseData: function (res) { //res 即为原始返回的数据
                return {
                    "code": 0, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.data.total, //解析数据长度
                    "data": res.data.list //解析数据列表
                };
            }
        });


        table.on('tool(test)', function (obj) {
            $("#reset").trigger("click");
            var d = obj.data;
            console.log(d);//可以打印出当前行的信息
            switch(obj.event){
                //$("#reset").trigger("click");
                case 'add':
                    layer.open({
                        area: ['800px', '500px'],
                        type: 1,
                        content: $('#applyBookForm') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                    });
                    form.on('submit(applyBook)', function(data){
                       $.ajax({
                           url:"${ctx}/teacher/applyBook",
                           type:'post',
                           data:$("#applyBookForm").serialize()+"&fBookId="+obj.data.fId,
                           success:function (result) {
                               if (result.status==200){
                                   layer.closeAll();
                                   layer.msg("选课成功");

                               }
                           },
                           error:function () {
                               layer.closeAll();
                           },
                           cancel: function () {
                               $("form").css("display", "none");//右上角关闭回调return false 开启该代码可禁止点击该按钮关闭
                           }

                       })
                        $("#applyBookForm").css("display","none");
                        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                    });
                    break;
                case 'delete':
                    layer.confirm('您确定要退选该课本吗?',{btn: ['确定', '取消'],title:"提示"}, function(){
                        $.ajax({
                            type: "post",
                            url: "${ctx}/teacher/deleteApply?fId="+obj.data.fId,
                            dataType: "json",
                            async:false,
                            success:function(data) {
                                layer.closeAll();
                                layer.msg("success")
                                $table.reload();
                            }
                        });
                    });
                    break;
                case 'exit':
                    exit(obj.data);
                    break;
                case 'order':
                    order(obj.data);
                    break;
            };
        })

        var active = {
            reload: function () {
                var keyWord = $('#keyWord');
                table.reload('bookList', {
                    where: {
                        keyword: keyWord.val()
                    }
                });
            }
        };
        /**
         * 点击"搜索" reload 表格
         */
        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        /**
         * 键盘开始输入，自动搜索刷新
         */
        $('#keyWord').keyup(function () {
            var type = $(".demoTable .layui-btn").data('type');
            active[type] ? active[type].call(this) : '';
        })
        
        function exit(e){
            layer.confirm('是否确认结束此申请？', {
                btn: ['确认', '取消'] //可以无限个按钮
            }, function(index, layero){
                $.getJSON("${ctx}/teacher/exit",{fId:e.fId},function (result) {
                    layer.closeAll();
                    $table.reload();
                    layer.msg(result.msg);
                })
            }, function(index){
                //按钮【按钮二】的回调
            });
        }

        function order(e){
            layer.confirm('是否确认提交订单？', {
                btn: ['确认', '取消'] //可以无限个按钮
            }, function(index, layero){
                $.getJSON("${ctx}/teacher/order",{fId:e.fId,fBookId:e.fBookId,number:e.number},function (result) {
                    layer.closeAll();
                    $table.reload();
                    layer.msg(result.msg);
                })
            }, function(index){
                //按钮【按钮二】的回调
            });
        }

    });//layui.use结束

</script>


</body>
</html>