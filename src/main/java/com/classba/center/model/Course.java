package com.classba.center.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity
@Table(name = "course")
public class Course implements Serializable
{

	@Id
	@GeneratedValue
	private Long   courseId;
	private String courseName;

	@Column
	public Long getCourseId()
	{
		return courseId;
	}

	public void setCourseId(Long courseId)
	{
		this.courseId = courseId;
	}

	public String getCourseName()
	{
		return courseName;
	}

	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}

	public Course()
	{
		super();
	}

	@Override
	public String toString()
	{
		return "Course{" + "courseId=" + courseId + ", courseName='" + courseName + '\'' + '}';
	}

	public Course(Long courseId, String courseName)
	{
		super();
		this.courseId   = courseId;
		this.courseName = courseName;
	}

	public Course(Map<String, Object> map)
	{
		super();
		this.courseId   = (long) map.get("course_id");
		this.courseName = (String) map.get("course_name");
	}
}
