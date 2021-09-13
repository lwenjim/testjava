package com.classba.center.classloader;

import org.gjt.mm.mysql.Driver;

import java.sql.SQLException;

public class LocalForname
{
	public static void main(String[] args)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.DriverManager.registerDriver(new Driver());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
