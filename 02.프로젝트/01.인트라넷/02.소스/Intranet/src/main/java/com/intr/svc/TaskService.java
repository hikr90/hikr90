package com.intr.svc;

import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

public interface TaskService {
	// ��������
	void intrTaskInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� �ۼ�
	void intrTaskInqy2010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ��ȸ
	//
	String intrTaskProc1010(Model model, List<HashMap<String,Object>> paramList) throws Exception; // ���

}
