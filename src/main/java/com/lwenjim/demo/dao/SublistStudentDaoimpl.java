package com.lwenjim.demo.dao;

import com.lwenjim.demo.JdbcUtil;
import com.lwenjim.demo.Pager;
import com.lwenjim.demo.model.Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SublistStudentDaoimpl implements CourseDao
{
	@Override
	public Pager<Course> findCourse(Course modle, int pageNum, int pageSize)
	{
		List<Course> list = getList(modle);
		return new Pager<>(pageNum, pageSize, list);
	}

	protected static List<Course> getList(Course model)
	{
		ArrayList<Course> result    = new ArrayList<>();
		ArrayList<Object> paramList = new ArrayList<>();
		StringBuilder     sql       = new StringBuilder("select * from course where 1=1");
		if (model.getCourseName() != null && !model.getCourseName().equals("")) {
			sql.append(" and course_name like ?");
			paramList.add(String.format("%% %s %%", model.getCourseName()));
		}
		if (model.getCourseId() != null && model.getCourseId() > 0) {
			sql.append(" and course_id=?");
			paramList.add(model.getCourseId());
		}
		JdbcUtil jdbc = null;
		try {
			jdbc = new JdbcUtil();
			jdbc.getConnection();
			List<Map<String, Object>> mapList = jdbc.findResult(sql.toString(), paramList);
			if (mapList != null) {
				for (Map<String, Object> map : mapList) {
					Course course = new Course(map);
					result.add(course);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("查询所有数据异常", e);
		} finally {
			if (jdbc != null) {
				jdbc.releaseConn();
			}
		}
		return result;
	}

	public static void main(String[] args)
	{
		List<Course> list = getList(new Course());

	}
}
