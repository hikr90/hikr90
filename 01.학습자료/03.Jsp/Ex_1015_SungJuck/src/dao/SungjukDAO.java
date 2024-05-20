package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SungjukVO;

public class SungjukDAO {
	
	/*	DAO
	 *		- Data Access Object
	 *		- 쿼리문을 통해서 실행된 결과를 List형식으로 돌려주는 클래스
	 */
	
	/*	싱글톤 패턴
	 * 		- 필요한 하나의 객체만 생성해두고 다른 클래스에서 같은 객체를 계속 사용하는 패턴
	 * 		- 객체 1개만 생성해서 지속적으로 사용
	 * 		- 서비스 클래스에서는 DB의 접속 과정을 담당한다.
	 */
	static SungjukDAO single = null;
	
	// getInstance로 객체를 생성한다.
	public static SungjukDAO getInstance() {
		// 생성되지 않았으면 객체 생성
		if (single == null)
			single = new SungjukDAO();
		// 생성된 객체정보를 반환
		return single;
	}
	
	// 목록 조회
	public List<SungjukVO> selectList() {
		//
		List<SungjukVO> list = new ArrayList<SungjukVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 쿼리문문
		String sql = "select * from sungtb_view";
		//
		try {
			// 커넥션 객체 생성
			conn = DBService.getInstance().getConnection();
			// 명령처리객체 생성
			pstmt = conn.prepareStatement(sql);
			// 결과 처리 객체 생성
			rs = pstmt.executeQuery();
			// 쿼리문 결과를 읽는다.
			while (rs.next()) {
				SungjukVO vo = new SungjukVO();
				// VO객체에 저장
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setTotal(rs.getInt("tot"));
				vo.setNo(rs.getInt("no"));
				vo.setAvg(rs.getInt("avg"));
				vo.setRank(rs.getInt("rank"));
				// ArrayList에 추가
				list.add(vo);
			}

		} catch (Exception e) {
			// e.printStackTrace은 예외를 출력하는 메소드이다.
			e.printStackTrace();
		} finally {
			// 연동 객체 종료
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				//
				e.printStackTrace();
			}
		}
		//
		return list;
	}
	
	// 삭제
	// 	- DML 기능은 변경되는 행의 수를 숫자로 반환한다.
	public int delete(int no) {
		//
		int res = 0;
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 쿼리문문 생성
		// 	- 물음표는 파라미터를 대신한다.
		String sql = "delete from sungtb where no = ?";
		//
		try {
			// 커넥션 생성
			conn = DBService.getInstance().getConnection();
			// 명령처리객체 생성
			pstmt = conn.prepareStatement(sql);
			// setInt 메소드를 통해서 파라미터의 값을 지정한다.
			// 	- setInt(?의 위치, 값)
			pstmt.setInt(1, no);
			
			// 쿼리문 동작
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			//
			e.printStackTrace();

		} finally {
			//
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				//
				e.printStackTrace();
			}
		}
		// 처리한 행수의 값이 나온다.
		return res;
	}
	
	// 등록
	public int insert(SungjukVO svo) {
		//
		int res = 0;
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 쿼리문문 생성
		String sql = "insert into sungtb values(seq_sungtb_no.nextVal,?,?,?,?)";
		//
		try {
			// 커넥션 생성
			conn = DBService.getInstance().getConnection();
			// 명령처리객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, svo.getName());
			pstmt.setInt(2, svo.getKor());
			pstmt.setInt(3, svo.getEng());
			pstmt.setInt(4, svo.getMat());

			// 쿼리문 동작
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			//
			e.printStackTrace();
		} finally {
			//
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				//
				e.printStackTrace();
			}
		}
		//
		return res;
	}
	
	// 수정
	public int update(SungjukVO svo) {
		//
		int res = 0;
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 쿼리문문 생성
		String sql = "update sungtb set name = ?, kor = ?, eng = ?, mat = ? where no = ?";
		//
		try {
			// 커넥션 생성
			conn = DBService.getInstance().getConnection();
			// 명령처리객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, svo.getName());
			pstmt.setInt(2, svo.getKor());
			pstmt.setInt(3, svo.getEng());
			pstmt.setInt(4, svo.getMat());
			pstmt.setInt(5, svo.getNo());

			// 쿼리문 동작
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			//
			e.printStackTrace();
			
		} finally {
			//
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				//
				e.printStackTrace();
			}
		}
		//
		return res;
	}
}
