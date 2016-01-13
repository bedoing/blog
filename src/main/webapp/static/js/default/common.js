$(document).ready(function(){
	headerClass();

});

function headerClass(){
	var url = window.location.href;
	$('#header-nav li').removeClass('current-page');

	if(url.indexOf("place/portfolio") != -1){
		$("#portfolioPage").parent().addClass('current-page');
	}if(url.indexOf("/archives/") != -1 || url.indexOf("/archive/") != -1){
		$("#blogPage").parent().addClass('current-page');
	}if(url.indexOf("/subject/") != -1){
		$("#subjectPage").parent().addClass('current-page');
	}if(url.indexOf("place/services") != -1){
		$("#servicesPage").parent().addClass('current-page');
	}if(url.indexOf("place/about") != -1){
		$("#aboutPage").parent().addClass('current-page');
	}if(url.indexOf("place/contact") != -1){
		$("#contactPage").parent().addClass('current-page');
	}else{
		$("#defaultPage").parent().addClass('current-page');
	}
}