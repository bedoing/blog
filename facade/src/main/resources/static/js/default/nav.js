$().ready(function(){

    POST("/search/", $("#searchContent").val(), function(data) {
        console.log(data)
    });
});