package com.intr.svc.inqy;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AprvInqyService {
	// 결재
	void intrAprvInqy101010(Model model, HashMap<String, Object> paramMap);	// 기안 목록
	void intrAprvInqy102010(Model model, HashMap<String, Object> paramMap);	// 결재 상세
	void intrAprvInqy201010(Model model, HashMap<String, Object> paramMap);	// 결재 목록
	
	// 메인 (사용자)
	void intrAprvInqy103010(Model model, HashMap<String, Object> paramMap); // 나의 기안
	void intrAprvInqy103011(Model model, HashMap<String, Object> paramMap); // 나의 결재
}
