<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- 
	view : intr_popup_inqy_1030
	title : 프로젝트 관리 팝업
-->
<div id="popArea" class="pop_area" style="height: 100%;">
	<article class="sub_article" style="height: 70%;">
		<div class="content">
			<div id="sub_content">					
				<div class="form_area">
					<div class="find_owner_wrap">
						<div class="post_wrap">
							<div class="srch_wrap">
								<div class="srch_area">
									<div class="right_srch_area">
										<label class="srch_label">프로젝트 조회</label>
									</div>
								</div>
							</div>
	                        
	                        <!-- 프로젝트 목록 -->
	                        <div id="projCon" class="post_con" style="height: 200px; border: 1px solid #e8edf2;"></div>
							
							<div class="btn_center">
								<button type="button" class="btn_navy_thin" onclick="popConfirm('proj');">확인</button>
								<button type="button" class="btn_gray_thin" onclick="popClose('proj');">취소</button>
	   						</div>
						</div>
					</div><!-- End post_wrap -->
				</div><!-- End form_area -->
			</div><!-- End sub_content -->
		</div><!-- End content -->
	</article>
</div>
</html>