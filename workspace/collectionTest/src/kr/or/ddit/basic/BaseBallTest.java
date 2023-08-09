package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/*
   문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
      (컴퓨터의 숫자는 난수를 이용하여 구한다. ( 1~9사이의 값 3개)
      (스트라이크는 S, 볼은 B로 나타낸다.)
   
   예시)
      컴퓨터 난수 ==> 9 5 7
   
   실행예시)
    숫자입력 >> 3 5 6
    3 5 6 ==> 1S 0B
    숫자입력 >> 7 8 9
    7 8 9 ==> 0S 2B
    숫자입력 >> 9 7 5
    9 7 5 ==> 1S 2B
    숫자입력 >> 9 5 7 
    9 5 7 ==> 3S 0B
    
    축하합니다...
    당신은 4번째 만에 맞췄습니다...

*/

public class BaseBallTest {
	
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<>();
		
		while(set.size() < 3) {
			set.add(random.nextInt(9) + 1);
		}
		
		ArrayList<Integer> computer = new ArrayList<>(set);
		ArrayList<Integer> user = new ArrayList<>();
		
		System.out.println("컴퓨터 난수 ==> " + computer);
		
		int count = 0;
		
		while(true) {
			int strike = 0;
			int ball = 0;
			user.clear();
			System.out.println();
			System.out.print("숫자입력 >> ");
			user.add(scanner.nextInt());
			user.add(scanner.nextInt());
			user.add(scanner.nextInt());
			System.out.print(user + " ==> ");
			for(int i = 0; i < computer.size(); i++) {
				if(computer.get(i) == user.get(i)) {
					strike++;
				}
				for(int j = 0; j < computer.size(); j++) {
					if(computer.get(i) != user.get(i) && computer.get(i) == user.get(j)) {
						ball++;
					}
				}
			}
			count++;
			if(strike == 3) {
				break;
			}
			System.out.println(strike + "S " + ball + "B");
		}
		System.out.println("축하합니다. 당신은 " + count + "번 만에 맞혔습니다.");
	}
}
