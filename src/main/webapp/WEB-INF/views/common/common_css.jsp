<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<link rel="stylesheet" type="text/css" href="${ctx}/static/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/layui/formSelects-v4.css">
<%--<link rel="stylesheet" href="${ctx}/static/treetable-lay/assets/layui/css/layui.css">
<link rel="stylesheet" href="${ctx}/static/treetable-lay/assets/common.css"/>--%>

<style>
    .layui-table {
        width: 100%;
        background-color: rgba(0,0,0,0.2);
    }
    .layui-input{
        color: #FFFFFF;
        background-color: rgba(0,0,0,0.2)!important;
        border: 1px solid gray;
    }
    form .layui-input{
        color: black;
        background-color: rgba(0,0,0,0)!important;
        border: 1px solid rgba(0,0,0,0.3);
    }
    .layui-table  tr{
        color: #fff;
        border: 1px solid gray;
    }
    .layui-table  tr th{
        border: 1px solid gray;
    }
    .layui-table  tr td{
        border: 1px solid gray;
    }
    .layui-table thead tr{
        background-color: rgba(0,0,0,0.3);
        color: #fff;
    }
    .layui-table tbody tr:hover{
        background-color: rgba(0,0,0,0.4);
    }

    .layui-form.layui-border-box.layui-table-view{
        border: 1px solid gray;
    }

    .layui-layer-title{
        background-color: #009688!important;
    }
    form{
        padding: 10px 30px;
    }
    .layui-rate{
        padding: 0px 5px 10px 0;
        font-size: 0;
    }
</style>
