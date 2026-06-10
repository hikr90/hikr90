package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AuthService {
	// 권한
	void authInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 권한 목록 조회
	void authInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 권한 상세 조회
	
	// 메뉴 권한
	void authInqyService2010(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 메뉴 권한 목록 조회
	
	// 사용자 권한
	void authInqyService3010(Model model, HashMap<String, Object> paramMap) throws Exception;		// 사용자 목록 조회
	void authInqyService4010(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 사용자 권한 목록 조회
	
	// 권한
	String authProcService1010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 등록
	String authProcService1020(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 수정
	String authProcService1030(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 삭제
	String authProcService1040(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 메뉴 권한 저장
	String authProcService1050(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 사용자 권한 저장
}
