package serviceImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import dao.TestDao;
import daoImpl.TestDAOImpl;
import service.TestService;
import vo.TestVO;

public class TestServiceImpl implements TestService{
	
	// TESTDAO 셋터 인젝션
	TestDao test_dao;
	
	public void setTest_dao(TestDao test_dao) {
		this.test_dao = test_dao;
	}
	
	// 서비스 메소드
	public void service_list(Model model, HashMap<String, Object> paramMap) {
		// 한가지의 작업 단위 (SERVICE)는 여러가지의 기능(DAO)으로 구성되어있다.
		paramMap.put("test","TEST_0001");
		List<TestVO> list = test_dao.dao_list(paramMap);
		model.addAttribute("list",list);
	}
	
}
