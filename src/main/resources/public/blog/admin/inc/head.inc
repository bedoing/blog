<%@ page language="java" pageEncoding="UTF-8" %>
<%@page import="org.bedoing.blog.commons.BrowserCache"%>
<%
	String path = request.getContextPath();
	String timeStr = BrowserCache.getTimestamp("timeStr");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link rel="stylesheet" href="<%= path%>/static/bootstrap 3.3.5/css/bootstrap.min.css">
<link rel='stylesheet' href='<%= path%>/static/css/admin/style.css'>

<script src="<%= path%>/static/js/jquery-1.11.3.min.js"></script>
<script src="<%= path%>/static/bootstrap 3.3.5/js/bootstrap.min.js"></script>

<!-- ****** -->
<script>
	PRE_URI_ARCHIVES="/blog/app/article/articleContent?articleId=";
	PRE_URI_LIST="/blog/app/article";
	PRE_URI_TAG="/blog/app/place/articleByTag?tagName=";
	PRE_URI_COMMENT="/blog/app/comment";
	PRE_URI_D="/blog/app/place"
	PRE_URI_AD="/blog/app/admin/article"
	PRE_URI_AA="/blog/app/admin/article"
</script>