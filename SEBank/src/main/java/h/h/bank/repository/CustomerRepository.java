package h.h.bank.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import h.h.bank.dao.CustomerDAO;
import h.h.bank.vo.Customer;

@Repository
public class CustomerRepository {

	@Autowired
	SqlSession sqlSession;

	public int insert(Customer c) {
		CustomerDAO cd = sqlSession.getMapper(CustomerDAO.class);
		int result = 0;
		try {
			result = cd.insert(c);
		} catch (Exception e ) {
			return 0;
		}
		return result;
	}
	
	public Customer login(String custid, String password) {
		CustomerDAO cd = sqlSession.getMapper(CustomerDAO.class);
		Customer result = null;
		try {
			result = cd.login(custid, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Customer select(String custid) {
		CustomerDAO cd = sqlSession.getMapper(CustomerDAO.class);
		Customer result = null;
		try {
			result = cd.select(custid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int update(Customer c) {
		CustomerDAO cd = sqlSession.getMapper(CustomerDAO.class);
		int result = 0;
		try {
			result = cd.update(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
	public int delete(String custid, String password) {
		CustomerDAO cd = sqlSession.getMapper(CustomerDAO.class);
		int result = 0;
		try {
			result = cd.delete(custid, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Customer> clist() {
		CustomerDAO cd = sqlSession.getMapper(CustomerDAO.class);
		List<Customer> clist = null;
		try {
			clist = cd.clist();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clist;
	}

}
