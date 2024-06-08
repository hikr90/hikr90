<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- Form postWriteWrap  -->
<div class="postWrite">
	<dl>
		<dt>
			<label for="post-title">권한명</label>
		</dt>
		<dd>
			${defaultInfo.authNm} 
		</dd>
	</dl>
	<dl>
		<dt>
			<label for="post-title">사용여부</label>
		</dt>
		<dd>
			<c:if test="${defaultInfo.useYn eq 'Y'}">예</c:if>
			<c:if test="${defaultInfo.useYn ne 'Y'}">아니오</c:if>
		</dd>
	</dl>
	<dl>
		<dt>
			<label for="post-title">비고</label>
		</dt>
		<dd style="height: 120px; vertical-align: text-top;">
			${defaultInfo.remark}
		</dd>
	</dl>
</div>

<div class="btnWrap alignR" style="float:right;">
	<input type="button" class="_btn _line" onclick="modCall(this.form);" value="수정">
	<input type="button" class="_btn _grep" onclick="delProc(this.form);" value="삭제">	
</div>
	