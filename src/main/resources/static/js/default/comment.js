var alertInfo = $("#_alertInfo");
        var ue = null;

        $().ready(function() {
                hideCommentInput();

                hideAlertInfo();
                $("#_commentBtn").on("click", function() {
                        var content = ue.getContent();

                        if(content == null || content.trim() == "") {
                                // return ;
                        }

                        var comment = {
                            "articleId": $("#_hArticleId").val(),
                            "content": UE.getEditor('_commentEditor').getContent()
                        };

                        $.ajax({
                                beforeSend:function(){
                                        $("#_commentBtn").attr("disabled", true);
                                        // $("#_commentBtn").text("提交中...");
                                        showMsg();
                                        showAlertInfo("提交中...");
                                },
                                type: "post",
                                dataType: "json",
                                url: PRE_URI_COMMENT + "/addComment",
                                data: comment,
                                success: function(res){
                                    if(res.retMsg == "success") {
                                            resetPage();
                                            showMsg("success");
                                            showAlertInfo("提交成功!");
                                            showComment();
                                    }else{
                                            showAlertInfo(res.retMsg);
                                            showMsg("fail");
                                    }
                                },
                                complete: function(){
                                        $("#_commentBtn").removeAttr("disabled");
                                        // $("#_commentBtn").text("提交");
                                }
                        });
                });

                $("#_pingLun").on("click", function() {
                    if(ue != null) {
                        ue.destroy();
                        ue = null;
                        hideCommentInput();
                    }else{
                        ue = UE.getEditor('_commentEditor', {
                                allowDivTransToP: false
                        });
                        showCommentInput();
                    }
                })
        });

    function showCommentInput() {
        $("#_commentDiv").removeAttr("style");
    }

    function hideCommentInput() {
        $("#_commentDiv").attr("style", "display:none");
    }

    function showAlertInfo(content) {
        alertInfo.removeAttr("style");
        alertInfo.html(content);
    }

    function hideAlertInfo() {
        alertInfo.attr("style", "display:none");
    }

    function showComment(){
        $("#_commentContent").empty();
        var articleId = $("#_hArticleId").val();
        if(articleId == ""){
            return;
        }

        var comment = {
                "articleId": articleId
        };

        $.ajax({
            type: "post",
            dataType: "json",
            url: PRE_URI_COMMENT + "/commentList",
            data: comment,
            success: function(res){
                for (var i = 0; i < res.result.length; i++) {
                    var c = res.result[i];
                    var cStr = "";

                    cStr += '<blockquote>';
                    cStr += '<p>';
                    cStr += '<span class="label label-default" >' + c.createTimeStr + '</span>';
                    cStr += '</p>';
                    cStr += '<p>';
                    cStr += c.content;
                    // cStr += '</p> <small>关键词 <cite>开源</cite></small>';
                    cStr += '</p>';
                    cStr += "</blockquote>";

                    $("#_commentContent").append(cStr);
                };
            }
        });
    }

    function resetPage(){
        ue.setContent("");
    }

    function showMsg(result) {
            alertInfo.removeClass();
            if(result == "success") {
                    alertInfo.addClass("alert alert-success");
                    setTimeout(hideAlertInfo,3000);
            }else if(result == "fail") {
                    alertInfo.addClass("alert alert-danger");
            }else{
                    alertInfo.addClass("alert alert-info");
            }
    }