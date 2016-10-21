$(document).ready(function(){

        var paramObj = {
            "tagName" : $("#hiddenTagName").val()
        };
        var indexMore = $("button[id=index-more]");
        indexMore.attr("disabled", "true");
        indexMore.text("正在加载");
        initPage("/article/list/tag", "_news_content", paramObj, function(flag){
            if(flag){
                indexMore.text("没有更多的文章")
            }else{
                indexMore.removeAttr("disabled");
                indexMore.text("加载更多")
            }
        });
    });