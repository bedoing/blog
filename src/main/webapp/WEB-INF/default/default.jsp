<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="zh-CN">
    <head>
        <title>首页</title>
        <%@ include file="inc/head.inc"%>
    </head>
    <body>
        <%@ include file="header.jsp"%>
        <!-- News -->
        <div class="container">
            <div class="row">
                <!-- <div class="col-md-1">
                </div> -->
                <div class="col-md-9">
                    <div class="row" id="_news_content">
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <!-- 1 -->
                    <div class="team-text col-md-12 default-summary-custom">
                        <img src="<%= path%>/img/logo/head.ico">
                        <div class="default-detail-custom">
                            <h3>Ken</h3>
                            <p>The most difficult thing is the decision to act. The rest is merely tenacity.</p>
                            <p>
                                <div class="vcard-stats">
                                    <a class="vcard-stat" href="/articles">
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
                    <div class="team-text col-md-12 default-summary-custom">
                        <div class="default-detail-custom">
                            <div class="page-title">
                                <div class="col-md-12 article-tag-span-custom">
                                    <i class="icon-tags"></i>
                                    <h4>Tags </h4>
                                    <!-- <p>Here is all the tags</p> -->
                                </div>
                            </div>
                            <div id="_tagsCloud"></div>
                        </div>
                    </div>
                </div>
                <!-- <div class="col-md-1"></div> -->
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
        <script src="<%= path%>/static/js/default/blog.js"></script>
        <script>
            $().ready(function(){
                initTagsCloud("tagClick", -1);
                statistics();
                var articleVO = {
                    "articleType": 1,
                    "pageSize": 5
                };
                initPage(PRE_URI_LIST + "/articleList", "_news_content", articleVO);
            });
        </script>
    </body>
</html>