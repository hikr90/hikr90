package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface AprvService {
	// 결재
	void intrAprvInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 기안 목록
	void intrAprvInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception;	// 기안 등록 양식

	void intrAprvInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 결재 목록
	void intrAprvInqy2020(Model model, HashMap<String, Object> paramMap) throws Exception;	// 결재 상세
	
	String intrAprvProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// 기안 등록
	void intrAprvProc2010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 기본 정보 처리
	void intrAprvProc3010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 양식 유형 처리
	void intrAprvProc4010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 결재 처리
}
