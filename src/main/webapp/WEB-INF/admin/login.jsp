<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>index</title>
    <%@ include file="inc/head.inc"%>
</head>

<body>
   
   <div class="ch-container">
    <div class="row">
        
    <div class="row">
        <div class="col-md-12 center login-header">
            <h2>Welcome to Ken's Blog</h2>
        </div>
        <!--/span-->
    </div><!--/row-->

    <div class="row">
        <div class="well col-md-5 center login-box">
            <div class="alert alert-info">
                Please login with your Username and Password.
            </div>
            <p id="_msgLabel" style="display: none;"><label for="msg" class="alert alert-danger" role="alert">${msg }</label></p>
            <form class="form-horizontal" action="/u/userLogin" method="post">
                <fieldset>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                        <input name="loginAccount" value="${loginAccount}" type="text" class="form-control" placeholder="用户名">
                    </div>
                    <div class="clearfix"></div><br>

                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                        <input name="password" value="${password}" type="password" class="form-control" placeholder="密码">
                    </div>
                    <div class="clearfix"></div>

                    <div class="input-prepend">
                        <label class="remember" for="remember"><input type="checkbox" id="remember"> 记住我</label>

                    </div>
                    <div class="clearfix"></div>

                    <p class="center col-md-5">
                        <button type="submit" class="btn btn-primary">登入</button>
                    </p>
                </fieldset>
            </form>
        </div>
        <!--/span-->
    </div><!--/row-->
</div><!--/fluid-row-->

</div><!--/.fluid-container-->

</body>
<script type="text/javascript" charset="utf-8" src="<%= path%>/static/js/admin/userMng.js"></script>
<script type="text/javascript">
    $().ready(function() {
            loginMsg('${msg}');
    });
</script>
</html>
