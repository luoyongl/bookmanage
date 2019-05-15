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
        .layui-badge {
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
<table class="layui-table" lay-filter="test" id="chooseList"></table>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<%@include file="../common/common_js.jsp" %>
<script type="text/html" id="myToolbarDemo">
    <div class="layui-btn-container">
        {{# if(d.fState>2){ }}
        <button class="layui-btn layui-btn-sm" lay-event="">已结束</button>
        {{# } else{ }}
            {{# if(d.chooseId >0){ }}
            <button class="layui-btn layui-btn-sm layui-btn-warm" lay-event="delete">退选</button>
            {{# } else{ }}
            <button class="layui-btn layui-btn-sm" lay-event="add">选用</button>
            {{# } }}
        {{# } }}


    </div>
</script>
<script type="text/html" id="iswriteToolbarDemo">
    <div class="layui-btn-container">
        {{# if(d.fBookIswrite ==true){ }}
        <span style="width:50px" class="layui-badge layui-bg-orange">是</span>
        {{# } else{ }}
        <span style="width:50px" class="layui-badge layui-bg-green">否</span>
        {{# } }}
    </div>
</script>
<script>
    var cols = [[
        {field: 'fBookName', title: '图书名称', sort: 'true'},
        {field: 'fCourseAttribute', title: '课程性质', sort: 'true'},
        {field: 'fApplyYear', title: '学年学期', sort: 'true'},
        {
            field: 'fBookIswrite',
            title: '是否自编',
            toolbar: '#iswriteToolbarDemo',
            sort: 'true',
            width: 100,
            align: 'center'
        },
        {field: 'fBookPrice', title: '单价(元)'},
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


        var $table = table.render({
            elem: '#chooseList',
            url: '${ctx}/student/list',
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
            switch (obj.event) {
                //$("#reset").trigger("click");
                case 'add':
                    add(obj.data);
                    break;
                case 'delete':
                    del(obj.data);
                    break;
                case 'update':

                    break;
            }
            ;
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


        //选用
        function add(e) {
            layer.confirm('是否确认选用此教材？', {
                btn: ['确认', '取消'] //可以无限个按钮
            }, function (index, layero) {
                $.ajax({
                    url: '${ctx}/student/add',
                    type: 'post',
                    data: {fBookId: e.fBookId},
                    async: false,
                    success: function x(result) {
                        if (result.status == 200) {
                            $("form").css("display", "none");
                            layer.closeAll();
                            $table.reload();
                            layer.msg(result.msg)
                        }
                    }
                })
            }, function (index) {
                //按钮【按钮二】的回调
            });
        }

        //删除操作
        function del(e) {
            layer.confirm('是否确认选择删除此选项？', {
                btn: ['确认', '取消'] //可以无限个按钮
            }, function (index, layero) {
                $.getJSON("${ctx}/student/del", {fBookId: e.fBookId}, function (result) {
                    layer.closeAll();
                    $table.reload();
                    layer.msg(result.msg);
                })
            }, function (index) {
                //按钮【按钮二】的回调
            });
        }


    });//layui.use结束

</script>

</body>
<form id="collegeForm" style="display: none"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
    <textarea name="fRemark" placeholder="请输入内容" class="layui-textarea"></textarea>
</form>
</html>