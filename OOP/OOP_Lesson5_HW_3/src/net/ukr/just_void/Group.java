package net.ukr.just_void;

import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Group implements Voenkom {
	private String name;
	private Student[] studentList = new Student[10];

	private int ascendingSortOrder = 1;
	private int sortField = 0;

	public Group(String name) {
		super();
		this.name = name;
	}

	public Group(String name, Student[] studentList) {
		super();
		this.name = name;
		this.studentList = studentList;
	}

	public String getName() {
		return name;
	}

	public Student[] getStudentList() {
		return studentList;
	}

	public void setStudentList(Student[] studentList) {
		this.studentList = studentList;
	}

	public int getAscendingSortOrder() {
		return ascendingSortOrder;
	}

	public int getSortField() {
		return sortField;
	}

	@Override
	public String toString() {
//		groupSort();
		StringBuilder sb = new StringBuilder("-------" + name + "-------" + System.lineSeparator());
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i] != null) {
				sb.append(i + ". " + studentList[i].getSurname() + " " + studentList[i].getName()
						+ System.lineSeparator());
			}

		}
		sb.append("-------------------");
		return sb.toString();
	}

	public void addStudent(Student student) throws GroupFullException, DuplicateStudentException {
		int emptyElementIndex = -1;
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i] == null) {
				emptyElementIndex = (emptyElementIndex == -1) ? i : emptyElementIndex;
			} else if (studentList[i].equals(student)) {
				throw new DuplicateStudentException("The student " + student.getSurname() + " " + student.getName()
						+ " is already present in group " + name + "!");
			}

		}
		if (emptyElementIndex == -1) {
			throw new GroupFullException("Can't add " + student.getSurname() + " " + student.getName() + "! The group "
					+ name + " is already full.");
		} else {
			studentList[emptyElementIndex] = student;
			student.setGroup(this);
			System.out.println("Added student " + student.getSurname() + " " + student.getName() + " to group " + name
					+ " to place " + emptyElementIndex);
		}
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
			throws GroupFullException, DuplicateStudentException, InvalidInputException, IllegalArgumentException {
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
		try {
			addStudent(newStudent);
		} catch (GroupFullException e) {
			System.out.println("The group is full! Student not added.");
			throw e;
		} catch (DuplicateStudentException e) {
			System.out.println("Student already present in the group! Student not added.");
			throw e;
		}
	}

	public void deleteStudent(Student student) {
		boolean studentFound = false;
		for (int i = 0; i < studentList.length; i++) {
			if ((studentList[i] != null) && (studentList[i].equals(student))) {
				studentFound = true;
				studentList[i] = null;
				student.setGroup(null);
				System.out.println("Removed student " + student.getSurname() + " " + student.getName() + " from group "
						+ name + " place " + i);
			}
		}
		if (!studentFound) {
			System.out.println(
					"Student " + student.getSurname() + " " + student.getName() + " was not found in group " + name);
		}

	}

	public void deleteStudent(int index) {
		if (studentList[index] != null) {
			System.out.println("Removed student " + studentList[index].getSurname() + " " + studentList[index].getName()
					+ " from group " + name + " place " + index);
			studentList[index].setGroup(null);
			studentList[index] = null;
		} else {
			System.out.println("There is no student in the group " + name + " under the number " + index + " !");
		}
	}

	private void groupSortNull() {
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i] == null) {
				for (int j = studentList.length - 1; j > i; j--) {
					if (studentList[j] != null) {
						studentList[i] = studentList[j];
						studentList[j] = null;
						break;
					}
				}
			}
		}
	}

	private int getStudentNumber() {
		int n = 0;
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i] != null) {
				n++;
			}
		}
		return n;
	}

	// My sort implementation
