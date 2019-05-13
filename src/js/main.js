// import {JsonSerializers} from "rsocket-core";

var RSocketWebSocketClient = require("rsocket-websocket-client").default;

var RSocketClient = require('rsocket-core');
var JsonSerializers = require('rsocket-core');

// import RSocketWebSocketClient from 'rsocket-websocket-client';

obj.f = function f(){
    console.log("ASDFASDF")
};

let rsocket = null;
// Create an instance of a client
const client = new RSocketClient.RSocketClient({
    // send/receive objects instead of strings/buffers
    serializers: JsonSerializers,
    setup: {
        // ms btw sending keepalive to server
        keepAlive: 600,
        // ms timeout if no keepalive response
        lifetime: 1800,
        // format of `data`
        dataMimeType: 'application/json',
        // format of `metadata`
        metadataMimeType: 'application/json',
    },
    transport: new RSocketWebSocketClient({
        url:"wss://72.66.54.109", port: 48626 }),
}).connect();

client.subscribe({
    onComplete: s => {
        rsocket = s;
        console.log("Completed!")
    },
    onError: e => {
        console.log(e)
    }
});

console.log(typeof client);



// Open the connection
obj.ping = function(){
    if(rsocket == null){
        console.log("rsocket not connected yet");
        return
    }
    rsocket.requestResponse({
        data: "{ i:3 }",
    }).subscribe({
        onComplete: r => {
            console.log(r)
        },
        onError: r => {
            console.log(r)
        }
    });
};