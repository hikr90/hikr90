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
	@RequestMapping("/list")
	public String intrRestInqy1010(String reqObj) throws Exception {
		String jStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안문 전체 목록 조회
			//--------------------------------------------------------------------------------------------
			jStr = restAPIService.intrRestInqy1010(reqObj);
			logger.debug("jStr : " + jStr);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 기안문 목록 조회 (API) 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return jStr;
	}

	// 기안문 상세 조회
	@RequestMapping("/{contId}")
	public String intrRestInqy1020(@PathVariable String contId) throws Exception {
		String jStr = "";
		//
		try {
			//--------------------------------------------------------------------------------------------
			// 기안문 상세 조회
			//--------------------------------------------------------------------------------------------
			jStr = restAPIService.intrRestInqy1020(contId);
			logger.debug("jStr : " + jStr);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : 기안문 상세 조회 (API) 중 에러가 발생했습니다. (" + e.getMessage() + ")");
		}
		//
		return jStr;
	}
}
