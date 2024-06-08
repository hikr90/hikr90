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
	href="${pageContext.request.contextPath}/resources/css/manager_estimate.css"
	rel="stylesheet" type="text/css">
<script
	src=${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
</head>

<body>
<div id="wrap">
	<jsp:include page="common_top.jsp"></jsp:include>
	<jsp:include page="common_menu.jsp"></jsp:include>
	<div id="main">

		<div class="totalbar">
			<h2 style="font-size: 24px">견적 신청 조회</h2>
			<form id="totalform">
				<table cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<th scope="row" width="354" height="60">전체 견적문의</th>
							<th width="354">조경 설계</th>
							<th width="354">시설물 설치</th>
							<th width="354">유지 관리</th>
							<th width="354">수목 관리</th>
							<th width="354">기타</th>
						</tr>
						<tr>
							<td scope="row" height="90">${estimate_c.total}건</td>
							<td>${estimate_c.landscape}건</td>
							<td>${estimate_c.facility}건</td>
							<td>${estimate_c.maintenance}건</td>
							<td>${estimate_c.tree}건</td>
							<td>${estimate_c.other}건</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<div id="productlist">
			<h2>문의 목록</h2>
			<form id="listform">
				<table border="0" cellspacing="0"
					cellpadding="0">
					<tbody>
						<tr>
							<th scope="row" width="81" height="65">No</th>
							<th width="112">이름</th>
							<th width="133">연락처</th>
							<th width="167">이메일</th>
							<th width="121">서비스</th>
							<th width="116">공간</th>
							<th width="120">예산</th>
							<th width="123">날짜</th>
							<th width="201">장소</th>
							<th width="108">평수</th>
							<th width="146">희망사항</th>
						</tr>
						<c:forEach var="vo" items="${list}">
							<tr>
								<td scope="row" width="81" height="85">${vo.est_idx}</td>
								<td width="112" height="85">${vo.m_name}</td>
								<td width="133" height="85">${vo.m_phone}</td>
								<td width="167" height="85">${vo.m_email}</td>
								<td width="121" height="85">${vo.est_type}</td>
								<td width="116" height="85">${vo.est_place}</td>
								<td width="120" height="85">${vo.est_price}</td>
								<td width="123" height="85">${vo.est_day}</td>
								<td width="201" height="85">${vo.est_region}</td>
								<td width="108" height="85">${vo.est_space}</td>
								<td width="146" height="85">${vo.est_memo}</td>
							</tr>
						</c:forEach>
						<c:if test="${empty list }">
							<tr>
								<td align="center" colspan="11">현재 견적 신청 목록이 비어있습니다.</td>
							</tr>
						</c:if>
						<tr align="center">
							<td colspan="11">${pageMenu }</td>
						</tr>
					</tbody>
				</table>
			</form>

		</div>

	</div>
	</div>


</body>
</html>
