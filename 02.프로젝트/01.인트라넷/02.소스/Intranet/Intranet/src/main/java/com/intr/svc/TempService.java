package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface TempService {
	// 기안문 양식 
	void intrTempInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 목록 조회
	void intrTempInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 상세 조회
	//
	String intrTempProc1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 수정
}
