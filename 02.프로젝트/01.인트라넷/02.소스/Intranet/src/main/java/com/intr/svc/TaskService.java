package com.intr.svc;

import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

public interface TaskService {
	// ��������
	void intrTaskInqy101010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� ��ȸ
	void intrTaskInqy201010(Model model, HashMap<String, Object> paramMap) throws Exception; // ���� �ۼ�
	//
	void intrTaskInqy101011(Model model, HashMap<String, Object> paramMap) throws Exception; // ����¡ �Ǽ� ��ȸ
	
	String intrTaskProc101010(Model model, List<HashMap<String,Object>> paramList) throws Exception; // ���

}
