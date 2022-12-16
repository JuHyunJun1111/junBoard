package com.junijunMall.controller;

import java.util.Scanner;

public class test {
	
	
	public static void main(String[] args) {
		 
        Scanner sc = new Scanner(System.in);
        
        int sum = 0;
        for(int i=0; i<5; i++) {
            System.out.print("숫자 5개를 입력하세요: ");
            int num = sc.nextInt();
            sum += num;
            System.out.println("출력: " + sum);
        }
        
    }
}


