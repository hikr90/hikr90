package com.intr.svc.proc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface MailProcService {
	// ���� ���� ����
	String intrMailProc101010(Model model, HashMap<String, Object> paramMap) throws Exception;
}
