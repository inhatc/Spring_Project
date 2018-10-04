package com.mymac.DAO;

import java.util.HashMap;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mymac.VO.memberVO;

@Repository
public class memberDAOImpl implements memberDAO {

	@Inject
	  private SqlSession session;

	  private static String namespace = "com.mymac.mapper.memberMapper";

	@Override
	public void insertMember(memberVO vo) {
		// TODO Auto-generated method stub
		session.insert(namespace+".insertMember", vo);
		
	}

	@Override
	public memberVO readMember(String id) throws Exception {
		// TODO Auto-generated method stub
		return (memberVO)session.selectOne(namespace+".selectMember", id);
	}

	@Override
	public memberVO readWithPW(String id, String pw) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("id", id);
		paramMap.put("pw", pw);
		return session.selectOne(namespace+".readWithPW",paramMap);
	}

	@Override
	public void updateMember(String id) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".updateMember", id);
	}
	
	

}
