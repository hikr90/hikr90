package com.lnsp.comm;

public class Common {
	// 게시판 페이징 처리를 위한 클래스

	public static class Test{
		public static final String VIEW_PATH = "/WEB-INF/views/";

		//한 페이지에 보여줄 게시물 수
		public final static int BLOCKLIST = 10;

		//한 화면에 보여지는 페이지 메뉴 수
		//<1 2 3 4 5>
		public final static int BLOCKPAGE = 5;
	}

	// 사용중 : CSCenterController
	public static class Notice {
		public final static int BLOCKLIST = 10;
		public final static int BLOCKPAGE = 5;
	}

	public static class Goods_page {
		public final static int BLOCKLIST = 12;
		public final static int BLOCKPAGE = 5;
	}
	
	public static class MyPage {
		public final static int BLOCKLIST = 5;
		public final static int BLOCKPAGE = 5;
	}
	
	public static class QnaProdInGoods {
		public final static int BLOCKLIST = 5;
		public final static int BLOCKPAGE = 5;
	}
}
