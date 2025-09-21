package Common;

public class Common {
	// 게시판 페이징 처리를 위한 클래스
	// 	- 내부 클래스를 사용하여 페이지를 개별적으로 게시글 수와 페이지 메뉴수를 조절할 수 있다.
	public static class Board{
		// - 한 페이지에 보여줄 게시글 수
		public final static int BLOCKLIST = 5;
		
		// - 한 화면에 보여지는 페이지 메뉴 수
		// - < 1 2 3 > 의 방식 
		public final static int BLOCKPAGE = 3;
	}
	
	// 공지사항 
	public static class Notice{
		public final static int BLOCKLIST = 10;
		public final static int BLOCKPAGE = 3;
	}
}
