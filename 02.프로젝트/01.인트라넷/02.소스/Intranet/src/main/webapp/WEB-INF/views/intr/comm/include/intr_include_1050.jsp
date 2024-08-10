<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<table class="post_table">
	<caption>좌측 메뉴 조회</caption>
	<tbody>
    	<c:forEach var="list" items="${menuList}"> 
			<tr>
				<td class="text_left">
					<c:choose> 
						<c:when test="${list.lv eq '1'}">
							<a class="a_title bold ${menuSet eq list.menuCd ? 'list_bg' : ''}" style="color: #214b97" href="${list.mappingId}?menuSet=${list.menuCd}&pageUrl=${list.mappingId}">${list.menuNm}</a>
						</c:when>
						<c:otherwise>
							&nbsp;&nbsp;ㄴ
							<a class="a_title ${menuSet eq list.menuCd ? 'list_bg bold' : ''}" href="${list.mappingId}?menuSet=${list.menuCd}&pageUrl=${list.mappingId}">${list.menuNm}</a>
						</c:otherwise>
					</c:choose>
				</td>
            </tr>
       	</c:forEach>
	</tbody>
</table>
