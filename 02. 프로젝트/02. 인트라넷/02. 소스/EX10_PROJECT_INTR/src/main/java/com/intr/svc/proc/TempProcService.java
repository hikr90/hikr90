package com.intr.svc.proc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface TempProcService {
	// ������ ���ø�
	String intrTempProc101010(Model model, HashMap<String, Object> paramMap); // ���
	String intrTempProc102010(Model model, HashMap<String, Object> paramMap); // ����
	String intrTempProc103010(Model model, HashMap<String, Object> paramMap); // ����

}
