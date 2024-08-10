package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface AprvService {
	// 결재
	void intrAprvInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 기안 목록
	void intrAprvInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception;	// 결재 상세
	void intrAprvInqyService1030(Model model, HashMap<String, Object> paramMap) throws Exception;	// 결재 목록
	
	// 사용자 메인
	void intrAprvInqyService1040(Model model, HashMap<String, Object> paramMap) throws Exception; // 나의 기안
	void intrAprvInqyService1050(Model model, HashMap<String, Object> paramMap) throws Exception; // 나의 결재
	
	// 전자결재
	String intrAprvProcService1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // 기안문 등록
	String intrAprvProcService1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 결재 수신 처리
	String intrAprvProcService1030(Model model, HashMap<String, Object> paramMap) throws Exception; // 결재 수신 처리
}
