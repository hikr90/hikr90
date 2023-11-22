<!--명칭 : intr_popup_inqy_1021
	작성자 : 김태현
	작성일자 : 2022.12.01
	내용 : 팝업 아이디 찾기-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h2>
	<a class="bold" onclick="javascript:chgPopup('intrPopupInqy1021.do');">아이디 찾기</a>/
	<a class="" onclick="javascript:chgPopup('intrPopupInqy1022.do');">비밀번호 찾기</a>
</h2>

<div id="findYn" class="findYn">
	<div class="postWrite">
		<dl>
			<dt>
				<label>이름</label>
			</dt>
			<dd class="sel_2part">
				<input type="text" title="이름" name="findNm" id="findNm">
			</dd>
		</dl>
		<dl>
			<dt>
				<label>이메일</label>
			</dt>
			<dd class="sel_2part">
				<input type="text" title="이메일" id="findEmail" name="findEmail"> 
				<input type="button" class="stb-box-btn email-btn" value="코드 전송" onclick="sendNum(this.form);">
			</dd>
		</dl>
		<dl>
			<dt>
				<label>인증코드</label>
			</dt>
			<dd class="sel_2part">
				<input type="text" title="인증번호 입력" id="inputCode">
				<input type="button" class="stb-box-btn" value="인증하기" onclick="chkNum(this.form);">
			</dd>
		</dl>
	</div>
	<!-- End postWriteWrap -->
</div>