<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Article Manage</title>
        <%@ include file="../inc/head.inc"%>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
        <script type="text/javascript" charset="utf-8" src="<%= path%>/ueditor/ueditor.config.js"></script>
        <script type="text/javascript" charset="utf-8" src="<%= path%>/ueditor/ueditor.all.min.js"> </script>
        <script type="text/javascript" charset="utf-8" src="<%= path%>/ueditor/lang/zh-cn/zh-cn.js"></script>
    </head>
    <body>
        <%@ include file="../header.jsp"%>
        <div class="ch-container">
            <div class="row">
                
                <%@ include file="../leftMenu.jsp"%>
                <div id="content" class="col-lg-10 col-sm-10">
                    <!-- content starts -->
                    <%@ include file="../breadcrumb.jsp"%>
                    <section>
                        <div class="container-fluid well">
                            <div class="form-group col-md-6">
                                <div class="label-group" id="_labelGroup"></div>
                            </div>
                            <div class="form-group col-md-6">
                                <div class="label-group" id="_labelGroup2"></div>
                            </div>
                        </div>
                    </section>
                    
                    <div class="box col-md-12">
                        <div class="box-inner">
                            <div class="box-header well" data-original-title="">
                                <h2><i class="glyphicon glyphicon-list"></i>  <span id="_listMng"></span>  Article List</h2>
                            </div>
                            <div class="box-content">
                                <ul class="dashboard-list" id="_articleListUl">
                                    
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <%@ include file="../footer.jsp"%>
        </div><!--/.fluid-container-->
        <script type="text/javascript" charset="utf-8" src="<%= path%>/static/js/admin/blog/publish.js"></script>
<script type="text/javascript">
        var selectedTagName = "";
        $().ready(function() {
            initLabel("mngTagClick");
            initPage();
        });

        function initPage() {
            var ul = $("#_articleListUl");
            ul.empty();
            $.ajax({
                type: "post",
                dataType: "json",
                url: PRE_URI_LIST + "/articleList",
                data: {
                    "pageSize": 15
                },
                success: function(res) {

                    for (var i = 0; i < res.result.length; i++) {
                        var a = res.result[i];
                        ul.append(articleLi(a));
                    };
                }
            });
        }

        function mngTagClick(tagId, tagName) {
            selectedTagName = tagName;
            $("#_listMng").text(tagName);
            var ul = $("#_articleListUl");
            ul.empty();
            $.ajax({
                type: "post",
                dataType: "json",
                url: PRE_URI_LIST + "/findArticlesByTag",
                data: {
                    "tagName": tagName
                },
                success: function(res) {
                    for (var i = 0; i < res.result.length; i++) {
                        var a = res.result[i];
                        ul.append(articleLi(a));
                    };
                }
            });
        }

        function articleLi(article) {
            var li = '<li>' +
                '<a onclick="removeArticle(' + article.articleId + ')">' +
                '<i class="glyphicon glyphicon-remove "></i>' +
                '</a>' +
                '<a >' +
                '<span class="red">' + "-" + '</span>' +
                '</a>' +
                '<a onclick="updateArticle(' + article.articleId + ')">' +
                article.title +
                '</a>' +
                '<a class="pull-right" target="_blank" href="' + PRE_URI_ARCHIVES + '/'  + article.articleId + '">阅读原文</a>' +
                '</li>';
            return li;
        }

        function removeArticle(articleId) {
            var flag = confirm("Confirm delete?", function(e) {
                
            });
            if (flag) {
                $.ajax({
                    url: PRE_URI_LIST + "/deleteArticle",
                    data: {
                        "articleId": articleId
                    },
                    success: function(res) {
                        if (selectedTagName == "") {
                            initPage();
                        } else {
                            mngTagClick(null, selectedTagName);
                        }
                    }
                });
            }
        }

        function updateArticle(articleId) {
            window.location = PRE_URI_LIST + "/UpdateArticlePage?articleId=" + articleId;
        }
</script>
    </body>
</html>