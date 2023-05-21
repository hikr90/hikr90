package com.intr.svc.inqy;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface CoreInqyService {
	// 메뉴 조회
	void intrCoreInqy101020(String type); 									// 메뉴 세션 저장
	void intrCoreInqy101010(Model model, HashMap<String, Object> paramMap); // 메뉴 조회
	void intrCoreInqy101030(Model model, HashMap<String, Object> paramMap); // 전체 메뉴

	// 페이징 처리
	void intrCoreInqy102010(Model model, HashMap<String, Object> paramMap);
	
	// 검색 값 세팅
	void intrCoreInqy103010(Model model, HashMap<String, Object> paramMap);
}
