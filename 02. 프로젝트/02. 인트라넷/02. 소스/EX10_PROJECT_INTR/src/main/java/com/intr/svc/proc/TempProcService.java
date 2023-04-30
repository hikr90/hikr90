package com.intr.svc.proc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface TempProcService {
	// 관리자 템플릿
	String intrTempProc101010(Model model, HashMap<String, Object> paramMap); // 등록
	String intrTempProc102010(Model model, HashMap<String, Object> paramMap); // 수정
	String intrTempProc103010(Model model, HashMap<String, Object> paramMap); // 삭제

}
