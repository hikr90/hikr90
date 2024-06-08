package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface MainService {
	// 메뉴 조회
	void intrMainInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;		// 메뉴 조회
	void intrMainInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; 		// 전체 메뉴
	void intrMainInqy1030(String string) throws Exception; 										// 메뉴 세션 저장
	void intrMainInqy1040(Model model) throws Exception; 										// 로그인 권한 사용자 조회
	void intrMainInqy1050(Model model, HashMap<String, Object> paramMap) throws Exception;		// 페이징 처리
	void intrMainInqy1060(Model model, HashMap<String, Object> paramMap) throws Exception;		// 검색 값 저장
	//
	String intrLoginProc1010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 사용자 조회

}
