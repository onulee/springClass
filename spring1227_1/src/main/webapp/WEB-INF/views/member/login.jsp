<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp" %>

	<!-- container -->
	<div id="container">

		<div id="location">
			<ol>
				<li><a href="#">HOME</a></li>
				<li><a href="#">MEMBERSHIP</a></li>
				<li class="last">로그인</li>
			</ol>
		</div>
		
		<div id="outbox">		
			<div id="left">
				<div id="title2">MEMBERSHIP<span>멤버쉽</span></div>
				<ul>	
					<li><a href="#" id="leftNavi1">로그인</a></li>
					<li><a href="#" id="leftNavi2">회원가입</a></li>
					<li><a href="#" id="leftNavi3">아이디/<span>비밀번호 찾기</span></a></li>
					<li><a href="#" id="leftNavi4">회원약관</a></li>
					<li><a href="#" id="leftNavi5">개인정보<span>취급방침</span></a></li>
					<li class="last"><a href="#" id="leftNavi6">이메일무단<span>수집거부</span></a></li>
				</ul>			
			</div><script type="text/javascript">initSubmenu(1,0);</script>


			<!-- contents -->
			<div id="contents">
				<div id="member">
					<h2><strong>로그인</strong><span>로그인 후 주문하시면 다양한 혜택을 받으실 수 있습니다.</span></h2>
					<h3>회원 로그인</h3>
					<script>
					  $(function(){
						 $(".sbtn").click(function(){
							alert("로그인을 합니다."); 
							console.log($(".loginType"));
							if($("#id").val().length<1){
								alert("아이디를 입력하셔야 합니다.");
								$(".loginType").focus();
								return false;
							}
							
							let id = $("#id").val();
							let pw = $("#pw").val();
							
							//ajax형태
							$.ajax({
								url:"/member/ajaxLogin",
								type:"post",
								data:{"id":id,"pw":pw},
								dataType:"text",
								success:function(data){
									//alert("성공");
									if(data=="1"){
								    	alert("로그인이 되었습니다.");
								    	location.href="/";
								    }else{
								    	alert("아이디 또는 패스워드가 일치하지 않습니다.");
								    	$("#pw").val(""); //패스워드삭제
								    	$("#pw").focus();
								    }
								},
								error:function(){
									alert("실패");
								}
							});//ajax
							
							//jsp형태
							//loginFrm.submit();
							
						 }); //click
						 
						 $("#idsave").click(()=>{
							//alert("체크확인");
							let id = "";
							if($("#idsave").is(":checked") == true){
								alert("체크되었습니다.");
								id = $("#id").val();
							}else{
								alert("체크해제 되었습니다.");
							}
							
							$.ajax({
								url:"/member/idsave",
								type:"post",
								data:{"id":id},
								dataType:"text",
								success:function(data){
									alert("성공");
									console.log(data);
								},
								error:function(){
									alert("실패");
								}
							}); 
							
							
							
						 });
						 
					  });//jquery
					</script>
					<form action="login" method="post" name="loginFrm" id="loginFrm">
						<div class="informbox">
							<div class="inform">
								<ul>
									<script>
									   $(function(){
										   if(${empty cookie.id.value}){
											   $("#id").addClass("loginType loginType2");
										   }else{
											   $("#id").addClass("loginType");
										   }
									   });
									</script>
									<li><input type="text" name="id" id="id" value="${cookie.id.value}" onfocus="this.className='mfocus'"     /></li>
									<li><input type="password" name="pw" id="pw" class="passType" onfocus="this.className='mfocus'" onblur="if (this.value.length==0) {this.className='passType'}else {this.className='mfocusnot'}" style="ime-mode:inactive;" /></li>
								</ul>
	
								<div class="btn"><a class="sbtn" style="cursor: pointer;">로그인</a></div>
								<div class="chk"><input type="checkbox" id="idsave" ${ empty cookie.id.value?"":"checked" }/><label for="idsave">아이디 저장</label></div>							
	
								<div class="point">
									<p>아이디와 비밀번호를 잊으셨나요?</p>
									<a href="/member/idsearch" class="nbtn">아이디/비밀번호 찾기</a>
								</div>
							</div>
						</div>
					</form>



					<h3>비회원 주문 조회</h3>
					<div class="informbox">
						<div class="inform">
							<ul>
								<li><input type="text" class="ordererType" onfocus="this.className='mfocus'" onblur="if (this.value.length==0) {this.className='ordererType'}else {this.className='mfocusnot'}" /></li>
								<li><input type="text" class="ordernumType" onfocus="this.className='mfocus'" onblur="if (this.value.length==0) {this.className='ordernumType'}else {this.className='mfocusnot'}" /></li>
							</ul>

							<div class="btn"><a href="#" class="gbtn">조회하기</a></div>
							<div class="point">
								<p>아직 JARDIN 회원이 아니신가요? <span>회원가입하시고 다양한 혜택을 받으세요.</span></p>
								<a href="#" class="nbtn">회원가입</a>
							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- //contents -->


		</div>
	</div>
	<!-- //container -->




	<div id="footerWrap">
		<div id="footer">
			<div id="fnb">
				<ul>
					<li class="left"><a href="#">개인정보취급방침</a></li>
					<li><a href="#">이용약관</a></li>
					<li class="left"><a href="#">이메일무단수집거부</a></li>
					<li><a href="#">고객센터</a></li>
					<li class="left brand"><a href="#">쟈뎅 브랜드 사이트</a></li>
				</ul>
			</div>
			
			<div id="finfo">
				<div id="flogo"><img src="../images/txt/flogo.gif" alt="JARDIN THE COFFEE CREATOR, SINCE 1984" /></div>
				<address>
					<ul>
						<li>㈜쟈뎅</li>
						<li>대표자 윤영노</li>
						<li class="tnone">주소 서울시 강남구 논현동 4-21번지 영 빌딩</li>
						<li class="webnone">소비자상담실 02)546-3881</li>
						<li>사업자등록번호 211-81-24727</li>
						<li class="tnone">통신판매신고 제 강남 – 1160호</li>
						<li class="copy">COPYRIGHT © 2014 JARDIN <span>ALL RIGHTS RESERVED.</span></li>
					</ul>
				</address>

				<div id="inicis"><img src="../images/ico/ico_inicis.png" alt="이니시스 결제시스템" /></div>
			</div>
		</div>
	</div>



</div>
</div>
</body>
</html>