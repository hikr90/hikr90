package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface ScheService {
	// 일정 관리
	void intrScheInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 일정 목록 조회
	void intrScheInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 일정 상세 조회
}
