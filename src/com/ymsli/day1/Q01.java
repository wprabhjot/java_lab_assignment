package com.ymsli.day1;
/*
	Requirements
	
	Generate the first 20 Fibonacci numbers using iterative logic.
	Store all numbers in an array.
	Print the numbers in one line.
	Compute and print the average.
	Expected Output
	
	The first 20 Fibonacci numbers are:
	1 1 2 3 5 8 ... 6765
	Average: 885.5
 */
public class Q01 {
	public static void main(String[] args) {
		int size = 20;
		int[] arr =  new int[20];
		arr[1] = 1;
		float sum=0f;
		sum+= arr[0]+ arr[1];
		System.out.println("The first 20 Fibonacci numbers are:");
		
		System.out.print(arr[0] + " " + arr[1] + " ");
		for(int i=2; i<20; i++) {
			arr[i] = arr[i-1] + arr[i-2];
			sum+=arr[i];
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("\nAverage: "+ (sum/size));
		
//		int a = 1;
//		int b = 1;
//		float sum=2f;
//		System.out.println("The first 20 Fibonacci numbers are: ");
//		System.out.print(a + " ");
//		System.out.print(b + " ");
//		for(int i=0; i<18; i++) {
//			int num = a + b;
//			sum+=num;
//			a = b;
//			b = num;
//			System.out.print(num + " ");
//			
//		}
//		System.out.println("\nAverage: "+ (sum/20));
	}
	
}