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
        form {
            padding: 0;
        }
        .layui-form-checkbox[lay-skin=primary] span {
            padding-left: 25px;
            color: black;
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
<table class="layui-table"  lay-filter="test" id="chooseList"></table>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<%@include file="../common/common_js.jsp" %>
<script type="text/html" id="myToolbarDemo">
    {{# if(d.evaId!=null){ }}
    {{# } else{ }}
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">提交</button>
    </div>
    {{# } }}

</script>
<script type="text/html" id="myToolRate">
   <%-- {{#  if(d.fGrade!=null){}}
111
    {{# } else { }}
      <div class="avgScore" id="avgScore_{{ d.fId }}"></div>
    {{# } }}--%>
    {{# }}
   <div class="avgScore" id="avgScore_{{ d.fId }}"></div>
    {{# }}
</script>
<script type="text/html" id="chooseRate">
    {{#  if(d.fList!=null){ }}
        {{d.fList}}
    {{# } else { }}
    <form id="form_{{ d.fId }}" class="layui-form"> <!--提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
                <input type="checkbox" name="fList" lay-skin="primary" title="内容好" value="内容好" >
                <input type="checkbox" name="fList" lay-skin="primary" title="质量合格" value="质量合格" >
                <input type="checkbox" name="fList" lay-skin="primary" title="难易适度" value="难易适度">
                <input type="checkbox" name="fList" lay-skin="primary" title="印刷差" value="印刷差">
                <input type="checkbox" name="fList" lay-skin="primary" title="不易理解" value="不易理解">
        </div>
    </form>
    {{# } }}
</script>
<script type="text/html" id="inputBar">
    {{# if(d.fRemark!=null){ }}
        {{d.fRemark }}
    {{# }else{ }}
        <input id="input_{{ d.fId }}" type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入简要评价" class="layui-input">
    {{# } }}
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
        {field: 'fCourseName', title: '课程名称', sort: 'true'},
        {field: 'fBookIswrite', title: '是否自编', width:80,toolbar: '#iswriteToolbarDemo',sort: 'true',align:'center'},
        {field: '', title: '评分',width:150, toolbar:'#myToolRate', align: 'center'},
        {field: '', title: '选择评价', toolbar: '#chooseRate',width:250},
        {field: '', title: '备注', toolbar: '#inputBar',width:250},
        {field: '', title: '操作', toolbar: '#myToolbarDemo', align: 'center'}
    ]];
    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element','rate'], function () {
        var laydate = layui.laydate //日期
            , laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , form = layui.form
            ,rate=layui.rate


        var $table=table.render({
            elem: '#chooseList',
            url: '${ctx}/student/evaluteList',
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
            },
            done:function (res, curr, count) {
                var result = res.data;//返回的json中data数据
                console.log(result);
                for (var item in result) {
                    // alert( result[item].fId);
                    if (result[item].fGrade==null){
                        rate.render({
                            elem: '#avgScore_' + result[item].fId + ''         //绑定元素
                            , length: 5            //星星个数
                            , value: 0            //初始化值
                            , text: false           //显示文本，默认显示 '3.5星'
                        });
                    }else {
                        rate.render({
                            elem: '#avgScore_' + result[item].fId + ''         //绑定元素
                            , length: 5            //星星个数
                            , value: result[item].fGrade           //初始化值
                            , text: false           //显示文本，默认显示 '3.5星'
                            , readonly: true      //只读
                        });
                    }

                }
            }
        });



        table.on('tool(test)', function (obj) {
            $("#reset").trigger("click");
            var d = obj.data;
            console.log(d);//可以打印出当前行的信息
            switch(obj.event){
                //$("#reset").trigger("click");
                case 'add':
                    add(obj.data);
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


        //选用
        function add(e) {
            layer.confirm('是否确认选用此教材？', {
                btn: ['确认', '取消'] //可以无限个按钮
            }, function(index, layero){
                let form_list="#form"+"_"+e.fId;
                let avgScoreValue="#avgScore_"+e.fId+" .layui-icon-rate-solid";
                let inputValue="#input_"+e.fId;
                //alert($(inputValue).val())
                //alert($(avgScoreValue).length);
                $.ajax({
                    url: '${ctx}/student/addevalute',
                    type: 'post',
                    data: $(form_list).serialize()+"&fGrade="+$(avgScoreValue).length+"&fRemark="+$(inputValue).val()+"&fBookId="+e.fBookId,
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
            }, function(index){
                //按钮【按钮二】的回调
            });
        }

        //删除操作
        function del(e) {
            layer.confirm('是否确认选择删除此选项？', {
                btn: ['确认', '取消'] //可以无限个按钮
            }, function(index, layero){
                $.getJSON("${ctx}/student/del",{fBookId:e.fBookId},function (result) {
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
<form id="collegeForm" style="display: none"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
            <textarea name="fRemark" placeholder="请输入内容" class="layui-textarea"></textarea>
</form>
</html>