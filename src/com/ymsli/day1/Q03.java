package com.ymsli.day1;
/*
	Q3. Array Copy Method
	Task
	
	public static int[] copyOf(int[] array)
	Requirements
	
	Return a new independent array with the same values.
	Do not return the same reference.
	Demonstrate independence by modifying the copied array.
	Corner Cases
	
	Empty array → return new empty array
	Single-element array → return new array
 */

public class Q03 {
	public static int[] copyOf(int[] array) {
		int len = array.length;
		int[] arr = new int[len];
		for(int i=0; i<len; i++) {
			arr[i] = array[i];
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,5,10};
		int[] copyArr = copyOf(arr);
		System.out.println("Copy array elements are:");
		for(int i=0; i<arr.length; i++) {
			System.out.print(copyArr[i]+ ", ");
		}
	}
}
