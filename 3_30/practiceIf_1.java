package com.jacalec.base;

import java.util.Scanner;

public class practiceIf_1 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		pracIf3(sc);

	}
	
	public static void pracIf3(Scanner sc) {
		/*
		 성적을 입력하세요 :90 
		 귀하의 학점은 A학점 입니다.
		 90 : B, 80 : C, 40 : F
		 
		 */
		String grade = "";
		
		System.out.print("성적을 입력하세요 : ");
		int input = sc.nextInt();
		
		if ( input >= 90) {
			grade = "A";
		} else if (input >= 80) {
			grade = "B";
		} else if (input >= 70) {
			grade = "C";
		} else {
			grade = "F";
		}
		
		
		System.out.println("귀하의 학점은 "+grade+"학점 입니다.");
	}
	
	public static void pracIf2() {
		int price = 5000;
		
		if( price > 8000 ) {
			System.out.println("너무 비쌉니다");
		} else if (price > 5000) {
			System.out.println("조금 비싼편입니다.");			
		}else if (price > 3000) {
			System.out.println("적당한 금액 입니다.");
		}else {
			System.out.println("싼편 입니다.");			
		}
		System.out.println("구매 하시겠습니까?");	
	}
	
	public static void pracIf1() {
		int i = 10;
		int j = 20;
		int k = 10;
		// if #1
		
		
		// if #2
		if (i > j) {
			System.out.println("i는 j보다"+ (i-j) +" 만큼 큽니다.");
		} else if (i < j) {
			System.out.println("j는 i보다"+ (j-i) +" 만큼 큽니다.");
		} else {
			System.out.println("i와 j는 같습니다.");
		}
		
		System.out.println(">>> End <<<");
	}

}
