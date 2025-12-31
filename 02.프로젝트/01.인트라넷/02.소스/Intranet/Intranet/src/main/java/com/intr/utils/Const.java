package com.intr.utils;

public class Const implements Page, Path, View, Api {
	//--------------------------------------------------------------------------------------------
	// 공통
	//--------------------------------------------------------------------------------------------
	public static final String USER 		= "0"; 			// 사용자
	public static final String ADMIN 	= "1"; 			// 관리자
	
	//--------------------------------------------------------------------------------------------
	// 결재
	//--------------------------------------------------------------------------------------------
	public static final String STEP_0010 		= "STEP_0010"; 			// 결재진행중
	public static final String STEP_0020 		= "STEP_0020"; 			// 결재완료
	public static final String STEP_0030 		= "STEP_0030"; 			// 결재반송
	public static final String STEP_0040 		= "STEP_0040"; 			// 결재취소
	
	public static final String TYPE_0010 		= "TYPE_0010"; 			// 기안
	public static final String TYPE_0020 		= "TYPE_0020"; 			// 결재
	public static final String TYPE_0030 		= "TYPE_0030"; 			// 참조
	
	public static final String RSLT_0010 		= "RSLT_0010"; 			// 승인
	public static final String RSLT_0020 		= "RSLT_0020"; 			// 반송
	public static final String RSLT_0030 		= "RSLT_0030"; 			// 취소
}
