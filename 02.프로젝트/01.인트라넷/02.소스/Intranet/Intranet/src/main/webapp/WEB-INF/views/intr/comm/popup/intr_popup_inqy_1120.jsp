<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 
	view : intr_popup_inqy_1120
	title : 업무 캘린더 관리 팝업
-->
<div class="pop_area" style="height: 100%;">
	<article class="sub_article" style="height: 80%; border: none;">
		<div class="content">
			<div id="sub_content">					
				<div class="form_area">
					<div class="pop_wrap">
	                	<div class="post_wrap">
							<div class="srch_wrap">
								<div class="srch_area">
									<div class="right_srch_area">
										<label class="srch_label">업무 캘린더 관리</label>
									</div>
								</div>
							</div>
	                        
	                     	<!-- 업무 캘린더 상세 -->
	                        
	                     	<div id="tldrCon" class="post_con disp_flex" style="height: 310px;"></div>
							<div class="btn_right">
   		                  		<button type="button" class="btn_blue_thin regBtn" onclick="regProc();">등록</button>
   		                  		<button type="button" class="btn_blue_thin mdBtn" onclick="modProc();">수정</button>
   		                  		<button type="button" class="btn_navy_thin mdBtn" onclick="delProc();">삭제</button>
	                      		<button type="button" class="btn_gray_thin" onclick="popClose('tldr');">닫기</button>
	                 		</div>
	                 	</div><!-- End post_wrap -->
	               	</div> 
				</div><!-- End form_area -->
			</div><!-- End sub_content -->
		</div><!-- End content -->
	</article>
</div>

