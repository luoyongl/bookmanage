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
    </style>
</head>
<body>

<%--搜索区域--%>
<div class="demoTable">
    <div class="layui-inline">
        <input class="layui-input" name="keyWord" id="keyWord" autocomplete="off">
    </div>
    <button class="layui-btn search" data-type="reload">搜索</button>
    <button class="layui-btn add" data-type="add">新编教材印刷申请</button>
</div>
<%--图书列表展示--%>
<table class="layui-table"  lay-filter="test" id="bookList"></table>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<%@include file="../common/common_js.jsp" %>
<script type="text/html" id="myToolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">选用</button>
       {{# if(d.fState=="1"){ }}
        <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
        {{# } }}
    </div>
</script>
<script type="text/html" id="fileToolbarDemo">
    <a href="{{d.fBookUrl}}" target="view_window" style="color: #FFFFFF">查看</a>
</script>
<script type="text/html" id="formTime">
    {{  dateFormat(d.fUpdateTime) }}
</script>
<script type="text/html" id="stateToolbarDemo">
    <div class="layui-btn-container">
        {{# if(d.fState == '1'){ }}
        <span class="layui-badge layui-bg-orange">待审核</span>
        {{# } else { }}
        <span class="layui-badge layui-bg-green">已通过</span>
        {{# } }}
    </div>
</script>
<script>
    var cols = [[
        {field: 'fBookName', title: '图书名称', sort: 'true' },
        {field: 'fUpdateTime', title: '申请日期', sort: 'true',templet: '#formTime'},
        {field: 'fState', title: '申请状态', sort: 'true', toolbar: '#stateToolbarDemo',align:'center'},
        {field: 'fBookUrl', title: '附件查看',toolbar: '#fileToolbarDemo'},
        {field: '', title: '操作', toolbar: '#myToolbarDemo', align: 'center'}
    ]];
    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element'], function () {
        var laydate = layui.laydate //日期
            , laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , form = layui.form


        table.render({
            elem: '#bookList',
            url: '${ctx}/teacher/showBookList?type=2',
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
                        content: $('#applyBookForm'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                        cancel: function () {
                    $("form").css("display", "none");//右上角关闭回调return false 开启该代码可禁止点击该按钮关闭
                }
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
                           }

                       })
                        $("#applyBookForm").css("display","none");
                        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                    });
                    break;
                case 'delete':
                    layer.msg('删除');
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
        /**
         * 点击"搜索" reload 表格
         */
        $('.demoTable .layui-btn.search').on('click', function () {
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

        /**
         * 点击申请按钮弹出申请界面
         */
        $('.demoTable .layui-btn.add').on('click', function () {
            $(".reset").trigger("click");
            layer.open({
                area: ['700px', '500px'],
                type: 1,
                content: $('#applyOwnBookForm'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                cancel: function(){
                    $("#applyOwnBookForm").css("display","none");
                }
            });
        });

        form.on('submit(applyOwnBook)', function(data){
            console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
            console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
            console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
            var formSatellite = document.getElementById("applyOwnBookForm");//获取所要提交form的id
            var fs1 = new FormData(formSatellite);  //用所要提交form做参数建立一个formdata对象
            $.ajax({
                url: "${ctx}/teacher/applyOwnBook",
                type: "POST",
                data: fs1,
                async : false,
                contentType: false,   //jax 中 contentType 设置为 false 是为了避免 JQuery 对其操作，从而失去分界符，而使服务器不能正常解析文件
                processData: false,   //当设置为true的时候,jquery ajax 提交的时候不会序列化 data，而是直接使用data
                error : function(request) {
                    parent.layer.alert("网络超时");
                },
                success: function (data) {
                    $("#applyOwnBookForm").css("display","none");
                }
            });
        });




        function update(e) {
            layer.open({
                type: 1,
                content: $('#editOwnBookForm')
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    var formSatellite1 = document.getElementById("editOwnBookForm");//获取所要提交form的id
                    var fs2 = new FormData(formSatellite1);
                    fs2.append("fId",e.fId);
                    $.ajax({
                        url: "${ctx}/teacher/editOwnBook",
                        type: "POST",
                        data: fs2,
                        async : false,
                        contentType: false,   //jax 中 contentType 设置为 false 是为了避免 JQuery 对其操作，从而失去分界符，而使服务器不能正常解析文件
                        processData: false,   //当设置为true的时候,jquery ajax 提交的时候不会序列化 data，而是直接使用data
                        success: function (data) {
                            $("#applyOwnBookForm").css("display","none");
                        }
                    });
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


<%--申请提交--%>
<form class="layui-form" id="applyOwnBookForm" enctype="multipart/form-data" style="display: none">
    <div class="layui-form-item">
        <label class="layui-form-label">课程名称</label>
        <div class="layui-input-block">
            <input type="text" name="fCourseName" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">课程属性</label>
        <div class="layui-input-block">
            <select name="fCourseAttribute" lay-verify="required">

            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">专业</label>
        <div class="layui-input-block">
            <select name="fMajor" lay-verify="required">
                <option>软件工程</option>
                <option>计算机科学</option>
                <option>数字媒体</option>
                <option>数学</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">选用班级</label>
        <div class="layui-input-block">
            <select name="fClass" lay-filter="aihao">
                <option>软件11501</option>
                <option>软件11502</option>
                <option>软件11503</option>
                <option>软件11504</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">学年学期</label>
        <div class="layui-input-block">
            <select name="fApplyYear" lay-verify="required">

            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">教材名称</label>
        <div class="layui-input-block">
            <input type="text" name="fBookName" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">主编</label>
        <div class="layui-input-block">
            <input type="text" name="fBookEditor" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">上传附件</label>
        <div class="layui-input-block">
            <input type="file" name="file" required  lay-verify="required">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="fRemark" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button id="applyOwnBook"  class="layui-btn" lay-submit lay-filter="applyOwnBook">立即提交</button>
            <button type="reset" class="reset layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</body>

<form class="layui-form" id="applyBookForm" action="" style="display: none">
    <div class="layui-form-item">
        <label class="layui-form-label">课程名称</label>
        <div class="layui-input-block">
            <input type="text" name="fCourseName" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">课程属性</label>
        <div class="layui-input-block">
            <select name="fCourseAttribute" lay-verify="required">

            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">专业</label>
        <div class="layui-input-block">
            <select name="fMajor" lay-verify="required">
                <option>软件工程</option>
                <option>计算机科学</option>
                <option>数字媒体</option>
                <option>数学</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">选用班级</label>
        <div class="layui-input-block">
            <select name="fClass" lay-filter="aihao">
                <option>软件11501</option>
                <option>软件11502</option>
                <option>软件11503</option>
                <option>软件11504</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">学年学期</label>
        <div class="layui-input-block">
            <select name="fApplyYear" lay-verify="required">

            </select>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="fRemark" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="applyBook">立即提交</button>
            <button id="reset" type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


<form  id="editOwnBookForm" enctype="multipart/form-data" style="display: none">
    <div class="layui-form-item">
        <label class="layui-form-label">教材名称</label>
        <div class="layui-input-block">
            <input type="text" name="fBookName" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">主编</label>
        <div class="layui-input-block">
            <input type="text" name="fBookEditor" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">上传附件</label>
        <div class="layui-input-block">
            <input type="file" name="file" required  lay-verify="required">
        </div>
    </div>
</form>
</html>