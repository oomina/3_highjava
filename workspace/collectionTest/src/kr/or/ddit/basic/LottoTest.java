package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class LottoTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int money = 0;
		boolean loop = true;
		
		while (loop) {
			System.out.println("==========================");
			System.out.println("Lotto 프로그램");
			System.out.println("--------------------------");
			System.out.println(" 1. Lotto 구입");
			System.out.println(" 2. 프로그램 종료");
			System.out.println("==========================");
			System.out.print("메뉴선택 : ");
			int num = scanner.nextInt();
			
			switch (num) {
			case 1:
				System.out.println();
				System.out.println("Lotto 구입 시작");
				System.out.println();
				System.out.println("(1000원에 로또번호 하나입니다.)");
				System.out.print("금액 입력 : ");
				money = scanner.nextInt();
				if (1000 <= money && money <= 100000) {
					System.out.println();
					System.out.println("행운의 로또번호는 아래와 같습니다.");
					for (int i = 1; i < money / 1000 + 1; i++) {
						HashSet<Integer> set = new HashSet<>();
						ArrayList<Integer> list = new ArrayList<>(set);
						while (set.size() < 6) {
							set.add(random.nextInt(45) + 1);
						}
						System.out.println("로또번호" + i + " : " + set);
					}
					System.out.println();
					System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " + money%1000 + "원입니다.");
					System.out.println();
				} else if (money < 1000) {
					System.out.println();
					System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
					System.out.println();
				} else {
					System.out.println();
					System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
					System.out.println();
				}
				break;
				
			case 2:
				System.out.println();
				System.out.print("감사합니다");
				loop = false;
				break;
			}
		}
	}
}
