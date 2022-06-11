package com.jdbc.JdbcMavenPro;

import java.sql.SQLException;

public class Main {
	public static void main(String[]args) {

		CrudOps crud = new CrudOps();
		
		Teacher t1 = new Teacher(1,"abc","Computer", "Fundamentals of computer",4);
		Teacher t2 = new Teacher(2,"pqr","Mechanical", "Basic Mechanical Engineering",6);
		Teacher t3 = new Teacher(3,"xyz","Computer", "Control Engineering",2);
		Teacher t4 = new Teacher(4, "ghi", "Mechanical", "Internal Cumbution Engine",8);
		
		//Test of inserting Teacher Objects into database
		
		try {
			crud.insertTeacher(t1);
			crud.insertTeacher(t2);
			crud.insertTeacher(t3);
			crud.insertTeacher(t4);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Test to get teacher Object from database
		
		try {
			System.out.println(crud.getTeacherById(1));
			System.out.println(crud.getTeacherById(2));
			System.out.println(crud.getTeacherById(3));
			System.out.println(crud.getTeacherById(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Update Teacher information by using TeacherId
		
		t2.setName("lmn");
		
		try {
			System.out.println(crud.updateTeacher(t2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Delete Teacher details from the database
		
		try {
			System.out.println(crud.deleteTeacherById(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
