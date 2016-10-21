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
    }
    div.append(tagStr);
}

function tagClick(tagId, tagName) {
    window.location = "/articles/tag=" + tagName;
}