//	public void groupSort() {
//		groupSortNull();
//		boolean madeChanges;
//		do {
//			madeChanges = false;
//			for (int i = 1; i < studentList.length; i++) {
//				if ((studentList[i] != null) && (studentList[i - 1] != null)) {
//					if ((studentList[i - 1].getSurname() + studentList[i - 1].getName())
//							.compareTo(studentList[i].getSurname() + studentList[i].getName()) > 0) {
//						Student buffer = studentList[i];
//						studentList[i] = studentList[i - 1];
//						studentList[i - 1] = buffer;
//						madeChanges = true;
//					}
//				}
//			}
//		} while (madeChanges);
//	}

	// Implementation via Comparable
//	public void groupSortCompare() {
//		groupSortNull();
//		Arrays.sort(studentList, 0, getStudentNumber());
//	}

	public void changeSortParameters() {
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
		}
	}

	// Implementation via Lambda with configurable search parameters
	public void groupSortWithParameters() {
		groupSortNull();
		Comparator<Student> cs;
		switch (sortField) {
		case 1: // Sort by Age
			cs = (s1, s2) -> ascendingSortOrder * (s1.getAge() - s2.getAge());
			break;
		case 2: // Sort by Average grade
			cs = (s1, s2) -> ascendingSortOrder * (Double.compare(s1.getAverageGrade(), s2.getAverageGrade()));
			break;
		case 3: // Sort by Year
			cs = (s1, s2) -> ascendingSortOrder * (s1.getYear() - s2.getYear());
			break;
		case 0: // Sort by Surname + Name; Default method! Falls through
		default:
			cs = (s1, s2) -> ascendingSortOrder
					* (s1.getSurname() + s1.getName()).compareToIgnoreCase(s2.getSurname() + s2.getName());
			break;
		}
		Arrays.sort(studentList, 0, getStudentNumber(), cs);
	}
	
	// Implementation via Lambda with configurable search parameters + CheckNull
//	public void groupSortWithParametersWithCheckNull() {
//		Comparator<Student> cs;
//		switch (sortField) {
//		case 1: // Sort by Age
//			cs = (s1, s2) -> CheckNull.checkNull(s1, s2)!=CheckNull.NOT_NULL?CheckNull.checkNull(s1, s2):ascendingSortOrder * (s1.getAge() - s2.getAge());
//			break;
//		case 2: // Sort by Average grade
//			cs = (s1, s2) -> CheckNull.checkNull(s1, s2)!=CheckNull.NOT_NULL?CheckNull.checkNull(s1, s2):ascendingSortOrder * (Double.compare(s1.getAverageGrade(), s2.getAverageGrade()));
//			break;
//		case 3: // Sort by Year
//			cs = (s1, s2) -> CheckNull.checkNull(s1, s2)!=CheckNull.NOT_NULL?CheckNull.checkNull(s1, s2):ascendingSortOrder * (s1.getYear() - s2.getYear());
//			break;
//		case 0: // Sort by Surname + Name; Default method! Falls through
//		default:
//			cs = (s1, s2) -> CheckNull.checkNull(s1, s2)!=CheckNull.NOT_NULL?CheckNull.checkNull(s1, s2):ascendingSortOrder
//					* (s1.getSurname() + s1.getName()).compareToIgnoreCase(s2.getSurname() + s2.getName());
//			break;
//		}
//		Arrays.sort(studentList, 0, getStudentNumber(), cs);
//	}

	public int[] findStudent(String surname) {
		int[] index = new int[studentList.length];
		int n = 0;
		for (int i = 0; i < studentList.length; i++) {
			if ((studentList[i] != null) && (studentList[i].getSurname() == surname)) {
				index[n++] = i;
			}
		}

		return Arrays.copyOf(index, n);
	}

	@Override
	public Student[] getConscripts() {
		Student[] conscripts = new Student[10];
		int n = 0;
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i] != null) {
				if ((studentList[i].getSex() == Sex.Male) && (studentList[i].getAge() >= 18)) {
					conscripts[n++] = studentList[i];
				}
			}
		}
		return Arrays.copyOf(conscripts, n);
	}

}
