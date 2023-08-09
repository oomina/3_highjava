package kr.or.ddit.basic.member.service;

import java.util.List;

import kr.or.ddit.vo.MemberVO;

public interface IMemberService {
public MemberVO getMember(String id);
	
	public List<MemberVO> getAllMember();
	
	public int insertMember(MemberVO vo);
	
	public int updateMember(MemberVO vo);
	
	public int deleteMember(String id);
	
	public int idCheck(String id);
}
