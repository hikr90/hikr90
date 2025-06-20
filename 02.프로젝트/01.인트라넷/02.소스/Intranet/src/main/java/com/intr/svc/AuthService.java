package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AuthService {
	// 권한
	void intrAuthInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 권한 목록 조회
	void intrAuthInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 권한 상세 조회
	
	// 메뉴 권한
	void intrAuthInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception; // 메뉴 권한 목록 조회
	
	// 사용자 권한
	void intrAuthInqy3010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 사용자 목록 조회
	void intrAuthInqy4010(Model model, HashMap<String, Object> paramMap) throws Exception; // 사용자 권한 목록 조회
	
	// 권한
	String intrAuthProc1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 등록
	String intrAuthProc1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 수정
	String intrAuthProc1030(Model model, HashMap<String, Object> paramMap) throws Exception; // 삭제
	
	String intrAuthProc1040(Model model, HashMap<String, Object> paramMap) throws Exception; // 메뉴 권한 저장
	String intrAuthProc1050(Model model, HashMap<String, Object> paramMap) throws Exception; // 사용자 권한 저장
}
