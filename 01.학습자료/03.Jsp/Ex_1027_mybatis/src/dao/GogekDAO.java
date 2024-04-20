package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MybatisConnector;
import vo.GogekVO;

public class GogekDAO {
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static GogekDAO single = null;

	public static GogekDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new GogekDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	SqlSessionFactory factory;
	
	public GogekDAO() {
		factory = MybatisConnector.getInstance().getFactory();
	}
	
	public List<GogekVO> select(){
		List<GogekVO> list = null;
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("gogek.gogek_list");
		
		sqlSession.close();
		
		return list;
	}
	
	public List<GogekVO> select(String search){
		
		List<GogekVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("gogek.gogek_list_search",search);
		
		sqlSession.close();
		
		return list;
	}
}
