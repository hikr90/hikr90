<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<!DOCTYPE html>
<html>
<head></head>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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
								<div class="top_area" style="width: 1120px;">
									<div class="area_title">
										<h3>부서 현황</h3>
									</div>
									
									<div class="area_content" style="margin-left: 30px;">
										<canvas id="myChart" width="900" height="300"></canvas>
										<script>
										var json = ${orgList};
										var labels = json.map(d => d.orgNm);
										var values = json.map(d => d.orgCnt);
										//
										var ctx = document.getElementById('myChart');
											new Chart(ctx, {
											  type: 'bar',
											  data: {
											    labels: labels,
											    datasets: [{
											      label: '부서별 인원 수',
											      data: values,
											      backgroundColor: ['#b7c2c9']
											    }]
											  },
											  options: {
												    plugins: {
												      legend: { display: true },   // 범례
												      tooltip: { enabled: true }   // 툴팁
												    },
												    scales: {
												        y: {
												          ticks: {
												            maxTicksLimit: 5,		// 눈금 수
												            stepSize: 10   			// 눈금 간격
												          }
												        }
												      }
											  }
											});
										</script>
									</div>
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
							    	<div class="area_title">
										<h3>인사 요약</h3>
									</div>
									
									<div class="area_content">
										<span style="font-weight: bold;">&#8251; ${empList[0].year} 기준</span>
									
									<table class="post_table" style="margin-top: 10px;">
										<caption>인사 요약</caption>
										<colgroup>
											<col class="auto">
											<col class="auto">
											<col class="auto">
										</colgroup>
										<thead>
											<tr style="border-bottom: none;">
												<th scope="col">신규</th>
												<th scope="col">퇴사</th>
												<th scope="col">재직</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="align_center" style="color: #0000ff">${empList[0].newCnt}</td>
												<td class="align_center" style="color: #ff0000;">${empList[0].leavCnt}</td>
												<td class="align_center">${empList[0].empCnt}</td>
											</tr>
										</tbody>
									</table>
									</div>
								</div>
								
								<div class="bottom_area">
						    		<div class="area_title">
										<h3>프로젝트 관리</h3>
									</div>
									
									<div class="area_content">
										<a href="javascript:formSubmit('intrProjInqy1010.do')" class="btn_more">전체보기</a>
										
										<ul>
											<c:forEach var="list" items="${projList}" begin="0" end="2">
												<li class="main_li">
													<a class="main_a">${list.projTitle}</a>
													<span class="main_ie">${list.ownerNm}</span>
												</li>
											</c:forEach>
											
											<c:if test="${empty projList}">
												<li class="main_li">
													등록된 글이 없습니다.
												</li>												
											</c:if>
										</ul>
									</div>
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
    