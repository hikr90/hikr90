<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 
	view : intr_popup_inqy_1070
	title : 정산내역 등록 관리 팝업
-->
<div class="pop_area" style="height: 100%;">
	<article class="sub_article" style="height: 85%;">
		<div class="content">
			<div id="sub_content">					
				<div class="form_area">
					<div class="pop_wrap" style="height: 650px;">
	                	<div class="post_wrap">
							<div class="srch_wrap">
								<div class="srch_area">
									<div class="right_srch_area">
										<label class="srch_label">정산내역 관리</label>
									</div>
								</div>
							</div>
	                        
	                     	<!-- 정산내역 등록 목록 -->
	                     	<div id="corpCon" class="post_con disp_flex pt20" style="height: 425px;"></div>
	                        
							<div class="btn_right" style="margin-top: 40px;">
								<span style="float: left;">
									<button type="button" class="btn_navy_thin procBtn" onclick="setCorp('add');">추가</button>
									<button type="button" class="btn_gray_thin procBtn" onclick="initCorp(this.form);">초기화</button>
								</span>
							
	                      		<button type="button" class="btn_blue_thin procBtn" onclick="corpProc('corp');">저장</button>
	                      		<button type="button" class="btn_gray_thin viewBtn" onclick="popClose('corp');">닫기</button>
	                 		</div>
	                 	</div><!-- End post_wrap -->
	               	</div> 
				</div><!-- End form_area -->
			</div><!-- End sub_content -->
		</div><!-- End content -->
	</article>
</div>

