



let client = {
    get: function(aUrl, aCallback,errorCallback) {
        let anHttpRequest = new XMLHttpRequest();
        anHttpRequest.onreadystatechange = function() {
            if (anHttpRequest.readyState === 4 && anHttpRequest.status === 200)
                aCallback(anHttpRequest.responseText);
            else
                errorCallback(anHttpRequest)
        };

        anHttpRequest.open( "GET", aUrl, true );
        anHttpRequest.send( null );
    }
};


obj.ping = (callback)=>{
    console.log("Pinging..." + typeof callback);
    client.get(obj.url + "/hello" , (res) => {
        console.log("Calling callbackP:" + typeof callback);
        callback(res)
    }, (err)=>{
        // console.error(err)
    });
};