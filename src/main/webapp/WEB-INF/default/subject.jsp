<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>题目练习</title>
        <%@ include file="inc/head.inc"%>
        <link rel="stylesheet" href="<%= path%>/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
    </head>
    <body>
        <%@ include file="header.jsp"%>
        <!-- blank -->
        <!-- <div class="container-fluid custom-top-blank custom-top-blank-blog"> </div> -->
        <!-- title -->
        <div class="page-title page-title-custom" id="_tagTitle">
            <div class="container-fluid">
                <div class="span1"></div>
                <div class="span11">
                    <i class="icon-list page-title-icon"></i>
                    <h2>${tagName} </h2>
                    <!-- <h2>${tagName} /</h2>
                    <p>Here is the work we've done so far</p> -->
                </div>
                
            </div>
        </div>
        
        <div class="container-fluid custom-top-tagsChart" id="_myTags"></div>
        
        <!-- Page Title -->
        <!-- <div class="page-title" id="_tagTitle" style="display: none;">
            <div class="container-fluid">
                <div class="span1"></div>
                <div class="span11">
                    <i class="icon-list page-title-icon"></i>
                    <h2>${tagName} </h2>
                </div>
                
            </div>
        </div> -->
        <!-- News -->
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span1">
                    <!-- 此处<abbr title="attribute">省略N个字...</abbr> -->
                </div>
                <div class="span7">
                    <div class="row-fluid" id="_news_content">
                    </div>
                    <div class="row-fluid">
                        <div class="span12">
                            <button class="btn btn-block" type="button" id="index-more">
                            </button>
                            <input type="hidden" value="1" name="_index_news_content_pageNo"/>
                        </div>
                    </div>
                </div>
                <div class="span4">
                    <div class="card-status-custom span12 default-summary-custom default-tags-custom team-text-custom">
                        <div class="page-title">
                            <div class="page-title-ranking"><h2>阅读排行</h2></div>
                            
                            <div class="box-content">
                                <ul class="dashboard-list" id="_ranking">
                                    
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- blank -->
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                </div>
            </div>
        </div>
        <%@ include file="footer.jsp"%>

<script src="<%= path%>/static/js/echarts.js"></script>
<script src="<%= path%>/static/js/default/subject.js"></script>

    </body>
</html>