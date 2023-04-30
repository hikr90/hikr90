package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.DBService;
import vo.MemberVO;

public class MemberDAO {
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static MemberDAO single = null;

	public static MemberDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new MemberDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	// 해당 비번과 아이디와 일치하는 사람이 있는지 확인
	// 파라미터로 id만 보내는 이유 : vo의 null유무로 아이디 존재 유무를 확인할 수 있는데 아이디랑 비번 둘중 뭐가 틀린건지 알기위해서 
	public MemberVO selectOne(String id) {

		MemberVO vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// (1) 해야할 것
		String sql = "select * from member where id = ?";

		try {
			//1.Connection얻어온다
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체정보를 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 설정
			// (2) sql문장에 넣어줄 변수 지정
			pstmt.setString(1, id);
			
			//4.결과행 처리객체 얻어오기
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new MemberVO();
				//현재레코드값=>Vo저장
				// (3) 아이디를 통해서 해당 유저의 이름과 비번정보를 가져옴
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
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
		// 아이디 검색 : vo는 null이 아님 아이디 검색 x : null
		return vo;
	}
}
