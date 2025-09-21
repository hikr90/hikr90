package Common;

//게시판 페이징 처리를 위한 클래스
public class Common {
		
	// 내부 클래스 생성
	// 게시판
	public static class Board{
		// 경로
		public static final String VIEW_PATH = "/WEB-INF/views/board/";
		// 한 페이지에 보여줄 목록 수
		public final static int BLOCKLIST = 5;
		// 한 페이지에 보여지는 페이지 메뉴 수
		public final static int BLOCKPAGE = 3;
	}
	
	// 공지사항
	public static class Notice{
		// 
		public static final String VIEW_PATH = "/WEB-INF/views/notice/";
		public final static int BLOCKLIST = 10;
		public final static int BLOCKPAGE = 3;
	}
}
