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
            width: 80px;
        }
    </style>
</head>
<body>

<%--搜索区域--%>
<div class="demoTable">
    <div class="layui-inline">
        <input class="layui-input" name="keyWord" id="keyWord" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>
<%--图书列表展示--%>
<table class="layui-table"  lay-filter="test" id="applyList"></table>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<%@include file="../common/common_js.jsp" %>
<script type="text/html" id="myToolbarDemo">
    <div class="layui-btn-container">
        {{# if(d.fBookIswrite == true){ }}
        <a href="{{d.fBookUrl}}" target="view_window" class="layui-btn layui-btn-sm" style="color: #FFFFFF">查看附件</a>
        <button class="layui-btn layui-btn-sm " lay-event="update">通过</button>
        <button class="layui-btn layui-btn-sm layui-btn-warm" lay-event="delete">不通过</button>
        {{# } else{ }}
        <button class="layui-btn layui-btn-sm" lay-event="update">通过</button>
        <button class="layui-btn layui-btn-sm layui-btn-warm" lay-event="delete">不通过</button>
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
        {field: 'username', title: '申请人', sort: 'true',width:80},
        {field: 'college', title: '申请单位', sort: 'true'},
        {field: 'fCourseName', title: '课程名称', sort: 'true'},
        {field: 'fCourseAttribute', title: '课程性质', sort: 'true'},
        {field: 'fClass', title: '选用班级', sort: 'true'},
        {field: 'fApplyYear', title: '学年学期', sort: 'true'},
        {field: 'fBookIswrite', title: '是否自编', toolbar: '#iswriteToolbarDemo',sort: 'true',width: 100,align:'center、、'},
        {field: '', title: '操作', toolbar: '#myToolbarDemo', align: 'center',width:200}
    ]];
    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element'], function () {
        var laydate = layui.laydate //日期
            , laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , form = layui.form


        table.render({
            elem: '#applyList',
            url: '${ctx}/manager/review/showApplyResult',
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
                    break;
                case 'delete':
                    del(obj.data);
                    break;
                case 'update':
                    update(obj.data);
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


        //审核通过操作
        function update(e) {
            layer.confirm('是否确认同意此申请？', {
                btn: ['确认', '取消'] //可以无限个按钮
            }, function(index, layero){
                $.getJSON("${ctx}/manager/review/update",{fId:e.fId},function (result) {
                    layer.closeAll();
                    table.reload();
                    layer.msg(result.msg);
                })
            }, function(index){
                //按钮【按钮二】的回调
            });
        }

        //审核通过操作
        //编辑操作
        function del(e) {
            layer.open({
                type: 1,
                title:'请填写备注',
                content: $('#collegeForm')
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    $.ajax({
                        url: '${ctx}/manager/review/del',
                        type: 'post',
                        data: $("#collegeForm").serialize()+"&fId="+e.fId,
                        async: false,
                        success: function x(result) {
                            if (result.status == 200) {
                                $("form").css("display", "none");
                                layer.closeAll();
                                table.reload();
                                layer.msg(result.msg)
                            }
                        }
                    })
                }
                , btn2: function (index, layero) {
                    $("form").css("display", "none");//按钮【按钮二】的回调 return false 开启该代码可禁止点击该按钮关闭
                }
                , cancel: function () {
                    $("form").css("display", "none");//右上角关闭回调return false 开启该代码可禁止点击该按钮关闭
                }
            });
        }

    });//layui.use结束

</script>

</body>
<form id="collegeForm" style="display: none"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
            <textarea name="fRemark" placeholder="请输入内容" class="layui-textarea"></textarea>
</form>
</html>