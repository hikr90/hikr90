package com.intr.svc.inqy;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface TaskInqyService {
	// 업무일지
	void intrTaskInqy201010(Model model, HashMap<String, Object> paramMap); // 목록 조회
	
}
