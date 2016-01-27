$().ready(function() {

});

function loginMsg(msg) {
    if(msg != null && msg != '' && msg != 'undefined') {
        $("#_msgLabel").removeAttr("style");
    }else {
        $("#_msgLabel").css("style", "display:none;");
    }
}