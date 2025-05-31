<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<script type="text/javascript">
	// 팝업 내 선택
	function popConfirm(popType){
		// 선택 여부 검증
		if($("input[name=popCd]:checked").length==0){
			alert("<spring:message code="RADIO.NONE"/>");
			return;
		}
		// 팝업 선택 후 종료
		$("#"+popType).val($("input[name=popCd]:checked").attr("popCd"));
		$("#"+popType+"Nm").val($("input[name=popCd]:checked").attr("popNm"));
		//
		popClose('popupArea');	
	}
</script>

<div id="popArea" class="pop_area" style="height: 100%;">
	<article class="sub_article" style="height: 82%;">
		<div class="content">
			<div id="sub_content">					
				<div class="form_area">
					<div class="find_owner_wrap">
						<div class="post_wrap">
							<div class="srch_wrap">
								<div class="srch_area">
									<div class="right_srch_area">
										<label class="srch_label">담당자 조회</label>
									</div>
								</div>
							</div>
	                        
	                        <!-- 기안문 양식 목록 -->
	                        <div id="postCon" class="post_con"></div>
							
							<div class="btn_center">
								<button type="button" class="btn_navy_thin" onclick="popConfirm('owner');">확인</button>
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