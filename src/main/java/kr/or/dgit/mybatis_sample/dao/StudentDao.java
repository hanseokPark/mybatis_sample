package kr.or.dgit.mybatis_sample.dao;

import java.util.List;
import java.util.Map;

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
	// insert
	int insertStudentWithAPI(Student student);
	// enum 타입 다루기
	int insertEnumStudentWithAPI(Student student);
	//update
	int updateStudentWithAPI(Student student);
	//delete
	int deleteStudentWithAPI(int studId);
	
	
}
