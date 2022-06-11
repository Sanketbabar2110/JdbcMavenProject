package com.jdbc.JdbcMavenPro;

public class Teacher {
	
	int TeacherId;
	String Name;
	String Department;
	String Subject;
	int Experience;
	
	public Teacher() {
		super();
	}
	
	public Teacher(int teacherId, String name, String department, String subject, int experience) {
		super();
		TeacherId = teacherId;
		Name = name;
		Department = department;
		Subject = subject;
		Experience = experience;
	}

	@Override
	public String toString() {
		return "[TeacherId : " + TeacherId + ", Name : " + Name + ", Department : " + Department + ", Subject : "
				+ Subject + ", Experience : " + Experience + "]";
	}

	public int getTeacherId() {
		return TeacherId;
	}

	public void setTeacherId(int teacherId) {
		TeacherId = teacherId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public int getExperience() {
		return Experience;
	}

	public void setExperience(int experience) {
		Experience = experience;
	}
}
