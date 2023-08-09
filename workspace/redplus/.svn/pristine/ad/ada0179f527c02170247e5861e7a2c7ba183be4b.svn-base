package kr.or.redplus.service.bloodStock;

import java.util.List;

import kr.or.redplus.vo.BdCardLssuedVO;
import kr.or.redplus.vo.Blood_stockVO;

public interface IBloodStockService {
	/**
	 * 오늘 날짜, 헌혈의집id 정보를 받고 현재 입고된 혈액코드 모두 출력하는 함수
	 * 
	 * @param vo 오늘 날짜, 헌혈의집id 정보
	 * @return 성공 시 모든 혈액재고 리턴, 실패 시 null
	 */
	public List<Blood_stockVO> AllStockList(Blood_stockVO vo);
	
	/**
	 * 오늘 날짜, 헌혈의집id 정보를 받고 현재 출고된 혈액코드 모두 출력하는 함수
	 * 
	 * @param vo 오늘 날짜, 헌혈의집id 정보
	 * @return 성공 시 모든 혈액재고 리턴, 실패 시 null
	 */
	public List<Blood_stockVO> AllResStockList(Blood_stockVO vo);
	
	/**
	 * 현재 재고등록을 하지 않는 혈액팩들을 보여주는 함수
	 * 
	 * @param bdh_id 병원아이디
	 * @return  재고등록을 하지않는 헌혈증 코드 반환
	 */
	public List<BdCardLssuedVO> NoStockList(String bdh_id);
	
	/**
	 * 아직 재고에 넣지 않은 혈액코드의 상세 내역을 반환하는 함수
	 * 
	 * @param bd_code 혈액코드
	 * @return 상제 내역 리턴
	 */
	public BdCardLssuedVO detailNoStock(String bd_code);
	
	/**
	 * 혈액재고 테이블을 저장하는 함수
	 * 
	 * @param vo 혈액재고테이블에 넣을 데이터
	 * @return 성공 시 : 1 , 실패 시 : 0
	 */
	public int stockSet(Blood_stockVO vo);
	
	/**
	 * 혈액의 지역을 반환하는 함수
	 * 
	 * @param bdh_id 반환할 헌혈의집 아이디
	 * @return 혈액의 지역
	 */
	public String getRegion(String bdh_id);
}
