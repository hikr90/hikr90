package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MybatisConnector;
import vo.CartVO;

public class CartDAO {
	static CartDAO single = null;

	public static CartDAO getInstance() {
		if (single == null)
			single = new CartDAO();
		return single;
	}
	
	SqlSessionFactory factroy;
	
	public CartDAO() {
		factroy = MybatisConnector.getInstance().getFactory();
	}
	
	// 회원별 장바구니 목록 (장바구니에는 물품이 하나만 들어갈리 없으니 SELECT를 사용해야한다.)
	public List<CartVO> select(int m_idx) {
		List<CartVO> list = null;
		SqlSession sqlSession = factroy.openSession();
		list = sqlSession.selectList("cart.cart_list",m_idx);
		sqlSession.close();
		return list;
	}
	
	// 회원별 장바구니 상품의 총계 (한 회원의 하나의 총합 금액만 가져와야하므로 SELECTONE을 사용한다.)
	public int selectTotalAmount(int m_idx) {
		SqlSession sqlSession = factroy.openSession();
		int total = sqlSession.selectOne("cart.total_amount", m_idx);
		sqlSession.close();
		return total;
	}
	
	// 상품 수량, 상품 번호, 유저 m_idx를 통해서 바꾸고자하는 수량을 업데이트한다. (유저 idx가 정해진 것이 없으므로 따로 따로 받는다.)
	public int update(int c_idx, int c_cnt, int m_idx) {
		SqlSession sqlSession = factroy.openSession(true);
		
		// MAP에 저장해서 다수의 데이터를 옮길 수 있다.
		// 만약 데이터 타입이 INTEGER만 있는 것이 아니라면 부모격인 OBJECT에 저장하여 두가지 이상의 데이터를 옮길 수 있다.
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("c_idx",c_idx);
		map.put("c_cnt",c_cnt);
		map.put("m_idx",m_idx);
		
		int res = sqlSession.update("cart.cart_cnt_update", map);
		sqlSession.close();
		return res;
	}
	
	// 삭제하기
	public int delete(int m_idx, int c_idx) {
		SqlSession sqlSession = factroy.openSession(true);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("c_idx", c_idx);
		map.put("m_idx", m_idx);
		int res = sqlSession.delete("cart_delete", map);
		sqlSession.close();
		return res;
	}
	
	// 장바구니에 등록된 상품이 있는지 검색
	public CartVO selectone(CartVO vo) {
		SqlSession sqlSession = factroy.openSession();
		CartVO resVo = sqlSession.selectOne("cart.cart_one", vo);
		sqlSession.close();
		return resVo;
	}
	
	// 장바구니에 중복된 상품이 없는 경우 상품 등록
	public int insert(CartVO vo) {
		SqlSession sqlSession = factroy.openSession(true);
		int res = sqlSession.insert("cart.cart_insert",vo);
		sqlSession.close();
		return res;
	}
}