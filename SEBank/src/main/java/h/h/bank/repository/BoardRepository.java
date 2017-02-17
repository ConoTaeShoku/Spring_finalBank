package h.h.bank.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import h.h.bank.dao.BoardDAO;
import h.h.bank.vo.Board;

@Repository
public class BoardRepository {

	@Autowired
	SqlSession sqlSession;

	public int insert(Board b) {
		BoardDAO bd = sqlSession.getMapper(BoardDAO.class);
		int result = 0;
		try {
			result = bd.insert(b);
		} catch (Exception e) {
			return 0;
		}
		return result;
	}

	public Board select(int boardnum) {
		BoardDAO bd = sqlSession.getMapper(BoardDAO.class);
		Board result = null;
		try {
			result = bd.select(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int update(Board b) {
		BoardDAO bd = sqlSession.getMapper(BoardDAO.class);
		int result = 0;
		try {
			result = bd.update(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public int delete(Board b) {
		BoardDAO bd = sqlSession.getMapper(BoardDAO.class);
		int result = 0;
		try {
			result = bd.delete(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Board> blist() {
		BoardDAO bd = sqlSession.getMapper(BoardDAO.class);
		List<Board> blist = null;
		try {
			blist = bd.blist();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blist;
	}

	public int getCount() {
		BoardDAO bd = sqlSession.getMapper(BoardDAO.class);
		int result = 0;
		try {
			result = bd.getCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int addHits(int boardnum) {
		BoardDAO bd = sqlSession.getMapper(BoardDAO.class);
		int result = 0;
		try {
			result = bd.addHits(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
