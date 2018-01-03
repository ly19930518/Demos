<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>我是websocket</div>
	<div id="message"></div>
	<input id="text" type="text" />
	<button onclick="send()">发送</button>
</body>
<script>
	var websocket = null;
	//判断当前游览器是否支持
	if('WebSocket' in window){
		websocket = new WebSocket("ws://127.0.0.1:8080/Demos/websocket1?url=1&name=u&id=01");
	}else{
		alert("当前游览器不知此websokcet,请更换游览器");
	}
	//连接发生错误回调
	websocket.onerror = function(){
		addmessage("发生了一个错误");
	}
	websocket.onopen = function(){
		addmessage("连接服务器成功");
	}
	//连接服务器关闭
	websocket.onclose = function (){
		addmessage("与服务器连接断开");
	}
	//接收到消息的回调方法
	websocket.onmessage = function (event) {
		addmessage("接收到消息："+event.data);
	}
	//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
	window.onbeforeunload = function () {
		closeWebSocket();
	}
	//关闭WebSocket连接
	function closeWebSocket() {
	 	websocket.close();
    }
	var addmessage = function(msg){
		var dm = document.getElementById("message")
		dm.innerHTML += msg+"<br/>"
	}
	//发送消息
	function send() {
		var message = document.getElementById('text').value;
		websocket.send(message);
	}
</script>
</html>