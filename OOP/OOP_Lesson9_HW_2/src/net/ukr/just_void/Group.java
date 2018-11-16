package net.ukr.just_void;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Group implements Voenkom, Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private Comparator<Student> cmp = new StudentComparator();
	private SortedSet<Student> studentSet = new TreeSet<>(cmp);

	public Group(String name) {
		super();
		this.name = name;
	}

	public Group(String name, SortedSet<Student> studentSet) {
		super();
		this.name = name;
		this.studentSet = studentSet;
	}

	public String getName() {
		return name;
	}

	public SortedSet<Student> getStudentSet() {
		return studentSet;
	}

	public void setStudentSet(SortedSet<Student> studentSet) {
		this.studentSet = studentSet;
	}

	@Override
	public String toString() {
		int i = 0;
		StringBuilder sb = new StringBuilder(
				"----------------------" + name + "----------------------" + System.lineSeparator());
		sb.append("#  Name\t\t\tSex\tAge\tGrade" + System.lineSeparator());
		for (Student student : studentSet) {
			sb.append(i++ + ". " + student.getSurname() + " " + student.getName());
			for (int j = 0; j < 20 - student.getSurname().length() - student.getName().length(); j++) {
				sb.append(" ");
			}
			sb.append(student.getSex() + "\t" + student.getAge() + "\t" + student.getAverageGrade()
					+ System.lineSeparator());
		}
		sb.append("-------------------------------------------------");
		return sb.toString();
	}

	public void addStudent(Student student) {
		studentSet.add(student);
	}

	private Student studentInfoManualInput() throws InvalidInputException, IllegalArgumentException {
		Scanner sc = new Scanner(System.in);
		String newName, newSurname;
		Sex newSex;
		int newAge, newYear;
		double newAverageGrade;
		System.out.println("Please enter student's personal information ");
		try {
			System.out.println("Name: ");
			newName = sc.nextLine();
			System.out.println("Surname: ");
			newSurname = sc.nextLine();
			System.out.println("Sex (Male/Female): ");
			newSex = Sex.valueOf(sc.nextLine());
			System.out.println("Age: ");
			newAge = sc.nextInt();
			System.out.println("Year: ");
			newYear = sc.nextInt();
			System.out.println("Average grade: ");
			newAverageGrade = sc.nextDouble();
		} catch (InvalidInputException e) {
			throw e;
		} catch (IllegalArgumentException e) {
			throw e;
		} finally {
			sc.close();
		}
		return new Student(newName, newSurname, newSex, newAge, newYear, newAverageGrade);
	}

	public void addStudentManual()
			throws ContainerFullException, DuplicateStudentException, InvalidInputException, IllegalArgumentException {
		Student newStudent;
		try {
			newStudent = studentInfoManualInput();
		} catch (InvalidInputException e) {
			System.out.println("Input mismatch! Student not added.");
			throw e;
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid mismatch! Student not added.");
			throw e;
		}
		addStudent(newStudent);
	}

	public void deleteStudent(Student student) {
		if (studentSet.remove(student)) {
			System.out.println(
					"Removed student " + student.getSurname() + " " + student.getName() + " from group " + name);
		} else {
			System.out.println(
					"Student " + student.getSurname() + " " + student.getName() + " was not found in group " + name);
		}
	}

	public void deleteStudent(int index) {
		Iterator<Student> iter = studentSet.iterator();
		int n = 0;
		Student student;
		while (iter.hasNext()) {
			student = iter.next();
			if (n++ == index) {
				System.out.println(
						"Removed student " + student.getSurname() + " " + student.getName() + " from group " + name);
				studentSet.remove(student);
				break;
			}
		}
	}

	private void changeSortParameters() {
		int sortField = 0;
		int ascendingSortOrder = 1;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Sorty by:" + System.lineSeparator() + "[0] Full name" + System.lineSeparator()
					+ "[1] Age" + System.lineSeparator() + "[2] Average grade" + System.lineSeparator() + "[3] Year");
			sortField = sc.nextInt();
			if ((sortField < 0) || (sortField > 3)) {
				throw new InvalidInputException("Out of range!");
			}
			System.out.println("Sort in ascending order? (true/false): ");
			ascendingSortOrder = sc.nextBoolean() ? 1 : -1;
		} catch (InputMismatchException e) {
			e.printStackTrace();
			System.out.println("Invalid input! Sorting by default parameters");
			sortField = 0;
			ascendingSortOrder = 1;
		} finally {
			sc.close();
			cmp = new StudentComparator(ascendingSortOrder, sortField);
		}
	}

	public void groupSortWithParameters() {
		changeSortParameters();
		SortedSet<Student> tmp = new TreeSet<Student>(cmp);
		tmp.addAll(studentSet);
		studentSet = tmp;
	}

	public Student[] findStudent(String surname) {
		Student[] index = new Student[studentSet.size()];
		int n = 0;
		for (Student student : studentSet) {
			if (student.getSurname() == surname) {
				index[n++] = student;
			}
		}
		return Arrays.copyOf(index, n);
	}

	@Override
	public Student[] getConscripts() {
		Student[] conscripts = new Student[studentSet.size()];
		int n = 0;
		for (Student student : studentSet) {
			if ((student.getSex() == Sex.Male) && (student.getAge() >= 18)) {
				conscripts[n++] = student;
			}
		}
		return Arrays.copyOf(conscripts, n);
	}

	public class StudentComparator implements Comparator<Student> {
		private int ascendingSortOrder;
		private int sortField;

		public StudentComparator() {
			super();
			ascendingSortOrder = 1;
			sortField = 0;
		}

		public StudentComparator(int ascendingSortOrder, int sortField) {
			super();
			this.ascendingSortOrder = ascendingSortOrder;
			this.sortField = sortField;
		}

		@Override
		public int compare(Student s1, Student s2) {
			switch (sortField) {
			case 1: // Sort by Age
				if ((s1.getAge() - s2.getAge()) != 0) {
					return ascendingSortOrder * (s1.getAge() - s2.getAge());
				} else {
					return (s1.getSurname() + s1.getName()).compareToIgnoreCase(s2.getSurname() + s2.getName());
				}
			case 2: // Sort by Average grade
				if (Double.compare(s1.getAverageGrade(), s2.getAverageGrade()) != 0) {
					return ascendingSortOrder * (Double.compare(s1.getAverageGrade(), s2.getAverageGrade()));
				} else {
					return (s1.getSurname() + s1.getName()).compareToIgnoreCase(s2.getSurname() + s2.getName());
				}
			case 3: // Sort by Year
				if (s1.getYear() - s2.getYear() != 0) {
					return ascendingSortOrder * (s1.getYear() - s2.getYear());
				} else {
					return (s1.getSurname() + s1.getName()).compareToIgnoreCase(s2.getSurname() + s2.getName());
				}
			case 0: // Sort by Surname + Name; Default method! Falls through
			default:
				return ascendingSortOrder
						* (s1.getSurname() + s1.getName()).compareToIgnoreCase(s2.getSurname() + s2.getName());
			}
		}
	}
}
