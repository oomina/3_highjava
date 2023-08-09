package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao {
	private final Logger logger = Logger.getLogger(MemberDaoImpl.class);
	
	// 1번
	private static MemberDaoImpl dao;
	
	// 2번
	private MemberDaoImpl() { }
	
	// 3번
	public static MemberDaoImpl getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;  // 반환값이 저장될 변수
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성 성공....");
			
			String sql = "insert into mymember (mem_id, mem_pass, mem_name, mem_tel, mem_addr) values ( ?, ?, ?, ?, ? ) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_pass());
			pstmt.setString(3, memVo.getMem_name());
			pstmt.setString(4, memVo.getMem_tel());
			pstmt.setString(5, memVo.getMem_addr());
			
			logger.debug("PreparedStatement객체 생성");
			logger.debug("실행 SQL : " + sql);
			logger.debug("사용 데이터 : [" + memVo.getMem_id() + ", " + memVo.getMem_pass() + ", " + memVo.getMem_name()
			 				+ ", " + memVo.getMem_tel() + ", " + memVo.getMem_addr() + "]");
			
			cnt = pstmt.executeUpdate();
			logger.info("쿼리문 실행 성공~~~");
			
		} catch (SQLException e) {
			logger.error("insert 작업 실패!!!", e);
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); logger.info("PreparedStatement 객체 반납..."); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); logger.info("Connection 객체 반납..."); } catch (SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;  // 반환값이 저장될 변수
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성 성공....");
			
			String sql = "delete from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			logger.debug("PreparedStatement객체 생성");
			logger.debug("실행 SQL : " + sql);
			logger.debug("사용 데이터 : [" + memId + "]");
			
			cnt = pstmt.executeUpdate();
			logger.info("쿼리문 실행 성공~~~");
			
		} catch (SQLException e) {
			logger.error("delete 작업 실패!!!", e);
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); logger.info("PreparedStatement 객체 반납..."); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); logger.info("Connection 객체 반납..."); } catch (SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;  // 반환값이 저장될 변수
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성 성공....");
			
			String sql = "update mymember set mem_pass = ?, mem_name = ?, mem_tel = ?, mem_addr = ? where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_pass());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			pstmt.setString(5, memVo.getMem_id());
			
			logger.debug("PreparedStatement객체 생성");
			logger.debug("실행 SQL : " + sql);
			logger.debug("사용 데이터 : [" + memVo.getMem_pass() + ", " + memVo.getMem_name()
			 				+ ", " + memVo.getMem_tel() + ", " + memVo.getMem_addr() + ", " + memVo.getMem_id() + "]");
			
			cnt = pstmt.executeUpdate();
			logger.info("쿼리문 실행 성공~~~");
			
		} catch (SQLException e) {
			logger.error("update 작업 실패!!!", e);
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); logger.info("PreparedStatement 객체 반납..."); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); logger.info("Connection 객체 반납..."); } catch (SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> memList = null;  // 반환값이 저장될 변수
		
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성 성공....");
			
			String sql = "select * from mymember";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			memList = new ArrayList<>();  // List객체 생성
			while(rs.next()) {
				MemberVO memVo = new MemberVO();  // 1개의 레코드가 저장될 VO객체 생성
				
				// ResultSet의 데이터를 꺼내와 VO객체에 셋팅한다.
				memVo.setMem_id(rs.getString("mem_id"));
				memVo.setMem_pass(rs.getString("mem_pass"));
				memVo.setMem_name(rs.getString("mem_name"));
				memVo.setMem_tel(rs.getString("mem_tel"));
				memVo.setMem_addr(rs.getString("mem_addr"));
				
				// VO객체를 List에 추가한다.
				memList.add(memVo);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try { pstmt.close(); logger.info("PreparedStatement 객체 반납..."); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); logger.info("Connection 객체 반납..."); } catch (SQLException e) {}
		}
		
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;  // 반환값이 저장될 변수 선언
		
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성 성공....");
			
			String sql = "select count(*) cnt from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try { pstmt.close(); logger.info("PreparedStatement 객체 반납..."); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); logger.info("Connection 객체 반납..."); } catch (SQLException e) {}
		}
		
		return count;
	}
	
	@Override
	public int updateMember3(Map<String, String> dataMap) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;  // 반환값이 저장될 변수
		
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성 성공....");
			
			String temp = "";  // SQL문의 set 이후에 수정할 컬럼 설정하는 부분이 저장될 변수
			
			// Map의 정보 ==> key값 : 수정할 컬럼명(검색할 ID는 'memId'), value값 : 수정할 데이터값 (검색할 ID값 포함)
			
			/*
			for(String fieldName : dataMap.keySet()) {
				if(!"memId".equals(fieldName)) {
					if(!"".equals(temp)) {
						temp += ", ";
					}
					// temp += fieldName + " = ? ";
					// temp += fieldName + " = " + dataMap.get(fieldName);
					temp += fieldName + " = '" + dataMap.get(fieldName) + "'";
				}
			}
			
			String sql = "update mymember set " + temp + "where mem_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dataMap.get("memId"));
			//------------------------------------------------
			*/
			
			for(String fieldName : dataMap.keySet()) {
				// Map의 key값 중 'memId'는 검색할 ID값에 대한 정보이기 때문에 수정할 컬럼을 설정할 때는 포함하지 않는다.
				if(!"memId".equals(fieldName)) {
					if(!"".equals(temp)) {
						temp += ", ";
					}
					temp += fieldName + " = ?";
				}
			}
			
			String sql = "update mymember set " + temp + " where mem_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			int num = 1;
			for(String fieldName : dataMap.keySet()) {
				if(!"memId".equals(fieldName)) {
					pstmt.setString(num++, dataMap.get(fieldName));
				}
			}
			pstmt.setString(num, dataMap.get("memId"));
			
			//------------------------------------------------
			
			cnt = pstmt.executeUpdate();
			logger.info("쿼리문 실행 성공~~~");
			
		} catch (SQLException e) {
			logger.error("update 작업 실패!!!", e);
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); logger.info("PreparedStatement 객체 반납..."); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); logger.info("Connection 객체 반납..."); } catch (SQLException e) {}
		}
		
		return cnt;
	}
	
	
	// Map의 정보 ==> key값 : 수정할 컬럼명(field), 수정할 데이터(data), 검색할 회원ID(memId)
	@Override
	public int updateMember2(Map<String, String> paramMap) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;  // 반환값이 저장될 변수
		
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성 성공....");
			
			String sql = "update mymember set " + paramMap.get("field") + " = ? where mem_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramMap.get("data"));
			pstmt.setString(2, paramMap.get("memId"));
			
			cnt = pstmt.executeUpdate();
			logger.info("쿼리문 실행 성공~~~");
			
		} catch (SQLException e) {
			logger.error("update 작업 실패!!!", e);
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); logger.info("PreparedStatement 객체 반납..."); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); logger.info("Connection 객체 반납..."); } catch (SQLException e) {}
		}
		
		return cnt;
	}
}
