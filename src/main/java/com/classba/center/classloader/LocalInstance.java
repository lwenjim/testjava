package com.classba.center.classloader;
import com.mysql.jdbc.Driver;

import java.sql.SQLException;

public class LocalInstance
{
	public static void main(String[] args)
	{
		try {
			new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
