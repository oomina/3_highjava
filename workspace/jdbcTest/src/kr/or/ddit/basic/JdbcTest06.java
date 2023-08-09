package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
	회원을 관리하는 프로그램을 작성하시오.
	(MYMEMBER 테이블 이용)
	
	아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
	메뉴 예시)
	--------------
	1. 자료 추가		--> insert (C)
	2. 자료 삭제		--> delete (D)
	3. 자료 수정		--> update (U)
	4. 전체 자료 출력	--> select (R)
	0. 작업 끝.
	--------------
	
	조건)
	1) 자료 추가에서 '회원ID'는 중복되지 않는다.(중복되면 다시 입력 받는다.)
	2) 자료 삭제는 '회원ID'를 입력 받아서 처리한다.
	3) 자료 수정에서 '회원ID'는 변경되지 않는다.
	
*/

public class JdbcTest06 {
	
	Scanner scanner = new Scanner(System.in);
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
		new JdbcTest06().menu();
	}

	public void menu() {
		while (true) {
			System.out.println("----------------------");
			System.out.println("1. 자료 추가");
			System.out.println("2. 자료 삭제");
			System.out.println("3. 자료 수정 (전체항목수정)");
			System.out.println("4. 전체 자료 출력");
			System.out.println("5. 자료 수정2 (수정항목선택)");
			System.out.println("6. 자료 수정3 (입력항목만수정)");
			System.out.println("0. 작업 끝");
			System.out.println("----------------------");
			System.out.print("메뉴 선택 >> ");
			int num = scanner.nextInt();
			switch (num) {
			case 1 :
				insert();
				break;
			case 2 :
				delete();
				break;
			case 3 :
				update();
				break;
			case 4 :
				select();
				break;
			case 5 :
				update2();
				break;
			case 6 :
				update3();
				break;
			case 0 :
				System.out.println();
				System.out.println("프로그램을 종료합니다");
				return;
			default :
				System.out.println();
				System.out.println("번호를 다시 입력해주세요!");
				break;
			}
		}
	}
			
	private void insert() {
		try {
			conn = DBUtil.getConnection();
			
			String memId;
			int count = 0;
			
			do {
				System.out.print("회원ID 입력 >> ");
				memId = scanner.next();
				
				String sql = "select count(*) cnt from mymember where mem_id = ? ";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memId);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
				if(count == 1) {
					System.out.println("회원ID " + memId + "는(은) 이미 등록된 ID입니다.");
					System.out.println("다시 입력해주세요!");
				}
				
			} while(count == 1);
			System.out.print("비밀번호 입력 >> ");
			String memPass = scanner.next();
			System.out.print("이름 입력 >> ");
			String memName = scanner.next();
			System.out.print("전화번호 입력 >> ");
			String memTel = scanner.next();
			System.out.print("주소 입력 >> ");
			String memAddr = scanner.next();
			
			String sql2 = "insert into mymember (mem_id, mem_pass, mem_name, mem_tel, mem_addr) " + " values(?, ?, ?, ?, ?) ";
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, memId);
			pstmt.setString(2, memPass);
			pstmt.setString(3, memName);
			pstmt.setString(4, memTel);
			pstmt.setString(5, memAddr);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("등록 성공!!!");
			} else {
				System.out.println("등록 실패~~~");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); } catch(SQLException e) {}
			if(pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
	}
	
	private void delete() {
		try {
			conn = DBUtil.getConnection();
			
			System.out.print("회원ID 입력 >> ");
			String memId = scanner.next();
			
			String sql = "delete from mymember where mem_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("삭제 성공!!!");
			} else {
				System.out.println("삭제 실패~~~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
	}
	
	private void update() {
		try {
			conn = DBUtil.getConnection();
			
			System.out.print("회원ID 입력 >> ");
			String memId = scanner.next();
			System.out.print("비밀번호 입력 >> ");
			String memPass = scanner.next();
			System.out.print("이름 입력 >> ");
			String memName = scanner.next();
			System.out.print("전화번호 입력 >> ");
			String memTel = scanner.next();
			System.out.print("주소 입력 >> ");
			String memAddr = scanner.next();
			
			String sql = "update mymember set mem_pass = ?, mem_name = ?, mem_tel = ?, mem_addr = ? where mem_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memPass);
			pstmt.setString(2, memName);
			pstmt.setString(3, memTel);
			pstmt.setString(4, memAddr);
			pstmt.setString(5, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("수정 성공!!!");
			} else {
				System.out.println("수정 실패~~~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
	}
	
	private void select() {
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from mymember ";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println("아이디 : " + rs.getString("mem_id"));
				System.out.println("비밀번호 : " + rs.getString("mem_pass"));
				System.out.println("이름 : " + rs.getString("mem_name"));
				System.out.println("전화번호 : " + rs.getString("mem_tel"));
				System.out.println("주소 : " + rs.getString("mem_addr"));
				System.out.println("---------------------------------");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); } catch(SQLException e) {}
			if(pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
	}
	
	private void update2() {
		try {
			conn = DBUtil.getConnection();
			
			System.out.print("회원ID 입력 >> ");
			String memId = scanner.next();
			
			int num;
			String updateField = null;
			String updateFieldTitle = null;
			
			do {
				System.out.println(" 1.비밀번호  2.이름  3.전화번호  4.주소");
				System.out.print("수정할 항목을 선택 >> ");
				num = scanner.nextInt();
				
				switch (num) {
				case 1 :
					updateField = "mem_pass"; updateFieldTitle = "비밀번호";
					break;
				case 2 :
					updateField = "mem_name"; updateFieldTitle = "이름";
					break;
				case 3 :
					updateField = "mem_tel"; updateFieldTitle = "전화번호";
					break;
				case 4 :
					updateField = "mem_addr"; updateFieldTitle = "주소";
					break;
				default : 
					System.out.println("번호를 다시 입력해주세요!");
					break;
				}
			} while(num < 1 || num > 4);
			
			scanner.nextLine();
			System.out.print("새로운 " + updateFieldTitle + " >> ");
			String updateData = scanner.nextLine();
			
			String sql = "update mymember set " + updateField + " = ? where mem_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updateData);
			pstmt.setString(2, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("수정 성공!!!");
			} else {
				System.out.println("수정 실패~~~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
	}
	
	private void update3() {
		
	}
}
