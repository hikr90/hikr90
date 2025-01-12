package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AprvService {
	// 결재
	void intrAprvInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 기안 목록
	void intrAprvInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception;	// 결재 상세
	//
	void intrAprvInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 결재 목록
	
	// 사용자 메인
	void intrAprvInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception; // 나의 기안
	void intrAprvInqy1040(Model model, HashMap<String, Object> paramMap) throws Exception; // 나의 결재
	
	// 전자결재
	String intrAprvProc1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 기안문 등록
	String intrAprvProc1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 결재 수신 처리
	String intrAprvProc1030(Model model, HashMap<String, Object> paramMap) throws Exception; // 결재 수신 처리
}
