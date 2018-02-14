package kr.or.dgit.mybatis_sample;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_sample.dto.Course;
import kr.or.dgit.mybatis_sample.service.CourseService;

public class CourseServiceTest {
	private static CourseService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new CourseService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}
	
	@Test
	public void test1FindCoursesByConditionWithAPI() {
		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<>();
		map.put("tutorId",1);
		map.put("name","%java%");
		map.put("startDate",cal.getTime());
		
		List<Course> courses = service.selectCoursesByConditionWithAPI(map);
		Assert.assertNotNull(courses);
	}
	@Test
	public void test2FindCaseCoursesWithAPI() {
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("searchBy","Tutor");
		map.put("tutorId",1);
		List<Course> courses = service.selectCaseCoursesWithAPI(map);
		Assert.assertNotNull(courses);
		
		map.replace("searchBy", "CourseName");
		map.remove("tutorId");
		map.put("courseName", "%java%");
		courses = service.selectCaseCoursesWithAPI(map);
		Assert.assertNotNull(courses);
	}
	@Test
	public void test3FindWhereCoursesWithAPI() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Course> courses = service.selectWhereCoursesWithAPI(map);
		Assert.assertNotNull(courses);
		
		map.put("tutorId",1);
		courses = service.selectWhereCoursesWithAPI(map);
		
		
		map.put("courseName", "%java%");
		courses = service.selectWhereCoursesWithAPI(map);
		
		map.clear();
		map.put("endDate", new Date());
		courses = service.selectWhereCoursesWithAPI(map);
	}
}
