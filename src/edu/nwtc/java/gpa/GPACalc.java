package edu.nwtc.java.gpa;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GPACalc {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter student name: ");
		String studentName = input.nextLine();

		System.out.print("Enter the student's Grade Level: ");
		String gradeLevel = input.nextLine();

		System.out.print("Enter the number of classes: ");
		int numClasses = -1;
		while (numClasses == -1) {
			try {
				numClasses = input.nextInt();
				input.nextLine();
			} catch (InputMismatchException ex) {
				input.nextLine();
				System.out.print("Please enter an integer: ");
			}
		}

		Grading[] classGrade = new Grading[numClasses];

		for (int index = 0; index < numClasses; index++) {
			System.out.print("Enter the grade for class number " + index + ": ");
			Grading grade = null;
			while (grade == null) {
				try {
					grade = Grading.valueOf(input.nextLine().trim().toUpperCase().charAt(0) + "");
				} catch (IllegalArgumentException ex) {
					System.out.print("Error. Please enter a letter grade: ");
				}
			}
			classGrade[index] = grade;
		}

		Student s = new Student(studentName, gradeLevel);
		s.setGrades(classGrade);

		System.out.println("Number of classes: " + s.getGrades().length);
		System.out.format("%15s%15s\n", "Letter Grade", "Grade Points");

		for (int gradeIndex = 0; gradeIndex < s.getGrades().length; gradeIndex++) {
			System.out.format("%15s%15s\n", s.getGrades()[gradeIndex], (double) s.getGrades()[gradeIndex].value());
		}

		System.out.println();
		DecimalFormat format = new DecimalFormat("0.00");
		format.setRoundingMode(RoundingMode.FLOOR);
		System.out.format("%s - GPA: %s", s.getName(), format.format(s.getGpa()));

		input.close();
	}
}
