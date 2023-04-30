package com.intr.svc.proc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileProcService {
	// 파일 업로드
	String intrFileProc101010(Model model, HashMap<String, Object> paramMap, MultipartHttpServletRequest request); // 업로드
	void intrFileProc102010(Model model, HashMap<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response); // 다운로드 (단건)
	
}
