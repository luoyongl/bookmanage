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
<div style="width: 500px;float: left">
    <table class="layui-table"  lay-filter="test" id="showList"></table>
</div>

<div style="width: 500px;height:500px;float: left">
    <div id="_pie" style="width: 100%;height: 40%"></div>
    <div id="sum" style="width: 100%;height: 65%"></div>
</div>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<%@include file="../common/common_js.jsp" %>

<script type="text/html" id="myToolRate">
    {{# }}
    <div class="avgScore" id="avgScore_{{ d.fBookId }}"></div>
    {{# }}
</script>
<script>
    var cols = [[
        {field: 'fBookName', title: '图书名称', sort: 'true'},
        {field: '', title: '学生评分',width:150, toolbar:'#myToolRate', align: 'center'},
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



        table.render({
            elem: '#showList',
            url: '${ctx}/teacher/showevaluteList',
            cols: cols,
            page: false, //开启分页，true为开启，false为关闭
            even: true, //隔行背景
            loading: true,//加载等待
            toolbar: '#toolbarDemo',
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
                      rate.render({
                          elem: '#avgScore_' + result[item].fBookId + ''         //绑定元素
                          , length: 5            //星星个数
                          , value: result[item].fGrade             //初始化值
                          , text: false           //显示文本，默认显示 '3.5星'
                          , readonly: true      //只读
                      });

              }
          }
        });

    });//layui.use结束



    echarts.init(document.getElementById('_pie')).setOption({
        title: {
            text: '评价信息占比',
            x: 'center',
            textStyle: {
                fontWeight: "normal",
                color: "#fff",
            },
        },
        legend: {
            orient: 'vertical',  //垂直显示
            y: 'center',    //延Y轴居中
            x: 'right',//居右显示
            textStyle: {
                color: '#ffffff'
            }
        },
        tooltip: {
            trigger: 'item',
        },
        series: {
            type: 'pie',
            orient: 'vertical',
            left: 'left',
            startAngle: 100,
            label: {
                normal: {
                    show: true,
                    position: 'outside',
                    formatter: '{d}%',
                    //模板变量有 {a}、{b}、{c}、{d}，分别表示系列名，数据名，数据值，百分比。
                    //{d}数据会根据value值计算百分比
                    textStyle: {
                        align: 'center',
                        baseline: 'middle',
                        color: 'white'
                    }
                },
            },
            labelLine: {
                normal: {
                    lineStyle: {
                        //color: 'black'
                    }
                }
            },
            data: [{name: '内容好', value:${eva1},
            }, {name: '质量合格', value:${eva2},
            }, {name: '难易适度', value: ${eva3},
            }, {name: '印刷差', value: ${eva4},
            },{name: '不易理解', value: ${eva5},
            }
            ],
            itemStyle: {
                normal: {
                    label: {
                        show: true,   //隐藏标示文字
                    },
                    labelLine: {
                        show: true,   //隐藏标示线
                    }
                }
            },
        }
    });

    echarts.init(document.getElementById('sum')).setOption({
        title : {
            text: '2018 vs 2019',
            subtext: '',
            x: 'right',

        },
        tooltip : {
            //雷达图的tooltip不会超出div，也可以设置position属性，position定位的tooltip 不会随着鼠标移动而位置变化，不友好
            confine: true,
            enterable: true, //鼠标是否可以移动到tooltip区域内
        },
        grid: { // 控制图的大小，调整下面这些值就可以，
            x: 10,
            x2: 10,
            y2: 15// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
        },
        calculable : true,
        legend: {
            orient: 'vertical',  //垂直显示
            y: 'center',    //延Y轴居中
            x: 'right',//居右显示
            textStyle: {
                color: '#ffffff'
            }
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,

        polar : [
            {
                name:{
                    show: true,
                    formatter: null,
                    textStyle: {
                        //设置颜色
                        color: '#109cad'
                    }
                },
                center:['50%','50%'], // 图的位置
                indicator : [
                    {text : '内容好', max  : 10},
                    {text : '质量合格', max  : 10},
                    {text : '难易适度', max  : 10},
                    {text : '印刷差', max  : 10},
                    {text : '不易理解', max  : 10}
                ],
                radius : 130,

            }
        ],
        series : [
            {
                name: '',
                type: 'radar',
                itemStyle: {
                    normal: {
                        areaStyle: {
                            type: 'default'
                        }
                    }
                },
                data : [
                    {
                        value : [${eva1}, ${eva2}, ${eva3}, ${eva4}, ${eva5}],
                        name : '2019'
                    },
                    {
                        value : [0, 0, 0, 0, 0, 0],
                        name : '2018'
                    }
                ]
            }
        ]
    });
</script>

</body>
</html>