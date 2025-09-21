<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<table class="post_table">
	<caption>좌측 메뉴 조회</caption>
	<tbody>
    	<c:forEach var="list" items="${leftList}"> 
			<tr>
				<td class="text_left" style="border: none;">
					<c:choose> 
						<c:when test="${list.lv eq '1'}">
							<span class="a_title bold" style="color: #214b97; font-size: 16px;">${list.menuNm}</span>
						</c:when>
						<c:otherwise>
							<c:forEach begin="0" end="1">
								&nbsp;
							</c:forEach>
								ㄴ	<a class="a_title ${menuSet eq list.menuSet ? 'list_bg' : ''}" style="font-size: 16px;" href="${list.mappingId}?menuCd=${list.menuCd}&menuSet=${list.menuSet}&pageUrl=${list.mappingId}&empIdx=${empVO.empIdx}">${list.menuNm}</a>
						</c:otherwise>
					</c:choose>
				</td>
            </tr>
       	</c:forEach>
	</tbody>
</table>
