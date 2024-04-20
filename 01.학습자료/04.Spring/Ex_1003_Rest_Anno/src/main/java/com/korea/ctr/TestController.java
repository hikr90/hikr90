package com.korea.ctr;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.korea.daoImpl.TestDAOImpl;
import com.korea.service.TestService;
import com.korea.serviceImpl.TestServiceImpl;
import com.korea.vo.TestVO;


@RestController
@RequestMapping("/test/*")
public class TestController {
	//
	public static final String VIEW_PATH = "/WEB-INF/views/test/";

	//
	@Autowired
	TestService test_service;
	//
	private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
	
	/*	@PATHVARIABLE
	 		- 브라우저에서 요청하는 URL로 전달된 매개변수를 가져오는 어노테이션
	 		- { } 내의 값이 @PATHVARIABLE로 지정되어 요청 URL에서 지정된 값이 { } 에 자동으로 할당된다.
	 		- NULL이나 공백이 들어가는 값은 인식하지 못한다.
	 		- 메소드의 데이터 타입과 다른 타입의 값이 들어가는 경우 오류가 발생한다.
	*/
	@RequestMapping("/test/{test_no}")
	public String test_no(@PathVariable("test_no") String test_no) throws Exception {
		//
		return test_no;
	}
	
	/*	@REQUESTBODY
			- 브라우저에서 전달되는 JSON 데이터를 객체로 자동 변환해주는 어노테이션
			- HTML화면의 BODY 영역 전체를 받아오는 방식으로, BODY가 없는 GET 방식으로는 받아올 수 없다.
	*/
	@RequestMapping("/test/sendData")
	public void sendData(@RequestBody TestVO vo) {
		//
		LOG.warn("getTest_no : "+vo.getTest_no());
		LOG.warn("getTest_nm : "+vo.getTest_nm());
		LOG.warn("getDisp_order : "+vo.getDisp_order());
		LOG.warn("getRemark : "+vo.getRemark());
	}
	
	/*	@RESPONSEBODY
			- 데이터 타입 리턴 메소드임을 명시하는 어노테이션
			- 해당 어노테이션이 있는 메소드는 JSP가 아닌 텍스트나 JSON타입으로 결과를 반환한다.
	 */
	@RequestMapping("/test/res")
	@ResponseBody
	public TestVO res() {
		//
		TestVO vo = new TestVO();
		vo.setTest_no("TEST_0001");
		vo.setTest_nm("TEST");
		vo.setDisp_order("1");
		vo.setRemark("NULL");
		//
		return vo;
	}
	
	/*	RESPONSEENTITY
			- @RESTCONTROLLER 사용 시, 데이터 전달 과정에서 발생하는 예외를 제어하는 클래스
			- 데이터 전송 중 예외가 발생한 경우 해당 클래스에서 HTTP 상태 코드를 반환하는 등의 예외 처리 작업이 가능하다.
	 */
	@RequestMapping("/test/entity")
	public ResponseEntity<List<TestVO>> list() throws Exception{
		//
		List<TestVO> list = null;
		list = test_service.test_list();
		// 오류 코드 500으로 반환
		ResponseEntity<List<TestVO>> entity = new ResponseEntity<List<TestVO>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
	
	@RequestMapping("/test/entity_msg")
	public ResponseEntity<List<TestVO>> list_msg() throws Exception{
		//
		HttpHeaders resHeader = new HttpHeaders();
		resHeader.add("Content-Type", "text/html; charset=utf-8");
		
		// 오류 코드와 메세지 동시 출력
		String msg = "<script>";
		msg += "alert('목록 정상 출력');";
		msg += "</script>";
		//
		ResponseEntity entity = new ResponseEntity(msg, resHeader, HttpStatus.CREATED);
		return entity;
	}

}
