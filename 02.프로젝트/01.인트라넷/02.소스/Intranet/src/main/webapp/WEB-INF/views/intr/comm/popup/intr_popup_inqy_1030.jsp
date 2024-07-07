<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<div class="pop_area">
	<article class="sub_article">
		<div class="content">
			<div id="sub_content">					
				<div class="form_area">
					<div class="find_aprv_wrap">
	                	<h3>결재선 조회</h3><br>
	                	<div class="post_wrap">
							<div class="srch_wrap">
								<div class="srch_area">
									<div class="right_srch_area">
										<label class="srch_label">결재선</label>
									</div>
								</div>
							</div>
	                        
	                     	<!-- 결재선 목록 -->
	                     	<div id="postCon" class="post_con disp_flex pt20"></div>
	                        
							<div class="btn_center">
	                     		<button type="button" class="btn_navy_thin" onclick="popConfirm(this.form);">확인</button>
	                      		<button type="button" class="btn_gray_thin" onclick="popClose('popupArea');">닫기</button>
	                 		</div>
	                 	</div><!-- End post_wrap -->
	               	</div> 
				</div><!-- End form_area -->
			</div><!-- End sub_content -->
		</div><!-- End content -->
	</article>
</div>
