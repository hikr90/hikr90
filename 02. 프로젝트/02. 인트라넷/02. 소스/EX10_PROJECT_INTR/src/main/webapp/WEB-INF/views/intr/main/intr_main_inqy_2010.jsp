<!--명칭 : intr_main_inqy_1020
	작성자 : 김태현
	작성일자 : 2022.12.01
	내용 : 사용자 메인 화면-->
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
							<h3>입사 현황</h3>
							
						</div>
					</div>
				</div><!-- End _wrap -->
			</div><!-- End widgetBox -->
		</div><!-- End _content -->
	</article>
   
   	<!-- MAIN BOTTOM -->
    <div class="mainBotWrap">
    	<div class="mainBotArea">
    		
        </div>
    </div>

	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
</form>	
</body>
</html>
    