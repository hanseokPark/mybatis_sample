package kr.or.dgit.mybatis_sample.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.mybatis_sample.dto.Student;

public interface StudentDao {
	//select
	Student selectStudentByNo(Student student);
	List<Student> selectStudentByAll();
	
	List<Student> selectStudentByAllForResultMap();
	
	List<Map<String, Object>> selectStudentByAllForHashMap();
	
	//resultMap Extends
	Student selectStudentByNoForResultMapExtends(Student student);
	
	//내포된 결과매핑(ResultMap)을 사용한 일대일 매핑
	Student selectStudentByNoAssociation(Student student);
	
	//여러 개의 입력 파라미터 전달
	Student selectAllStudentByParam(String name, String email);
	Student selectAllStudentByStudent(Student student);
	Student selectAllStudentByMap(Map<String, String> map);
	
	//insert
	int insertStudent(Student student);
	// enum 타입 다루기
	int insertEnumStudent(Student student);
	//update
	int updateStudent(Student student);
	//delete
	int deleteStudent(int studId);
	
	
}
