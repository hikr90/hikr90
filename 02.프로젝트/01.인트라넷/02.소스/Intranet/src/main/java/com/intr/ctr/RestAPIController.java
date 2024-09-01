package com.intr.ctr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intr.svc.RestAPIService;

@RestController
@RequestMapping("/aprv")
public class RestAPIController {
	//
	@Autowired
	RestAPIService restAPIService;
	//
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	// 기안문 전송 API
	@RequestMapping("/{contId}")
	public String intrRestInqy1010(@PathVariable("contId") String contId) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안문 전체 목록 조회
			//--------------------------------------------------------------------------------------------
			System.out.println("kth : "+contId);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 기안문 전송 API 처리 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return "kth2";
	}
}
