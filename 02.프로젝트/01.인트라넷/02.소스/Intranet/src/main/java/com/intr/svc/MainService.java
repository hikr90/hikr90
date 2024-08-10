package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface MainService {
	// 메뉴 조회
	void intrMainInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception;		// 메뉴 조회
	void intrMainInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 전체 메뉴
	void intrMainInqyService1030(String string) throws Exception; 	// 메뉴 세션 저장
	void intrMainInqyService1040(Model model) throws Exception; 	// 로그인 권한 사용자 조회
	//
	String intrLoginProcService1010(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 사용자 조회

}
