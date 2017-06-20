<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
</head>
<body>
<!-- 	<img alt="" src="Image?id=C:\Users\Administrator\Pictures\1920x1080\1920x1080-1.jpg" width="400px" height="400px">
	<img alt="" src="Image?id=C:\Users\Administrator\Pictures\1920x1080\1920x1080-2.jpg" width="400px" height="400px">
	<img alt="" src="Image?id=C:\Users\Administrator\Pictures\1920x1080\1920x1080-3.jpg" width="400px" height="400px">
	<img alt="" src="Image?id=C:\Users\Administrator\Pictures\1920x1080\1920x1080-4.jpg" width="400px" height="400px">
	<img alt="" src="Image?id=C:\Users\Administrator\Pictures\1920x1080\1920x1080-5.jpg" width="400px" height="400px">
	<img alt="" src="Image?id=C:\Users\Administrator\Pictures\1920x1080\1920x1080-6.jpg" width="400px" height="400px">
	<img alt="" src="Image?id=C:\Users\Administrator\Pictures\1920x1080\1920x1080-7.jpg" width="400px" height="400px">
	<img alt="" src="Image?id=C:\Users\Administrator\Pictures\1920x1080\1920x1080-3.jpg" width="400px" height="400px">
	<img alt="" src="Image?id=C:\Users\Administrator\Pictures\1920x1080\1920x1080-3.jpg" width="400px" height="400px">
	<img alt="" src="Image?id=C:\Users\Administrator\Pictures\1920x1080\1920x1080-3.jpg" width="400px" height="400px">
	 -->
	 <div id="x">ces</div>
<script type="text/javascript">
	window.onload = function(){
		console.log("111");
		alert("111");
		set_ub("a", "xxxxxxxxxx");
		get_ub("a");
	}
	function set_ub(key,value){
		var a = document.getElementById("x");
		a.addBehavior("#default#userdata");
		a.setAttribute(key, value);
		a.save("db");
	}
	function get_ub(key){
		var a = document.getElementById("x");
		a.addBehavior("#default#userdata");
		a.load("db");
		alert(a.getAttribute(key));
	}
</script>
</body>
</html>