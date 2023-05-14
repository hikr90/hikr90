<!--명칭 : intr_popup_inqy_1010
	작성자 : 김태현
	작성일자 : 2022.12.01
	내용 : 팝업 관리 (목록 조회)-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<div id="popArea" class="_popList">
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner">					
					<div class="_contentArea _formArea">
                        <div class="_find_info_Wrap">
                            <div class="postWrap" style="height: 350px;">
								<div class="tagWrap">
									<h2>팝업 관리</h2>
								</div>
							
								<div class="srchWrap">
									<div class="search_nav">
										<div class="srchArea">
											<label class="srcLabel">목록 조회</label>
										</div>
									</div>
								</div>
                                
                                <div id="postCon" style="min-height: 68%;">
                                
                                </div>
                                
                                <div class="btn_center">
                                	<input type="button" class="_btn _grey" value="확인" onclick="popConfirm();">
                                    <input type="button" class="_btn _line" value="취소" onclick="popClose('popArea');">
                                </div>
                            </div><!-- End postWrap -->
                          </div> 
					
					
					
					</div><!-- End _contentArea _formArea -->
				</div><!-- End _inner -->
			</div><!-- End _content -->
		</div><!-- End _wrap -->
	</article>
</div>
</html>