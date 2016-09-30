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

    DELETE = function(url, callback) {
         fetch(url, {
             headers: {
                 'Accept': 'application/json',
                 'Content-Type': 'application/json'
             },
             method: "DELETE"
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

    PUT = function(url, jsonData, callback) {
        fetch(url, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "PUT",
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

    var _hmt = _hmt || [];
    (function() {
      var hm = document.createElement("script");
      hm.src = "//hm.baidu.com/hm.js?e66a05834c64fd17c9f0d5457c333e0f";
      var s = document.getElementsByTagName("script")[0];
      s.parentNode.insertBefore(hm, s);
    })();
});