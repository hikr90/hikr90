package com.intr.svc.proc;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface AuthProcService {
	// 관리자 권한
	String intrAuthProc101010(Model model, HashMap<String, Object> paramMap); // 등록
	String intrAuthProc102010(Model model, HashMap<String, Object> paramMap); // 수정
	String intrAuthProc103010(Model model, HashMap<String, Object> paramMap); // 삭제
	
	String intrAuthProc201010(Model model, HashMap<String, Object> paramMap); // 메뉴 권한 저장
	String intrAuthProc301010(Model model, HashMap<String, Object> paramMap); // 사용자 권한 저장
}
