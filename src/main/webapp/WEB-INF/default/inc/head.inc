<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="org.bedoing.blog.commons.BrowserCache"%>
<%
	String path = request.getContextPath();
	String timeStr = BrowserCache.getTimestamp("timeStr");
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="keywords" content="java,数据结构,算法分析,云计算,大数据">
<link rel="shortcut icon" href="<%= path%>/img/logo/bedoing.ico">
<!-- CSS -->
<link rel="stylesheet" href="<%= path%>/static/css/bootstrap.min.css">
<link rel="stylesheet" href="<%= path%>/static/css/font-awesome.css">
<link rel="stylesheet" href="<%= path%>/static/css/default/asStyle.css?t=<%=timeStr%>">
<link rel="stylesheet" href="<%= path%>/static/css/default/style.css?t=<%=timeStr%>">
<link rel="stylesheet" href="<%= path%>/static/css/nprogress.css">
<!-- Javascript -->
<script src="<%= path%>/static/js/jquery-1.11.3.min.js"></script>
<script src="<%= path%>/static/js/bootstrap.min.js"></script>
<script src="<%= path%>/static/js/nprogress.js"></script>
<script src="<%= path%>/static/js/default/common.js?t=<%=timeStr%>"></script>
<script src="<%= path%>/static/js/jquery.scrollUp.min.js"></script>
<!-- nav -->
<!-- <script src="<%= path%>/inc/stickUp/stickUp.min.js"></script>-->
<script>
	PRE_URI_ARCHIVES="/archive";
	PRE_URI_LIST="/list";
	PRE_URI_TAG="/tag";
	PRE_URI_COMMENT="/c";
</script>