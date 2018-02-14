package kr.or.dgit.mybatis_sample;

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

}
