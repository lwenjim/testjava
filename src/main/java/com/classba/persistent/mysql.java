package com.classba.persistent;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mysql
{
	public static void main(String[] args)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				PreparedStatement preparedStatement = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_db?useSSL=false", "root", "123456!@#").prepareStatement("select * from course_db.course limit ?");
				preparedStatement.setInt(1, 10);
				ResultSet         resultSet         = preparedStatement.executeQuery();
				while (resultSet.next()) {
					System.out.println(String.format("course_id:%s, course_name:%s", resultSet.getLong("course_id"), resultSet.getString("course_name")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}