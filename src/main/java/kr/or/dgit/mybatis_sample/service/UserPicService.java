package kr.or.dgit.mybatis_sample.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.UserPic;
import kr.or.dgit.mybatis_study_util.MyBatisSqlSessionFactory;

public class UserPicService {
	private static final Log log = LogFactory.getLog(UserPicService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.UserPicDao.";

	
	public int insertUserPicWithAPI(UserPic userPic) {
		log.debug("insertUserPicWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "insertUserPicWithAPI", userPic);
		}
	}
	
	public UserPic getUserPicWithAPI(int id) {
		log.debug("getUserPicWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "getUserPicWithAPI", id);
		}
	}
	
}
