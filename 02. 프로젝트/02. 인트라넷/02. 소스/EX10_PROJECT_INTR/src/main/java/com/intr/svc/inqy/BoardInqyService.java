package com.intr.svc.inqy;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface BoardInqyService {
	// 공지사항
	void intrBoardInqy101010(Model model, HashMap<String, Object> paramMap); // 정보 정정 목록 조회
	void intrBoardInqy101011(Model model, HashMap<String, Object> paramMap); // 목록 건수 조회
	void intrBoardInqy103010(Model model, HashMap<String, Object> paramMap); // 상세 화면 조회
}
