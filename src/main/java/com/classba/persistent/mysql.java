package com.classba.persistent;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysql
{
	public static void main(String[] args) throws IOException
	{

	}

	protected void test() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		String    url       = "jdbc:mysql://localhost:3306/course_db?useUnicode=true&characterEncoding=UTF8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&useSSL=false";
		Statement statement = DriverManager.getConnection(url, "root", "123456!@#").createStatement();
		ResultSet rs        = statement.executeQuery("select * from course limit 100");
		while (rs.next()) {
			System.out.println(rs.getString("course_name").toString());
		}
		if (!statement.isClosed()) {
			statement.close();
		}
		System.out.println("ok");
	}

	protected void data()
	{
//		String            resource          = "mybatis-config.xml";
//		InputStream       inputStream       = Resources.getResourceAsStream(resource);
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//		DataSource         dataSource         = BlogDataSourceFactory.getBlogDataSource();
//		TransactionFactory transactionFactory = new JdbcTransactionFactory();
//		Environment        environment        = new Environment("development", transactionFactory, dataSource);
//		Configuration      configuration      = new Configuration(environment);
//		configuration.addMapper(CourseMapper.class);
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
//
//		try (SqlSession session = sqlSessionFactory.openSession()) {
//			CourseMapper mapper = session.getMapper(CourseMapper.class);
//			Course       course = mapper.selectCourse(760);
//			System.out.println(course.getCourseId());
//		}
	}
}