package com.intr.svc.proc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface LoginProcService {
	//
	String intrLoginProc101010(Model model, HashMap<String, Object> paramMap); // 사용자 조회
	String intrLoginProc102010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request); // 기초데이터 업로드
}
