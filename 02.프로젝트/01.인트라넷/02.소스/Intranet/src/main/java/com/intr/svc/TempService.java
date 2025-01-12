package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface TempService {
	// 템플릿 
	void intrTempInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 목록 조회
	void intrTempInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 상세 조회
	void intrTempInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception; // (메인) 템플릿 목록 조회

	String intrTempProc1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 등록
	String intrTempProc1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 수정
	String intrTempProc1030(Model model, HashMap<String, Object> paramMap) throws Exception; // 삭제
}
