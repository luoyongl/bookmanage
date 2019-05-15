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

        .layui-tab-title li {
            color: #ffffff;
        }

        .layui-tab-title .layui-this {
            color: #ffffff;
            background-color: rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<body>
<div class="layui-tab">
    <ul class="layui-tab-title">
        <li class="layui-this">学院信息</li>
        <li>课程开设</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <table id="table_college" class="layui-table" lay-filter="college"></table>
        </div>
        <div class="layui-tab-item">
            <table id="table_course" class="layui-table" lay-filter="course"></table>
        </div>
        <div class="layui-tab-item">内容3</div>
        <div class="layui-tab-item">内容4</div>
        <div class="layui-tab-item">内容5</div>
    </div>
</div>


<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<%@include file="../common/common_js.jsp" %>


<script type="text/html" id="formTime">
    {{  dateFormat(d.fUpdateTime) }}
</script>
<script type="text/html" id="myToolbarDemo">
    <div class="layui-btn-container">
        {{# if(d.fParentNode == '0'&&d.fDictionaryCode=='college'){ }}
        <button class="layui-btn layui-btn-sm" lay-event="add">添加下级</button>
        <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
        <button class="layui-btn layui-btn-sm  layui-btn-danger" lay-event="delete">删除</button>
        {{# } else{ }}
        <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
        <button class="layui-btn layui-btn-sm  layui-btn-danger" lay-event="delete">删除</button>
        {{# } }}
    </div>
</script>
<script>
    layui.config({
        base: '${ctx}/static/treetable-lay/module/'
    }).extend({
        treetable: 'treetable-lay/treetable'
    });

    var cols=[[
        {type: 'numbers'},
        {field: 'fId', title: 'id', hide: 'true'},
        {field: 'fDictionaryContent', title: '名称'},
        {field: 'fUpdateTime', title: '更新时间', templet: '#formTime'},
        {field: 'fParentNode', title: 'pid', hide: 'true'},
        {field: 'fSort', title: '排序'},
        {field: '', title: '操作', toolbar: '#myToolbarDemo',}
    ]]
    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'treetable'], function () {
        var laydate = layui.laydate //日期
            , laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , form = layui.form
            , treetable = layui.treetable

        //学院信息展示
        var collegetable = function () {
            treetable.render({
                treeColIndex: 2,          // treetable新增参数
                treeSpid: 0,             // treetable新增参数
                treeIdName: 'fId',       // treetable新增参数
                treePidName: 'fParentNode',     // treetable新增参数
                //treeDefaultClose: true,   // treetable新增参数
                //  treeLinkage: true,        // treetable新增参数
                treeShowName: 'fDictionaryContent',//以树形式显示的字段
                elem: '#table_college',
                url: '${ctx}/manager/baseDate/dict?code=college',
                cols:cols
            });
        }

        collegetable();

        treetable.render({
            treeColIndex: 2,          // treetable新增参数
            treeSpid: 0,             // treetable新增参数
            treeIdName: 'fId',       // treetable新增参数
            treePidName: 'fParentNode',     // treetable新增参数
            //treeDefaultClose: true,   // treetable新增参数
            //  treeLinkage: true,        // treetable新增参数
            treeShowName: 'fDictionaryContent',//以树形式显示的字段
            elem: '#table_course',
            url: '${ctx}/manager/baseDate/dict?code=course',
            cols:cols
        });

        //监听学院信息按钮
        table.on('tool(college)', function (obj) {
            var d = obj.data;
            console.log(d);//可以打印出当前行的信息
            switch (obj.event) {
                //$("#reset").trigger("click");
                case 'add':
                    reset();
                    add(obj.data);
                    break;
                case 'delete':
                    del(obj.data);
                    break;
                case 'update':
                    showContext(obj.data);
                    edit(obj.data);
                    break;
            }
        })

        function add(e) {
            layer.open({
                type: 1,
                content: $('#collegeForm')
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    $.ajax({
                        url: '${ctx}/manager/baseDate/add',
                        type: 'post',
                        data: $("#collegeForm").serialize() + '&fParentNode=' + e.fId + "&fDictionaryCode=" + e.fDictionaryCode,
                        async: false,
                        success: function x(result) {
                        if (result.status == 200) {
                            $("form").css("display", "none");
                            layer.closeAll();
                            collegetable();
                            layer.msg("操作成功")
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

        function add(e) {
            layer.open({
                type: 1,
                content: $('#collegeForm')
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    $.ajax({
                        url: '${ctx}/manager/baseDate/add',
                        type: 'post',
                        data: $("#collegeForm").serialize() + '&fParentNode=' + e.fId + "&fDictionaryCode=" + e.fDictionaryCode,
                        async: false,
                        success: function x(result) {
                            if (result.status == 200) {
                                $("form").css("display", "none");
                                layer.closeAll();
                                collegetable();
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

        //删除操作
        function del(e) {
            layer.confirm('是否确认选择删除此选项？', {
                btn: ['确认', '取消'] //可以无限个按钮
            }, function(index, layero){
               $.getJSON("${ctx}/manager/baseDate/del",{fId:e.fId},function (result) {
                   layer.closeAll();
                   collegetable();
                   layer.msg(result.msg);
               })
            }, function(index){
                //按钮【按钮二】的回调
            });
        }

        //编辑操作
        function edit(e) {
            layer.open({
                type: 1,
                content: $('#collegeForm')
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    $.ajax({
                        url: '${ctx}/manager/baseDate/edit',
                        type: 'post',
                        data: $("#collegeForm").serialize()+"&fId="+e.fId,
                        async: false,
                        success: function x(result) {
                            if (result.status == 200) {
                                $("form").css("display", "none");
                                layer.closeAll();
                                collegetable();
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
        
        function showContext(e) {
            $("#collegeForm input[name='fDictionaryContent']").val(e.fDictionaryContent);
            $("#collegeForm input[name='number']").val(e.number);
        }

        function reset() {
            $(".reset").trigger("click");
        }
    });//layui.use结束

</script>
<form id="collegeForm" style="display: none"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
    <div class="layui-form-item">
        <label class="layui-form-label">选项名称</label>
        <div class="layui-input-block">
            <input type="text" name="fDictionaryContent" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">排序</label>
        <div class="layui-input-block">
            <input type="number" lay-verify="number" name="fSort" placeholder="请输入" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-input-block" style="display: none">
        <button type="reset" class="reset layui-btn layui-btn-primary">重置</button>
    </div>
</form>

</body>
</html>