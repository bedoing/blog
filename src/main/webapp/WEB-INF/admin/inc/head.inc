<%@ page language="java" pageEncoding="UTF-8" %>
<%
	String path = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link href="<%= path%>/admin/css/bootstrap-cerulean.min.css" rel="stylesheet">
<link href="<%= path%>/admin/css/charisma-app.css" rel="stylesheet">
<link href='<%= path%>/admin/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
<link href='<%= path%>/admin/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
<link href='<%= path%>/admin/bower_components/chosen/chosen.min.css' rel='stylesheet'>
<link href='<%= path%>/admin/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
<link href='<%= path%>/admin/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
<link href='<%= path%>/admin/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
<link href='<%= path%>/admin/css/jquery.noty.css' rel='stylesheet'>
<link href='<%= path%>/admin/css/noty_theme_default.css' rel='stylesheet'>
<link href='<%= path%>/admin/css/elfinder.min.css' rel='stylesheet'>
<link href='<%= path%>/admin/css/elfinder.theme.css' rel='stylesheet'>
<link href='<%= path%>/admin/css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='<%= path%>/admin/css/uploadify.css' rel='stylesheet'>
<link href='<%= path%>/admin/css/animate.min.css' rel='stylesheet'>
<link href='<%= path%>/static/css/admin/style.css' rel='stylesheet'>
<!-- jQuery -->
<script src="<%= path%>/static/js/jquery-1.11.3.min.js"></script>
<script src="<%= path%>/static/js/bootstrap.min.js"></script>
<!-- The fav icon -->
<link rel="shortcut icon" href="<%= path%>/admin/img/favicon.ico">
<!-- library for cookie management -->
<script src="<%= path%>/admin/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='<%= path%>/admin/bower_components/moment/min/moment.min.js'></script>
<script src='<%= path%>/admin/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='<%= path%>/admin/js/jquery.dataTables.min.js'></script>
<!-- select or dropdown enhancer -->
<script src="<%= path%>/admin/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="<%= path%>/admin/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="<%= path%>/admin/js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="<%= path%>/admin/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="<%= path%>/admin/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="<%= path%>/admin/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="<%= path%>/admin/js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="<%= path%>/admin/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="<%= path%>/admin/js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="<%= path%>/admin/js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="<%= path%>/admin/js/charisma.js"></script>
<!-- ****** -->
<script>
	PRE_URI_ARCHIVES="/archive";
	PRE_URI_LIST="/list";
	PRE_URI_TAG="/tag";
	PRE_URI_COMMENT="/c";
	PRE_URI_D="/d"
</script>