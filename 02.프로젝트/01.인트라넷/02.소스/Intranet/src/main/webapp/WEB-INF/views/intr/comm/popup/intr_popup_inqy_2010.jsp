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
                	<div class="find_info_wrap">
                    	<div class="post_wrap">
                        	<div id="post_con"></div>
                               
							<div class="btn_center">
                            	<input type="button"class="_btn _grey" value="확인" onclick="aprvProc();">
								<input type="button"class="_btn btn_gray" value="취소" onclick="popClose('popupArea1');">
 							</div>
						</div><!-- End post_wrap -->
					</div> 
				</div><!-- End form_area -->
			</div><!-- End sub_content -->
		</div><!-- End content -->
	</article>
</div>
