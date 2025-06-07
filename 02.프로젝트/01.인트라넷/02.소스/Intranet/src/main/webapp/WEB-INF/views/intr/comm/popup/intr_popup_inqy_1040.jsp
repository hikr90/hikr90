<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<!-- 
	view : intr_popup_inqy_1040
	title : 결재선 관리 팝업
-->
<div class="pop_area" style="height: 100%;">
	<article class="sub_article" style="height: 85%;">
		<div class="content">
			<div id="sub_content">					
				<div class="form_area">
					<div class="find_aprv_wrap">
	                	<div class="post_wrap">
							<div class="srch_wrap">
								<div class="srch_area">
									<div class="right_srch_area">
										<label class="srch_label">결재선 관리</label>
									</div>
								</div>
							</div>
	                        
	                     	<!-- 결재선 목록 -->
	                     	<div id="lineCon" class="post_con disp_flex pt20" style="height: 425px;"></div>
	                        
							<div class="btn_right" style="margin-top: 40px;">
	                      		<button type="button" class="btn_blue_thin" onclick="#">저장</button>
	                      		<button type="button" class="btn_gray_thin" onclick="popClose('line');">닫기</button>
	                 		</div>
	                 	</div><!-- End post_wrap -->
	               	</div> 
				</div><!-- End form_area -->
			</div><!-- End sub_content -->
		</div><!-- End content -->
	</article>
</div>
