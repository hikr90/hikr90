<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=euc-kr">
<title>IslandScape</title>
<style type="text/css">
a:link {
	text-decoration: none;
	;
}
</style>

<link
	href="${pageContext.request.contextPath}/resources/css/manager_noticeboard.css"
	rel="stylesheet" type="text/css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function MM_openBrWindow(theURL, winName, features) { //v2.0
		window.open(theURL, winName, features);
	}
</script>
</head>

<body>
<div id="wrap">
	<jsp:include page="common_top.jsp"></jsp:include>
	<jsp:include page="common_menu.jsp"></jsp:include>


	<div id="main">
		<div id="productlist">
			<h2 style="font-size: 24px">게시판 관리</h2>
			<form id="listform">
				<table border="0" cellspacing="0"
					cellpadding="0">
					<tbody>
						<tr>
							<th scope="row" width="218" height="60">분류</th>
							<th width="242">게시판 제목</th>
							<th width="242">관리자 ID</th>
							<th width="242">권한(읽기/쓰기)</th>
							<th width="242">게시글 갯수</th>
							<th width="242">게시글 관리</th>
						</tr>
						<tr>
							<td scope="row" height="60">운영</td>
							<td height="60"><a href="cscenter_notice.do">공지사항</a></td>
							<td height="60">${notice_manager}</td>
							<td height="60">관리자/비회원</td>
							<td height="60">${notice_count.notice}</td>
							<td><img
								src="${pageContext.request.contextPath}/resources/image/manageboard.png"
								alt="" width="90" height="40"
								onClick="MM_openBrWindow('delete_notice.do','','width=1020,height=850')" /></td>
						</tr>
						<tr>
							<td scope="row">운영</td>
							<td><a href="cscenter_top10.do">자주묻는 질문</a></td>
							<td>${center_manager}</td>
							<td>관리자/비회원</td>
							<td>10</td>
							<td><img
								src="${pageContext.request.contextPath}/resources/image/manageboard.png"
								width="90" height="40"
								onClick="MM_openBrWindow('delete_faq.do?ctg=자주묻는 질문','','width=1020,height=850')"
								alt="" /></td>
						</tr>
						<tr>
							<td scope="row">운영</td>
							<td><a href="cscenter_order.do">주문 / 결제 FAQ</a></td>
							<td>${order_manager}</td>
							<td>관리자/비회원</td>
							<td>${notice_count.order}</td>
							<td><img
								src="${pageContext.request.contextPath}/resources/image/manageboard.png"
								width="90" height="40"
								onClick="MM_openBrWindow('delete_faq.do?ctg=주문 / 결제 FAQ','','width=1020,height=850')"
								alt="" /></td>
						</tr>
						<tr>
							<td scope="row">운영</td>
							<td><a href="cscenter_refund.do">반품 / 교환 FAQ</a></td>
							<td>${refund_manager}</td>
							<td>관리자/비회원</td>
							<td>${notice_count.refund}</td>
							<td><img
								src="${pageContext.request.contextPath}/resources/image/manageboard.png"
								width="90" height="40"
								onClick="MM_openBrWindow('delete_faq.do?ctg=반품 / 교환 FAQ','','width=1020,height=850')"
								alt="" /></td>
						</tr>
						<tr>
							<td scope="row">운영</td>
							<td><a href="CSdeliveryFAQ.do">배송 FAQ</a></td>
							<td>${delivery_manager}</td>
							<td>관리자/비회원</td>
							<td>${notice_count.delivery}</td>
							<td><img
								src="${pageContext.request.contextPath}/resources/image/manageboard.png"
								width="90" height="40"
								onClick="MM_openBrWindow('delete_faq.do?ctg=배송 FAQ','','width=1020,height=850')"
								alt="" /></td>
						</tr>
						<tr>
							<td scope="row">운영</td>
							<td><a href="cscenter_member.do">회원 FAQ</a></td>
							<td>${member_manager}</td>
							<td>관리자/비회원</td>
							<td>${notice_count.member}</td>
							<td><img
								src="${pageContext.request.contextPath}/resources/image/manageboard.png"
								width="90" height="40"
								onClick="MM_openBrWindow('delete_faq.do?ctg=회원 FAQ','','width=1020,height=850')"
								alt="" /></td>
						</tr>
						<tr>
							<td scope="row">1:1 문의</td>
							<td><a href="1to1QNA.do">1:1 문의</a></td>
							<td>${qna_manager}</td>
							<td>관리자/회원</td>
							<td>${notice_count.qna1}</td>
							<td><img
								src="${pageContext.request.contextPath}/resources/image/manageboard.png"
								width="90" height="40"
								onClick="location.href='manager_1to1QNA.do'" alt="" /></td>
						</tr>
						<tr>
							<td scope="row">상품 문의</td>
							<td><a href="itemQNA.do">상품 문의</a></td>
							<td>${itemqna_manager}</td>
							<td>관리자/회원</td>
							<td>${notice_count.qna2}</td>
							<td><img
								src="${pageContext.request.contextPath}/resources/image/manageboard.png"
								width="90" height="40"
								onClick="location.href='manager_itemQNA.do'" alt="" /></td>
						</tr>

					</tbody>
				</table>


			</form>

		</div>


	</div>
	</div>
</body>
</html>
