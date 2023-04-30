package com.intr.svc.proc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface LoginProcService {
	//
	String intrLoginProc101010(Model model, HashMap<String, Object> paramMap); // 사용자 조회
	String intrLoginProc102010(Model model); // 관리자 계정 조회

}
