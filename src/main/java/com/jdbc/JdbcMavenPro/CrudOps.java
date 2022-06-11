package com.jdbc.JdbcMavenPro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudOps {
	
	/**
	 * C --> Create new object and insert into table
	 * R --> Read/Write
	 * U --> Update
	 * D --> Delete
	 * 
	 * **/
	
	/*	>	method to insert Teacher object into database
	 *	>	returns true when teacher information successfully inserted into database
	 *		otherwise false
	 */
	
	public boolean insertTeacher(Teacher teacher) throws SQLException {
		
		Connection con = JdbcConnection.getdbConnection();
		
		String insertTeacherObjectQuery = "insert into Teacher values(?,?,?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(insertTeacherObjectQuery);
		
		stmt.setInt(1, teacher.getTeacherId());
		stmt.setString(2, teacher.getName());
		stmt.setString(3, teacher.getDepartment());
		stmt.setString(4, teacher.getSubject());
		stmt.setInt(5, teacher.getExperience());
		
		int update = stmt.executeUpdate();
		
		JdbcConnection.closeDbConnection();
		
		if(update>0)
		{
			System.out.println("Teacher information inserted into database successfully");
			return true;
		}
		else
			return false;
	}
	
	/*	>	method to retrieve teacher object from the database
	 * 	>	returns teacher object
	 */
	
	public Teacher getTeacherById(int teacherId) throws SQLException {
		
		Statement stmt =JdbcConnection.getdbConnection().createStatement();
		
		String setTeacher = "select*from Teacher where TeacherId = "+teacherId;

		ResultSet set = stmt.executeQuery(setTeacher);
		
		Teacher teacher = null;
		
			while(set.next()) {
				teacher = new Teacher(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5));
			}
		
		JdbcConnection.closeDbConnection();
		return teacher;
	}
	
	/*	>	It is used to update teacher information to the database
	 * 	>	returns true when teacher information successfully updated
	 */
	
	public boolean updateTeacher(Teacher teacher) throws SQLException {
		
		
		String updateTeacher = "UPDATE Teacher SET Name = ?, Department = ?, Subject = ?, Experience = ? WHERE TeacherId = ?";
		
		PreparedStatement stmt = JdbcConnection.getdbConnection().prepareStatement(updateTeacher);
		
		stmt.setString(1, teacher.getName());
		stmt.setString(2, teacher.getDepartment());
		stmt.setString(3, teacher.getSubject());
		stmt.setInt(4, teacher.getExperience());
		stmt.setInt(5, teacher.getTeacherId());
		
		int update = stmt.executeUpdate();
		
		JdbcConnection.closeDbConnection();
		
		if(update>0)
			return true;
		else
			return false;
	}
	
	/*	>	It is used to delete the teacher from the database
	 * 	>	returns true when teacher is removed from the database
	 */
	
	public boolean deleteTeacherById(int TeacherId) throws SQLException {
		
		String deleteTeacher = "DELETE FROM Teacher Where TeacherId = ?";
		
		PreparedStatement stmt = JdbcConnection.getdbConnection().prepareStatement(deleteTeacher);
		
		stmt.setInt(1, TeacherId);
		
		int update = stmt.executeUpdate();
		
		JdbcConnection.closeDbConnection();
		
		if(update>0)
			return true;
		else
			return false;
	}
}
