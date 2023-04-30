package com.korea.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

import vo.TestVO;

public interface TestService {
	//
	public void service_list(Model model, HashMap<String, Object> paramMap) throws Exception;
}
