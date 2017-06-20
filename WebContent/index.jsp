<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome<br/><input id="text" type="text"/>
	<button onclick="send()">发送消息</button>
	<hr/>
	<button onclick="closeWebSocket()">关闭WebSocket连接</button>
	<hr/>
	<hr/>
	<hr/>
	<div id="message"></div>
	<c:set var="test" scope="session" value="${2000*2}"></c:set>
	<c:if test="${test>2000}">
		<c:out value="${test}"></c:out>
	</c:if>
</body>
<script type="text/javascript">
	var websocket =null;
	var dialogue = "000001";
	var userid = "100001";
	var type = "0";
	//判断当前游览器是否支持websocket
	if('WebSocket' in window){
		setMessageInnerHTML("websocket 连接中....");
		websocket =new WebSocket("ws://192.168.0.208:8080/webSocketTest/imServers/"+userid+"/"+type+"");
	}
	else{
		alert("当前游览器不支持websocket,请升级游览器");
	}
	
	//连接发送错误 回调
	websocket.onerror=function (){
		setMessageInnerHTML("websocket 发生错误");
	}
	//连接成功建立的回调
	websocket.onopen=function (){
		setMessageInnerHTML("websocket 连接成功");
		setMessageInnerHTML("连接成功，等待分配客服");
	}
	//接受到消息的回调
	websocket.onmessage = function (event){
		var message = event.data;
		message = eval('('+message+')');
		setMessageInnerHTML(message.sendMessage);
	}
	//连接关闭的回调
	websocket.onclose = function (){
		 setMessageInnerHTML("WebSocket 连接关闭");
	}
	//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
	window.onbeforeunload = function () {
		closeWebSocket();
	}
	//将消息显示在网页上
	function setMessageInnerHTML(innerHTML) {
	    document.getElementById('message').innerHTML += innerHTML + '<br/>';
	}
	
	//关闭WebSocket连接
	function closeWebSocket() {
		websocket.close();
	}
	//发送消息
	function send() {
		var message = document.getElementById('text').value;
		var json = {
				type:"1",
				receiveid:dialogue,
				sendid:userid,
				sendtime:"2017.11.11",
				sendMessage:message
		}
	    websocket.send(JSON.stringify(json));
	}
</script>
</html>