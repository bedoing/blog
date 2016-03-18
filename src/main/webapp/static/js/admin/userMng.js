function loginMsg(msg) {
    if(msg != null && msg != '' && msg != 'undefined') {
        $("#_alertMsg").show();
    }else {
        $("#_alertMsg").hide();
    }
}