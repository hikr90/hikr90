package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {
	// 공지사항
	void intrBoardInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception; // 정보 정정 목록 조회
	void intrBoardInqy1020(Model model, HashMap<String, Object> paramMap) throws Exception; // 상세 화면 조회
	//
	String intrBoardProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// 등록
	String intrBoardProc1020(Model model, String[] delIdxArr) throws Exception; 	// 삭제
	String intrBoardProc1030(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// 수정

}
