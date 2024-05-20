package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.PhotoVO;

@Repository
public class PhotoDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	// 파일 업로드
	public int insert_photo(PhotoVO vo){
		int res = sqlSession.insert("photo.insert_photo", vo);
		return res;
	}
	
}
