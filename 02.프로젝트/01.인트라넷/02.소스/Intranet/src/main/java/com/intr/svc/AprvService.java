package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AprvService {
	// 결재
	void intrAprvInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 기안 목록
	void intrAprvInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception;	// 기안 등록 양식

	void intrAprvInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 결재 목록
	void intrAprvInqy2020(Model model, HashMap<String, Object> paramMap) throws Exception;	// 결재 상세
}
