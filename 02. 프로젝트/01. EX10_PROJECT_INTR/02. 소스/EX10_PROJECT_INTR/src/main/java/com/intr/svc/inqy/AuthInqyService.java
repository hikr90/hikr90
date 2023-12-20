package com.intr.svc.inqy;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AuthInqyService {
	// 관리자 권한
	void intrAuthInqy101010(Model model, HashMap<String, Object> paramMap); // 권한 목록 조회
	void intrAuthInqy102010(Model model, HashMap<String, Object> paramMap); // 권한 상세 조회
	
	// 관리자 메뉴 권한
	void intrAuthInqy201010(Model model, HashMap<String, Object> paramMap); // 메뉴 권한 목록 조회
	
	// 관리자 사용자 권한
	void intrAuthInqy301010(Model model, HashMap<String, Object> paramMap);	// 사용자 목록 조회
	void intrAuthInqy301020(Model model, HashMap<String, Object> paramMap); // 사용자 권한 목록 조회
}
