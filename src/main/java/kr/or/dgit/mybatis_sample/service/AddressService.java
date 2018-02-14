package kr.or.dgit.mybatis_sample.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dto.Address;
import kr.or.dgit.mybatis_study_util.MyBatisSqlSessionFactory;

public class AddressService {
	private static final Log log = LogFactory.getLog(AddressService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.AddressDao.";
	
	public List<Address> selectAddressByAllWithAPI(RowBounds rowBounds) {
		log.debug("selectAddressByAllWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectAddressByAllWithAPI", null, rowBounds);
		}
	}
	
	public List<Address> selectAddressLimitByAllWithAPI(Map<String, Integer> map) {
		log.debug("selectAddressLimitByAllWithApI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectAddressLimitByAllWithAPI", map);
		}
	}
}
