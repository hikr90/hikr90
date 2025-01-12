<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h3>
	<a class="list_bg" onclick="javascript:chgPopup('intrPopupInqy1020.do');">아이디 찾기</a>
	<a onclick="javascript:chgPopup('intrPopupInqy1030.do');">비밀번호 찾기</a>
</h3>

<div id="findYn" class="findYn">
	<div class="post_write">
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
				<input type="button"class="btn_navy ml10" value="코드 전송" onclick="sendNum(this.form);">
			</dd>
		</dl>
		<dl>
			<dt>
				<label>인증코드</label>
			</dt>
			<dd class="sel_2part">
				<input type="text" title="인증번호 입력" id="inputCode">
				<input type="button"class="btn_navy ml10" value="인증하기" onclick="chkNum(this.form);">
			</dd>
		</dl>
	</div>
	<!-- End post_write -->
</div>