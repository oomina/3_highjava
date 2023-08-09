package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고
	Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
	- Map의 구조 : key값은 입력한 '이름'으로 사용하고 value값은 Phone클래스의 인스턴스로 한다. 
	예) HashMap<String, Phone> 변수명;
	
	- 아래의 메뉴를 구현한다. 
	1. 전화번호 등록
	2. 전화번호 수정
	3. 전화번호 삭제
	4. 전화번호 검색
	5. 전화번호 전체 출력
	0. 프로그램 종료
	---------------------------
	
	- 삭제, 검색 기능은 '이름'을 입력 받아 처리한다. 
	
	실행예시)
	---------------------------
	다음 메뉴를 선택하세요. 
	1. 전화번호 등록
	2. 전화번호 수정
	3. 전화번호 삭제
	4. 전화번호 검색
	5. 전화번호 전체 출력
	0. 프로그램 종료
	---------------------------
	번호입력 >> 1
	
	새롭게 등록할 전화번호 정보를 입력하세요.
	이 름 >> 홍길동
	전화번호 >> 010-1111-1111
	주 소 >> 대전시 중구 오류동
	
	'홍길동'씨의 전화번호 정보가 등록되었습니다. 
	
	---------------------------
	다음 메뉴를 선택하세요. 
	1. 전화번호 등록
	2. 전화번호 수정
	3. 전화번호 삭제
	4. 전화번호 검색
	5. 전화번호 전체 출력
	0. 프로그램 종료
	---------------------------
	번호입력 >> 1
	
	새롭게 등록할 전화번호 정보를 입력하세요.
	이 름 >> 홍길동
	
	'홍길동'은 이미 등록된 사람입니다. 
	
	---------------------------
	다음 메뉴를 선택하세요. 
	1. 전화번호 등록
	2. 전화번호 수정
	3. 전화번호 삭제
	4. 전화번호 검색
	5. 전화번호 전체 출력
	0. 프로그램 종료
	---------------------------
	번호입력 >> 5
	
	 ------------------------------------------
	 번호     이 름     전화번호        주 소
	  1     홍길동  010-1111-1111  대전시 중구 오류동
	 ~~~~
	 ~~~
	 ------------------------------------------
	 출력 완료...
	 
	 ---------------------------
	다음 메뉴를 선택하세요. 
	1. 전화번호 등록
	2. 전화번호 수정
	3. 전화번호 삭제
	4. 전화번호 검색
	5. 전화번호 전체 출력
	0. 프로그램 종료
	---------------------------
	번호입력 >> 0
	
	프로그램을 종료합니다...
	
*/

public class PhoneBookTest {
	Scanner scanner = new Scanner(System.in);
	HashMap<String, Phone> map = new HashMap<>();
	
	public static void main(String[] args) {
		new PhoneBookTest().select();
	}
	
	public void menu() {
		System.out.println("---------------------------");
		System.out.println("다음 메뉴를 선택하세요.");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("---------------------------");
		System.out.print("번호입력 >> ");
	}
	
	public void select() {
		
		boolean loop = true;
		
		while(loop) {
			menu();
			int num = scanner.nextInt();
			
			switch (num) {
			case 1 : 
				insert();
				break;
			case 2 : 
				update();
				break;
			case 3 : 
				delete();
				break;
			case 4 : 
				search();
				break;
			case 5 : 
				print();
				break;
			case 0 : 
				System.out.println();
				System.out.println("프로그램을 종료합니다");
				loop = false;
				break;
			default:
				break;
			}
		}
	}
	
	private void insert() {
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이 름 >> ");
		String name = scanner.next();
		if(map.containsKey(name)) {
			System.out.println();
			System.out.println("'" + name + "'씨는 이미 등록된 사람입니다.");
			return;
		}
		System.out.print("주 소 >> ");
		String address = scanner.next();
		System.out.print("전화번호 >> ");
		String phoneNum = scanner.next();
		map.put(name, new Phone(name, address, phoneNum));
		System.out.println();
		System.out.println("'" + name + "'씨의 전화번호 정보가 등록되었습니다.");
	}
	
	private void update() {
		System.out.println();
		System.out.println("수정할 사람의 이름을 입력하세요.");
		System.out.print("이 름 >> ");
		String name = scanner.next();
		if(!map.containsKey(name)) {
			System.out.println();
			System.out.println("'" + name + "'씨는 등록된 사람이 아닙니다.");
			return;
		}
		System.out.print("주 소 >> ");
		String address = scanner.next();
		System.out.print("전화번호 >> ");
		String phoneNum = scanner.next();
		map.put(name, new Phone(name, address, phoneNum));
		System.out.println();
		System.out.println("'" + name + "'씨의 전화번호 정보가 수정되었습니다.");
	}
	
	private void delete() {
		System.out.println();
		System.out.println("삭제할 사람의 이름을 입력하세요.");
		System.out.print("이 름 >> ");
		String name = scanner.next();
		if(!map.containsKey(name)) {
			System.out.println();
			System.out.println("'" + name + "'씨는 등록된 사람이 아닙니다.");
			return;
		}
		map.remove(name);
		System.out.println();
		System.out.println("'" + name + "'씨의 전화번호 정보가 삭제되었습니다.");
	}
	
	private void search() {
		System.out.println();
		System.out.println("검색할 사람의 이름을 입력하세요.");
		System.out.print("이 름 >> ");
		String name = scanner.next();
		if(!map.containsKey(name)) {
			System.out.println();
			System.out.println("'" + name + "'씨는 등록된 사람이 아닙니다.");
			return;
		}
		Phone p1 = map.get(name);
		
		System.out.println("---------------------------");
		System.out.println("이 름   전화번호    주 소");
		System.out.println("---------------------------");
		System.out.println(p1.getName()+" "+p1.getPhoneNum()+" "+p1.getAddress());
		System.out.println("---------------------------");
		System.out.println("출력 완료");
	}
	
	private void print() {
		Set<String> keyset = map.keySet();
		
		System.out.println("---------------------------");
		System.out.println("이 름   전화번호    주 소");
		System.out.println("---------------------------");
		for(String key : map.keySet()) {
			Phone value = map.get(key);
			System.out.println(value.getName()+" "+value.getPhoneNum()+" "+value.getAddress());
		}
		System.out.println("---------------------------");
		System.out.println("출력 완료");
	}
}

class Phone {
	private String name;
	private String address;
	private String phoneNum;
	
	public Phone(String name, String address, String phoneNum) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	@Override
	public String toString() {
		return "Phone [name=" + name + ", address=" + address + ", phoneNum=" + phoneNum + "]";
	}
}
