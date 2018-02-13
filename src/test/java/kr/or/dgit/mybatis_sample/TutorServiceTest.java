package kr.or.dgit.mybatis_sample;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_sample.dto.Tutor;
import kr.or.dgit.mybatis_sample.service.TutorService;

public class TutorServiceTest {
	private static TutorService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new TutorService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	
	@Test
	public void test1SelectTutorByTutorId() {
		Tutor findTutor = new Tutor();
		findTutor.setTutorId(1);
		Tutor tutor2 = service.selectTutorByTutorId(findTutor);
		
		Assert.assertEquals(1, tutor2.getTutorId());
		
	}
}
