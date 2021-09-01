package com.classba.persistent;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysql
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Statement statement = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_db?useUnicode=true&characterEncoding=UTF8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&useSSL=false", "root", "123456!@#").createStatement();
		ResultSet rs        = statement.executeQuery("select * from course limit 100");
		while (rs.next()) {
			System.out.println(rs.getString("course_name").toString());
		}
		if (!statement.isClosed()) {
			statement.close();
		}
		System.out.println("ok");
	}
}
