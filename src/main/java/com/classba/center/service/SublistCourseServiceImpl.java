package com.classba.center.service;

import com.classba.center.Pager;
import com.classba.center.dao.CourseDao;
import com.classba.center.dao.SublistStudentDaoimpl;
import com.classba.center.model.Course;

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
