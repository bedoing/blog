<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html lang="zh-CN">
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
    <div class="container">
        <div class="row">
            <div id="content" class="col-md-12">
                    <div class="row well">
                        <div class="col-md-6">
                            <div class="label-group" id="_labelGroup"></div>
                        </div>
                        <div class="col-md-6">
                            <div class="label-group" id="_labelGroup2"></div>
                        </div>
                    </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            <a onclick="initPage()">
                                <i class="glyphicon glyphicon-list"></i> 文章列表 / 
                            </a>
                            <span id="_listMng"></span>
                        </div>

                        <!-- Table -->
                        <table id="_articleListTable" class="table table-hover">

                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>
    
    <!-- Modal -->
    <div class="modal fade" id="_deleteAlertModal" tabindex="-1" role="dialog" aria-labelledby="_deleteAlertModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <!-- modal begin -->
                        <div class="alert alert-danger">
                           <strong>警告！</strong>确定删除文章?
                        </div>
                        <button type="button" class="btn btn-danger" tagFun="tagClick" onclick="deleteArticle();">继续删除</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <!-- modal end -->
                </div>
            </div>
        </div>
    </div>

    <%@ include file="../footer.jsp"%>
    </div><!--/container-->

<script type="text/javascript" charset="utf-8" src="<%= path%>/static/js/admin/blog/publish.js"></script>
<script type="text/javascript">
        var selectedTagName = "";
        var articleId;

        $().ready(function() {
            initLabel("mngTagClick");
            initPage();
        });

        function initPage() {
            $("#_listMng").empty();
            var table = $("#_articleListTable");
            table.empty();
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
                        table.append(articleTr(a, i + 1));
                    };
                }
            });
        }

        function mngTagClick(tagId, tagName) {
            selectedTagName = tagName;
            $("#_listMng").text(tagName);
            var table = $("#_articleListTable");
            table.empty();
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
                        table.append(articleTr(a, i + 1));
                    };
                }
            });
        }

        function articleTr(article, idx) {
            var tr = '<tr>' + 
                            '<td>' +
                                '<button type="button" class="btn btn-link">' + 
                                    '<span class="label label-default">' + idx + '</span>' + 
                                '</button>' + 
                            '</td>' + 
                            '<td>' + 
                                '<button type="button" class="btn btn-link pull-left">' + 
                                    '<a target="_blank" href="' + PRE_URI_ARCHIVES + '/'  + article.articleId + '">' + article.title + '</a>' + 
                                '</button>' + 
                            '</td>' +
                            '<td>' + 
                                '<button type="button" class="btn btn-link pull-right" onclick="updateArticle(' + article.articleId + ')">' + 
                                    '<span class="label label-success">更新文章</span>' + 
                                '</button>' + 
                                '<button type="button" class="btn btn-link pull-right" data-toggle="modal" data-target="#_deleteAlertModal" onclick="setArticleData(' + article.articleId + ');">' + 
                                    '<span class="label label-danger">删除文章</span>' + 
                                '</button>' +
                            '</td>' + 
                            // temp
                        '</tr>';
            return tr;
        }

        function setArticleData(articleId) {
            this.articleId = articleId;
        }

        function deleteArticle() {
            if(articleId == null || articleId == "undefined") {
                alert("删除失败!");
                return;
            }
            
            $.ajax({
                url: PRE_URI_AA + "/deleteArticle",
                data: {
                    "articleId": articleId
                },
                success: function(res) {
                    if (selectedTagName == "") {
                        initPage();
                    } else {
                        mngTagClick(null, selectedTagName);
                    }
                    $('#_deleteAlertModal').modal('hide')
                }
            });
        }

        function updateArticle(articleId) {
            window.location = PRE_URI_AA + "/UpdateArticlePage?articleId=" + articleId;
        }
</script>
</body>
</html>