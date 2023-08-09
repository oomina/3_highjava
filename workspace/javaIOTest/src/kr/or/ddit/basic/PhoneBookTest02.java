package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
	
	- 추가 조건)
	1) '6'. 전화번호 저장'메뉴를 추가하고 구현한다.
		(저장파일명은 'phoneData.bin)
	2) 프로그램이 시작될 때 저장된 파일이 있으면 그 데이터를 읽어와 Map에 저장한다.
	3) 프로그램을 종료할 때 Map의 데이터의 변화가 있으면
		(데이터의 추가, 수정, 삭제작업 후 저장하지 않은 상태) 자료를 저장한 후 종료되도록 한다.
	
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

public class PhoneBookTest02 {
	private HashMap<String, Phone02> phoneBookMap;
	private Scanner scan;
	private String fileName = "d:/d_other/phoneData.bin";  // 저장 파일명
	
	// 데이터의 변화가 있었는지 여부를 저장하는 변수
	// 데이터의 변화가 있으면 이 변수값이 true가 된다.
	private boolean isDataChange = false;
	
	// 생성자
	public PhoneBookTest02() {
//		phoneBookMap = new HashMap<>();
		phoneBookMap = load();  // 파일 내용을 읽어와 Map에 저장하기
		if(phoneBookMap == null) {  // 파일이 없을 때...
			phoneBookMap = new HashMap<>();
		}
		
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
			case 6 : // 저장
				save(); break;
			case 0 : 
				if(isDataChange==true) {
					System.out.println("변경된 자료가 있어서 저장 후 종료합니다...");
					save();
				}
				System.out.println("프로그램을 종료합니다...");
				return;
			default : 
				System.out.println("번호를 잘못 입력했습니다. 다시 선택하세요...");
			}
		}
	}
	
	// 파일로 저장된 전화번호 정보를 읽어와서 Map에 추가한 후 반환하는 메서드
	private HashMap<String, Phone02> load() {
		HashMap<String, Phone02> pMap = null;  // 반환값이 저장될 변수 선언
		
		File file = new File(fileName);
		if(!file.exists()) {  // 저장된 파일이 없으면...
			return null;
		}
		
		// 저장된 파일 있을 때 처리되는 영역...
		ObjectInputStream oin = null;
		try {
			// 입력용 스트림 객체 생성
			oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			
			// 파일에 저장된 데이터를 읽어와 Map객체에 저장하기
			
			// '방법1'로 저장했을 때 (Map 자체를 저장했을 때..)
			pMap = (HashMap<String, Phone02>) oin.readObject();
			
			// '방법2'로 저장했을 때
			Object obj = null;  // 읽어온 데이터가 저장될 변수
			pMap = new HashMap<>();  // 저장할 Map객체 생성
			while ( (obj=oin.readObject())!=null ) {
				Phone02 p = (Phone02) obj;
				pMap.put(p.getName(), p);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(oin!=null) try { oin.close(); } catch (IOException e) {}
		}
		
		return pMap;
	}
	
	// 전화번호 정보를 파일로 저장하는 메서드
	private void save() {
		ObjectOutputStream oout = null;
		try {
			// 객체 출력용 스트림 객체 생성
			oout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
			
			// Map에 저장된 전화번호 정보를 파일로 출력한다.
			oout.writeObject(phoneBookMap);  // Map객체 자체 저장하기 (방법1)
			
			// Map에 저장된 Phone객체를 하나씩 꺼내서 저장하기 (방법2)
			for(String name : phoneBookMap.keySet()) {
				Phone02 p = phoneBookMap.get(name);
				oout.writeObject(p);
			}
			oout.writeObject(null);
			
			System.out.println("저장이 완료되었습니다.");
			
			isDataChange = false;
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oout!=null) try { oout.close(); } catch (IOException e) {}
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
		
		isDataChange = true;
		
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
		String newAddr = scan.nextLine();
		
		// 같은 key값에 새로운 전화번호 정보를 저장한다. ==> 수정작업
		phoneBookMap.put(name, new Phone02(name, newTel, newAddr));
		
		System.out.println(name + "씨의 전화번호 정보를 변경했습니다...");
		
		isDataChange = true;
		
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
		
		isDataChange = true;
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
		System.out.println(" 6. 전화번호 저장");
		System.out.println(" 0. 프로그램 종료");
		System.out.println("---------------------------");
		System.out.print("번호입력 >> ");
		return scan.nextInt();
	}
}

//이름, 주소, 전화번호를 멤버로 갖는 Phone클래스 작성
class Phone02 implements Serializable {
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
