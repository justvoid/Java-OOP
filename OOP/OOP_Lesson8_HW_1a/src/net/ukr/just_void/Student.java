package net.ukr.just_void;

import java.io.Serializable;
import java.util.Objects;

public class Student extends Human implements Serializable {
	private int year;
	private double averageGrade;
	Group group = null;

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
				+ averageGrade;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(super.getName(), super.getSurname(), super.getSex(), super.getAge(), this.year,
//				this.averageGrade);
//	}
//
//	@Override
//	public int compareTo(Object o) {
//		Student oStudent = (Student) o;
//		if (this.group == null) {
//			return (this.getSurname() + this.getName()).compareToIgnoreCase(oStudent.getSurname() + oStudent.getName());
//		} else {
//
//			switch (group.getSortField()) {
//			case 0: // Sort by Surname + Name
//				return this.group.getAscendingSortOrder() * (this.getSurname() + this.getName())
//						.compareToIgnoreCase(oStudent.getSurname() + oStudent.getName());
//			case 1: // Sort by Age
//				return this.group.getAscendingSortOrder() * (Integer.compare(this.getAge(), oStudent.getAge()));
//			case 2: // Sort by Average grade
//				return this.group.getAscendingSortOrder()
//						* (Double.compare(this.getAverageGrade(), oStudent.getAverageGrade()));
//			case 3: // Sort by Year
//				return this.group.getAscendingSortOrder() * (Integer.compare(this.getYear(), oStudent.getYear()));
//			default:
//				return this.group.getAscendingSortOrder() * (this.getSurname() + this.getName())
//						.compareToIgnoreCase(oStudent.getSurname() + oStudent.getName());
//			}
//		}
//	}
}
