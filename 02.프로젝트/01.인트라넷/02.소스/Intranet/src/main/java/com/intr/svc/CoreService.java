package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface CoreService {
	// 메뉴 조회
	void intrCoreInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 메뉴 조회
	void intrCoreInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 전체 메뉴
	void intrCoreInqy1030(String string) throws Exception; 															// 메뉴 세션 저장
	HashMap<String, Object> intrCoreInqy1040() throws Exception; 												// 메뉴 세션 저장
}
