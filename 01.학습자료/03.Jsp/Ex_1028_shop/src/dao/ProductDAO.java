package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MybatisConnector;
import vo.ProductVO;

public class ProductDAO {
	static ProductDAO single = null;
	//
	public static ProductDAO getInstance() {
		if (single == null)
			single = new ProductDAO();
		return single;
	}
	//
	SqlSessionFactory factory = null;
	
	// 생성자
	public ProductDAO() {
		factory = MybatisConnector.getInstance().getFactory();
	}
	
	// 상품 조회
	public List<ProductVO> select(String category){
		List<ProductVO> list = null;
		SqlSession sqlSession = factory.openSession(); 
		list = sqlSession.selectList("pro.product_list", category);
		sqlSession.close();
		return list;
	}
	
	// 상품 등록
	public int insert(ProductVO vo) {
		// openSession의 true 값
		// 	- DML(insert, update, delete) 작업은 작업 후 커밋(Commit)을 하여 작업을 확정지어야하는데
		//	- true값이 이 기능을 대신한다.
		SqlSession sqlSession = factory.openSession(true);
		int cnt = sqlSession.insert("pro.product_insert", vo);
		sqlSession.close();
		return cnt;
	}
	
	// 상품 단건 조회
	public ProductVO selectone(int idx){
		ProductVO vo = null;
		SqlSession sqlSession = factory.openSession();
		vo = sqlSession.selectOne("pro.product_content", idx);
		sqlSession.close();
		return vo;
	}
}