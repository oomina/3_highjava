package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
	10마리의 말들이 경주하는 프로그램 작성하기
	
	말은 Horse라는 이름의 쓰레드 클래스로 작성하는데
	이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다. 
	그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준을 갖고 있다. 
	(Comparable인터페이스 구현)
	
	경기 구간은 1 ~ 50구간으로 되어 있다. 
	경기가 끝나면 등수 순으로 출력한다. 
	
	경기 중간 중간에 각 말들의 위치를 아래와 같이 출력한다. 
	예시)
	말이름01 : ----->--------------------------
	말이름02 : ------>-------------------------
	말이름03 : -->-----------------------------
	...
	말이름10 : ------->------------------------
*/

public class ThreadTest14 {
	static int ranking = 1;
	
	public static void main(String[] args) {
		List<Horse> list = new ArrayList<>();
		
		list.add(new Horse("01번말"));
		list.add(new Horse("02번말"));
		list.add(new Horse("03번말"));
		list.add(new Horse("04번말"));
		list.add(new Horse("05번말"));
		list.add(new Horse("06번말"));
		list.add(new Horse("07번말"));
		list.add(new Horse("08번말"));
		list.add(new Horse("09번말"));
		list.add(new Horse("10번말"));
		
		for(Horse h : list) {
			h.start();
		}
		
		for(Horse h : list) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		Collections.sort(list);
		System.out.println("-- 경기 결과 --");
		for(Horse h : list) {
			System.out.println(h.getRanking() + "등 " + h.getHorseName());
		}
	}
}

class Horse extends Thread implements Comparable<Horse> {
	private String horseName;
	private int ranking;
	private int location;
	
	public Horse(String horseName) {
		this.horseName = horseName;
	}
	
	public String getHorseName() {
		return horseName;
	}
	
	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}
	
	public int getRanking() {
		return ranking;
	}
	
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	public int getLocation() {
		return location;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		for(int i=0; i<50; i++) {
			System.out.print(horseName + " : ");
			for(int j=0; j<i; j++) {
				System.out.print("-");
			}
			System.out.print(">");
			for(int j=49; j>i; j--) {
				System.out.print("-");
			}
			
			System.out.println();
			System.out.println();
			
			try {
				Thread.sleep(random.nextInt(300));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		setRanking(ThreadTest14.ranking);
		ThreadTest14.ranking++;
	}
	
	@Override
	public int compareTo(Horse hh) {
		if(ranking > hh.getRanking()) {
			return 1;
		}
		return -1;
	}
}
