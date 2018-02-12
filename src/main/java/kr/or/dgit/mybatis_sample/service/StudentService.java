package kr.or.dgit.mybatis_sample.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_study_util.MyBatisSqlSessionFactory;

public class StudentService {
	private static final Log log = LogFactory.getLog(StudentService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.StudentDao.";

	
	public Student findStudentByNoWithAPI(Student student) {
		log.debug("findStudentByNoWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectStudentByNoWithAPI", student);
		}
	}

	public List<Student> findStudentByAllWithAPI() {
		log.debug("findStudentByAllWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectStudentByAllWithAPI");
		}
	}

	public int insertStudentWithAPI(Student student) {
		log.debug("createStudentWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + "insertStudentWithAPI", student);
			sqlSession.commit();
			return res;
		}
	}
	public int updateStudentWithAPI(Student student) {
		log.debug("updateStudentWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.update(namespace + "updateStudentWithAPI", student);
			sqlSession.commit();
			return res;
		}
	}
	public int deleteStudentWithAPI(int studId) {
		log.debug("deleteStudentWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace + "deleteStudentWithAPI", studId);
			sqlSession.commit();
			return res;
		}
	}
	public List<Student> selectStudentByAllWithAPIForResultMap(){
		log.debug("selectStudentByAllWithAPIForResultMap()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectStudentByAllWithAPIForResultMap");
		}
	}
}
