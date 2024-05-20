package util;

public class Paging {
	public static String getPaging(String pageURL,int nowPage, int rowTotal,int blockList, int blockPage){
		/*	Paging 클래스 
		 *		- 페이지 기능을 처리하는 클래스
		 *		- Common 클래스가 게시물의 수, 페이지 넘버 수를 조정하는 클래스라면 해당 클래스는 기능이나 메뉴, 디자인 등의 변경이 가능하다.
		 *		
		 *		관련 변수
		 *	 		(1) nowPage : 현재 페이지
		 *			(2) rowTotal : 전체 데이터 수
		 *			(3) blockList : 한 화면 내 게시물 수
		 *			(4) blockPage : 한 화면 내 출력할 페이지 수
		 *			(5) isPrevPage : < 가 있는지에대한 여부
		 *			(6) isNextPage : > 가 있는지에대한 여부
		 */
		int totalPage,	/* 전체 페이지 수 */
            startPage,	/* 시작 페이지 번호 */
            endPage;	/* 마지막 페이지 번호 */

		boolean  isPrevPage,isNextPage;
		StringBuffer sb; // 페이지 구성을 Html로 반환
		isPrevPage=isNextPage=false;

		// 전체 페이지 계산
		totalPage = (int)(rowTotal/blockList);
		if(rowTotal%blockList!=0)totalPage++;
		
		// 만약 잘못된 연산으로 현재 페이지 수가 전체 페이지 수를 넘어가면 강제로 현재 페이지 값을 전체 페이지 값으로 변경
		if(nowPage > totalPage)nowPage = totalPage;
		
		// 시작 페이지와 마지막 페이지 계산
		startPage = (int)(((nowPage-1)/blockPage)*blockPage+1);
		endPage = startPage + blockPage - 1; 
		
		// 마지막 페이지 수가 전체 페이지수보다 크면 마지막페이지 값을 변경
		if(endPage > totalPage)endPage = totalPage;
		
		// 마지막 페이지가 전체 페이지보다 작을 경우 다음 페이징이 적용할 수 있도록 다음 페이지 여부를 참으로 변경
		if(endPage < totalPage) isNextPage = true;

		// 시작 페이지의 값이 1보다 크면 이전 페이징 적용할 수 있도록 이전 페이지 여부를 참으로 변경
		if(startPage > 1)isPrevPage = true;
		
		// Html 출력을 위한 StringBuffer 선언
		sb = new StringBuffer();

		/*	그룹페이지 이전 */
		if(isPrevPage){
			sb.append("<a href ='"+pageURL+"?page=");
			sb.append( startPage-1 );
			sb.append("'><img src='../img/btn_prev.gif'></a>");	// 클릭이 가능한 < 화살표 이미지
		}
		else
			// 첫 페이지이므로 더이상 클릭이 안되는 < 화살표 이미지
			sb.append("<img src='../img/btn_prev.gif'>");

		/* 페이지 목록 출력 */
		sb.append("&nbsp;");
		for(int i=startPage; i<= endPage ;i++){
			if(i>totalPage)break;
			// 선택된 페이지
			if(i == nowPage){
				sb.append("&nbsp;<b><font color='#ff0000'>");
				sb.append(i); // 페이지 숫자
				sb.append("</font></b>");
			}
			// 선택되지 않은 페이지
			else{	
				sb.append("&nbsp;<a href='"+pageURL+"?page=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		}
		//
		sb.append("&nbsp;&nbsp;");

		/* 그룹페이지 다음 */
		if(isNextPage){
			sb.append("<a href='"+pageURL+"?page=");
			sb.append(endPage + 1);
			sb.append("'><img src='../img/btn_next.gif'></a>"); // 클릭이 가능한 > 화살표 이미지
		}
		else
			// 마지막 페이지이므로 더이상 클릭이 안되는 > 화살표 이미지
			sb.append("<img src='../img/btn_next.gif'>");
		
		// Html 형식의 메뉴 값을 String값으로 변환하여 반환
		return sb.toString();
	}
}