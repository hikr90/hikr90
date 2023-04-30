package com.intr.constant;

public class IntrConstant implements PageConstant, ViewConstant {
	//--------------------------------------------------------------------------------------------
	// 프로젝트 경로
	//--------------------------------------------------------------------------------------------
	public static final String INTR_PATH  = "/WEB-INF/views/intr";

	//--------------------------------------------------------------------------------------------
	// 공통 영역
	//--------------------------------------------------------------------------------------------
	public static final String VIEW_PATH_POPUP = INTR_PATH + "/comm/popup/"; 	// 팝업

	//--------------------------------------------------------------------------------------------
	// 폴더 경로
	//--------------------------------------------------------------------------------------------
	public static final String VIEW_PATH_MAIN 	= INTR_PATH + "/main/"; 		// 메인
	public static final String VIEW_PATH_LOGIN 	= INTR_PATH + "/login/"; 		// 로그인
	public static final String VIEW_PATH_MYPAGE = INTR_PATH + "/mypage/"; 		// 내 정보
	public static final String VIEW_PATH_BOARD 	= INTR_PATH + "/board/"; 		// 공지사항
	public static final String VIEW_PATH_SCHE 	= INTR_PATH + "/sche/";		 	// 일정
	public static final String VIEW_PATH_TASK 	= INTR_PATH + "/task/"; 		// 업무
	public static final String VIEW_PATH_EMP 	= INTR_PATH + "/emp/";	 		// 사원
	public static final String VIEW_PATH_TEMP 	= INTR_PATH + "/template/";	 	// 템플릿
	public static final String VIEW_PATH_QNA 	= INTR_PATH + "/qna/";	 		// Q&A
	public static final String VIEW_PATH_AUTH 	= INTR_PATH + "/auth/";	 		// 권한
	
	//--------------------------------------------------------------------------------------------
	// 파일 다운로드 경로
	//--------------------------------------------------------------------------------------------
	public static final String FILE_PATH = "UPLOAD/FILE"; // 파일
	public static final String EMP_PATH = "UPLOAD/EMP"; // 프로필 이미지

}
