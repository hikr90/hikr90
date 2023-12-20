package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface MainService {
	// 메뉴 조회
	void intrMainInqy101020(String string) throws Exception; 									// 메뉴 세션 저장
	void intrMainInqy101010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 메뉴 조회
	void intrMainInqy101030(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 전체 메뉴

	void intrMainInqy102010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 페이징 처리
	void intrMainInqy103010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 검색 값 저장
	//
	String intrLoginProc101010(Model model, HashMap<String, Object> paramMap) throws Exception; // 사용자 조회

}
