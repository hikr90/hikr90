package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {
	// 공지사항
	void intrBoardInqyService1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 정보 정정 목록 조회
	void intrBoardInqyService1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 상세 화면 조회
	
	// 관리자 공지사항
	String intrBoardProcService1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// 등록
	String intrBoardProcService1020(Model model, String[] delIdxArr) throws Exception; 													// 삭제
	String intrBoardProcService1030(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// 수정

}
