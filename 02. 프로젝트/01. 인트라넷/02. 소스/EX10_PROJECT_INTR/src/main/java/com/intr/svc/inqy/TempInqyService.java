package com.intr.svc.inqy;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface TempInqyService {
	// 템플릿 
	void intrTempInqy101010(Model model, HashMap<String, Object> paramMap); // 목록 조회
	void intrTempInqy102010(Model model, HashMap<String, Object> paramMap); // 상세 조회
}
