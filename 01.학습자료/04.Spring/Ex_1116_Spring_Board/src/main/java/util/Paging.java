package util;
/*
 		Paging 목록 구현 클래스
        	- nowPage : 현재 페이지
        	- rowTotal : 전체 데이터 행 수
        	- BLOCKLIST : 한 페이지당 게시물 수
        	- BLOCKPAGE : 한 화면에 나타낼 페이지 페이징 넘버 수
 */
public class Paging {
	public static String getPaging(String pageURL,int nowPage, int rowTotal,int blockList, int blockPage){
		
		int totalPage,		/* 	총 페이지 번호	*/
            startPage,		/* 	페이지 시작 번호	*/
            endPage;		/* 	페이지 마지막 번호	*/

		boolean isPrevPage, /* 	이전 그룹 페이지 시작 번호 여부	(true : 존재) */
				isNextPage; /*	다음 그룹 페이지 마지막 번호 여부 (true : 존재) */
		
		// 구현된 페이징 Html 태그 데이터를 저장할 변수
		StringBuffer sb; 
		isPrevPage=isNextPage=false;
		
		/*	totalPage
		 		- 총 페이지 넘버를 지정할 변수
		 		- 목록 수 / 한페이지 당 보여주고자하는 목록 수의 값으로 총 페이지 넘버를 잡은 뒤
		 		- 나머지값이 있는지 확인하여 있는 경우 페이지 번호를 추가한다.
		 		
		 		(예시 : 101/10 인 경우 한 건이 따로 보여져야하므로 페이지 번호는 10 + 1 번이 보여야한다.)
		*/
		totalPage = (int)(rowTotal/blockList);
		if(rowTotal%blockList!=0)totalPage++;  // 나머지 여부에따라서 총 페이지 넘버를 증가한다.

		// 시작과 마지막 페이지 번호 
		startPage = (int)(((nowPage-1)/blockPage)*blockPage+1);
		endPage = startPage + blockPage - 1;

		// 예외처리	
		if(nowPage > totalPage)nowPage = totalPage; 	// 현재 페이지 넘버가 총 페이지 넘버보다 높은 경우 마지막 페이지 넘버를 보여주도록 지정
		if(endPage > totalPage)endPage = totalPage;		// 마지막 페이지 넘버가 총 페이지 넘버보다 큰 경우 마지막 페이지 넘버를 보여주도록 지정

		// 그룹 페이지
		if(endPage < totalPage) isNextPage = true;	// 끝 페이지가 아니므로 다음페이지 존재 여부 true값으로 지정
		if(startPage > 1)isPrevPage = true;			// 첫 페이지가 아니므로 다음페이지 존재 여부 true값으로 지정 
		
		// StringBuffer 생성
		sb = new StringBuffer();

		// 이전 그룹 페이지 버튼 (<)
		if(isPrevPage){
			// 
			sb.append("<a href ='"+pageURL+"?page=");
			sb.append( startPage-1 ); // 이전 그룹 페이지로 이동하므로 시작 페이지 번호 -1 값으로 지정
			sb.append("'><img src='/bbs/resources/img/btn_prev.gif'></a>");
		} else {
			// 이전 그룹 페이지가 없으므로 클릭해도 이동하지 않는 이미지
			sb.append("<img src='/bbs/resources/img/btn_prev.gif'>");
		}
		
		sb.append("&nbsp;");
		
		// 페이지 목록
		for(int i=startPage; i<= endPage ;i++){
			// 시작 페이지가 총 페이지 넘버를 초과하는 경우, 스탑
			if(i>totalPage)break;
			
			// 선택된 페이지의 경우
			if(i == nowPage){
				// 선택 페이지 번호 디자인 처리
				sb.append("&nbsp;<b><font color='#ff0000'>");
				sb.append(i);
				sb.append("</font></b>");

			// 선택된 페이지가 아닌 경우
			} else {
				// 선택되지 않은 페이지 번호 디자인 처리
				sb.append("&nbsp;<a href='"+pageURL+"?page=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		}
		//
		sb.append("&nbsp;&nbsp;");

		// 다음 그룹 페이지 버튼 (>)
		if(isNextPage){
			//
			sb.append("<a href='"+pageURL+"?page=");
			sb.append(endPage + 1); // 다음 그룹 페이지로 이동하므로 시작 페이지 번호 +1 값으로 지정
			sb.append("'><img src='/bbs/resources/img/btn_next.gif'></a>"); // 다음 그룹 페이지로 이동하는 이미지
		} else {
			//
			sb.append("<img src='/bbs/resources/img/btn_next.gif'>"); // 다음 그룹 페이지로 이동하지 않는 이미지
		}
		
		// Html 페이징 태그 반환
		return sb.toString();
	}
}