/**
 * 
 */
 $(function(){
	   $(".btn_login").click(function(){
		   if($("#id").val().length<1){
			   alert("아이디를 입력하셔야 합니다.");
			   $("#id").focus();
			   return false;
		   }
		   loginFrm.submit();
	   });
	  
   });