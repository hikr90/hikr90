package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface CoreService {
	// 트랜젝션
	void setTx(HashMap<String, Object> paramMap, boolean procYn) throws Exception;	// 트랜젝션 처리
	
	// 메뉴 조회
	void intrCoreInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 메뉴 조회
	void intrCoreInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 전체 메뉴
	void intrCoreInqy1030(String string) throws Exception; 	// 메뉴 세션 저장
}
