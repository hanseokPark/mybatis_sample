package kr.or.dgit.mybatis_sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_sample.dto.Address;
import kr.or.dgit.mybatis_sample.service.AddressService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressServiceTest {
	private static AddressService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new AddressService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	
	@Test
	public void test1FindAddressByAllWithAPI() {
		RowBounds rowBounds = new RowBounds(0, 3);
		List<Address> lists = service.selectAddressByAllWithAPI(rowBounds);
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test2FindAddressLimitByAllWithAPI() {
		Map<String, Integer> maps = new HashMap<>();
		maps.put("offset",0);
		maps.put("limit",3);
		List<Address> lists = service.selectAddressLimitByAllWithAPI(maps);
		System.out.println(lists.size());
	    Assert.assertNotNull(lists);
		
	}
}
