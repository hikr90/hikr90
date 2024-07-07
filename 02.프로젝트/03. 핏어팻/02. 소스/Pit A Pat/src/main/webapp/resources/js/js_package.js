function checkID()		
{  										
	var id = newMem.id.value;		

    if (id  == "")				
    {
		alert("ID를 입력해 주세요!"); 
		newMem.id.focus(); 
		return; 
    }

	window.open("checkId.jsp?id="+id,"win", "width=255, height=145, scrollbars=no, resizable=no");
}                                       

function checkValue()             
{                                           
	if(newMem.id.value == "")    
    {
		alert("ID를 입력해 주세요!"); 
		newMem.id.focus();					 
		return;                       
    }

    if(newMem.pw.value == "") 
    {
		alert("비밀번호를 입력해 주세요!");
		newMem.pw.focus();
		return;
    }

	if(newMem.pwchk.value == "") 
    {
		alert("비밀번호확인란을 입력해 주세요!");
		newMem.pwchk.focus();
		return;
    }

	if(newMem.pw.value != newMem.pwchk.value) 
    {
		alert("비밀번호와 비밀번호 확인란이 일치하지 않습니다!");
		newMem.pwchk.focus();
		return;
    }
	

    if(newMem.name.value == "") 
    {
		alert("성명을 입력해 주세요!");
		newMem.name.focus();
		return;
    }


    if(newMem.sex.value == "") 
    {
		alert("성별을 입력해 주세요!");
		newMem.sex.focus();
		return;
    }

	if(newMem.address1.value == "") 
    {
		alert("주소를 입력해 주세요!");
		newMem.address1.focus();
		return;
    }

    if(newMem.address2.value == "") 
    {
		alert("주소를 입력해 주세요!");
		newMem.address2.focus();
		return;
    }

	if(newMem.hp1.value == "") 
    {
		alert("휴대폰 앞자리 국번을 입력해 주세요!");
		newMem.hp1.focus();
		return;
    }

    if(newMem.hp2.value == "") 
    {
		alert("휴대폰 중간자리 번호를 입력해 주세요!");
		newMem.hp2.focus();
		return;
    }

    if(newMem.hp3.value == "") 
    {
		alert("휴대폰 끝자리 번호를 입력해 주세요!");
		newMem.hp3.focus();
		return;
    }
	if(newMem.email1.value == "")
	{
		alert("이메일주소를 입력해주세요!");
		newMem.email1.focus();
		return;
	}

    newMem.submit();   
}

function joinCancle()
{
	location.href="/ils/index1.html";
}

function checkUpdateValue()             
{                                           

    if(updateMem.pw.value == "") 
    {
		alert("비밀번호를 입력해 주세요!");
		updateMem.pw.focus();
		return;
    }

    if(updateMem.name.value == "") 
    {
		alert("성명을 입력해 주세요!");
		updateMem.name.focus();
		return;
    }


    if(updateMem.sex.value == "") 
    {
		alert("성별을 입력해 주세요!");
		updateMem.sex.focus();
		return;
    }

	if(updateMem.address1.value == "") 
    {
		alert("주소를 입력해 주세요!");
		updateMem.address1.focus();
		return;
    }

    if(updateMem.address2.value == "") 
    {
		alert("주소를 입력해 주세요!");
		updateMem.address2.focus();
		return;
    }

	if(updateMem.hp1.value == "") 
    {
		alert("휴대폰 앞자리 국번을 입력해 주세요!");
		updateMem.hp1.focus();
		return;
    }

    if(updateMem.hp2.value == "") 
    {
		alert("휴대폰 중간자리 번호를 입력해 주세요!");
		updateMem.hp2.focus();
		return;
    }

    if(updateMem.hp3.value == "") 
    {
		alert("휴대폰 끝자리 번호를 입력해 주세요!");
		updateMem.hp3.focus();
		return;
    }

	if(updateMem.email1.value == "")
	{
		alert("이메일주소를 입력해주세요!");
		updateMem.email1.focus();
		return;
	}

    updateMem.submit();   
}

function zipCheck()
{
	window.open("zipCheck.jsp", "win", "width=600, height=200, scrollbars=yes, status=yes");
}

function zipCheck2()
{
	window.open("zipCheck2.jsp", "win", "width=600, height=200, scrollbars=yes, status=yes");
}

function zipCheck3()
{
	window.open("zipCheck3.jsp", "win", "width=600, height=200, scrollbars=yes, status=yes");
}

