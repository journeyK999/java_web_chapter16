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
				
				let jsonStr = '{"name":["홍길동","이순신","임꺽정"]}';
				let jsonInfo = JSON.parse(jsonStr);
				let output = "회원이름<br>";
				output += "======<br>";
				
				console.log(jsonInfo.name)
				
				for(let i in jsonInfo.name){
					output += jsonInfo.name[i] + "<br>";
				}
				
				$("#output").html(output);
				
			});
			
		});
	</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">출력</a><br><br>
	<div id="output"></div>
</body>
</html>