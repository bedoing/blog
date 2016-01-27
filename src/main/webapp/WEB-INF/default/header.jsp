<%@ page language="java" pageEncoding="utf-8"%>
<!-- Header -->
<!-- <div class="navbar-fixed-top" > -->
<div class="navbar-static-top header-custom" >
    <div class="header">
        <div class="navbar">
            <div class="navbar-inner-custom navbar-inner">
                <div class="span1"></div>
                <div class="span2 custom-header-title">
                    <h1 style="line-height: 61px;">
                    <a href="http://www.bedoing.org">Doing Something</a>
                    </h1>
                </div>
                
                <ul class="nav pull-left" id="header-nav">
                    <li class="current-page">
                        <a id="defaultPage" href="/">
                            <i class="icon-home"></i>
                            <!-- <br/> -->
                        首页</a>
                    </li>
                    
                    <!-- <li>
                        <a id="portfolioPage" href="<%= path%>/app/place/portfolio">Portfolio</a>
                    </li> -->
                    
                    <li>
                        <a id="blogPage" href="/archives">
                            <i class="icon-list"></i>
                        文章列表</a>
                    </li>
                    <li>
                        <a id="subjectPage" href="/subject">
                            <i class="icon-comments"></i>
                        题目练习</a>
                    </li>
                    
                    <!-- <li>
                        <a id="servicesPage" href="<%= path%>/app/place/services">Services</a>
                    </li> -->
                    
                    
                    <!-- <li>
                        <a id="aboutPage" href="<%= path%>/app/place/about">
                            <i class="icon-user"></i>
                        About</a>
                    </li>
                    <li>
                        <a id="contactPage" href="<%= path%>/app/place/contact">
                            <i class="icon-envelope-alt"></i>
                        Contact</a>
                    </li> -->
                    
                </ul>
                <ul class="nav pull-right" id="header-nav">
                    <li>
                        <div class="input-group  custom-header-title">
                            <form action="/list/search" method="post" class="custom-searchform">
                                <input type="text" class="" name="content" placeholder="本站搜索...">
                            </form>
                            </div><!-- /input-group -->
                        </li>
                        
                    </ul>
                    
                </div>
            </div>
        </div>
    </div>
<script type="text/javascript">
    jQuery(function($) {
        $(document).ready( function() {
            $.scrollUp({
                animation: 'fade',
                activeOverlay: '#00FFFF',
                scrollImg: {
                    active: true,
                    type: 'background',
                    src: 'img/top.png'
                    }
            });

            $.scrollUp({
                scrollName:'scrollUp',// 元素ID
                topDistance:'300',// 顶部距离显示元素之前 (px)
                topSpeed:300,// 回到顶部的速度 (ms)
                animation:'fade',// 动画类型Fade, slide, none
                animationInSpeed:200,
                animationOutSpeed:200,
                scrollText:'Scroll to top',// 元素文本
                activeOverlay:false,// 显示scrollUp的基准线，false为不显示, e.g '#00FFFF'
                });
        });
    });
</script>