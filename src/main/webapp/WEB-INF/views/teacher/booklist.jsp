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
    <button class="layui-btn" data-type="reload">搜索</button>
</div>
<%--图书列表展示--%>
<table class="layui-table"  lay-filter="test" id="bookList"></table>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<%@include file="../common/common_js.jsp" %>
<script type="text/html" id="myToolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">选用</button>
       <%-- {{# if(d.fBookNumber == '10010'){ }}
        <button class="layui-btn layui-btn-sm" lay-event="add">选用</button>
        {{# } else { }}
        <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="update">退选</button>
        {{# } }}--%>
    </div>
</script>
<script>
    var cols = [[
        {field: 'fBookNumber', title: '编号', sort: 'true', width: 100},
        {field: 'fBookName', title: '图书名称', sort: 'true', width: 180},
        {field: 'fBookPublish', title: '出版社', sort: 'true', width: 150},
        {field: 'fBookIsbn', title: 'ISBN', width: 150,},
        {field: 'fBookEditor', title: '主编'},
        {field: 'fBookEdtion', title: '版次', sort: 'true', width: 100},
        {field: 'fBookType', title: '性质', width: 100},
        {field: 'fBookPrice', title: '价格(元)', width: 85},
        {field: '', title: '操作', toolbar: '#myToolbarDemo', align: 'center'}
    ]];
  /*  layui.config({
        base: '${ctx}/static/layui/',
    });*/
    layui.config({
        base: '${ctx}/static/layui/'
    }).extend({
        formSelects: 'formSelects'
    });
    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element','formSelects'], function () {
        var laydate = layui.laydate //日期
            , laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , form = layui.form
            ,formSelects = layui.formSelects;


        table.render({
            elem: '#bookList',
            url: '${ctx}/teacher/showBookList?type=1',
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
            //重置form
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
                        cancel: function(){
                            $("#applyBookForm").css("display","none");
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
                    layer.msg('编辑');
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


    });//layui.use结束

</script>


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
                <c:forEach items="${courseList}" var="course">
                    <option>${course.fDictionaryContent}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">专业</label>
        <div class="layui-input-block">
            <select name="fMajor" lay-verify="required">
                <option>软件工程</option>
                <option>计算机科学</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">选用班级</label>
        <div class="layui-input-block">
            <select name="fClass" xm-select>
             <c:forEach items="${collegeList}" var="college">
                    <option>${college.fDictionaryContent}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">学年学期</label>
        <div class="layui-input-block">
            <select name="fApplyYear" lay-verify="required">
                <option>2018-2019年一学期</option>
                <option>2018-2019年二学期</option>
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
</html>