function zipCheck4()
{
	window.open("zipCheck4.jsp", "win", "width=600, height=200, scrollbars=yes, status=yes");
}

function idFocus()        
{										
	newMem.id.focus();
	return;
}

function login_check()      
{
	if(document.login.id.value=="")
	{
    	alert("아이디를 입력해 주세요.");
    	document.login.id.focus();
    	return;	
    }

    if(document.login.pw.value=="")
	{
    	alert("비밀번호를 입력해 주세요.");
    	document.login.pw.focus();			
    	return;
    }
		
    document.login.submit();
}

function search_Id()
{
	document.searchId.submit();
}

function search_Pw()
{
	document.searchPw.submit();
}

function onEnterSubmit()                 
{
  	var keyCode = window.event.keyCode;
   	if(keyCode==13)  login.submit();    
}
	

function login_focus()     
{											
   	document.login.id.focus();
   	return;
}

function leaveOk()
{
	document.leaveform.submit();
}

function ord()       
{
	var str=product.count.value;
	var frm = document.product;
	frm.action = "order_ver.kakaopay.jsp";
	frm.submit();
}

function ordSubmit()
{
	ordForm.submit();

}

function consultOk()
{
	consultform.submit();

}


function putCart()           
{
	var str=product.count.value;
	var frm = document.product;
	frm.action = "putCart.jsp";
	frm.submit();
}

function amountCheck()    
{
	obj=document.product.count;
	if(isNaN(obj.value))       
	{
		obj.value="1";
		alert('숫자만 입력해주세요');
		return;
	}

   if(obj.value < 1)
	{
		obj.value="1";
	}
}


function amountPlus()  
{
	obj=document.product.count;
	obj.value=parseInt(obj.value) + 1;
}


function amountMinus()  
{
	obj=document.product.count;
	if(parseInt(obj.value)  > 1)
	{
		obj.value=parseInt(obj.value) - 1;
	}
	else
	{
		alert('더이상 줄일수가 없습니다');
		return;
	}
}

function refundSubmit() 
{
	refund.submit();
}

function cartOrder()
{
	cart.submit();
}

function qnaSubmit()
{
	if (document.qnaform.title.value == "") {
		alert("제목을 입력하세요!");
		return;
	}
	if (document.qnaform.content.value == "") {
		alert("본문을 입력하세요!");
		return;
	}
	document.qnaform.submit();
}

function MM_callJS(jsStr) { //v2.0
  return eval(jsStr)
}

function reviewSubmit()
{
	reviewform.submit();
	MM_callJS('window.close();');
}

function pqnaSubmit()
{
	productqna.submit();
	MM_callJS('window.close();');
}


function mlogin_check()      
{
	if(document.mlogin.id.value=="")
	{
    	alert("아이디를 입력해 주세요.");
    	document.login.id.focus();
    	return;	
    }

    if(document.mlogin.pw.value=="")
	{
    	alert("비밀번호를 입력해 주세요.");
    	document.login.pw.focus();			
    	return;
    }
	document.mlogin.submit();
	
}

function mpl_search()
{
	document.mpl_search.submit();
}

function loginPop()
{
	MM_openBrWindow('returnID.html','','width=520,height=420')
}

function goHome()
{
	loaction.href="index1.jsp";
}

function qnaAnswerSubmit()
{
	document.qnaAnswer.submit();
}

function pqnaAnswerSubmit(){
	document.pqnaAnswer.submit();
}

function changeSubmit() 
{
	change.submit();
}

function goLogin()
{
	opener.location.href="pipt_login_inqy_1010.jsp";
	window.close();
}

function mpp_search()
{
	document.mpp_search.submit();
}

function mpo_search(){
	document.mpo_search.submit();
}

function change_noticeSubmit()
{
	chgnotice.submit();
	MM_callJS('window.close();');
}

function change_cscenterSubmit()
{
	chgcenter.submit();
	MM_callJS('window.close();');
}

function change_orderSubmit()
{
	chgorder.submit();
	MM_callJS('window.close();');
}

function change_refundSubmit()
{
	chgrefund.submit();
	MM_callJS('window.close();');
}

function change_deliverySubmit()
{
	chgdelvry.submit();
	MM_callJS('window.close();');
}

function change_memberSubmit()
{
	chgmember.submit();
	MM_callJS('window.close();');
}

function kakaopay(){
	var frm = document.ordForm;
	frm.action = "kakaoPay.jsp";
	frm.submit();
}

function cartkakaopay(){
	var frm = document.ordForm;
	frm.action = "cartkakaoPay.jsp";
	frm.submit();
}
