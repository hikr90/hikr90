package dao;

import java.util.HashMap;
import java.util.List;
import vo.TestVO;

public interface TestDao {
	List<TestVO> dao_list(HashMap<String, Object> paramMap);
}
