<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<!DOCTYPE html>
<html>
<head></head>
<body id="main">
<form id="form" name="form" method="POST" onsubmit="return false;">
	<!-- 메뉴 -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>

	<div class="top_wrap">
		<div class="top_area">
			<article class="main_article">
				<div class="content">
					<div class="top_box">
						<div class="wrap">
							<div class="top_wrap">
								<div class="top_area">
									<h3>부서 현황</h3><br>
									<a href="javascript:formSubmit('intrEmpInqy1010.do')" class="btn_more">전체보기</a>
									<c:if test="${not empty deptEmpList}">
										<!-- 부서 사원 수 목록 -->
										<div class="scroll_wrap" style="width: 700px; float: right;">
										<table class="post_table">
											<caption>부서 사원 수 목록</caption>
											<colgroup>
												<col class="auto">
												<col class="w10per">
												<col class="w25per">
											</colgroup>
											<thead>
												<tr>
													<th scope="col">부서</th>
													<th scope="col">인원 수</th>
													<th scope="col">등록일자</th>
												</tr>
											</thead>
											<tbody>
		                                    	<c:forEach var="list" items="${deptEmpList}" varStatus="status"> 
												<tr>
													<td class="text_left">${list.deptNm}</td>
													<td class="text_center">${list.deptCnt}</td>
													<td class="text_center">
														<span class="date">
															<fmt:parseDate value="${list.regDt}" var="parseDt" pattern="yyyyMMdd"/>
															<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
															${formatDt} 
														</span>	
													</td>
		                                        </tr>
		                                        </c:forEach>
											</tbody>
										</table>
										</div>
									</c:if>
								</div>
							</div>
						</div><!-- End wrap -->
					</div><!-- End widget_box -->
				</div><!-- End content -->
			</article>
		</div>
	</div>

	<div class="bottom_wrap">
		<div class="bottom_area">
			<article class="main_article">
				<div class="content">
					<div class="bottom_box">
						<div class="wrap">
							<div class="bottom_wrap">
								<div class="bottom_area">
							    	<h3>템플릿 관리</h3><br>
							    	<a href="javascript:formSubmit('tempList.do')" class="btn_more">전체보기</a>
									<ul>
									<c:forEach var="list" items="${tempList}" begin="0" end="9">
										<li><a href="javascript:#"><span class="date">${list.tempNm}</span></a></li>
									</c:forEach>
									<c:if test="${empty tempList}">
										등록된 템플릿이 없습니다.
									</c:if>
									</ul>
								</div>
								
								<div class="bottom_area">
						    		<h3>권한 부여</h3><br>
						    		<a href="javascript:formSubmit('intrAuthInqy3010.do')" class="btn_more">전체보기</a>
									<ul>
									<c:forEach var="list" items="${authEmpList}" begin="0" end="9">
										<li><a href="javascript:#">${list.authNm}<span class="date">(${list.deptNm}) ${list.empNm}</span></a></li>
									</c:forEach>
									<c:if test="${empty authEmpList}">
										권한을 소유한 사용자가 없습니다.
									</c:if>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div><!-- End content -->
			</article>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
</form>	
</body>
</html>
    