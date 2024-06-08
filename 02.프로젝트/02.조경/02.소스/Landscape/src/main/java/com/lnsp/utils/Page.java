package com.lnsp.utils;

public class Page {
	//--------------------------------------------------------------------------------------------
	// Block Page 조회
	//--------------------------------------------------------------------------------------------
	public final static int BLOCKLIST = 10; 	// 페이지 목록 수
	public final static int BLOCKPAGE = 5; 		// 페이지 페이지 수 
	
	// 페이지 관련 클래스
	public static class paging{
		// 페이지 조회
		public static String getPaging(String pageURL, int nowPage, int rowTotal, int blockList, int blockPage) {
			// 
			int totalPage, startPage, endPage; 	// 전체 페이지수, 시작페이지 번호, 마지막 페이지 번호
			boolean isPrevPage, isNextPage;		// 이전 페이지 존재 여부, 다음 페이지 존재 여부
			StringBuffer sb;
			//
			isPrevPage = isNextPage = false;
			totalPage = (int) (rowTotal / blockList);	// 전체 페이지 수
			if (rowTotal % blockList != 0) {totalPage++;}

			// 만약 잘못된 연산으로 현재 페이지 수가 전체 페이지 수를 넘을 경우 강제로 현재 페이지 값을 전체 페이지 값으로 변경
			if (nowPage > totalPage) {nowPage = totalPage;}

			// 시작 페이지와 마지막 페이지 조회
			startPage = (int) (((nowPage - 1) / blockPage) * blockPage + 1);
			endPage = startPage + blockPage - 1; //

			// 만약 잘못된 연산으로 마지막 페이지가 전체 페이지 수를 넘을 경우 강제로 마지막 페이지 값을 전체 페이지 값으로 변경
			if (endPage > totalPage) {endPage = totalPage;}

			// 마지막 페이지가 전체 페이지보다 작을 경우 다음 페이지 여부의 값을 참으로 변경
			if (endPage < totalPage) {isNextPage = true;}
			
			// 시작 페이지의 값이 1보다 작은 경우 이전 페이지 여부의 값을 참으로 변경
			if (startPage > 1) {isPrevPage = true;}

			// StringBuffer
			sb = new StringBuffer();

			//--------------------------------------------------------------------------------------------
			// 이전 페이지
			//--------------------------------------------------------------------------------------------
			if (isPrevPage) {
				sb.append("<a href ='" + pageURL + "?page=");
				sb.append(startPage - 1);
				sb.append("'>◀</a>");
			} else {
				sb.append("◀");
			}
			//
			sb.append("&nbsp;");

			//--------------------------------------------------------------------------------------------
			// 페이지 목록
			//--------------------------------------------------------------------------------------------
			for (int i = startPage; i <= endPage; i++) {
				if (i > totalPage) {break;}
				//
				if (i == nowPage) { // 현재 클릭한 페이지인 경우
					sb.append("&nbsp;<b><font color='#ff0000'>");
					sb.append(i);
					sb.append("</font></b>");
				} else { // 현재 클릭한 페이지가 아닌 경우
					sb.append("&nbsp;<a href='" + pageURL + "?page=");
					sb.append(i);
					sb.append("'>");
					sb.append(i);
					sb.append("</a>");
				}
			}
			//
			sb.append("&nbsp;&nbsp;");

			//--------------------------------------------------------------------------------------------
			// 다음 페이지
			//--------------------------------------------------------------------------------------------
			if (isNextPage) {
				sb.append("<a href='" + pageURL + "?page=");
				sb.append(endPage + 1);
				sb.append("'>▶</a>");
			} else {
				sb.append("▶");
			}
			
			// 결과 반환
			return sb.toString();
		}
	}
}
