package com.classba.center.service;

import com.classba.center.Pager;
import com.classba.center.model.Course;

public interface CourseService
{
	public Pager<Course> findCourse(Course model, int pageNum, int pageSize);
}
