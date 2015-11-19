package edu.nwtc.java.gpa;

public enum Grading implements Comparable<Grading> {
	A(4), B(3), C(2), D(1), F(0);
	
	private final int value;

	Grading(int value) {
		this.value = value;
	}
	
	public int value() {
		return value;
	}
}
