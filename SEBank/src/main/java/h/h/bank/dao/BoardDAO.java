package h.h.bank.dao;

import java.util.List;

import h.h.bank.vo.Board;

public interface BoardDAO {
	
	public int insert(Board b) throws Exception;

	public Board select(int boardnum) throws Exception;

	public int update(Board b) throws Exception;
	//이 경우도 동적 query가 필요 - 첨부파일을 올린 경우와 올리지 않은 경우를 구분하기 위함
	
	public int delete(Board b) throws Exception;

	public List<Board> blist() throws Exception;
	//public List<Board> list(String searchField, String searchText) throws Exception;
	//column명은 변수로 받을 수 없음
	// like 앞쪽에 있는 변수명은 외부에서 전달받은 값으로 못함
	// 동적 sql (=제어문이 있음, if문이 있음)
	
	public int getCount () throws Exception;
	//public int getCount (String searchField, String searchText) throws Exception;
	
	public int addHits (int boardnum) throws Exception;
}
