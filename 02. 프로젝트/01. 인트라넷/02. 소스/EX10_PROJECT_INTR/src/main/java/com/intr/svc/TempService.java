package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface TempService {
	// 템플릿 
	void intrTempInqy101010(Model model, HashMap<String, Object> paramMap) throws Exception; // 목록 조회
	void intrTempInqy102010(Model model, HashMap<String, Object> paramMap) throws Exception; // 상세 조회
	void intrTempInqy103010(Model model, HashMap<String, Object> paramMap) throws Exception; // (메인) 템플릿 목록 조회

	String intrTempProc101010(Model model, HashMap<String, Object> paramMap) throws Exception; // 등록
	String intrTempProc102010(Model model, HashMap<String, Object> paramMap) throws Exception; // 수정
	String intrTempProc103010(Model model, HashMap<String, Object> paramMap) throws Exception; // 삭제
}
