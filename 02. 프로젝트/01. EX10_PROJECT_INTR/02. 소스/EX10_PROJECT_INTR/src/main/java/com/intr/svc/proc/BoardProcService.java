package com.intr.svc.proc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardProcService {
	// ������ ��������
	String intrBoardProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request); // ���
	String intrBoardProc102010(Model model, String[] delIdxArr); // ����
	String intrBoardProc103010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request); // ����

}
