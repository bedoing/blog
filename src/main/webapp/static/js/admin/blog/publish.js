var tagIdStr = "";

$().ready(function(){
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('_articleEditor')就能拿到相关的实例
    // var ue = UE.getEditor('_articleEditor');

    $("#_articleAddBtn").on("click",function(){
        var title = $("#_articleTitle").val()
        var summary = $("#_summary").val()
        var articleType = $("#_articleType").val()
        var content = UE.getEditor('_articleEditor').getContent()
        
        if(title == "" || summary =="" || articleType =="" || content == "") {
            alert("Blank ...");
            return;
        }

        var article = {
            "title": title,
            "summary": summary,
            "tags": tagIdStr,
            "articleType": articleType,
            "content": content
        };

        $.ajax({
            beforeSend:function(){$('.table').html("正在保存，请稍候……");},
            type: "post",
            dataType: "json",
            url: PRE_URI_AA + "/addArticle",
            data: article,
            success: function(res){
                alert(res.retMsg);
                resetArticlePage("mngTagClick");
            }
        });
    });

    $("#_newTagBtn").on("click", function(){
        var tagName = $("#_newTagName").val();
        var tagType = $("#_newTagType").val();
        
        $.ajax({
            url: PRE_URI_AA + "/addNewTag",
            type: "post",
            dataType: "json",
            data: {"tagName": tagName, "tagType":tagType},
            success: function(res) {
                if(res.retMsg == "success") {
                    initLabel($("#_newTagBtn").attr("tagFun"));
                }else {
                    alert(res.retMsg);
                }
            }
        });
    });
    
});

function initUE() {
    return UE.getEditor('_articleEditor', {
        allowDivTransToP: false
    });
}

/*function selectTagType(type, name){
    $("#_newTagType").val(type);
    $("#_typeToggleBtn").text(name)
}*/

function toggleSelect(btnId, key, value, hiddenId) {
    $("#" + hiddenId).val(key);
    $("#" + btnId).text(value);
}

function resetArticlePage(funName) {
    $("#_articleTitle").val("");
    $("#_summary").val("");
    // $("#_articleToggleBtn").text("选择分类");
    tagIdStr = "";
    UE.getEditor('_articleEditor').setContent("");
    // initLabel(funName);
    resetTagStatus();
}

function resetTagStatus() {
    $("#_labelGroup > div").removeAttr("style");
    $("#_labelGroup2 > div").removeAttr("style");
}

function initLabel(funName){
    $("#_labelGroup").empty();
    $("#_labelGroup2").empty();
    $.ajax({
            type: "post",
            dataType: "json",
            url: PRE_URI_LIST + "/getAllTagsByType",
            data: {"type": -1},
            success: function(res){
                for (var i = 0; i < res.length; i++) {

                    if(res[i].tagType == 1) {
                        $("#_labelGroup").append('<div class="btnLabel" ' + 'id="' + res[i].tagId + '"' + 'onClick="' + funName + '(' + res[i].tagId + ', \'' + res[i].tagName + '\')">' + res[i].tagName + '</div>');
                    }else {
                        $("#_labelGroup2").append('<div class="btnLabel" ' + 'id="' + res[i].tagId + '"' + 'onClick="' + funName + '(' + res[i].tagId + ', \'' + res[i].tagName + '\')">' + res[i].tagName + '</div>');
                    }
                };

                var tagList = tagIdStr.split(",");
                for (var i = 0; i < tagList.length; i++) {
                    var tagId = tagList[i];
                    if(tagId != "") {
                        tagCss(tagId, true);
                    }
                };
            }
        });
}

