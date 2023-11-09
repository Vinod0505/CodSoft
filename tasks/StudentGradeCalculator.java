package tasks;

import java.util.Scanner;

class StudentGradeCalculator {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		//enter no of subjects and marks of the subject out of 100
		System.out.println("Enter how many subjects: ");
		int n= sc.nextInt();
		//to store marks of students with respect to subjects
		int[] marks = new int[n];
		for(int i=0;i<marks.length;i++) {
			System.out.println("Enter marks of "+(i+1)+" subject out of (100): ");
			marks[i]=sc.nextInt();
		}
		//sum of total marks
		int sum=0;
		for(int i=0;i<marks.length;i++) {
			sum=sum+marks[i];
		}
		System.out.println("Total marks obtained in "+n+ " Subjects:\n"+sum);
		//calculate average percentage of total marks out of n subjects
		double avgPerc=sum/n;
		System.out.println("Average percentage: "+avgPerc);
		//assign grades based on percentage
		ifPerc(avgPerc);
		//if any subjects less than 35 you have failed
		for(int i=0;i<marks.length;i++) {
			if(marks[i]<35) {
				System.out.println("Failed");
				return;
			}
		}
	}

	private static void ifPerc(double perc) {
		if(perc<45)
			System.out.println("Grade : Fail");
		else if(perc<55)
			System.out.println("Grade : E ");
		else if(perc<65)
			System.out.println("Garde : D ");
		else if(perc<75)
			System.out.println("Grade : C ");
		else if(perc<85)
			System.out.println("Grade : B ");
		else if(perc<=100)
			System.out.println("Grade : A ");

	}
}
