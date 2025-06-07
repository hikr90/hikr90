<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<!-- 
	view : intr_popup_inqy_1050
	title : 결재의견 관리 팝업
-->
<div class="pop_area" style="height: 100%:">
	<article class="sub_article" style="height: 82%;">
		<div class="content">
			<div id="sub_content">					
				<div class="form_area">
                	<div class="find_info_wrap">
                    	<div class="post_wrap">
                    		<div class="srch_wrap">
								<div class="srch_area">
									<div class="right_srch_area">
										<label class="srch_label">결재 의견 입력</label>
									</div>
								</div>
							</div>
                    	
                        	<div id="opinCon"></div>
                               
							<div class="btn_center">
                            	<input type="button"class="_btn btn_navy" value="확인" onclick="aprvProc('opin');">
								<input type="button"class="_btn btn_gray" value="취소" onclick="popClose('opin');">
 							</div>
						</div><!-- End post_wrap -->
					</div> 
				</div><!-- End form_area -->
			</div><!-- End sub_content -->
		</div><!-- End content -->
	</article>
</div>
