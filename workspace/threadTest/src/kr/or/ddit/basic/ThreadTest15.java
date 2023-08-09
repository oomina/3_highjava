package kr.or.ddit.basic;

import java.util.Arrays;
import java.util.Random;

public class ThreadTest15 {

	public static void main(String[] args) {
		Horse02[] horseArr = new Horse02[] {
				new Horse02("01번말"),new Horse02("02번말"),new Horse02("03번말"),
				new Horse02("04번말"),new Horse02("05번말"),new Horse02("06번말"),
				new Horse02("07번말"),new Horse02("08번말"),new Horse02("09번말"),new Horse02("10번말"),
		};
		GameState gs = new GameState(horseArr);
		
		for(Horse02 h : horseArr) {
			h.start();
		}
		gs.start();  // 말들의 현재 위치를 출력하는 쓰레드 시작
		
		for(Horse02 h : horseArr) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		try {
			gs.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println();
		System.out.println("경기 끝...");
		System.out.println();
		
		// 등수의 오름차순으로 정렬하기
		Arrays.sort(horseArr);  // 배열 정렬하기
		
		for(Horse02 h : horseArr) {
			System.out.println(h);
		}
	}
}

class Horse02 extends Thread implements Comparable<Horse02> {
	public static int currentRank = 0;  // 말의 등수를 구할 때 사용할 변수
	
	private String hname;  // 말이름
	private int rank;  // 등수
	private int location;  // 현재위치
	
	// 생성자
	public Horse02(String hname) {
		super();
		this.hname = hname;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "경주마 " + hname + "는(은) " + rank + "등 입니다.";
	}

	// 등수의 오름차순 정렬의 내부 정렬 기준
	@Override
	public int compareTo(Horse02 horse) {
		// TODO Auto-generated method stub
		return Integer.compare(this.rank, horse.getRank());
	}
	
	@Override
	public void run() {
		Random rnd = new Random();
		for(int i=1; i<=50; i++) {
			this.location = i;  // 말의 현재위치 저장
			try {
				Thread.sleep(rnd.nextInt(500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		// 한 마리의 말의 경주가 끝나면 현재의 등수를 구해서 저장한다. 
		currentRank++;
		this.rank = currentRank;
	}
}

/*
	경기 중간 중간에 각 말들의 위치를 아래와 같이 출력하는 쓰레드
	예시)
	말이름01 : ----->--------------------------
	말이름02 : ------>-------------------------
	말이름03 : -->-----------------------------
	...
	말이름10 : ------->------------------------
*/
class GameState extends Thread {
	private Horse02[] horseArr;  // 경주에 참가한 말들의 정보가 저장될 배열 변수 선언
	
	// 생성자
	public GameState(Horse02[] horseArr) {
		super();
		this.horseArr = horseArr;
	}
	
	@Override
	public void run() {
		while(true) {
			// 모든 말의 경주가 끝났는지 여부 검사
			if(Horse02.currentRank==horseArr.length) {
				break;
			}
			
			for(int i=1; i<=15; i++) {
				System.out.println();
			}
			
			for(int i=0; i<horseArr.length; i++) {
				System.out.print(horseArr[i].getHname() + " : ");
				
				for(int j=1; j<=50; j++) {
					if(horseArr[i].getLocation()==j) {  // 말의 현재위치 찾기
						System.out.print(">");
					} else {
						System.out.print("-");
					}
				}
				System.out.println();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}
