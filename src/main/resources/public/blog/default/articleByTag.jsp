<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="zh-CN">
    <head>
        <title>${tagName}</title>
        <%@ include file="inc/head.inc"%>
        <link rel="stylesheet" href="<%= path%>/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
    </head>
    <body>
        <%@ include file="header.jsp"%>
        <!-- blank -->
        <!-- <div class="container custom-top-blank"> </div> -->
        <!-- Page Title -->
        <div class="page-title">
            <div class="container">
                <div class="row">
                <div class="col-md-12">
                    <i class="icon-list page-title-icon"></i>
                    <h2>${tagName} </h2>
                    <!-- <h2>${tagName} /</h2>
                    <p>Here is the work we've done so far</p> -->
                </div>
                </div>
            </div>
        </div>
        
        <!-- <div class="container custom-top-tagsChart" id="_myTags"></div> -->
        
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

<script src="<%= path%>/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
<script src="<%= path%>/static/js/default/blog.js"></script>
<script>
    $().ready(function(){
        SyntaxHighlighter.all();
        var paramObj = {
            "tagName" : "${tagName}"
        };
        var indexMore = $("button[id=index-more]");
        indexMore.attr("disabled", "true");
        indexMore.text("正在加载");
        initPage(PRE_URI_LIST + "/findArticlesByTag", "_news_content", paramObj, function(flag){
            if(flag){
                indexMore.text("没有更多的文章")
            }else{
                indexMore.removeAttr("disabled");
                indexMore.text("加载更多")
            }
        });
    });
</script>
    </body>
</html>