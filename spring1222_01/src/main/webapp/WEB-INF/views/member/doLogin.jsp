<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html lang="ko">
	<head>
	    <meta charset="UTF-8">
	    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
	    <title>doLogin</title>
	</head>
	<body>
	   <script>
	       if(${result}==1){
	    	   alert("로그인이 되었습니다.");
	    	   location.href="/";
	       }else{
	    	   alert("아이디 또는 패스워드가 일치하지 않습니다.");
	    	   location.href="login";
	       }
	   </script>
	</body>
</html>