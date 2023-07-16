package com.intr.svc.inqy;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AprvInqyService {
	// 결재
	void intrAprvInqy101010(Model model, HashMap<String, Object> paramMap);	// 결재내역 목록
	void intrAprvInqy102010(Model model, HashMap<String, Object> paramMap);	// 결재 상세
}
