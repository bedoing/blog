<%@ page language="java" pageEncoding="utf-8"%>
<!-- Header -->
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
          </button>
            <a class="navbar-brand" href="http://www.bedoing.org">Ken</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li id="defaultPage">
                    <a href="<%= path%>/app/index">
                        <i class="icon-home"></i>
                    首页</a>
                </li>
                
                <!-- <li>
                    <a id="portfolioPage" href="<%= path%>/app/portfolio">Portfolio</a>
                </li> -->
                
                <li id="blogPage">
                    <a href="<%= path%>/app/articles">
                        <i class="icon-list"></i>
                    文章列表</a>
                </li>
                <li id="subjectPage">
                    <a href="<%= path%>/app/subject">
                        <i class="icon-comments"></i>
                    题目练习</a>
                </li>
                
                <!-- <li>
                    <a id="servicesPage" href="<%= path%>/app/services">Services</a>
                </li> -->
                
                
                <!-- <li>
                    <a id="aboutPage" href="<%= path%>/app/about">
                        <i class="icon-user"></i>
                    About</a>
                </li>
                <li>
                    <a id="contactPage" href="<%= path%>/app/contact">
                        <i class="icon-envelope-alt"></i>
                    Contact</a>
                </li> -->
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-left" role="search" action="/blog/app/article/search" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control" name="content" placeholder="本站搜索...">
                    </div>
                </form>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container -->
</nav>