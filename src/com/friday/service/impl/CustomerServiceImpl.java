package com.friday.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.friday.inter.CustomerMapper;
import com.friday.inter.ProductTypeMapper;
import com.friday.model.Customer;
import com.friday.service.CustomerService;
import com.friday.utils.SessionUtils;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<Customer> queryCustomer() throws Exception {
		SqlSession sqlSession = null;
		List<Customer> list = null;
		try {
			sqlSession = SessionUtils.getSession();
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			
			list = customerMapper.selectAll();
		} catch (Exception e) {
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		return list;
	}

	@Override
	public Customer queryCustomerById(int id) throws Exception {
		SqlSession sqlSession = null;
		Customer customer = null;
		try {
			sqlSession = SessionUtils.getSession();
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			
			customer = customerMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		return customer;
	}

	@Override
	public int modifyCustomer(Customer customer) throws Exception {
		SqlSession sqlSession = null;
		int ret = 0;
		try {
			sqlSession = SessionUtils.getSession();
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			
			customerMapper.updateByPrimaryKey(customer);

			sqlSession.commit();
			
			ret = 1;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		return ret;	
	}

	@Override
	public int deleteCustomer(int id) throws Exception {
		SqlSession sqlSession = null;
		int ret = 0;
		try {
			sqlSession = SessionUtils.getSession();
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			
			customerMapper.deleteByPrimaryKey(id);

			sqlSession.commit();
			
			ret = 1;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		return ret;	
	}

	@Override
	public int addCustomer(Customer customer) throws Exception {
		SqlSession sqlSession = null;
		int ret = 0;
		try {
			sqlSession = SessionUtils.getSession();
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			
			customerMapper.insert(customer);

			sqlSession.commit();
			
			ret = 1;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			SessionUtils.closeSession(sqlSession);
		}
		return ret;	
	}

}
