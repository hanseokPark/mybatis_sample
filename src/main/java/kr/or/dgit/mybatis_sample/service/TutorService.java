package kr.or.dgit.mybatis_sample.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.TutorDao;
import kr.or.dgit.mybatis_sample.dto.Tutor;
import kr.or.dgit.mybatis_study_util.MyBatisSqlSessionFactory;

public class TutorService {
	private static final TutorService instance = new TutorService();
	private static final Log log = LogFactory.getLog(TutorService.class);
	
	public TutorService() {};
	
	public static TutorService getInstance() {
		return instance;
	}
	
	public Tutor selectTutorByTutorId(Tutor tutor) {
		log.debug("selectTutorByTutorId()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			TutorDao studentDao = sqlSession.getMapper(TutorDao.class);
			return studentDao.selectTutorByTutorId(tutor);
		}
	}


}
