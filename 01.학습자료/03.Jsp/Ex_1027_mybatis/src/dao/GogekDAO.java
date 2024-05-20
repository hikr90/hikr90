package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MybatisConnector;
import vo.GogekVO;

public class GogekDAO {
	//
	static GogekDAO single = null;
	//
	public static GogekDAO getInstance() {
		if (single == null)
			single = new GogekDAO();
		return single;
	}
	//
	SqlSessionFactory factory;
	//
	public GogekDAO() {
		factory = MybatisConnector.getInstance().getFactory();
	}
	//
	public List<GogekVO> select(){
		List<GogekVO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("gogek.gogek_list");
		sqlSession.close();
		return list;
	}
	//
	public List<GogekVO> select(String search){
		List<GogekVO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("gogek.gogek_list_search",search);
		sqlSession.close();
		return list;
	}
}
