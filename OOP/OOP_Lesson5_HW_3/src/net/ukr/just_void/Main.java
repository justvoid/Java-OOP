package net.ukr.just_void;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		Controller ctr = new Controller();
		Group gr = new Group("Gr401");
		ctr.addGroup(gr);

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
				gr.addStudent(i);
			} catch (GroupFullException e) {
				e.printStackTrace();
			} catch (DuplicateStudentException e) {
				e.printStackTrace();
			}

		}
		gr.deleteStudent(0);
		gr.deleteStudent(7);
//		System.out.println("Now listing all students...");
//		System.out.println(gr.toString());
//		gr.changeSortParameters();
//		gr.groupSortCompare();
//		System.out.println(gr.toString());
//		try {
//		gr.addStudentManual();
//		} catch (GroupFullException e) {
//			e.printStackTrace();
//		} catch (DuplicateStudentException e) {
//			e.printStackTrace();
//		} catch (InvalidInputException e) {
//			e.printStackTrace();
//		} catch (InputMismatchException e) {
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println(gr.toString());
//		gr.groupSortCompare();
//		System.out.println(gr.toString());
//		
//		System.out.println("------------");
//		
//		Comissar comissar = new Comissar();
//		System.out.println(Arrays.toString(comissar.conscript(gr)));
		

//		ctr.groupToFile(gr, ctr.getFileReadWriteInterface());
		Group gr1 = ctr.groupFromFile("Gr501", ctr.getFileReadWriteInterface());
		System.out.println(gr1.toString());
		
	}

}
