package h.h.bank.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<Board> blist(String searchTitle, String searchText, int currentPage, int countPerPage) {
		BoardDAO bd = sqlSession.getMapper(BoardDAO.class);
		Map<String, Object> search = new HashMap<>();
		search.put("searchTitle", searchTitle);
		search.put("searchText", searchText);
		int start = (currentPage-1) *countPerPage +1;
		search.put("start", start);
		int end = start + countPerPage - 1;
		search.put("end", end);
		List<Board> boardList = null;
		try {
			boardList = bd.blist(search);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return boardList;
	}

	public int getCount(String searchTitle, String searchText) {
		BoardDAO bd = sqlSession.getMapper(BoardDAO.class);
		Map<String, String> search = new HashMap<>();
		search.put("searchTitle", searchTitle);
		search.put("searchText", searchText);
		int result = 0;
		try {
			result = bd.getCount(search);
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
