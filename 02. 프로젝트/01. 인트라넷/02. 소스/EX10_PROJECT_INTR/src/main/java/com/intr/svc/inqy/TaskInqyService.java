package com.intr.svc.inqy;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface TaskInqyService {
	// 업무일지
	void intrTaskInqy101010(Model model, HashMap<String, Object> paramMap); // 업무 조회
	void intrTaskInqy201010(Model model, HashMap<String, Object> paramMap); // 업무 작성
	//
	void intrTaskInqy101011(Model model, HashMap<String, Object> paramMap); // 페이징 건수 조회
}
