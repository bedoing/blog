<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <title>portfolio</title>
    <%@ include file="inc/head.inc"%>
</head>

<body>
    <%@ include file="header.jsp"%>

    <!-- Page Title -->
    <div class="page-title">
        <div class="container">
            <div class="row">
                <div class="span12">
                    <i class="icon-camera page-title-icon"></i>
                    <h2>Portfolio /</h2>
                    <p>Here is the work we've done so far</p>
                </div>
            </div>
        </div>
    </div>

    <!-- Portfolio -->
    <div class="portfolio portfolio-page container">
        <div class="row">
            <div class="portfolio-navigator span12">
                <h4 class="filter-portfolio">
                    <a class="all" id="active-imgs" href="#">All</a> /
                    <a class="web-design" id="" href="#">Web Design</a> /
                    <a class="logo-design" id="" href="#">Logo Design</a> /
                    <a class="print-design" id="" href="#">Print Design</a>
                </h4>
            </div>
        </div>
        <div class="row">
            <ul class="portfolio-img">
                <li data-id="p-1" data-type="web-design" class="span3">
                    <div class="work">
                        <a href="<%= path%>/default/assets/img/portfolio/work1.jpg" rel="prettyPhoto">
                            <img src="<%= path%>/default/assets/img/portfolio/work1.jpg" alt="">
                        </a>
                        <h4>Lorem Website</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                    </div>
                </li>
                <li data-id="p-2" data-type="logo-design" class="span3">
                    <div class="work">
                        <a href="<%= path%>/default/assets/img/portfolio/work2.jpg" rel="prettyPhoto">
                            <img src="<%= path%>/default/assets/img/portfolio/work2.jpg" alt="">
                        </a>
                        <h4>Ipsum Logo</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                    </div>
                </li>
                <li data-id="p-3" data-type="print-design" class="span3">
                    <div class="work">
                        <a href="<%= path%>/default/assets/img/portfolio/work3.jpg" rel="prettyPhoto">
                            <img src="<%= path%>/default/assets/img/portfolio/work3.jpg" alt="">
                        </a>
                        <h4>Dolor Prints</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                    </div>
                </li>
                <li data-id="p-4" data-type="web-design" class="span3">
                    <div class="work">
                        <a href="<%= path%>/default/assets/img/portfolio/work4.jpg" rel="prettyPhoto">
                            <img src="<%= path%>/default/assets/img/portfolio/work4.jpg" alt="">
                        </a>
                        <h4>Sit Amet Website</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                    </div>
                </li>
                <li data-id="p-5" data-type="logo-design" class="span3">
                    <div class="work">
                        <a href="<%= path%>/default/assets/img/portfolio/work5.jpg" rel="prettyPhoto">
                            <img src="<%= path%>/default/assets/img/portfolio/work5.jpg" alt="">
                        </a>
                        <h4>Consectetur Logo</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                    </div>
                </li>
                <li data-id="p-6" data-type="print-design" class="span3">
                    <div class="work">
                        <a href="<%= path%>/default/assets/img/portfolio/work6.jpg" rel="prettyPhoto">
                            <img src="<%= path%>/default/assets/img/portfolio/work6.jpg" alt="">
                        </a>
                        <h4>Adipisicing Print</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                    </div>
                </li>
                <li data-id="p-7" data-type="web-design" class="span3">
                    <div class="work">
                        <a href="<%= path%>/default/assets/img/portfolio/work7.jpg" rel="prettyPhoto">
                            <img src="<%= path%>/default/assets/img/portfolio/work7.jpg" alt="">
                        </a>
                        <h4>Elit Website</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                    </div>
                </li>
                <li data-id="p-8" data-type="print-design" class="span3">
                    <div class="work">
                        <a href="<%= path%>/default/assets/img/portfolio/work8.jpg" rel="prettyPhoto">
                            <img src="<%= path%>/default/assets/img/portfolio/work8.jpg" alt="">
                        </a>
                        <h4>Sed Do Prints</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                    </div>
                </li>
                <li data-id="p-9" data-type="web-design" class="span3">
                    <div class="work">
                        <a href="<%= path%>/default/assets/img/portfolio/work9.jpg" rel="prettyPhoto">
                            <img src="<%= path%>/default/assets/img/portfolio/work9.jpg" alt="">
                        </a>
                        <h4>Eiusmod Website</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                    </div>
                </li>
                <li data-id="p-10" data-type="logo-design" class="span3">
                    <div class="work">
                        <a href="<%= path%>/default/assets/img/portfolio/work10.jpg" rel="prettyPhoto">
                            <img src="<%= path%>/default/assets/img/portfolio/work10.jpg" alt="">
                        </a>
                        <h4>Tempor Logo</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                    </div>
                </li>
                <li data-id="p-11" data-type="web-design" class="span3">
                    <div class="work">
                        <a href="<%= path%>/default/assets/img/portfolio/work11.jpg" rel="prettyPhoto">
                            <img src="<%= path%>/default/assets/img/portfolio/work11.jpg" alt="">
                        </a>
                        <h4>Incididunt Website</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                    </div>
                </li>
                <li data-id="p-12" data-type="print-design" class="span3">
                    <div class="work">
                        <a href="<%= path%>/default/assets/img/portfolio/work12.jpg" rel="prettyPhoto">
                            <img src="<%= path%>/default/assets/img/portfolio/work12.jpg" alt="">
                        </a>
                        <h4>Ut Labore Print</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
                    </div>
                </li>
            </ul>
        </div>
    </div>

    <%@ include file="footer.jsp"%>
</body>
</html>
