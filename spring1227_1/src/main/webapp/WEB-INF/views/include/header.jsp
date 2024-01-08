<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
	<head>
		<title> JARDIN SHOP </title>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="description" content="JARDIN SHOP" />
		<meta name="keywords" content="JARDIN SHOP" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scaleable=no" />
		<link rel="stylesheet" type="text/css" href="../css/reset.css?v=Y" />
		<link rel="stylesheet" type="text/css" href="../css/layout.css?v=Y" />
		<link rel="stylesheet" type="text/css" href="../css/content.css?v=Y" />
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript" src="../js/top_navi.js"></script>
		<script type="text/javascript" src="../js/left_navi.js"></script>
		<script type="text/javascript" src="../js/main.js"></script>
		<script type="text/javascript" src="../js/common.js"></script>
		<script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>
		<script type="text/javascript" src="../js/idangerous.swiper-2.1.min.js"></script>
		<script type="text/javascript" src="../js/jquery.anchor.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
<div id="allwrap">
<div id="wrap">

	<div id="header">
		
		<div id="snbBox">
			<h1><a href="/"><img src="../images/txt/logo.gif" alt="JARDIN SHOP" /></a></h1>
			<div id="quickmenu">
				<div id="mnaviOpen"><img src="../images/btn/btn_mnavi.gif" width="33" height="31" alt="메뉴열기" /></div>
				<div id="mnaviClose"><img src="../images/btn/btn_mnavi_close.gif" width="44" height="43" alt="메뉴닫기" /></div>
				<ul>
					<li><a href="/layout/chart">차트EVENT</a></li>
					<li><a href="/customer/notice">CUSTOMER</a></li>
					<li><a href="/layout/publicData">dataCOMMUNITY</a></li>
				</ul>
			</div>
			<div id="snb">
				<ul>
					<c:if test="${session_id == null}">
						<li><a href="/member/login">LOGIN</a></li>
						<li><a href="/member/step01">JOIN</a></li>
					</c:if>
					<c:if test="${session_id != null}">
						<li><a href="/member/logout">LOGOUT</a></li>
						<li><a href="#">${session_name}님</a></li>
					</c:if>
					<li><a href="layout/bikeData">bike MY PAGE</a></li>
					<li><a href="layout/screenData">스크린CART</a></li>
				</ul>

				<div id="search">
					<input type="text" class="searchType" />
					<input type="image" src="../images/btn/btn_main_search.gif" width="23" height="20" alt="검색하기" />
				</div>
			</div>
		</div>
	</div>


	<!-- GNB -->
	<div id="gnb">
		
		<div id="top">
			<ul>
				<li class="brand t1"><a href="#" id="topNavi1">JARDIN’s BRAND</a>
					<ul id="topSubm1">
						<li><a href="#">클래스</a></li>
						<li><a href="#">홈스타일 카페모리</a></li>
						<li><a href="#">드립커피백</a></li>
						<li><a href="#">카페리얼 커피</a></li>
						<li><a href="#">오리지널커피백</a></li>
						<li><a href="#">카페리얼 음료</a></li>
						<li><a href="#">마일드커피백</a></li>
						<li><a href="#">워터커피</a></li>
						<li><a href="#">카페포드</a></li>
						<li><a href="#">모히또파티</a></li>
						<li><a href="#">테이크아웃 카페모리</a></li>
						<li><a href="#">포타제</a></li>
					</ul>
				</li>
				<li class="t2"><a href="#" id="topNavi2">원두</a>
					<ul id="topSubm2">
						<li><a href="#">클래스</a></li>
						<li><a href="#">로스터리샵</a></li>
						<li><a href="#">커피휘엘</a></li>
						<li><a href="#">산지별 생두</a></li>
					</ul>
				</li>
				<li class="t1"><a href="#" id="topNavi3">원두커피백</a>
					<ul id="topSubm3">
						<li><a href="#">드립커피 로스트</a></li>
						<li><a href="#">오리지널커피백</a></li>
						<li><a href="#">마일드커피백</a></li>
					</ul>
				</li>
				<li class="t2"><a href="#" id="topNavi4">인스턴트</a>
					<ul id="topSubm4">
						<li><a href="#">까페모리</a></li>
						<li><a href="#">홈스타일카페모리</a></li>
						<li><a href="#">포타제</a></li>
					</ul>
				</li>
				<li class="t1"><a href="#" id="topNavi5">음료</a>
					<ul id="topSubm5">
						<li><a href="#">까페리얼</a></li>
						<li><a href="#">워터커피</a></li>
						<li><a href="#">모히또</a></li>
					</ul>
				</li>
				<li class="t2"><a href="#" id="topNavi6">커피용품</a>
					<ul id="topSubm6">
						<li><a href="#">종이컵</a></li>
						<li><a href="#">커피필터</a></li>
						<li><a href="#">머신 등</a></li>
					</ul>
				</li>
				<li class="t1"><a href="#" id="topNavi7">선물세트</a></li>
				<li class="t2"><a href="#" id="topNavi8">대량구매</a></li>
			</ul>
		</div>

		<script type="text/javascript">initTopMenu();</script>
	</div>
	<!-- //GNB -->
    
    
    
    
    