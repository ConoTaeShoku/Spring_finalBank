package h.h.bank.dao;

import java.util.List;

import h.h.bank.vo.Reply;

public interface ReplyDAO {

	public int insert(Reply r) throws Exception;

	public int update(Reply r) throws Exception;

	public int delete(int rnum) throws Exception;

	public List<Reply> rlist(int boardnum) throws Exception;

}
