package com.javalec.clac;

import java.util.Scanner;

public class calc {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int inputNum = sc.nextInt();
			
			if (inputNum == 0) {
				break;
			}
			
			System.out.println(inputNum % 2 == 0? "짝수" : "홀수");
		}
	}

}
