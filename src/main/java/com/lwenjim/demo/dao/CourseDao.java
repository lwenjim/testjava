package com.lwenjim.demo.dao;

import com.lwenjim.demo.Pager;
import com.lwenjim.demo.model.Course;

public interface CourseDao
{
	public Pager<Course> findCourse(Course modle, int pageNum, int pageSize);
}
