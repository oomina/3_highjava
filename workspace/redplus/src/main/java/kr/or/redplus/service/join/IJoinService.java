package kr.or.redplus.service.join;

import java.util.List;

import kr.or.redplus.vo.JoinVO;
import kr.or.redplus.vo.JoinZipVO;

public interface IJoinService {
	
	/**
	 * 회원가입
	 * @param vo
	 * @return
	 */
	public int insertClient(JoinVO vo);
	
	/**
	 * 회원가입
	 * @param vo
	 * @return
	 */
	public int insertMember(JoinVO vo);
	
	/**
	 * 아이디 중복확인
	 * @param id
	 * @return
	 */
	public String idCheck(String id);
	
	/**
	 * 동 이름으로 주소검색
	 * @param dong
	 * @return
	 */
	public List<JoinZipVO> selectByDong(String dong);
	
	/**
	 * 아이디 찾기
	 * @param vo
	 * @return
	 */
	public String findId(JoinVO vo);
	
	/**
	 * 비밀번호 찾기
	 * @param vo
	 * @return
	 */
	public String findPassword(JoinVO vo);
	
	/**
	 * 회원정보 조회
	 * @param vo
	 * @return
	 */
	public JoinVO memberInfo(JoinVO vo);
	
	/**
	 * 회원정보 수정
	 * @param vo
	 * @return
	 */
	public int updateMember(JoinVO vo);
	
	/**
	 * 회원가입전 중복된 회원 체크
	 * @param vo
	 * @return
	 */
	public int regnoChk(JoinVO vo);
	
}
