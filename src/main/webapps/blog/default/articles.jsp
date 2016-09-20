<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="zh-CN">
    <head>
        <title>文章列表</title>
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
                    <!-- <div class="card-status-custom col-md-12 default-summary-custom default-tags-custom team-text-custom"> -->
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
    </body>
<script src="<%= path%>/static/js/echarts.js"></script>
        <script src="<%= path%>/static/js/default/blog.js"></script>
<script>
            $().ready(function(){
                initTitle();
                
                var indexMore = $("button[id=index-more]");
                indexMore.attr("disabled", "true");
                indexMore.text("正在加载");
                var articleVO = {
                    "articleType": 1
                };
                initPage(PRE_URI_LIST + "/articleList", "_news_content", articleVO, function(flag){
                    if(flag){
                        indexMore.text("没有更多的文章")
                    }else{
                        indexMore.removeAttr("disabled");
                        indexMore.text("加载更多")
                    }
                });
                listTitle(PRE_URI_LIST + "/hotArticles", articleVO, '_ranking');
                
                myTags(1);
            });
                
            var initTitle = function(){
                var tagName = "${tagName}";
                if(tagName != null && tagName != "") {
                    $("#_tagTitle").removeAttr("display");
                }else {
                    $("#_tagTitle").attr("display", "none");
                }
            }
        </script>
</html>