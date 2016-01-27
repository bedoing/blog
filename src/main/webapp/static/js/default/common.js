$(document).ready(function(){
	headerClass();

});

function headerClass(){
	var url = window.location.href;
	$('#header-nav li').removeClass('current-page');

	if(url.indexOf("/archives/") != -1 || url.indexOf("/archive/") != -1){
		$("#blogPage").parent().addClass('current-page');
	}else if(url.indexOf("/subject/") != -1){
		$("#subjectPage").parent().addClass('current-page');
	}else{
		$("#defaultPage").parent().addClass('current-page');
	}
}