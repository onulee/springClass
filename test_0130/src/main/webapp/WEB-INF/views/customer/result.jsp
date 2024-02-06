<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<title>결과</title>
	</head>
	<body>
	   <script>
	      if("${notice_write}"=="success"){
	    	  alert("게시글이 저장되었습니다.");
	    	  location.href="/customer/notice";
	      }
	   </script>
	
	</body>
</html>