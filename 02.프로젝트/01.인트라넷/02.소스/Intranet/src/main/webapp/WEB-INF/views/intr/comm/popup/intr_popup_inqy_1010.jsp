<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<script type="text/javascript">
	// 템플릿 선택
	function popConfirm(){
		// 선택 여부 검증
		if($("input[name=tempCd]:checked").length==0){
			alert("<spring:message code="RADIO.NONE"/>");
			return;
		}
		// 팝업 종료 후,
		popClose('popupArea');	
		formSubmit("intrAprvInqy1020.do");
	}
</script>

<div id="popArea" class="pop_area">
	<article class="sub_article">
		<div class="content">
			<div id="sub_content">					
				<div class="form_area">
					<div class="find_temp_wrap">
						<h3>템플릿 조회</h3><br>
						<div class="post_wrap">
							<div class="srch_wrap">
								<div class="srch_area">
									<div class="right_srch_area">
										<label class="srch_label">템플릿</label>
									</div>
								</div>
							</div>
	                        
	                        <!-- 템플릿 목록 -->
	                        <div id="postCon" class="post_con"></div>
							
							<div class="btn_center">
								<button type="button" class="btn_navy_thin" onclick="popConfirm();">확인</button>
								<button type="button" class="btn_gray_thin" onclick="popClose('popupArea');">취소</button>
	   						</div>
						</div>
					</div><!-- End post_wrap -->
				</div><!-- End form_area -->
			</div><!-- End sub_content -->
		</div><!-- End content -->
	</article>
</div>
</html>