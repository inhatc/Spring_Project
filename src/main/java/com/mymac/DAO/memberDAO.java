package com.mymac.DAO;

import com.mymac.VO.*;

public interface memberDAO {
	
	public void insertMember(memberVO vo);
	
	public memberVO readMember(String userid)throws Exception;
	
	public memberVO readWithPW (String userid, String userpw) throws Exception;
	
	public void updateMember (String id) throws Exception;
	
}
