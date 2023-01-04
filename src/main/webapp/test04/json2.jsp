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
				
				let jsonStr = '{"age":[22,33,44]}';
				let jsonInfo = JSON.parse(jsonStr);
				let output = "회원나이<br>";
				output += "======<br>";
				
				for(let i in jsonInfo.age){
					output += jsonInfo.age[i] + "<br>";
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