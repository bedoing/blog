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
            url: "/article/list",
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
            url: "/article/list/tag",
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
                                '<a target="_blank" href="' + PRE_URI_ARCHIVES  + article.articleId + '">' + article.title + '</a>' +
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