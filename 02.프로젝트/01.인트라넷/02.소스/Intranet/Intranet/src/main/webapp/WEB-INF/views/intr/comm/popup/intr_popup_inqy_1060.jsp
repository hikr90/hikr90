<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 
	view : intr_popup_inqy_1060
	title : 물품 등록 관리 팝업
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
										<label class="srch_label">물품 관리</label>
									</div>
								</div>
							</div>
	                        
	                     	<!-- 물품 등록 목록 -->
	                     	<div id="itemCon" class="post_con disp_flex pt20" style="height: 425px;"></div>
	                        
							<div class="btn_right" style="margin-top: 40px;">
								<span style="float: left;">
									<button type="button" class="btn_navy_thin procBtn" onclick="setItem('add');">추가</button>
									<button type="button" class="btn_gray_thin procBtn" onclick="initItem(this.form);">초기화</button>
								</span>
							
	                      		<button type="button" class="btn_blue_thin procBtn" onclick="itemProc('item');">저장</button>
	                      		<button type="button" class="btn_gray_thin viewBtn" onclick="popClose('item');">닫기</button>
	                 		</div>
	                 	</div><!-- End post_wrap -->
	               	</div> 
				</div><!-- End form_area -->
			</div><!-- End sub_content -->
		</div><!-- End content -->
	</article>
</div>

