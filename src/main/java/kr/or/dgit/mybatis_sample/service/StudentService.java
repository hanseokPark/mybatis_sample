package kr.or.dgit.mybatis_sample.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.StudentDao;
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
	public List<Map<String, Object>> selectStudentByAllWithAPIForMap() {
		log.debug("selectStudentByAllWithAPIForMap()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAllWithAPIForMap();
		}
	}
	public Student selectStudentByNoForResultMapExtendsWithAPI(Student student) {
		log.debug("selectStudentByNoForResultMapExtendsWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNoForResultMapExtendsWithAPI(student);
		}
	}
	public Student selectStudentByNoAssociationWithAPI(Student student) {
		log.debug("selectStudentByNoAssociationWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNoAssociationWithAPI(student);
		}
	}
	
	public int insertEnumStudentWithAPI(Student student) {
		log.debug("insertEnumStudentWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.insertEnumStudentWithAPI(student);
		}
	}
	
	public Student selectAllStudentByStudentWithAPI(Student student) {
		log.debug("selectAllStudentByStudentWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectAllStudentByStudentWithAPI", student);
		}
	}
	public Student selectAllStudentByMapWithAPI(Map<String, String> map) {
		log.debug("selectAllStudentByMapWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectAllStudentByMapWithAPI", map);
		}
	}
	public Map<Integer, String> selectStudentForMapWithAPI() {
		log.debug("selectStudentForMapWithAPI()");
		Map<Integer, String> map = new HashMap<>();
		ResultHandler<Student> resultHandler = new ResultHandler<Student>() {
			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student = resultContext.getResultObject();
				map.put(student.getStudId(), student.getName());
			}
			
		};
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			sqlSession.select(namespace + "selectStudentForMapWithAPI", resultHandler);
			return map;
		}
		
	}
}
