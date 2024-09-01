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
	
	// ��ȹ� ���� API
	@RequestMapping("/{contId}")
	public String intrRestInqy1010(@PathVariable("contId") String contId) throws Exception {
		//
		try {
			//--------------------------------------------------------------------------------------------
			// ��ȹ� ��ü ��� ��ȸ
			//--------------------------------------------------------------------------------------------
			System.out.println("kth : "+contId);
			
		} catch (Exception e) {
			//
			logger.debug("Exception : ��ȹ� ���� API ó�� �� ������ �߻��߽��ϴ�. (" + e.getMessage() + ")");
		}
		//
		return "kth2";
	}
}
