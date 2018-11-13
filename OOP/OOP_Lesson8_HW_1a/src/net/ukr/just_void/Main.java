package net.ukr.just_void;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
//		Group gr = new Group("Gr401");
//		populateGroup(gr);
//		gr.deleteStudent(0);
//		gr.deleteStudent(7);
//		System.out.println("Now listing all students...");
//		System.out.println(gr.toString());
		
//		checkSorting(gr); // Check Sorting via Lambda with configurable search parameters

//		checkManualInput(gr);	// Check Manual Input

//		Comissar comissar = new Comissar();		// Check Comissar class
//		System.out.println(Arrays.toString(comissar.conscript(gr)));

//		checkManualToFile(gr); // Check Manual Group to/from File via Controller and Group DAO

		Faculty fc = new Faculty("IT Faculty");
//		fc.addGroup(gr);		
//		fc.groupToFile(0);
		fc.groupFromFile("Gr401");
		System.out.println(fc.getGroupList()[0]);
		System.out.println(fc.getGroupList()[0]);
		System.out.println(fc.getGroupList()[0].getStudentList()[0].getSex());

	}

	public static void populateGroup(Group group) {
		Student martinJ = new Student("Jake", "Martin", Sex.Male, 22, 4, 92.5);
		Student martinJ1 = new Student("Jake", "Martin", Sex.Male, 22, 4, 92.5);
		Student reedD = new Student("Derek", "Reed", Sex.Male, 22, 5, 96);
		Student sarahP = new Student("Sarah", "Patrick", Sex.Female, 21, 4, 78.7);
		Student GreenM = new Student("Mick", "Green", Sex.Male, 21, 4, 68.2);
		Student hillM = new Student("Mary", "Hill", Sex.Female, 21, 4, 90.1);
		Student markV = new Student("Mark", "Vince", Sex.Male, 23, 4, 62);
		Student derekP = new Student("Derek", "Peterson", Sex.Male, 22, 4, 76.5);
		Student annaM = new Student("Anna", "Ming", Sex.Female, 21, 4, 61.8);
		Student jakeS = new Student("Jake", "Shade", Sex.Male, 23, 4, 100);
		Student mannyB = new Student("Manny", "Boyde", Sex.Female, 21, 4, 84.1);
		Student hillB = new Student("Barbara", "Hill", Sex.Female, 21, 4, 99.6);
		Student[] students = { martinJ, reedD, sarahP, GreenM, hillM, markV, derekP, annaM, jakeS, hillB };

		for (Student i : students) {
			try {
				group.addStudent(i);
			} catch (GroupFullException e) {
				e.printStackTrace();
			} catch (DuplicateStudentException e) {
				e.printStackTrace();
			}

		}
	}

	public static void checkSorting(Group group) {
		group.changeSortParameters();
		group.groupSortWithParameters();
		System.out.println(group.toString());
	}

	public static void checkManualInput(Group group) {
		try {
			group.addStudentManual();
		} catch (GroupFullException | DuplicateStudentException | InvalidInputException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		System.out.println(group.toString());
	}
	
	public static void checkManualToFile(Group group) {
		try {
			Controller ctr = new Controller();
			ctr.addGroup(group);
			ctr.groupToFile(group);
			Group gr1 = ctr.groupFromFile("Gr501");
			System.out.println(gr1.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
