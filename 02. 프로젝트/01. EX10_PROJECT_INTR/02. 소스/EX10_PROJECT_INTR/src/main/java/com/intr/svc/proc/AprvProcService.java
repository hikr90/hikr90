package com.intr.svc.proc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface AprvProcService {
	// 전자결재
	String intrAprvProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request); // 기안문 등록
	String intrAprvProc102010(Model model, HashMap<String, Object> paramMap); // 결재 수신 처리
}
