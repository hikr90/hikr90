package com.intr.svc.proc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface EmpProcService {
	// 관리자 사원 관리
	String intrEmpProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request); // 등록
	String intrEmpProc102010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request); // 수정
	String intrEmpProc103010(Model model, HashMap<String, Object> paramMap); // 복직, 퇴사
}
