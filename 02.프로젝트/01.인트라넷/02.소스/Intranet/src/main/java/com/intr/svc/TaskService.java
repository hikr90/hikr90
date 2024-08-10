package com.intr.svc;

import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

public interface TaskService {
	// 업무일지
	void intrTaskInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 업무 조회
	void intrTaskInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 업무 작성
	
	String intrTaskProcService1010(Model model, List<HashMap<String,Object>> paramList) throws Exception; // 등록

}
