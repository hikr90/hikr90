package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MybatisConnector;
import vo.CartVO;

public class CartDAO {
	static CartDAO single = null;
	//
	public static CartDAO getInstance() {
		if (single == null)
			single = new CartDAO();
		return single;
	}
	//
	SqlSessionFactory factroy;
	//
	public CartDAO() {
		factroy = MybatisConnector.getInstance().getFactory();
	}
	
	// 회원별 장바구니 목록
	public List<CartVO> select(int m_idx) {
		List<CartVO> list = null;
		SqlSession sqlSession = factroy.openSession();
		list = sqlSession.selectList("cart.cart_list",m_idx);
		sqlSession.close();
		return list;
	}
	
	// 회원별 장바구니 상품의 총계
	public int selectTotalAmount(int m_idx) {
		SqlSession sqlSession = factroy.openSession();
		int total = sqlSession.selectOne("cart.total_amount", m_idx);
		sqlSession.close();
		return total;
	}
	
	// 회원별 상품 수량 수정
	public int update(int c_idx, int c_cnt, int m_idx) {
		SqlSession sqlSession = factroy.openSession(true);
		
		// Map에 저장하여 여러 데이터를 전송
		//	- 제네릭타입을 <String, Object>로 하여 여러 타입의 데이터를 전송하는 것도 가능하다.
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("c_idx",c_idx);
		map.put("c_cnt",c_cnt);
		map.put("m_idx",m_idx);
		//
		int res = sqlSession.update("cart.cart_cnt_update", map);
		sqlSession.close();
		return res;
	}
	
	// 회원별 상품 삭제
	public int delete(int m_idx, int c_idx) {
		SqlSession sqlSession = factroy.openSession(true);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("c_idx", c_idx);
		map.put("m_idx", m_idx);
		int res = sqlSession.delete("cart_delete", map);
		sqlSession.close();
		return res;
	}
	
	// 장바구니 내 상품 조회
	public CartVO selectone(CartVO vo) {
		SqlSession sqlSession = factroy.openSession();
		CartVO resVo = sqlSession.selectOne("cart.cart_one", vo);
		sqlSession.close();
		return resVo;
	}
	
	// 장바구니 내 상품 등록
	public int insert(CartVO vo) {
		SqlSession sqlSession = factroy.openSession(true);
		int res = sqlSession.insert("cart.cart_insert",vo);
		sqlSession.close();
		return res;
	}
}