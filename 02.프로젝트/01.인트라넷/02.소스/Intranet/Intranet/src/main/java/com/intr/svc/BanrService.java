package com.intr.svc;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BanrService {
	// 배너
	void intrBanrInqy1010(Model model, HashMap<String, Object> paramMap) throws Exception;	// 배너 관리
	//
	String intrBanrProc1010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request) throws Exception; 	// 저장
	String intrBanrProc1020(Model model, HashMap<String, Object> paramMap) throws Exception; 	// 삭제

}
