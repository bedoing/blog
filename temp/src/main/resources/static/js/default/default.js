$().ready(function(){
    initTagsCloud("tagClick", -1);
    statistics();
    var articleVO = {
        "articleType": 1,
        "pageSize": 5
    };
    initPage("article/list", "_news_content", articleVO);
});