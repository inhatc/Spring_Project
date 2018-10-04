package com.mymac.service;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mymac.VO.*;

public interface BoardService {
	public void regist(BoardVO board)throws Exception;
	
	public BoardVO read(Integer bno)throws Exception;
	
	public void modify(BoardVO board)throws Exception;
	
	public void remove(Integer bno)throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public void increaseViewcnt(int bno, HttpSession session) throws Exception;
	
}