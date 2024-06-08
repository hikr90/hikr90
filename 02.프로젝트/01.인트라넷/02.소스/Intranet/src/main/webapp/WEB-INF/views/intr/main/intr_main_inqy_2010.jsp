<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<!DOCTYPE html>
<html>
<head></head>
<body id="main">
<form id="form" name="form" method="POST" onsubmit="return false;">
	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>

	<!-- MAIN TOP -->
	<article id="_mainArticle">
		<div id="_content" style="margin-top: 50px;">
			<div class="widgetBox">
				<div class="_wrap">
					<div class="mainTopWrap">
						<div class="mainTopArea">
							<h3>부서 현황</h3>
							<a href="javascript:formSubmit('intrEmpInqy1010.do')" class="moreBtn">전체보기</a>
							<c:if test="${not empty deptEmpList}">
								<!-- 부서 사원 수 목록 -->
								<div class="scrollTableWrap">
								<table class="postTable" style="width: 80%; float: right;">
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
											<td>${list.deptNm}</td>
											<td style="text-align: center;">${list.deptCnt}</td>
											<td style="text-align: center;">
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
				</div><!-- End _wrap -->
			</div><!-- End widgetBox -->
		</div><!-- End _content -->
	</article>
   
   	<!-- MAIN BOTTOM -->
	<div class="mainBotWrap">
		<div class="mainBotArea">
	    	<article class="_subArticle" style="margin: 0 auto auto 52%;">
		    	<h2>템플릿 관리</h2>
			    	<a href="javascript:formSubmit('intrTempInqy1010.do')" class="moreBtn">전체보기</a>
					<ul style="line-height: 25px;">
					<c:forEach var="list" items="${tempList}" begin="0" end="9">
						<li><a href="javascript:#"><span class="date">${list.templateNm}</span></a></li>
					</c:forEach>
					<c:if test="${empty tempList}">
						등록된 템플릿이 없습니다.
					</c:if>
					</ul>
		    </article>
	    </div>
        
        <div class="mainBotArea" style="width: 25%;">
			<article class="_subArticle">
	    		<h2>권한 부여</h2>
		    		<a href="javascript:formSubmit('intrAuthInqy3010.do')" class="moreBtn">전체보기</a>
					<ul style="line-height: 25px;">
					<c:forEach var="list" items="${authEmpList}" begin="0" end="9">
						<li><a href="javascript:#">${list.authNm}<span class="date">(${list.deptNm}) ${list.empNm}</span></a></li>
					</c:forEach>
					<c:if test="${empty authEmpList}">
						권한을 소유한 사용자가 없습니다.
					</c:if>
					</ul>
    		</article>
        </div>
	</div>

	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
</form>	
</body>
</html>
    