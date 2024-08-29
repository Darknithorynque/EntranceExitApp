package com.example.entrance_exit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EntranceExitApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntranceExitApplication.class, args);
		Fibonacci();
		Palindrome("olos","solo");
		SearchBinary(5);

	}
	// Online Java Compiler
// Use this editor to write, compile and run your Java code online


		//011235
		public static List<Integer> Fibonacci(){
			List<Integer> fibonacci = new ArrayList<>();
			fibonacci.add(0);
			fibonacci.add(1);
			int next;

			for(int i = 1; i<=10; i++){
				next = fibonacci.get(i-1) + fibonacci.get(i);
				fibonacci.add(next);
			}
			System.out.println(fibonacci);
			return fibonacci;
	}

	public static int SearchBinary(int num){
		//5
		int[] arr = {1,2,5,4,3};
		int index = 0;

		for(int i = 0; i< arr.length; i++){
			if(arr[i] == num){
				System.out.println(i);
				index = i;
			}
		}
		return index;
	}

		public static boolean Palindrome(String s1, String s2){
			char[] s2ToChar = s2.toCharArray();

			int charS2Length = s2ToChar.length;
			for(int i = charS2Length-1, j = 0; i >= 0; i--, j++ ){
				s2ToChar[j] = s2ToChar[i];
				System.out.println("hjhjjhjh:"+String.valueOf(s2ToChar[j])+s2ToChar[i]+j+i);

			}
			boolean result = new String(s2ToChar).equals(s1);
			System.out.println("reversed:"+String.valueOf(s2ToChar)+s1);

			return result;
		}

}
