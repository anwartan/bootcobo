var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('http://localhost:8080/web-socket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/broker/comment', function (greeting) {
            showGreeting(JSON.parse(greeting.body).message);
        });
        stompClient.subscribe('/broker/like', function (greeting) {
            console.log(JSON.parse(greeting.body).status);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/sendComment", {}, JSON.stringify({'message': $("#name").val(),'userId':"1","postingId":"606550f6552b4c4586c9fe4b"}));
}

function setLike(status) {
    stompClient.send("/app/setLike", {}, JSON.stringify({'status': status,'userId':"1","postingId":"606550f6552b4c4586c9fe4b"}));

}

function join() {
    stompClient.send("/app/joinRoom", {}, JSON.stringify({'roomId':"6065c2b3922dba3caa670450","userId":"1"}));

}
function quit() {
    stompClient.send("/app/quitRoom", {}, JSON.stringify({'roomId':"6065c2b3922dba3caa670450","userId":"1"}));

}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    $( "#like" ).click(function() { setLike(true); });
    $( "#like1" ).click(function() { setLike(false); });
    $( "#join" ).click(function() { join() });
    $( "#quit" ).click(function() { quit() });

});