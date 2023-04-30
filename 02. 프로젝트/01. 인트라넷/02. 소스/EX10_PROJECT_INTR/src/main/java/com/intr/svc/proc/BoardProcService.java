package com.intr.svc.proc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardProcService {
	// 관리자 공지사항
	String intrBoardProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request); // 등록
	String intrBoardProc102010(Model model, String[] delIdxArr); // 삭제
	String intrBoardProc103010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request); // 수정

}
