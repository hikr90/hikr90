package com.intr.svc.proc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AuthProcService {
	// ������ ����
	String intrAuthProc101010(Model model, HashMap<String, Object> paramMap); // ���
	String intrAuthProc102010(Model model, HashMap<String, Object> paramMap); // ����
	String intrAuthProc103010(Model model, HashMap<String, Object> paramMap); // ����
	
	String intrAuthProc201010(Model model, HashMap<String, Object> paramMap); // �޴� ���� ����
	String intrAuthProc301010(Model model, HashMap<String, Object> paramMap); // ����� ���� ����
}
