package com.lwenjim.demo.service;

import com.lwenjim.demo.Pager;
import com.lwenjim.demo.dao.CourseDao;
import com.lwenjim.demo.dao.SublistStudentDaoimpl;
import com.lwenjim.demo.model.Course;

public class SublistCourseServiceImpl implements CourseService
{
	protected CourseDao coursedao;

	public CourseDao getCoursedao()
	{
		return coursedao;
	}

	public void setCoursedao(CourseDao coursedao)
	{
		this.coursedao = coursedao;
	}

	public SublistCourseServiceImpl()
	{
		this.coursedao = new SublistStudentDaoimpl();
	}

	@Override
	public Pager<Course> findCourse(Course model, int pageNum, int pageSize)
	{
		return this.getCoursedao().findCourse(model, pageNum, pageSize);
	}
}
