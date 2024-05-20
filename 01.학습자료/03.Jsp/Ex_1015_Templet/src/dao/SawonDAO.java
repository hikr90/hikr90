package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SawonVO;

public class SawonDAO {
	//
	static SawonDAO single = null;
	//
	public static SawonDAO getInstance() {
		//
		if (single == null)
			single = new SawonDAO();
		//
		return single;
	}

	// 목록 조회
	public List<SawonVO> selectList() {
		//
		List<SawonVO> list = new ArrayList<SawonVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//
		String sql = "select * from sawon";
		//
		try {
			//
			conn = DBService.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//
			while (rs.next()) {
				//
				SawonVO vo = new SawonVO();
				vo.setSabun(rs.getInt("sabun"));
				vo.setSaname(rs.getString("saname"));
				vo.setDeptno(rs.getInt("deptno"));
				vo.setSapay(rs.getInt("sapay"));
				//
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			//
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
		//
		return list;
	}
}
