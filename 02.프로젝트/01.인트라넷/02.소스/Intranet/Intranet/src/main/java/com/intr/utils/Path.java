package com.intr.utils;

public interface Path {
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
	public static final String VIEW_PATH_MAIN 		= INTR_PATH + "/main/"; 			// 메인
	public static final String VIEW_PATH_LOGIN 		= INTR_PATH + "/login/"; 			// 로그인
	public static final String VIEW_PATH_MYPAGE 		= INTR_PATH + "/mypage/"; 		// 내 정보
	public static final String VIEW_PATH_BOARD 		= INTR_PATH + "/board/"; 			// 공지사항
	public static final String VIEW_PATH_SCHE 			= INTR_PATH + "/sche/";		 	// 일정
	public static final String VIEW_PATH_TASK 			= INTR_PATH + "/task/"; 			// 업무
	public static final String VIEW_PATH_EMP 			= INTR_PATH + "/emp/";	 			// 사원
	public static final String VIEW_PATH_TEMP 			= INTR_PATH + "/temp/";	 		// 기안문 양식
	public static final String VIEW_PATH_AUTH 		= INTR_PATH + "/auth/";	 		// 권한
	public static final String VIEW_PATH_APRV 			= INTR_PATH + "/aprv/";	 		// 결재
	public static final String VIEW_PATH_QUERY 		= INTR_PATH + "/query/";	 		// 쿼리
	public static final String VIEW_PATH_PROJ 			= INTR_PATH + "/project/"; 		// 프로젝트
	public static final String VIEW_PATH_MTG 			= INTR_PATH + "/meeting/"; 		// 회의
	public static final String VIEW_PATH_BANR 			= INTR_PATH + "/banr/"; 			// 배너
	
	//--------------------------------------------------------------------------------------------
	// 파일 다운로드 경로
	//--------------------------------------------------------------------------------------------
	public static final String FILE_PATH = "INTR\\FILE"; 		// 파일
	public static final String TEMP_PATH = "INTR\\TEMP"; 		// 임시
	public static final String IMG_PATH  = "INTR\\IMG"; 		// 이미지
	public static final String DOC_PATH  = "INTR\\DOC"; 		// 참고문서

	//--------------------------------------------------------------------------------------------
	// 참고문서 명칭
	//--------------------------------------------------------------------------------------------
	public static final String DOC_WORD  = "인트라넷 테이블.docx"; 		// WORD
	public static final String DOC_EXCEL  = "인트라넷 데이터.xlsx"; 		// EXCEL
	public static final String DOC_PPT  = "인트라넷 프로젝트.ppt"; 			// PPT
	
	//--------------------------------------------------------------------------------------------
	// RESTful API URL
	//--------------------------------------------------------------------------------------------
	public static final String API_URL = "http://172.30.1.81:9090/api/v1/";
}
