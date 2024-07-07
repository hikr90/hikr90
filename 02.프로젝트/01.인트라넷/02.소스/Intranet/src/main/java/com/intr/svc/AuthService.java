package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AuthService {
	// 관리자 권한
	void intrAuthInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 권한 목록 조회
	void intrAuthInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 권한 상세 조회
	
	// 관리자 메뉴 권한
	void intrAuthInqyService1030(Model model, HashMap<String, Object> paramMap) throws Exception; // 메뉴 권한 목록 조회
	
	// 관리자 사용자 권한
	void intrAuthInqyService1040(Model model, HashMap<String, Object> paramMap) throws Exception;	// 사용자 목록 조회
	void intrAuthInqyService1050(Model model, HashMap<String, Object> paramMap) throws Exception; // 사용자 권한 목록 조회
	
	// 관리자 권한
	String intrAuthProcService1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 등록
	String intrAuthProcService1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 수정
	String intrAuthProcService1030(Model model, HashMap<String, Object> paramMap) throws Exception; // 삭제
	
	String intrAuthProcService1040(Model model, HashMap<String, Object> paramMap) throws Exception; // 메뉴 권한 저장
	String intrAuthProcService1050(Model model, HashMap<String, Object> paramMap) throws Exception; // 사용자 권한 저장
}
