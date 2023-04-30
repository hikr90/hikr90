package dao;

import java.util.ArrayList;
import java.util.List;

public class BoardDAOImpl implements BoardDAO{
	
	// 인터페이스에서 생성한 메소드 구현
	@Override
	public List selectList() {
		// NEW 키워드로 메모리 할당 시, 반드시 GENERAL TYPE이 있어야한다.
		List<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("수박");
		list.add("참외");
		list.add("바나나");
		//
		return list;
	}
	
	//
	@Override
	public int increaseCnt() {
		// TODO Auto-generated method stub
		return 0;
	}
}
