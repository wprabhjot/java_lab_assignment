package com.ymsli.day1;

import java.util.InputMismatchException;
import java.util.Scanner;

/*'
	Requirements

	Prompt user for number of students.
	Collect grades into an int[].
	Each grade must be between 0 and 100.
	If invalid, print:
	Invalid grade. Try again.
	Compute and print the average.
	Sample Interaction
	
	Enter number of students: 3
	Enter grade for student 1: 55
	Enter grade for student 2: 108
	Invalid grade. Try again.
	Enter grade for student 2: 56
	Enter grade for student 3: 57
	Average: 56.0
	Corner Cases
	
	Number of students = 0 → show message and exit
	Reject negative grades
	Reject grades > 100

*/
public class Q02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalStudents=0;
		try {
			System.out.println("Enter number of students:");
			totalStudents = sc.nextInt();
			if(totalStudents==0) {
				System.out.println("Students can't be 0");
				return;
			}
		
		
			int[] grade = new int[totalStudents];
			double sum=0;
			int i=0;
			while(i<totalStudents) {
				
				try {
					System.out.println("Enter grade for student "+ (i+1) + ": ");
					
					grade[i] = sc.nextInt();
					if(grade[i]>=0 && grade[i]<=100) {
						sum+=grade[i];
						i++;
					}
					else {
						System.out.println("Invalid grade. Try again.");
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid grade. Try again.");
					sc.next();
				}
			}
			System.out.println("Average: "+ sum/totalStudents);
			
		} catch (InputMismatchException e) {
			System.out.println("Invalid number of students");
			sc.next();
		} finally {
			sc.close();
		}
	}
	
}
