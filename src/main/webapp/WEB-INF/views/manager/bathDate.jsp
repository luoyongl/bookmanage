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
        <li>课程类别</li>
        <li>教材管理</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <div class="demoTable">
                <button class="layui-btn colege_add" data-type="add">新增</button>
            </div>
            <table id="table_college" class="layui-table" lay-filter="college"></table>
        </div>
        <div class="layui-tab-item">
            <div class="demoTable">
                <button class="layui-btn course_add" data-type="add">新增</button>
            </div>
            <table id="table_course" class="layui-table" lay-filter="course"></table>
        </div>
        <div class="layui-tab-item">
            <table class="layui-table"  lay-filter="book" id="bookList"></table>
        </div>
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
<script type="text/html" id="addToolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="toolbar_add">新增教材</button>
    </div>
</script>
<script>
    layui.config({
        base: '${ctx}/static/treetable-lay/module/'
    }).extend({
        treetable: 'treetable-lay/treetable'
    });

    var Flag=1;
    var cols_book = [[
        {field: 'fBookNumber', title: '编号', sort: 'true', width: 80},
        {field: 'fBookName', title: '图书名称', sort: 'true',width: 200},
        {field: 'fBookPublish', title: '出版社', sort: 'true',width: 100},
        {field: 'fBookIsbn', title: 'ISBN', width: 100},
        {field: 'fBookEditor', title: '主编',width: 100},
        {field: 'fBookEdtion', title: '版次', sort: 'true',width: 100},
        {field: 'fBookType', title: '性质',width: 100},
        {field: 'fBookPrice', title: '价格(元)',width: 100},
        {field: '', title: '操作', toolbar: '#myToolbarDemo', align: 'center',width: 200}
    ]];
    var cols = [[
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
                cols: cols
            });
        }

        collegetable();

        var coursetable = function () {
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
                cols: cols
            });
        }
        coursetable();


        var $table=table.render({
            elem: '#bookList',
            url: '${ctx}/teacher/showBookList?type=1',
            cols: cols_book,
            page: true, //开启分页，true为开启，false为关闭
            even: true, //隔行背景
            loading: true,//加载等待
            //toolbar: '#toolbarDemo',
            toolbar: '#addToolbarDemo',
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
        table.on('tool(course)', function (obj) {
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

        table.on('tool(book)', function (obj) {
            var d = obj.data;
            console.log(d);//可以打印出当前行的信息
            switch (obj.event) {
                //$("#reset").trigger("click");
                case 'update':
                    editBook(obj.data);
                    break;
                case 'delete':
                    del(obj.data);
                    break;
            }
        })
        table.on('toolbar(book)', function (obj) {
            switch (obj.event) {
                case 'toolbar_add':
                    add_book(obj.data);
                    break;
            }
        })
        $('.demoTable .colege_add').on('click', function () {
            open("college");
        });

        $('.demoTable .course_add').on('click', function () {
            open("course");
        });

        function open(str) {
            layer.open({
                type: 1,
                content: $('#collegeForm')
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    $.ajax({
                        url: '${ctx}/manager/baseDate/add',
                        type: 'post',
                        data: $("#collegeForm").serialize() + '&fParentNode=0' + "&fDictionaryCode=" + str,
                        async: false,
                        success: function x(result) {
                            if (result.status == 200) {
                                $("form").css("display", "none");
                                layer.closeAll();
                                collegetable();
                                coursetable();
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
                                coursetable();
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
            }, function (index, layero) {
                $.getJSON("${ctx}/manager/review/delBook", {fId: e.fId}, function (result) {
                    layer.closeAll();
                    $table.reload();
                    layer.msg(result.msg);
                })
            }, function (index) {
                //按钮【按钮二】的回调
            });
        }


        //添加教材操作
        function add_book(e) {
            layer.open({
                type: 1
                , content: $('#bookform')
                , area:['500px']
                , cancel: function () {
                    $("form").css("display", "none");//右上角关闭回调return false 开启该代码可禁止点击该按钮关闭
                }
            });
        }

        form.on('submit(applyBook)', function(data){
            var url=""
            if (Flag==1){
                url='${ctx}/manager/review/addBook';
            }else {
                url='${ctx}/manager/review/updateBook';
            }
            $.ajax({
                url:url,
                type:'post',
                data:$("#bookform").serialize(),
                success:function (result) {
                    if (result.status==200){
                        layer.closeAll();
                        layer.msg("操作成功");
                        $table.reload();
                        Flag=1;
                    }
                },
                error:function () {
                    layer.closeAll();
                }

            })
            $("form").css("display","none");
            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        });

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
                        data: $("#collegeForm").serialize() + "&fId=" + e.fId,
                        async: false,
                        success: function x(result) {
                            if (result.status == 200) {
                                $("form").css("display", "none");
                                layer.closeAll();
                                collegetable();
                                coursetable();
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


        //编辑操作
        function editBook(e) {
            Flag=2;
            showBookContext(e);
            layer.open({
                type: 1,
                content: $('#bookform')
                , cancel: function () {
                    $("form").css("display", "none");//右上角关闭回调return false 开启该代码可禁止点击该按钮关闭
                }
            });
        }
        function showContext(e) {
            $("#collegeForm input[name='fDictionaryContent']").val(e.fDictionaryContent);
            $("#collegeForm input[name='number']").val(e.number);
        }

        function showBookContext(e) {
            for (var i in e){
                $("#bookform input[name='"+i+"']").val(e[i]);
            }
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
<form id="bookform" class="layui-form" style="display: none"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->

    <div class="layui-form-item" style="display: none">
        <label class="layui-form-label"></label>
        <div class="layui-input-block">
            <input required type="text" name="fId" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div><div class="layui-form-item">
        <label class="layui-form-label">教材编号</label>
        <div class="layui-input-block">
            <input required type="text" name="fBookNumber" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">教材名称</label>
        <div class="layui-input-block">
            <input required type="text" name="fBookName" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">出版社</label>
        <div class="layui-input-block">
            <input required type="text" name="fBookPublish" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">ISBN</label>
        <div class="layui-input-block">
            <input required type="text" name="fBookIsbn" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">主编</label>
        <div class="layui-input-block">
            <input required type="text" name="fBookEditor" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">版次</label>
        <div class="layui-input-block">
            <input required type="text" name="fBookEdtion" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">价格</label>
        <div class="layui-input-block">
            <input required type="text" name="fBookPrice" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图书类型</label>
        <div class="layui-input-block">
            <input required lay-verify="required"  type="text" name="fBookType" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="applyBook">立即提交</button>
            <button id="reset" type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</body>
</html>