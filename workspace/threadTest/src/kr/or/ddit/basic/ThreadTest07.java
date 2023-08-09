package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

/*

	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오. 
	
	컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
	사용자의 가위 바위 보는 showInputDialog()메서드를 이용하여 입력 받는다. 
	
	입력 시간은 5초로 제한하고 카운트 다운을 진행 한다. 
	5초 안에 입력이 없으면 게임에 진것으로 처리한다. 
	
	5초 안에 입력이 완료되면 승패를 구해서 출력한다. 
	
	결과 예시)
	1) 5초안에 입력하지 못했을 경우
	   --- 결 과 ---
	   시간 초과로 당신이 졌습니다. 

	2) 5초 안에 입력했을 경우
	   --- 결 과 ---
	   컴퓨터 : 가위
	   사용자 : 바위
	   결 과 : 당신이 이겼습니다. 

*/

public class ThreadTest07 {

	public static void main(String[] args) {
		Thread th3 = new DataInput02();
		Thread th4 = new CountDown02();
		
		th3.start();
		th4.start();
	}
}

class DataInput02 extends Thread{
	
	public static boolean inputCheck = false;
	
	@Override
	public void run() {
		Random random = new Random();
		String str[] = {"가위", "바위", "보"};
		int a = random.nextInt(3) + 0;
		String com = str[a];
		String result = null;
		
		String user = JOptionPane.showInputDialog("가위 바위 보를 입력하세요");
		
		inputCheck = true;
		if(com.equals(user)) {
			result = "비겼습니다.";
		} else if(com.equals("가위") && user.equals("바위") ||
				com.equals("바위") && user.equals("보") ||
				com.equals("보") && user.equals("가위")) {
			result = "당신이 이겼습니다.";
		} else {
			result = "당신이 졌습니다.";
		}
		System.out.println("--- 결 과 ---");
		System.out.println("컴퓨터 : " + com);
		System.out.println("사용자 : " + user);
		System.out.println("결 과 : " + result);
	}
}

class CountDown02 extends Thread {
	@Override
	public void run() {
		for(int i=5; i>=1; i--) {
			if(DataInput.inputCheck==true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println("--- 결 과 ---");
		System.out.println("시간 초과로 당신이 졌습니다.");
		System.exit(0);
	}
}
