package net.ukr.just_void;

import java.util.Arrays;
import java.util.Scanner;

public class Group implements Voenkom {
	private String name;
	private Student[] studentList = new Student[10];

	public Group() {
		super();
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public Student[] getStudentList() {
		return studentList;
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
			System.out.println("Added student " + student.getSurname() + " " + student.getName() + " to group " + name
					+ " to place " + emptyElementIndex);
		}
	}

	public void addStudentManual() throws GroupFullException, DuplicateStudentException, InvalidInputException {
		Scanner sc = new Scanner(System.in);
		Student newStudent;
		String newName, newSurname, newSexString;
		Sex newSex;
		int newAge, newYear;
		double newAverageGrade;
		System.out.println("Please enter student's personal information ");
		try {
			System.out.println("Name: ");
			newName = sc.nextLine();
			System.out.println("Surname: ");
			newSurname = sc.nextLine();
			System.out.println("Sex (M/F): ");
			newSexString = sc.nextLine();
			if (newSexString.equalsIgnoreCase("m")) {
				newSex = Sex.Male;
			} else if (newSexString.equalsIgnoreCase("f")) {
				newSex = Sex.Female;
			} else {
				throw new InvalidInputException("Sex must be entered either as M or F!");
			}
			System.out.println("Age: ");
			newAge = sc.nextInt();
			System.out.println("Year: ");
			newYear = sc.nextInt();
			System.out.println("Average grade: ");
			newAverageGrade = sc.nextDouble();
		} catch (InvalidInputException e) {
			System.out.println("Invalid input! Student not added.");
			throw e;
		} finally {
			sc.close();
		}
		newStudent = new Student(newName, newSurname, newSex, newAge, newYear, newAverageGrade);
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

	public void groupSort() {
		groupSortNull();
		boolean madeChanges;
		do {
			madeChanges = false;
			for (int i = 1; i < studentList.length; i++) {
				if ((studentList[i] != null) && (studentList[i - 1] != null)) {
					if ((studentList[i - 1].getSurname() + studentList[i - 1].getName())
							.compareTo(studentList[i].getSurname() + studentList[i].getName()) > 0) {
						Student buffer = studentList[i];
						studentList[i] = studentList[i - 1];
						studentList[i - 1] = buffer;
						madeChanges = true;
					}
				}
			}
		} while (madeChanges);
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

	public void groupSortCompare() {
		groupSortNull();
		Arrays.sort(studentList, 0, getStudentNumber());
	}

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