function tagClick(tagId) {
    tagId += "";

    tagCss(tagId, tagIdStr.indexOf(tagId) == -1);

    if(tagIdStr.indexOf(tagId) != -1) {
        if(tagIdStr.indexOf(tagId) + tagId.length == tagIdStr.length){
            tagIdStr = tagIdStr.substring(0, tagIdStr.indexOf(tagId) - 1);
        }else if(tagIdStr.indexOf(tagId) == 0) {
            tagIdStr = tagIdStr.substring(tagId.length + 1,  tagIdStr.length)
        }else {
            tagIdStr = tagIdStr.substring(0, tagIdStr.indexOf(tagId)) + tagIdStr.substring(tagIdStr.indexOf(tagId) + tagId.length + 1, tagIdStr.length)
        }
    }else{
        tagIdStr += tagId + ",";
    }
}

function tagCss(id, isAdd){
    var div = $("#" + id);

    if(isAdd) {
        div.attr("style", "background-color: #40AA53; border-radius: 1em;");
    }else {
        div.attr("style", "background-color: #4BA1F3; border-radius: .25em;");
    }
}

function isFocus(e){
    alert(UE.getEditor('_articleEditor').isFocus());
    UE.dom.domUtils.preventDefault(e)
}
function setblur(e){
    UE.getEditor('_articleEditor').blur();
    UE.dom.domUtils.preventDefault(e)
}
function insertHtml() {
    var value = prompt('插入html代码', '');
    UE.getEditor('_articleEditor').execCommand('insertHtml', value)
}
function createEditor() {
    enableBtn();
    UE.getEditor('_articleEditor');
}
function getAllHtml() {
    alert(UE.getEditor('_articleEditor').getAllHtml())
}
function getContent() {
    var arr = [];
    arr.push("使用editor.getContent()方法可以获得编辑器的内容");
    arr.push("内容为：");
    arr.push(UE.getEditor('_articleEditor').getContent());
    alert(arr.join("\n"));
}
function getPlainTxt() {
    var arr = [];
    arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
    arr.push("内容为：");
    arr.push(UE.getEditor('_articleEditor').getPlainTxt());
    alert(arr.join('\n'))
}
function setContent(isAppendTo) {
    var arr = [];
    arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
    UE.getEditor('_articleEditor').setContent('欢迎使用ueditor', isAppendTo);
    alert(arr.join("\n"));
}
function setDisabled() {
    UE.getEditor('_articleEditor').setDisabled('fullscreen');
    disableBtn("enable");
}

function setEnabled() {
    UE.getEditor('_articleEditor').setEnabled();
    enableBtn();
}

function getText() {
    //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
    var range = UE.getEditor('_articleEditor').selection.getRange();
    range.select();
    var txt = UE.getEditor('_articleEditor').selection.getText();
    alert(txt)
}

function getContentTxt() {
    var arr = [];
    arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
    arr.push("编辑器的纯文本内容为：");
    arr.push(UE.getEditor('_articleEditor').getContentTxt());
    alert(arr.join("\n"));
}
function hasContent() {
    var arr = [];
    arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
    arr.push("判断结果为：");
    arr.push(UE.getEditor('_articleEditor').hasContents());
    alert(arr.join("\n"));
}
function setFocus() {
    UE.getEditor('_articleEditor').focus();
}
function deleteEditor() {
    disableBtn();
    UE.getEditor('_articleEditor').destroy();
}
function disableBtn(str) {
    var div = document.getElementById('_btns');
    var _btns = UE.dom.domUtils.getElementsByTagName(div, "button");
    for (var i = 0, btn; btn = _btns[i++];) {
        if (btn.id == str) {
            UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
        } else {
            btn.setAttribute("disabled", "true");
        }
    }
}
function enableBtn() {
    var div = document.getElementById('_btns');
    var _btns = UE.dom.domUtils.getElementsByTagName(div, "button");
    for (var i = 0, btn; btn = _btns[i++];) {
        UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
    }
}

function getLocalData () {
    alert(UE.getEditor('_articleEditor').execCommand( "getlocaldata" ));
}

function clearLocalData () {
    UE.getEditor('_articleEditor').execCommand( "clearlocaldata" );
    alert("已清空草稿箱")
}