package net.ukr.just_void;

import java.io.Serializable;

public class Human implements Serializable{
	private String name;
	private String surname;
	private Sex sex;
	private int age;

	public Human(String name, String surname, Sex sex, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.age = age;
	}

	public Human() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "FULL NAME: " + surname + " " + name + System.lineSeparator() + "SEX: " + sex + System.lineSeparator()
				+ "AGE:" + age;
	}

}
