package com.mymac.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import com.mymac.VO.BoardVO;
import com.mymac.DAO.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public void regist(BoardVO board) throws Exception {
		dao.create(board);
	}
	
	@Override
	public BoardVO read(Integer bno) throws Exception {
		return dao.read(bno);
	}
	
	@Override
	public void modify(BoardVO board) throws Exception {
		dao.update(board);
	}
	
	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}
	
	 @Override
	    public void increaseViewcnt(int bno, HttpSession session) throws Exception {
	        long update_time = 0;
	        // ���ǿ� ����� ��ȸ�ð� �˻�
	        // ���ʷ� ��ȸ�� ��� ���ǿ� ����� ���� ���� ������ if���� ����X
	        if(session.getAttribute("update_time_"+bno) != null){
	                                // ���ǿ��� �о����
	            //update_time = (long)session.getAttribute("update_time_"+bno);
	        }
	        // �ý����� ����ð��� current_time�� ����
	        long current_time = System.currentTimeMillis();
	        // �����ð��� ��� �� ��ȸ�� ���� ó�� 24*60*60*1000(24�ð�)
	        // �ý�������ð� - �����ð� > �����ð�(��ȸ�� ������ �����ϵ��� ������ �ð�)
	        if(current_time - update_time > 5*1000){
	        	dao.increaseViewcnt(bno);
	            // ���ǿ� �ð��� ���� : "update_time_"+bno�� �ٸ������� �ߺ����� �ʰ� ����� ��
	            session.setAttribute("update_time_"+bno, current_time);
	            
	        }
	    }
}
