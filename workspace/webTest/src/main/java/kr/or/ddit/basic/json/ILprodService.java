package kr.or.ddit.basic.json;

import java.util.List;

import kr.or.ddit.vo.LprodVO;

public interface ILprodService {
	
	/**
	 * Lprod테이블의 전체 데이터를 List에 담아서 반환하는 메서드
	 * 
	 * @return LprodVO가 저장된 List객체
	 */
	
	public List<LprodVO> getLprodList();

}
