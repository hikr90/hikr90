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
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static SungjukDAO single = null;

	public static SungjukDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new SungjukDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	public List<SungjukVO> selectList() {

		List<SungjukVO> list = new ArrayList<SungjukVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sungtb_view";

		try {
			//1.Connection얻어온다
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체정보를 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.결과행 처리객체 얻어오기
			rs = pstmt.executeQuery();

			while (rs.next()) {
				SungjukVO vo = new SungjukVO();
				//현재레코드값=>Vo저장
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setTotal(rs.getInt("tot"));
				vo.setNo(rs.getInt("no"));
				vo.setAvg(rs.getInt("avg"));
				vo.setRank(rs.getInt("rank"));
				//ArrayList추가
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}
	
	// 이름은 차후에 맞게 delete로 바꿔주자
	// 파라미터는 받는 파라미터 값과 동일한 자료형으로 해주면 된다.
	public int delete(int no) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// 파라미터 값쪽에는 ?를 
		// (1) 우리가 해야할 것
		String sql = "delete from sungtb where no = ?";

		try {
			//1.Connection획득
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체 획득
			pstmt = conn.prepareStatement(sql);
			// (2) 우리가 해야할 것 
			// pstmt : 물음표 채워야한다.
			// pstmt(물음표의 위치,변수값);
			pstmt.setInt(1, no);
			
			//3.pstmt parameter 채우기

			//4.DB로 전송(res:처리된행수)
			// (삭제) 쿼리문이 실행이 된다. 단, 값이 int로 반환된다. 35분
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 처리한 행수의 값이 나온다.
		return res;
	}
	
	
	public int insert(SungjukVO svo) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into sungtb values(seq_sungtb_no.nextVal,?,?,?,?)";

		try {
			//1.Connection획득
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체 획득
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, svo.getName());
			pstmt.setInt(2, svo.getKor());
			pstmt.setInt(3, svo.getEng());
			pstmt.setInt(4, svo.getMat());
			//3.pstmt parameter 채우기

			//4.DB로 전송(res:처리된행수)
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	
	public int update(SungjukVO svo) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update sungtb set name = ?, kor = ?, eng = ?, mat = ? where no = ?";

		try {
			//1.Connection획득
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체 획득
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, svo.getName());
			pstmt.setInt(2, svo.getKor());
			pstmt.setInt(3, svo.getEng());
			pstmt.setInt(4, svo.getMat());
			pstmt.setInt(5, svo.getNo());
			//3.pstmt parameter 채우기

			//4.DB로 전송(res:처리된행수)
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	
}
