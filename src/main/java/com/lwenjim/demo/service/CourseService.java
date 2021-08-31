package com.lwenjim.demo.service;

import com.lwenjim.demo.Pager;
import com.lwenjim.demo.model.Course;

import java.util.List;

public interface CourseService
{
	public Pager<Course> findCourse(Course model, int pageNum, int pageSize);
}
