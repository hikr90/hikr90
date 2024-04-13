<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IslandScape</title>
<style type="text/css">
a:link {
	text-decoration: none;
}
</style>
<link
	href="${pageContext.request.contextPath}/resources/css/manager_member.css"
	rel="stylesheet" type="text/css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script>
	function del(idx) {
		if(confirm('정말 삭제하시겠습니까?')){
			location.href='manager_member_delaction.do?idx='+idx;
		}
	}
</script>
<script>
	function search(f) {
		if(f.m_id.value == ""){
			return;
		}
		
		/* 아이디검색 */
		location.href='manager_member.do?m_id='+ f.m_id.value ;
	}
</script>
</head>

<body>
<div id="wrap">
	<jsp:include page="common_top.jsp"></jsp:include>
	<jsp:include page="common_menu.jsp"></jsp:include>
	<div id="main">
		<div class="totalbar">
			<h2 style="font-size: 24px">고객 관리</h2>
			<form id="totalform">
				<table cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<th scope="row" width="480" height="60">TOTAL</th>
							<th width="480">신규회원</th>
							<th width="480">탈퇴회원</th>
						</tr>
						<tr>
							<td scope="row" height="90">${count_map.allmember}명</td>
							<td>${count_map.member}명</td>
							<td>${count_map.dismember}명</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<div id="productlist">
			<h2 style="font-size: 24px">회원 목록</h2>
			<form id="listform" action="manager_member.do" method="get">
				<table border="0" cellspacing="0"
					cellpadding="0">
					<tbody>
						<tr>
							<th scope="row" width="115" height="65">이름</th>
							<th width="116">아이디</th>
							<th width="117">비밀번호</th>
							<th width="250">휴대폰번호</th>
							<th width="93">성별</th>
							<th width="329">주소</th>
							<th width="350">이메일</th>
							<th width="122">삭제</th>
						</tr>
						<c:forEach var="vo" items="${member_list}">
							<tr>
								<td scope="row" width="115" height="75">${vo.m_name}</td>
								<td width="116" height="75">${vo.m_id}</td>
								<td width="117" height="75">${vo.m_pwd}</td>
								<td width="158" height="75">${vo.m_phone}</td>
								<td width="93" height="75">${vo.m_gender}</td>
								<td width="329" height="75">${vo.m_addr}</td>
								<td width="224" height="75">${vo.m_email}</td>
								<td width="122" height="75"><img
									src="${pageContext.request.contextPath}/resources/image/deletemember.png"
									onclick="del(${vo.idx});"></td>
							</tr>
						</c:forEach>
						<c:if test="${empty member_list }">
							<tr>
								<td align="center" colspan="10">현재 주문 목록이 비어있습니다.</td>
							</tr>
						</c:if>
						<tr align="center">
							<td colspan="10">${pageMenu }</td>
						</tr>
					</tbody>
				</table>


				<div style="float: right;">
					아이디 : <input id="m_id" name="m_id"> <input type="button"
						value="찾기" onclick="search(this.form);">
				</div>

			</form>

		</div>
	</div>



	</div>
</body>
</html>
