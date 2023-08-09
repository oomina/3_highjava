package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTest02 {
	private HashMap<String, Phone02> phoneBookMap;
	private Scanner scan;
	
	public PhoneBookTest02() {
		phoneBookMap = new HashMap<>();
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new PhoneBookTest02().phoneBookStart();
	}
	
	public void phoneBookStart() {
		System.out.println("*********************************");
		System.out.println("     전 화 번 호 관 리 프 로 그 램");
		System.out.println("*********************************");
		System.out.println();
		
		while(true) {
			int choice = displayMenu();
			
			switch(choice) {
			case 1 : // 등록
				insert(); break;
			case 2 : // 수정
				update(); break;
			case 3 : // 삭제
				delete(); break;
			case 4 : // 검색
				search(); break;
			case 5 : // 전체출력
				displayAll(); break;
			case 0 : 
				System.out.println("프로그램을 종료합니다...");
				return;
			default : 
				System.out.println("번호를 잘못 입력했습니다. 다시 선택하세요...");
			}
		}
	}
	
	// 전화번호 정보를 검색하는 메서드
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요...");
		System.out.print("이 름 >> ");
		String name = scan.next();
		
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다...");
			return;
		}
		
		Phone02 p = phoneBookMap.get(name);
		System.out.println(name + "씨의 전화번호 정보");
		System.out.println("-------------------------");
		System.out.println("이 름 : " + p.getName());
		System.out.println("전 화 : " + p.getTel());
		System.out.println("주 소 : " + p.getAddr());
		System.out.println("-------------------------");
		System.out.println();
		
	}
	
	// 전화번호 정보를 삭제하는 메서드
	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요...");
		System.out.print("이 름 >> ");
		String name = scan.next();
		
		// 삭제할 대상이 있는지 검사
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 전화번호 정보가 등록되지 않은 사람입니다...");
			return;
		}
		
		phoneBookMap.remove(name);
		
		System.out.println(name + "씨의 전화번호 정보가 삭제되었습니다...");
		
	}
	
	// 전화번호 정보를 수정하는 메서드
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요...");
		System.out.print("이 름 >> ");
		String name = scan.next();
		
		// 수정할 대상이 등록되어 있지 않으면 수정 작업을 못한다.
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 전화번호 정보가 등록되지 않은 사람입니다...");
			return;
		}
		
		System.out.print("새로운 전화번호 >> ");
		String newTel = scan.next();
		
		scan.nextLine(); // 입력버퍼 지우기
		System.out.print("새로운 주소 >> ");
		String newAddr = scan.next();
		
		// 같은 key값에 새로운 전화번호 정보를 저장한다. ==> 수정작업
		phoneBookMap.put(name, new Phone02(name, newTel, newAddr));
		
		System.out.println(name + "씨의 전화번호 정보를 변경했습니다...");
	}
	
	// 전화번호 정보 전체를 출력하는 메서드
	private void displayAll() {
		System.out.println();
		System.out.println("--------------------------------------------");
		System.out.println("번호\t이 름\t전화번호\t주소");
		System.out.println("--------------------------------------------");
		
		Set<String> phoneKeySet = phoneBookMap.keySet();
		
		if(phoneKeySet.size()==0) {
			System.out.println("  등록된 전화번호 정보가 하나도 없습니다.");
		} else {
			int num = 0;
			for(String name : phoneKeySet) { // Set개수만큼 반복
				num++;
				Phone02 p = phoneBookMap.get(name); // value값(Phone객체) 구하기
				System.out.println(num + "\t" + p.getName() + "\t" + p.getTel() + "\t" + p.getAddr());
			}
		}
		System.out.println("--------------------------------------------");
		System.out.println("출력 끝...");
	}
	
	/*
	Scanner의 next(). nextInt(), nextDouble() 등...
		==> 사이띄기, Tab키, Enter키를 구분 문자로 분리해서 분리된 자료만 읽어간다. 
	Scanner의 nextLine()
		==> 한 줄 단위로 입력한다. 
			(즉, 자료를 입력하고 Enter키를 누르면 Enter키까지 읽어가서 Enter키를 뺀 나머지를 반환한다.)
	
	- 컴퓨터의 입력 작업은 입력된 데이터를 입력 버퍼에 저장하고 이것을 차례로 꺼내가는 
	  방법으로 처리된다. 
	  그래서 next(), nextInt()등과 같은 메서드를 실행한 후에 nextLine()을 사용할 때는 
	  입력 버퍼를 비워줘야 한다. (방법 : nextLine()을 한 번 더 사용한다.)
	  
	*/
	// 전화번호 정보를 등록하는 메서드
	
	private void insert() {
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		
		System.out.print("이 름 >> ");
		String name = scan.next();
		
		// 이미 등록된 사람인지 여부 검사
		if(phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 이미 등록된 사람입니다.");
			return;
		}
		
		System.out.print("전화번호 >> ");
		String tel = scan.next();
		
		scan.nextLine(); // 입력버퍼 지우기
		System.out.print("주 소 >> ");
		String addr = scan.nextLine();
		
//		Phone02 p = new Phone02(name, tel, addr);
//		phoneBookMap.put(name, p);
		
		phoneBookMap.put(name, new Phone02(name, tel, addr));
		
		System.out.println(name + "씨 전화번호 정보 등록 완료!!!");
	}
	
	
	// 메뉴를 출력하고 사용자가 입력한 작업 번호를 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("---------------------------");
		System.out.println("다음 메뉴를 선택하세요.");
		System.out.println(" 1. 전화번호 등록");
		System.out.println(" 2. 전화번호 수정");
		System.out.println(" 3. 전화번호 삭제");
		System.out.println(" 4. 전화번호 검색");
		System.out.println(" 5. 전화번호 전체 출력");
		System.out.println(" 0. 프로그램 종료");
		System.out.println("---------------------------");
		System.out.print("번호입력 >> ");
		return scan.nextInt();
	}
}

//이름, 주소, 전화번호를 멤버로 갖는 Phone클래스 작성

class Phone02 {
	private String name;
	private String tel;
	private String addr;

	public Phone02() {
	}

	public Phone02(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
}
