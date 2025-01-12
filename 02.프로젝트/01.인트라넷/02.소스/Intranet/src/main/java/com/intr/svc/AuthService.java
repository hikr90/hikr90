package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AuthService {
	// 관리자 권한
	void intrAuthInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 권한 목록 조회
	void intrAuthInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 권한 상세 조회
	
	// 관리자 메뉴 권한
	void intrAuthInqy1030(Model model, HashMap<String, Object> paramMap) throws Exception; // 메뉴 권한 목록 조회
	
	// 관리자 사용자 권한
	void intrAuthInqy1040(Model model, HashMap<String, Object> paramMap) throws Exception;	// 사용자 목록 조회
	void intrAuthInqy1050(Model model, HashMap<String, Object> paramMap) throws Exception; // 사용자 권한 목록 조회
	
	// 관리자 권한
	String intrAuthProc1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 등록
	String intrAuthProc1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 수정
	String intrAuthProc1030(Model model, HashMap<String, Object> paramMap) throws Exception; // 삭제
	
	String intrAuthProc1040(Model model, HashMap<String, Object> paramMap) throws Exception; // 메뉴 권한 저장
	String intrAuthProc1050(Model model, HashMap<String, Object> paramMap) throws Exception; // 사용자 권한 저장
}
