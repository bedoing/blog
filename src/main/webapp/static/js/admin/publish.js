$().ready(function(){
	//实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('_articleEditor')就能拿到相关的实例
    var ue = UE.getEditor('_articleEditor');
    addArticle();
});

var addArticle = function(){
	$("#_articleAddBtn").click(function(){
		var article = {
			"title": $("#_articleTitle").val(),
			"classify": 1,
			"content": UE.getEditor('_articleEditor').getContent()
		};


		$.ajax({
			// beforeSend:function(){$('.table').html("正在加载数据，请稍候……");},
			type: "post",
            dataType: "json",
            url: PRE_URI_LIST + "article/addArticle",
			data: article,
			success: function(res){
				
			}
		});
	});
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