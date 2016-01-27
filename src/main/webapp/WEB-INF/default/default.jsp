<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>首页</title>
        <%@ include file="inc/head.inc"%>
        <link rel="stylesheet" href="<%= path%>/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
    </head>
    <body>
        <%@ include file="header.jsp"%>
        <!-- blank -->
        <!-- <div class="container-fluid custom-top-blank"> -->
            <!-- <div class="span1"></div>
            <div class="span10">
                <div class="call-to-action container">
                    <div class="row">
                        <div class="call-to-action-text span12">
                            <div class="ca-text">
                                <p>Lorem ipsum <span class="violet">dolor sit amet</span>, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et ut wisi enim.</p>
                            </div>
                            <div class="ca-button">
                                <a href="">Try It Now!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="span1"></div> -->
        </div>
        <!-- News -->
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span1">
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
                <div class="span3">
                    <!-- 1 -->
                    <div class="team-text span12 default-summary-custom">
                        <img src="<%= path%>/img/logo/head.ico" alt="">
                        <div class="default-detail-custom">
                            <h3>Ken</h3>
                            <p>The most difficult thing is the decision to act. The rest is merely tenacity.</p>
                            <p>
                                <div class="vcard-stats">
                                    <a class="vcard-stat" href="/archives">
                                        <strong id="_articlesCount" class="vcard-stat-count">0</strong>
                                        <span class="text-muted">Articles</span>
                                    </a>
                                    <a class="vcard-stat" href="/subject">
                                        <strong id="_subjectsCount" class="vcard-stat-count">0</strong>
                                        <span class="text-muted">F&Q</span>
                                    </a>
                                    <a class="vcard-stat">
                                        <strong id="_days" class="vcard-stat-count">0</strong>
                                        <span class="text-muted">Days</span>
                                    </a>
                                </div>
                            </p>
                            <div class="social-links default-links-custom">
                                <a class="github" href="https://github.com/KenKwan" target="_blank"></a>
                                <a class="linkedin" href=""></a>
                                <a class="email" href=""></a>
                                <a class="rss" href=""></a>
                            </div>
                        </div>
                    </div>
                    <!-- 2 -->
                    <!-- <div class="team-text span12 default-tags-custom">
                        <div class="page-title">
                            <div class="article-tag-page-title-custom">
                                <div class="span12 article-tag-span-custom">
                                    <i class="icon-tags"></i>
                                    <h4>Tags /</h4>
                                    <p>Here is all the tags</p>
                                </div>
                            </div>
                        </div>
                        <div id="_tagsCloud">
                        </div>
                    </div> -->
                    <!-- 3 -->
                    <div class="team-text span12 default-summary-custom default-tags-custom team-text-custom">
                        <div class="default-detail-custom">
                            <div class="page-title">
                                <div class="article-tag-page-title-custom">
                                    <div class="span12 article-tag-span-custom">
                                        <i class="icon-tags"></i>
                                        <h4>Tags /</h4>
                                        <p>Here is all the tags</p>
                                    </div>
                                </div>
                            </div>
                            <div id="_tagsCloud"></div>
                        </div>
                    </div>
                </div>
                <div class="span1"></div>
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

<script src="<%= path%>/static/js/default/blog.js"></script>
<script>
    $().ready(function(){
        initTagsCloud("tagClick", -1);
        statistics();
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
    });
</script>
    </body>
</html>