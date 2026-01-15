package com.ymsli.day1;
/*
  	Q4. 2D Array – Pattern Triangle (Pascal-Style)
	Requirements Using a 2D array, print the following pattern:
	
	1
	1 2
	1 2 3
	1 2 3 4
	...
	1 2 3 4 5 6 7 8
	Notes
	
	This is not mathematical Pascal’s triangle.
	Must use nested loops and a 2D int[][] array.
	Common Mistakes
	
	Misaligned spacing
	Trailing spaces
	Incorrect array initialization
 */
public class Q04 {
	public static void main(String[] args) {
		int rows = 7;
		int [][] arr = new int[rows][rows];
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0 || j==i) arr[i][j] = 1;
				else {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
		}
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<rows-i-1; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<=i; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
