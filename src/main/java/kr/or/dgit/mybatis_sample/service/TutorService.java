package kr.or.dgit.mybatis_sample.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.Tutor;
import kr.or.dgit.mybatis_study_util.MyBatisSqlSessionFactory;

public class TutorService {
	private static final Log log = LogFactory.getLog(TutorService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.TutorDao.";
	
	
	public Tutor selectTutorByTutorId(Tutor tutor) {
		log.debug("selectTutorByTutorId()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			Tutor res = sqlSession.selectOne(namespace + "selectTutorByTutorId", tutor);
			sqlSession.commit();
			return res;
		}
	}
}
