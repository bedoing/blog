$(document).ready(function() {

	GET = function(url, param, callback) {
	    if(param != 'undefined' && param != null && param != "") {
	        if(url.endsWith("/")) {
	            url += param;
	        }else {
	            url += "/" + param;
	        }
	    }
	    fetch(url, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "GET"
        }).then(function(response){
            if(response.status!==200){
                console.log("WRONG, STATUS: "+response.status);
                return;
            }
            response.json().then(function(data) {
                if(callback){
                    callback(data);
                }
            });
        }).catch(function(err){
            console.log("Fetch ERROR: "+err);
        });
	}

	GETWithBody = function(url, jsonData, callback) {
        POST(url, jsonData, function(data) {
            if(callback){
                callback(data);
            }
        });
    }

    POST = function(url, jsonData, callback) {
        fetch(url, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify(jsonData)
        }).then(function(response){
            if(response.status!==200){
                console.log("WRONG, STATUS: "+response.status);
                return;
            }
            response.json().then(function(data) {
                if(callback){
                    callback(data);
                }
            });
        }).catch(function(err){
            console.log("Fetch ERROR: "+err);
        });
    }

});