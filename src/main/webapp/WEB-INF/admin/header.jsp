<!-- topbar starts -->
<%@ page language="java" pageEncoding="utf-8"%>
<!-- Header -->
<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/d/login">
                管理面板</a>
        </div>
        
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li id="blogPage">
                    <a href="/ad/adminArticle">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        写文章
                    </a>
                </li>
                <li id="defaultPage">
                    <a href="/ad/articleMng">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                        文章管理
                    </a>
                </li>
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>Profile</a></li>
                        <li class="divider"></li>
                        <li><a href="/u/logout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div>

    </div>
</nav>
<!-- topbar ends -->