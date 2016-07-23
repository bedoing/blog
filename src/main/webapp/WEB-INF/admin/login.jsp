<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Login</title>
        <%@ include file="inc/head.inc"%>
        <link rel="stylesheet" href="<%= path%>/static/css/admin/sign.css?t=<%=timeStr%>">
    </head>
    <body>
        <div class="container">
            <form class="form-signin" action="/blog/app/user/userLogin" method="post">
                
                <div id="_alertMsg" class="alert alert-danger alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <strong>${msg}</strong>
                </div>

                <h2 class="form-signin-heading">Please sign in</h2>
                <label for="inputEmail" class="sr-only">Email address</label>
                <input name="loginAccount" value="${loginAccount}" type="text" class="form-control" placeholder="用户名">
                <label for="inputPassword" class="sr-only">Password</label>
                <input name="password" value="${password}" type="password" class="form-control" placeholder="密码">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>
        </div>
    </body>

<script type="text/javascript" charset="utf-8" src="<%= path%>/static/js/admin/userMng.js"></script>
<script type="text/javascript">
    $().ready(function() {
        loginMsg('${msg}');
    });

</script>
</html>