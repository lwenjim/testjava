package com.classba.center;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class JdbcUtil
{
	private static String            USERNAME;
	private static String            PASSWORD;
	private static String            DRIVER;
	private static String            URL;
	private        Connection        connection;
	private        PreparedStatement pstmt;
	private        ResultSet         resultSet;

	static {
		loadConfig();
	}

	public static void loadConfig()
	{
		try {
			InputStream inStream = JdbcUtil.class.getResourceAsStream("/jdbc.properties");
			Properties  prop     = new Properties();
			prop.load(inStream);
			USERNAME = prop.getProperty("jdbc.username");
			PASSWORD = prop.getProperty("jdbc.password");
			DRIVER   = prop.getProperty("jdbc.driver");
			URL      = prop.getProperty("jdbc.url");
		} catch (Exception e) {
			throw new RuntimeException("读取数据库配置文件异常！", e);
		}
	}

	public JdbcUtil()
	{

	}

	public void initConnection()
	{
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			throw new RuntimeException("get connection error!", e);
		}
	}

	public boolean updateByPreparedStatement(String sql, List<?> params) throws Exception
	{
		pstmt = connection.prepareStatement(sql);
		int index = 1;
		if (params != null && !params.isEmpty()) {
			for (Object param : params) {
				pstmt.setObject(index++, param);
			}
		}
		return pstmt.executeUpdate() > 0;

	}

	public List<Map<String, Object>> findResult(String sql, List<?> params) throws SQLException
	{
		List<Map<String, Object>> list  = new ArrayList<>();
		int                       index = 1;
		pstmt = connection.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (Object param : params) {
				pstmt.setObject(index++, param);
			}
		}
		resultSet = pstmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();

		int cols_len = metaData.getColumnCount();
		while (resultSet.next()) {
			Map<String, Object> map = new HashMap<>();
			for (int i = 0; i < cols_len; i++) {
				String cols_name  = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}
				map.put(cols_name, cols_value);
			}
			list.add(map);
		}
		return list;
	}

	public void releaseConn()
	{
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args)
	{
		JdbcUtil jdbcUtil = new JdbcUtil();
		jdbcUtil.initConnection();
		try {
			List<Map<String, Object>> result = jdbcUtil.findResult("select course_id,course_name from course", null);
			for (Map<String, Object> m : result) {
				System.out.println(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.releaseConn();
		}
	}
}

