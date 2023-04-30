package com.intr.svc.inqy;

import java.util.HashMap;
import org.springframework.ui.Model;

public interface CoreInqyService {
	// 메뉴 조회
	void intrCoreInqy101010(Model model, HashMap<String, Object> paramMap); // 사용자 메뉴
	void intrCoreInqy101020(Model model, HashMap<String, Object> paramMap); // 관리자 메뉴
	void intrCoreInqy101030(Model model, HashMap<String, Object> paramMap); // 전체

	// 페이징 처리
	void intrCoreInqy102010(Model model, HashMap<String, Object> paramMap);
	
	// 검색 값 세팅
	void intrCoreInqy103010(Model model, HashMap<String, Object> paramMap);
}
