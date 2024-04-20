package Common;

public class Common {
	// 게시판 페이징 처리를 위한 클래스
	// 내부 클래스를 사용하여 페이지를 개별적으로 게시글 수와 페이지 메뉴수를 조절할 수 있다.
	public static class Board{
		// 한 페이지에 보여줄 게시글 수
		public final static int BLOCKLIST = 5;
		
		// 한 화면에 보여지는 페이지 메뉴 수
		// < 1 2 3 > 의 방식 
		public final static int BLOCKPAGE = 3;
	}
	
	// 만약 아래의 NOTICE처럼 해당 클래스에서 내부 클래스로 따로 구분하게 되면 
	// Common.Board.BLOCKLIST 혹은 Common.Notice.BLOCKLIST 처럼 따로 관리하기 용이하다.
	public static class Notice{
		public final static int BLOCKLIST = 10;
		
		public final static int BLOCKPAGE = 3;
	}
}
