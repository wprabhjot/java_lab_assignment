package com.ymsli.day1;

import java.util.Scanner;

/*
	Q5. Next Date Calculator
	Requirements
	
	Input day, month, year from the user.
	Validate the date.
	Compute the next day’s date manually.
	Display both dates.
	Sample Output
	
	Enter day: 31
	Enter month: 12
	Enter year: 2022
	Today: 31/12/2022
	Next Date: 1/1/2023
	Validations Required
	
	Correct days for each month
	Leap year logic:
	(year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
	Month-end transitions
	Year-end transition
 */
public class Q05 {
	
	private static boolean isLeapYear(int year) {
		return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter day: ");
		int day = sc.nextInt();
		System.out.print("Enter month: ");
		int month = sc.nextInt();
		System.out.print("Enter year: ");
		int year = sc.nextInt();
		int[] calender = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(isLeapYear(year)) {
			calender[2]=29;
		}
		if(month>12 || month<=0) {
			System.out.println("Invalid month");
			return;
		}
		if(day>calender[month] || day<=0) {
			System.out.println("Invalid day");
			return;
		}
		
		int nextDay = day+1;
		int nextMonth = month, nextYear=year;
		if(nextDay>calender[month]) {
			nextDay=1;
			nextMonth++;
			if(nextMonth>12) {
				nextMonth=1;
				nextYear++;
			}
		}
		System.out.println("Today: "+ day+ "/"+month+ "/"+year);
		System.out.println("Next Date: "+ nextDay+ "/"+nextMonth+ "/"+nextYear);
		sc.close();
		
	}
}
