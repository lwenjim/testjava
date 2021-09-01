package com.lwenjim.demo.servlet;

import com.library.Request;
import com.lwenjim.demo.Constant;
import com.lwenjim.demo.Pager;
import com.lwenjim.demo.model.Course;
import com.lwenjim.demo.service.SublistCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SublistCourseServlet", value = "sublist/SublistServlet")
public class SublistCourseServlet extends HttpServlet
{
	protected SublistCourseServiceImpl service = new SublistCourseServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Request newReq = new Request(req);
		Course  course = new Course();
		course.setCourseId(newReq.getLong("course_id"));
		course.setCourseName(newReq.getString("course_name"));
		Pager<Course> result = service.findCourse(course, getPage(newReq), getPageSize(newReq));
		req.setAttribute("result", result);
		req.getRequestDispatcher("sublistStudent.jsp").forward(req, resp);
	}

	protected int getPage(Request re)
	{
		return re.getInt("pageNum", Constant.DEFAULT_PAGE_NUM);
	}

	protected int getPageSize(Request re)
	{
		return re.getInt("pageSize", Constant.DEFAULT_PAGE_SIZE);
	}
}