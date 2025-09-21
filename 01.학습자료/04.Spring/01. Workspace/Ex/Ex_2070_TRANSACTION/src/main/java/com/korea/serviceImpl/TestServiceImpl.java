package com.korea.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.korea.dao.TestDao;
import com.korea.service.TestService;
import com.korea.vo.TestVO;

@Service
@Transactional
public class TestServiceImpl implements TestService{
	
	/* 트랜젝션 
	 *		- 여러개의 DML 명령어를 하나의 논리적인 작업 단위로 묶어서 관리하는 것을 뜻한다.
	 *		- 스프링에서는 트랜젝션 기능을 Mybatis와 연동하여 사용한다.
	 *		- 작업은 All 혹은 All Nothing의 방식으로 완료된다.
	 *			(1) All : 모든 작업의 결과가 DB에 적용된다.
	 *			(2) All Nothing : 하나라도 잘못된 작업이 있는 경우 모든 작업이 취소된다.
	 *	
	 *		방식
	 *			(1) @Transacional을 사용하는 선언적 트랜젝션 방식
	 *			(2) 코드 상에서 직접 사용하는 방식 두가지가 존재한다. (본문 예제에서는 어노테이션 방식을 사용한다.)
	 *
	 *		성질
	 *			(1) 일관성 : 트랜젝션 전후의 데이터의 조건이 동일하다. (데이터 타입, 길이 등의 조건이 트랜젝션 전후로 달라질 수 없다.)
	 *			(2) 원자성 : 트랜젝션으로 묶인 기능은 더이상 쪼갤 수 없는 단위이다. (전부 성공 & 전부 실패 처리)
	 *			(3) 고립성 : 트랜젝션 중에 다른 트랜젝션은 간섭할 수 없다. (트랜젝션이 있는 동안은 교착 상태로서 이는 트랜젝션이 종료되기 전까지는 계속 유지된다.) 
	 *			(4) 지속성 : 트랜젝션 완료 시 데이터는 커밋 (영구보존)된다.
	 *
	 *		속성
	 *			(1) propagation : 트랜젝션의 전파 규칙 설정
	 *				(1.1) required
	 *					- 트랜젝션 필요
	 *					- 진행 중인 트랜젝션이 있는 경우 해당 트랜젝션 사용
	 *					- 트랜젝션이 없는 경우 새로운 트랜젝션 생성 (default)
	 *
	 *				(1.2) mandatory
	 *					- 트랜젝션 필요
	 *					- 진행 중인 트랜젝션이 없는 경우 예외 발생
	 *
	 *				(1.3)required_new
	 *					- 항상 새로운 트랜젝션 생성
	 *					- 진행 중인 트랜젝션이 있는 경우 기존 트랜젝션을 일시 중지시킨 뒤 새로운 트랜젝션을 시작
	 *					- 새로 시작된 트랜젝션이 종료되면 기존 트랜젝션을 계속해서 진행
	 *
	 *				(1.4) supports
	 *					- 트랜젝션 필요 없음
	 *					- 진행 중인 트랜젝션이 있는 경우 해당 트랜젝션 사용
	 *
	 *				(1.5) not_supported
	 *					- 트랜젝션 필요 없음
	 *					- 진행 중인 트랜젝션이 있는 경우 기존 트랜젝션을 일시 중지시킨 후 메소드 실행
	 *					- 메소드 실행이 종료되면 기존 트랜젝션 계속 진행
	 *
	 *				(1.6) never
	 *					- 트랜젝션 필요 없음
	 *					- 진행 중인 트랜젝션이 있는 경우 예외 발생
	 *
	 *				(1.7) nested
	 *					- 트랜젝션 필요
	 *					- 진행 중인 트랜젝션이 있는 경우 기존 트랜젝션에 중첩된 트랜젝션에서 메소드 실행 
	 *					- 트랜젝션이 없으면 새로운 트랜젝션 생성
	 *
	 *			(2) isolation : 트랜젝션의 격리 레벨 설정
	 *				(2.1) default : 데이터베이스에서 기본적으로 제공하는 설정
	 *				(2.2) read_uncommited : 다른 트랜젝션에서 커밋하지 않은 데이터 읽기 가능
	 *				(2.3) read_commited : 커밋한 데이터만 읽기 가능
	 *				(2.4) repeatable_read : 현재 트랜젝션에서 데이터를 수정하지 않았다면 처음 읽어온 데이터와 두번째로 읽어온 데이터가 동일
	 *				(2.5) serializable : 같은 데이터에대해서 한 개의 트랜젝션만 수행 가능
	 *	
	 *			(3) realOnly : 읽기 전용 여부 설정
	 *			(4) rollbackFor : 트랜젝션을 롤백할 예외타입 설정
	 *			(5) norollbackFor : 트랜젝션을 롤백하지 않을 예외타입 설정
	 *			(6) timeout : 트랜젝션 타임아웃 설정
	 */
	
	@Autowired
	TestDao test_dao;
	
	// 목록 조회
	public void list(Model model) throws Exception{
		// 
		List<TestVO> list = test_dao.selectList();
		model.addAttribute("list",list);
	}
	
	// 트랜젝션
	public String updateTest() throws Exception {
		//
		int res = 0;
		
		// 트랜젝션 시작
		res = test_dao.updateTest1(); 
		res = test_dao.updateTest2();
		//
		String resStr = "NO";
		String resJson = "";
		//
		if(res!=0) {
			resStr = "YES";
		}
		//
		resJson = String.format("[{'res':'%s'}]", resStr);
		return resJson;
	}
	
}
