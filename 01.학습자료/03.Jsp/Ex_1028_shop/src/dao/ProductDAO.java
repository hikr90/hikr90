package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MybatisConnector;
import vo.ProductVO;

public class ProductDAO {
	static ProductDAO single = null;

	public static ProductDAO getInstance() {
		if (single == null)
			single = new ProductDAO();
		return single;
	}

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
	
	// 상품 등록 (제품의 정보를 통째로 넣기에 VO객체에 담아서 보낸다.)
	public int insert(ProductVO vo) {
		// OPSESSION의 경우 RUD(UPDATE, INSERT, DELETE)등의 작업은 COMMIT을 해줘야하는데 TRUE가 그 기능을 담당한다.
		SqlSession sqlSession = factory.openSession(true);
		int cnt = sqlSession.insert("pro.product_insert", vo);
		sqlSession.close();
		return cnt;
	}
	
	// IDX로 상품 한건에대한 정보만 가져오기
	public ProductVO selectone(int idx){
		// NULL은 안해도 상관없지만 혹시나 정보가 도달하지 않을 가능성을 대비
		ProductVO vo = null;
		SqlSession sqlSession = factory.openSession();
		vo = sqlSession.selectOne("pro.product_content", idx);
		sqlSession.close();
		return vo;
	}
}