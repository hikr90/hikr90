package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AuthService {
	// 관리자 권한
	void intrAuthInqy101010(Model model, HashMap<String, Object> paramMap) throws Exception; // 권한 목록 조회
	void intrAuthInqy102010(Model model, HashMap<String, Object> paramMap) throws Exception; // 권한 상세 조회
	
	// 관리자 메뉴 권한
	void intrAuthInqy201010(Model model, HashMap<String, Object> paramMap) throws Exception; // 메뉴 권한 목록 조회
	
	// 관리자 사용자 권한
	void intrAuthInqy301010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 사용자 목록 조회
	void intrAuthInqy301020(Model model, HashMap<String, Object> paramMap) throws Exception; // 사용자 권한 목록 조회
	
	// 관리자 권한
	String intrAuthProc101010(Model model, HashMap<String, Object> paramMap) throws Exception; // 등록
	String intrAuthProc102010(Model model, HashMap<String, Object> paramMap) throws Exception; // 수정
	String intrAuthProc103010(Model model, HashMap<String, Object> paramMap) throws Exception; // 삭제
	
	String intrAuthProc201010(Model model, HashMap<String, Object> paramMap) throws Exception; // 메뉴 권한 저장
	String intrAuthProc301010(Model model, HashMap<String, Object> paramMap) throws Exception; // 사용자 권한 저장
}
