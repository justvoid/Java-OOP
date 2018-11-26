package net.ukr.just_void;

import java.io.Serializable;

public class Student extends Human implements Serializable {
	private static final long serialVersionUID = 1L;
	private int year;
	private double averageGrade;
	Group group = null;

	public Student() {
		super();
	}

	public Student(String name, String surname, Sex sex, int age) {
		super(name, surname, sex, age);
	}

	public Student(String name, String surname, Sex sex, int age, int year, double averageGrade) {
		super(name, surname, sex, age);
		this.year = year;
		this.averageGrade = averageGrade;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
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
				+ averageGrade + System.lineSeparator();
	}
}
