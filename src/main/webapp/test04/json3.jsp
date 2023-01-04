<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>JSON 테스트</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		$(function(){
			
			$('#checkJson').click(function(){
				
				let jsonStr = '{"name":"박지성","age":25,"gender":"남자"}';
				let jsonObj = JSON.parse(jsonStr);
				let output = "회원나이<br>";
				output += "======<br>";
				output += "이름 : " + jsonObj.name + "<br>";
				output += "나이 : " + jsonObj.age + "<br>";
				output += "성별 : " + jsonObj.gender + "<br>";

				$("#output").html(output);
				
				for(let key in jsonObj){
					console.log(key, " ", jsonObj[key]);
				}
				
				
			});
			
		});
	</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">출력</a><br><br>
	<div id="output"></div>
</body>
</html>