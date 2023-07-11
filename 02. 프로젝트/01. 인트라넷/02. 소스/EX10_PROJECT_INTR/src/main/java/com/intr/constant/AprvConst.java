package com.intr.constant;

public interface AprvConst {
	//--------------------------------------------------------------------------------------------
	// 결재 단계 (INTR_STATUS)
	//--------------------------------------------------------------------------------------------
	public static final String STAT_0001 = "STAT_0001"; 	// 임시 저장
	public static final String STAT_0002 = "STAT_0002"; 	// 대기
	public static final String STAT_0003 = "STAT_0003"; 	// 진행 중
	public static final String STAT_0004 = "STAT_0004"; 	// 진행 완료

	//--------------------------------------------------------------------------------------------
	// 결재 단계 (INTR_STEP)
	//--------------------------------------------------------------------------------------------
	public static final String STEP_0001 = "STEP_0001"; 	// 기안 
	public static final String STEP_0002 = "STEP_0002"; 	// 결재
	public static final String STEP_0003 = "STEP_0003"; 	// 참조
	public static final String STEP_0004 = "STEP_0004"; 	// 반려
	public static final String STEP_0005 = "STEP_0005"; 	// 회수

	//--------------------------------------------------------------------------------------------
	// 결재 단위
	//--------------------------------------------------------------------------------------------
	public static final String ATSIGN = "@"; 		 
	public static final String VERTICALBAR = "|"; 

}
