package edu.nwtc.java.gpa;

public class Student {
	private String name;
	private String gradeLevel;
	private Grading[] grades;
	private double gpa;

	public Student(String name, String gradeLevel) {
		super();
		this.name = name;
		this.gradeLevel = gradeLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public Grading[] getGrades() {
		return grades;
	}

	public void setGrades(Grading[] grades) {
		this.grades = grades;
	}

	public double getGpa() {
		double total = 0.0;

		for (Grading g: grades) {
			total += g.value() * 3.0;
		}
		
		double units = 3.0 * grades.length;
		
		gpa = total / units;
		
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
