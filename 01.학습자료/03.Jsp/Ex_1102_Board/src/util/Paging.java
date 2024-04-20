package util;
/*
  		PAGE의 기능을 처리하는 클래스
  			(COMMON이 페이지 게시물의 수나 메뉴 수를 정하는 클래스라면 여기서는 페이지의 기능이나 메뉴 이미지 선택, 디자인등의 변경이 가능하다.)
			
			핵심 변수
			  nowPage 	: 현재 페이지
			  rowTotal 	: 전체 데이터 개수
			  blockList : 한 페이지당의 게시물 수
			  blockPage : 한 화면에 나타낼 페이지 메뉴 수
 */
public class Paging {
	public static String getPaging(String pageURL,int nowPage, int rowTotal,int blockList, int blockPage){
		
		int totalPage,	/*전체페이지수*/
            startPage,	/*시작페이지번호*/
            endPage;	/*마지막페이지번호*/

		// isPrevPage는 < 1 2 3 > 에서 <를 선택했는지 여부를, isNextPage는 >를 선택했는지의 여부를 BOOLEAN타입으로 리턴
		boolean  isPrevPage,isNextPage;
		StringBuffer sb; //모든 상황을 판단하여 HTML코드를 저장할 곳
		
		isPrevPage=isNextPage=false;
		// 입력된 전체 자원을 통해 전체 페이지 수를 구한다..
		totalPage = (int)(rowTotal/blockList);
		if(rowTotal%blockList!=0)totalPage++;
		
		// 만약 잘못된 연산과 움직임으로 인하여 현재 페이지 수가 전체 페이지 수를
		// 넘을 경우 강제로 현재페이지 값을 전체 페이지 값으로 변경
		if(nowPage > totalPage)nowPage = totalPage;
		
		//시작 페이지와 마지막 페이지를 구한다.
		startPage = (int)(((nowPage-1)/blockPage)*blockPage+1);
		endPage = startPage + blockPage - 1; 
		
		// 마지막 페이지 수가 전체페이지수보다 크면 마지막페이지 값을 변경
		if(endPage > totalPage)endPage = totalPage;
		
		// 마지막 페이지가 전체 페이지보다 작을 경우 다음 페이징이 적용할 수 있도록
		// BOOLEAN형 변수의 값을 설정
		if(endPage < totalPage) isNextPage = true;
		// 시작 페이지의 값이 1보다 작으면 이전 페이징 적용할 수 있도록 값설정
		if(startPage > 1)isPrevPage = true;
		
		// HTML코드를 저장할 StringBuffer생성 => 코드생성
		sb = new StringBuffer();
//-----그룹페이지처리 이전 --------------------------------------------------------------------------------------------		
		if(isPrevPage){
			sb.append("<a href ='"+pageURL+"?page=");
			// sb.append(nowPage - blockPage);
			sb.append( startPage-1 );
			// 클릭이 되는 화살표 (img의 src는 ''만 사용가능하다.)
			sb.append("'><img src='../img/btn_prev.gif'></a>");
		}
		else
			// 맨 앞 페이지로 와서 더이상 클릭이 안되는 화살표
			sb.append("<img src='../img/btn_prev.gif'>");
		
//------페이지 목록 출력 -------------------------------------------------------------------------------------------------
		sb.append("&nbsp;");
		for(int i=startPage; i<= endPage ;i++){
			if(i>totalPage)break;
			if(i == nowPage){ // 현재 있는 페이지 (선택된 페이지)
				sb.append("&nbsp;<b><font color='#ff0000'>");
				sb.append(i); // 페이지 숫자
				sb.append("</font></b>");
			}
			else{// 현재 페이지가 아니면 (선택안된 페이지)
				sb.append("&nbsp;<a href='"+pageURL+"?page=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		}// end for
		
		sb.append("&nbsp;&nbsp;");
		
//-----그룹페이지처리 다음 ----------------------------------------------------------------------------------------------
		if(isNextPage){
			sb.append("<a href='"+pageURL+"?page=");
			
			sb.append(endPage + 1);
			/*if(nowPage+blockPage > totalPage)nowPage = totalPage;
			else
				nowPage = nowPage+blockPage;
			sb.append(nowPage);*/
			sb.append("'><img src='../img/btn_next.gif'></a>"); // 클릭이 되는 화살표
		}
		else
			sb.append("<img src='../img/btn_next.gif'>"); // 마지막 페이지에 와서 더이상 클릭이 안되는 화살표
//---------------------------------------------------------------------------------------------------------------------	    

		return sb.toString();
	}
}