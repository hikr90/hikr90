package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.DeptVO;

public class DeptDAO {
	
	// 싱글톤 패턴
	static DeptDAO single = null;

	public static DeptDAO getInstance() {
		//
		if (single == null)
			single = new DeptDAO();
		//
		return single;
	}
	
	// 목록 조회
	public List<DeptVO> selectList() {
		//
		List<DeptVO> list = new ArrayList<DeptVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//
		String sql = "select * from DEPT";
		//
		try {
			//
			conn = DBService.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//
			while (rs.next()) {
				DeptVO vo = new DeptVO();
				//
				vo.setDeptno(rs.getInt("deptno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));
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
