<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<title>checkbox</title>
		<script>
		  $(function(){
			 $("#sbtn").click(function(){
				alert("검색을 진행합니다."); 
				frm.submit();
			 }); 
		  });
		</script>
	</head>
	<body>
		<h2>검색</h2>
		<form action="/member/send" name="frm" method="post">
			<select name="category">
			  <option>전체</option>
			  <option>제목</option>
			  <option>내용</option>
			</select>
			<input type="text" name="search" id="search">
			<br>
			<label>검색지역1(1개변수)</label>
			<br>
			<label for="seoul">서울</label>
			<input type="checkbox" name="local" id="seoul" value="서울">
			<label for="pusan">부산</label>
			<input type="checkbox" name="local" id="pusan" value="부산">
			<label for="incheon">인천</label>
			<input type="checkbox" name="local" id="incheon" value="인천">
			<label for="daegu">대구</label>
			<input type="checkbox" name="local" id="daegu" value="대구">
			<br>
			<br>
			<label>검색지역2(배열)</label>
			<br>
			<label for="seoul2">서울</label>
			<input type="checkbox" name="locals" id="seoul2" value="서울">
			<label for="pusan2">부산</label>
			<input type="checkbox" name="locals" id="pusan2" value="부산">
			<label for="incheon2">인천</label>
			<input type="checkbox" name="locals" id="incheon2" value="인천">
			<label for="daegu2">대구</label>
			<input type="checkbox" name="locals" id="daegu2" value="대구">
			<br>
			<button type="button" id="sbtn">검색</button>
		</form>
	</body>
</html>