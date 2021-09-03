package com.classba.persistent;

import com.classba.center.model.Course;
import org.apache.ibatis.annotations.Select;

public interface CourseMapper
{
	@Select("SELECT * FROM course WHERE course_id = #{course_id}")
	Course selectCourse(int course_id);
}
