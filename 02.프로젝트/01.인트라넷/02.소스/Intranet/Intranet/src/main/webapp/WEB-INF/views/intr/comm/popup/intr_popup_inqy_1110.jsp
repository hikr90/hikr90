<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 
	view : intr_popup_inqy_1110
	title : RESTful API 관리
-->
<div class="pop_area" style="height: 100%;">
	<article class="sub_article" style="height: 85%;">
		<div class="content">
			<div id="sub_content">					
				<div class="form_area">
					<div class="pop_wrap">
	                	<div class="post_wrap">
							<div class="srch_wrap">
								<div class="srch_area">
									<div class="right_srch_area">
										<label class="srch_label">RESTful API 조회</label>
									</div>
								</div>
							</div>
	                        
	                     	<!-- RESTful API 상세 -->
	                     	<div id="qryCon" class="post_con disp_flex"></div>
	                        
							<div class="btn_right">
	                      		<button type="button" class="btn_gray_thin" onclick="popClose('qry');">닫기</button>
	                 		</div>
	                 	</div><!-- End post_wrap -->
	               	</div> 
				</div><!-- End form_area -->
			</div><!-- End sub_content -->
		</div><!-- End content -->
	</article>
</div>

