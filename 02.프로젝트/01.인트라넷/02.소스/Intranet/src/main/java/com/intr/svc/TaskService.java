package com.intr.svc;

import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

public interface TaskService {
	// ��������
	void intrTaskInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ��ȸ
	void intrTaskInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� �ۼ�
	
	String intrTaskProcService1010(Model model, List<HashMap<String,Object>> paramList) throws Exception; // ���

}
