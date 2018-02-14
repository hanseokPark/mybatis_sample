package kr.or.dgit.mybatis_sample.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;

import kr.or.dgit.mybatis_sample.dto.Student;

public interface StudentDao {
	// select
	Student selectStudentByNoWithAPI(Student student);
	List<Student> selectStudentByAllWithAPI();
	
	List<Student> selectStudentByAllWithAPIForResultMap();
	List<Map<String, Object>> selectStudentByAllWithAPIForMap();
	
	//resultMap Extends
	Student selectStudentByNoForResultMapExtendsWithAPI(Student student);
	//내포된 결과매핑(ResultMap)을 사용한 일대일 매핑
	Student selectStudentByNoAssociationWithAPI(Student student);
	//여러 개의 입력 파라미터 전달
	Student selectAllStudentByStudentWithAPI(Student student);
	Student selectAllStudentByMapWithAPI(Map<String, String> map);
	// ResultSet 처리방식의 재정의
	Map<Integer, String> selectStudentForMapWithAPI(ResultHandler<Student> student);
	
	// insert
	int insertStudentWithAPI(Student student);
	// enum 타입 다루기
	int insertEnumStudentWithAPI(Student student);
	//update
	int updateStudentWithAPI(Student student);
	//delete
	int deleteStudentWithAPI(int studId);
	
	
}
