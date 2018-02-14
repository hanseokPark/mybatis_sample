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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)//이름순으로 정렬
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
	public void test1findAddressByAll() {
		RowBounds rowBounds = new RowBounds(0,3);
		List<Address> lists = service.findAddressByAll(rowBounds);
		Assert.assertNotNull(lists);
	}
	@Test
	public void test2selectAddressLimitByAll() {
		Map<String, Integer> map = new HashMap<>();
		map.put("offset", 0);
		map.put("limit", 3);
        List<Address> lists = service.selectAddressLimitByAll(map);
        System.out.println(lists.size());
        Assert.assertNotNull(lists);
	}
	@Test
	public void test3selectAddressLimitByAll() {
		Map<String, Integer> map = new HashMap<>();
		map.put("offset", 3);
		map.put("limit", 3);
        List<Address> lists = service.selectAddressLimitByAll(map);
        System.out.println(lists.size());
        Assert.assertNotNull(lists);

	}
}















