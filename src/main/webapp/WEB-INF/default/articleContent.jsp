<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>${article.title }</title>
        <%@ include file="inc/head.inc"%>
        <link rel="stylesheet" href="<%= path%>/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
    </head>
    <body>
        <%@ include file="header.jsp"%>
        <!-- blank -->
        <!-- <div class="container-fluid custom-top-blank"></div> -->
        <!-- News -->
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span1">
                    <!-- 此处<abbr title="attribute">省略N个字...</abbr> -->
                </div>
                <div class="span10">
                    <!-- <div class="row-fluid" id="_articleContent">-->
                    <article class="article well well-custom">
                        <div class="row-fluid">
                            <div class="span12">
                                <h2><a href="#">${article.title }</a></h2>
                                <p><p>
                                    <div class="title-two">
                                        <!-- <small>' + idx + '</small> -->
                                        <i class="icon-time"> </i>
                                        <a href="#"><time>${article.createTimeStr }</time></a>
                                        &nbsp;
                                        <i class="icon-eye-open"> </i>
                                        <a>${article.clicks}</a>&nbsp;&nbsp;
                                        <i class="icon-tags"> </i>
                                        <span id="_articleContentTags">
                                        </span>
                                        
                                    </div>
                                </p>
                                <p class="lead">
                                    ${article.content }
                                </p>
                            </p>
                        </div>
                    </div>
                </article>
                <!--</div>-->
                
            </div>
            <div class="span1">
                <!-- 此处也<abbr title="attribute">省略N个字...</abbr> -->
            </div>
        </div>
    </div>
    <!-- blank -->
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span1"></div>
            <div class="span10">
                <%@ include file="comment.jsp"%>
            </div>
            <div class="span1"></div>
        </div>
    </div>
    <%@ include file="footer.jsp"%>

<script src="<%= path%>/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
<script src="<%= path%>/ueditor/ueditor.parse.min.js"></script>
<script>
    $().ready(function(){
        SyntaxHighlighter.all();
        $("#_hArticleId").val("${article.articleId}");
        showComment();
        tagsInit();
    });

    function tagsInit(){
        var div = $("#_articleContentTags");
        div.empty();
        // var tagList = '${article.tagList}';
        var tagList = eval('('+ '${article.tagList}' +')');
        var tagStr = "";

        for (var i = 0; i < tagList.length; i++) {
            var tag = tagList[i];
            tagStr += '<a href="#" onClick="tagClick(' + tag.tagId + ',\'' + tag.tagName + '\')"><em>' + tag.tagName + '</em>';
            if(tagList.length - i != 1) {
                tagStr += ',   ';
            }
        };
        div.append(tagStr);
    }
    
    function tagClick(tagId, tagName) {
        window.location = PRE_URI_TAG + "/" + tagName;
    }
</script>
    </body>
</html>