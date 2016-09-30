var ue;
    $().ready(function(){

        ue = initUE();
        initArticlePage();

        $("#_articleUpdateBtn").on("click",function(){
            var title = $("#_articleTitle").val()
            var summary = $("#_summary").val()
            var articleType = $("#_articleType").val()
            var content = UE.getEditor('_articleEditor').getContent()

            if(title == "" || summary =="" || articleType =="" || content == "") {
                alert("Blank ...");
                return;
            }

            var article = {
                "articleId": $("#_articleId").val(),
                "title": title,
                "articleType": articleType,
                "summary": summary,
                "tags": tagIdStr,
                "content": content
            };

            PUT("/article", article, function(data) {
                alert(res.retMsg);
            });
        });
    });

    function initArticlePage() {
        var articleType = '${article.articleType}';

        var articleTypeName = articleType == 1? 'Article':'Subject';

        var tagList = JSON.parse('${article.tagList}');
        for (var i = 0; i < tagList.length; i++) {
            var tag = tagList[i]

            tagIdStr += tag.tagId + ",";
        };

        toggleSelect('_articleToggleBtn',articleType,articleTypeName,'_articleType')

        initLabel("tagClick");

        ue.ready(function() {
            this.setContent($("#_tempContent").html());
            $("#_tempContent").empty();
        })
    }