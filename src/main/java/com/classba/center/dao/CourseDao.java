package com.classba.center.dao;

import com.classba.center.Pager;
import com.classba.center.model.Course;

public interface CourseDao
{
	public Pager<Course> findCourse(Course modle, int pageNum, int pageSize);
}
