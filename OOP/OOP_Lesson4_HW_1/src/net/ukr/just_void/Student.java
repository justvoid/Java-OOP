package net.ukr.just_void;

import java.util.Objects;

public class Student extends Human implements Comparable {
	private int year;
	private double averageGrade;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String surname, Sex sex, int age) {
		super(name, surname, sex, age);
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String surname, Sex sex, int age, int year, double averageGrade) {
		super(name, surname, sex, age);
		this.year = year;
		this.averageGrade = averageGrade;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Student) {
			Student st = (Student) arg0;
			return ((super.getName() == st.getName()) && (super.getSurname() == st.getSurname())
					&& (super.getSex() == st.getSex()) && (super.getAge() == st.getAge()) && (this.year == st.getYear())
					&& (this.averageGrade == st.getAverageGrade()));
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + System.lineSeparator() + "YEAR: " + year + System.lineSeparator() + "AVERAGE GRADE: "
				+ averageGrade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.getName(), super.getSurname(), super.getSex(), super.getAge(), this.year,
				this.averageGrade);
	}

	@Override
	public int compareTo(Object o) {
		Student oStudent = (Student) o;
		return (this.getSurname() + this.getName()).compareToIgnoreCase(oStudent.getSurname() + oStudent.getName());
	}

}
