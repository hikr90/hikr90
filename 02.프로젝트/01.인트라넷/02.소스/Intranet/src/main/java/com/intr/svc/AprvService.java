package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AprvService {
	// 결재
	void intrAprvInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 기안 목록
}
