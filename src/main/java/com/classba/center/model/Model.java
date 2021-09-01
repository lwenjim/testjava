package com.classba.center.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model
{
	protected String driver   = "com.mysql.cj.jdbc.Driver";
	protected String url      = "jdbc:mysql://127.0.0.1:3306/course_db";
	protected String user     = "root";
	protected String password = "123456!@#";

	public String getDriver()
	{
		return driver;
	}

	public void setDriver(String driver)
	{
		this.driver = driver;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException, UnsupportedEncodingException
	{
		Class.forName(this.getDriver());
		return DriverManager.getConnection(this.getUrl(), this.getUser(), URLEncoder.encode(this.getPassword(), "UTF-8"));
	}

	public ResultSet query(String sql) throws SQLException, ClassNotFoundException, UnsupportedEncodingException
	{
		return this.getConnection().createStatement().executeQuery(sql);
	}
}
