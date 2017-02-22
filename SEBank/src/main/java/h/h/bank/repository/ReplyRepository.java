package h.h.bank.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import h.h.bank.dao.ReplyDAO;
import h.h.bank.vo.Reply;

@Repository
public class ReplyRepository {
	
	@Autowired
	SqlSession sqlSession;
	
	public int insert(Reply r) {		
		ReplyDAO rd = sqlSession.getMapper(ReplyDAO.class);
		int result = 0;
		try {
			result = rd.insert(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(Reply r) {		
		ReplyDAO rd = sqlSession.getMapper(ReplyDAO.class);
		int result = 0;
		try {
			result = rd.update(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int delete(int rnum) {		
		ReplyDAO rd = sqlSession.getMapper(ReplyDAO.class);
		int result = 0;
		try {
			result = rd.delete(rnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Reply> rlist(int boardnum) {		
		ReplyDAO rd = sqlSession.getMapper(ReplyDAO.class);
		ArrayList<Reply> rlist=new ArrayList<>();
		try {
			rlist = (ArrayList<Reply>) rd.rlist(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rlist;
	}

}
