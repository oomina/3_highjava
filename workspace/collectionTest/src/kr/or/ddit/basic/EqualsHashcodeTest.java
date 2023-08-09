package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;

public class EqualsHashcodeTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setNum(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
//		p2.setNum(2);
//		p2.setName("일지매");
		p2.setNum(1);
		p2.setName("홍길동");
		
		Person p3 = p1;
		
		System.out.println(p1 == p2); // false
		
		System.out.println(p1.equals(p2)); // false : 참조값이 다르기때문에 다른 객체임!!!
		System.out.println("--------------------------------");
		
		HashSet<Person> testSet = new HashSet<>();
		
		testSet.add(p1);
		testSet.add(p2);
		
		System.out.println("Set의 갯수 : " + testSet.size());
		
		System.out.println("--------------------------------");
		System.out.println("p1 : " + p1.hashCode());
		System.out.println("p2 : " + p2.hashCode());
		System.out.println("p3 : " + p3.hashCode());
	}
}

class Person {
	private int num;
	private String name;
	
	public Person() {	} // 기본 생성자
	
	public Person(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name) && num == other.num;
	}

	/*
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		
		if(obj==null) {
			return false;
		}
		
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		Person that = (Person) obj; // 매개변수의 값의 현재 객체 유형으로 형변환 한다. 
		
		if(that.name==null && that.name != null) {
			return false;
		}
		
		if(this.num == that.num && this.name == that.name) {
			return true;
		}
		
		if(this.num == that.num && this.name.equals(that.name)) {
			return true;
		}
		return false;
	}
	*/
}
