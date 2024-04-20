package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface AprvService {
	// 결재
	void intrAprvInqy101010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 기안 목록
	void intrAprvInqy102010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 결재 상세
	void intrAprvInqy201010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 결재 목록
	
	// 메인 (사용자)
	void intrAprvInqy103010(Model model, HashMap<String, Object> paramMap) throws Exception; // 나의 기안
	void intrAprvInqy103011(Model model, HashMap<String, Object> paramMap) throws Exception; // 나의 결재

	// 전자결재
	String intrAprvProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; // 기안문 등록
	String intrAprvProc102010(Model model, HashMap<String, Object> paramMap) throws Exception; // 결재 수신 처리
}
