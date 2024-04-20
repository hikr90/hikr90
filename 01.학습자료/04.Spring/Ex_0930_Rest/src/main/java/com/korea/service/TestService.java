package com.korea.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

import com.korea.vo.TestVO;

public interface TestService {
	//
	public TestVO test_vo(Model model) throws Exception;
	public HashMap<String, Object> test_map(Model model) throws Exception;
	public List<TestVO> test_list(Model model) throws Exception;
}
