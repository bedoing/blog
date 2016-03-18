<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="zh-CN">
    <head>
        <title>题目练习</title>
        <%@ include file="inc/head.inc"%>
    </head>
    <body>
        <%@ include file="header.jsp"%>
        <!-- title -->
        <div class="page-title page-title-custom" id="_tagTitle">
            <div class="row">
                <div class="col-md-12">
                    <i class="icon-list page-title-icon"></i>
                    <h2>${tagName} </h2>
                    <!-- <h2>${tagName} /</h2>
                    <p>Here is the work we've done so far</p> -->
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-12">
                <div class="custom-top-tagsChart" id="_myTags"></div>
            </div>
        </div>
        <!-- News -->
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="row" id="_news_content">
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <button class="btn btn-block" type="button" id="index-more">
                            </button>
                            <input type="hidden" value="1" name="_index_news_content_pageNo"/>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="col-md-12 ">
                        <div class="page-title">
                            <div class="page-title-ranking"><h2>阅读排行</h2></div>
                            <div class="box-content">
                                <ul id="_ranking">
                                    
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- blank -->
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                </div>
            </div>
        </div>
        <%@ include file="footer.jsp"%>
        <script src="<%= path%>/static/js/echarts.js"></script>
        <script src="<%= path%>/static/js/default/subject.js"></script>
    </body>
</html>