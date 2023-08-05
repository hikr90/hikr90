<!--명칭 : intr_popup_inqy_1030
	작성자 : 김태현
	작성일자 : 2023.07.02
	내용 : 팝업 관리 (결재선)-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<div class="_popList">
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner">					
					<div class="_contentArea _formArea" style="margin-bottom: 0px;">
                        <div class="_find_info_Wrap">
                            <div class="postWrap" style="height: 350px; width: 1050px;">
								<div class="srchWrap">
									<div class="search_nav">
										<div class="srchArea">
											<label class="srcLabel">결재선 관리</label>
										</div>
									</div>
								</div>
                                
                                <div id="postCon">

                                </div>
                                
                                <div class="btn_center" style="text-align: center;">
                               		<input type="button" class="_btn _grey" value="확인" onclick="popConfirm(this.form);">
                                    <input type="button" class="_btn _line" value="닫기" onclick="popClose('popupArea');">
                                </div>
                            </div><!-- End postWrap -->
                          </div> 
					</div><!-- End _contentArea _formArea -->
				</div><!-- End _inner -->
			</div><!-- End _content -->
		</div><!-- End _wrap -->
	</article>
</div>
