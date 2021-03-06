package com.mymac.DAO;

import java.util.List;

import com.mymac.VO.BoardVO;

public interface BoardDAO {
	
	public void create(BoardVO vo)throws Exception;
	public BoardVO read(Integer bno)throws Exception;
	public void update(BoardVO vo)throws Exception;
	public void delete(Integer bno)throws Exception;
	public List<BoardVO> listAll()throws Exception;
	public void increaseViewcnt(int bno) throws Exception;
}
