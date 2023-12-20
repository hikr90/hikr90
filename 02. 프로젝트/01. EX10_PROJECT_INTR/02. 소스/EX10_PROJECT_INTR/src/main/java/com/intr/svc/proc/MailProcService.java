package com.intr.svc.proc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface MailProcService {
	// 메일 전송 관련
	String intrMailProc101010(Model model, HashMap<String, Object> paramMap) throws Exception;
}
