package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface TaskService {
	// 업무
	void intrTaskInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 업무 작성
	void intrTaskInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 업무 작성 (AJAX)
	void intrTaskInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception; // 업무 조회
	void intrTaskInqy2020(Model model, HashMap<String, Object> paramMap) throws Exception; // 업무 상세
	void intrTaskInqy3010(Model model, HashMap<String, Object> paramMap) throws Exception; // 업무 캘린더 조회
	//
	String intrTaskProc1010(Model model, HashMap<String,Object> paramMapt) throws Exception; // 등록
}
