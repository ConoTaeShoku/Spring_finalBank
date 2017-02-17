package h.h.bank.dao;

import java.util.List;

import h.h.bank.vo.Customer;

public interface CustomerDAO {

	public int insert(Customer c) throws Exception;

	public Customer login(String custid, String password) throws Exception;
	
	public Customer select(String custid) throws Exception;

	public int update(Customer c) throws Exception;

	public int delete(String custid, String password) throws Exception;

	public List<Customer> clist() throws Exception;

}
