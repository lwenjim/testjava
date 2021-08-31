package com.lwenjim.demo.servlet;

import com.lwenjim.demo.Constant;
import com.lwenjim.demo.Pager;
import com.lwenjim.demo.StringUtil;
import com.lwenjim.demo.model.Course;
import com.lwenjim.demo.service.SublistCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SublistCourseServlet", value = "/sublist/SublistServlet")
public class SublistCourseServlet extends HttpServlet
{
	private static final long                     serialVersionUID     = -3658128508633145268L;
	protected            SublistCourseServiceImpl sublistCourseService = new SublistCourseServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String courseId   = req.getParameter("course_id");
		String courseName = req.getParameter("course_name");
		String pageNumStr = req.getParameter("pageNum");
		if (pageNumStr != null && StringUtil.isNum(pageNumStr)) {
			System.out.println("参数错误");
			return;
		}
		int pageNum = Constant.DEFAULT_PAGE_NUM;
		if (pageNumStr != null && !"".equals(pageNumStr)) {
			pageNum = Integer.parseInt(pageNumStr);
		}
		String pageSizeStr = req.getParameter("pageSize");
		if (pageSizeStr != null && !StringUtil.isNum(pageSizeStr)) {
			System.out.println("参数错误");
			return;
		}
		int pageSize = Constant.DEFAULT_PAGE_SIZE;
		if (pageSizeStr != null && !"".equals(pageSizeStr)) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		Course course = new Course();
		if (courseId != null && !"".equals(courseId)) {
			course.setCourseId(Long.parseLong(courseId));
		}
		course.setCourseName(courseName);
		Pager<Course> result = sublistCourseService.findCourse(course, pageNum, pageSize);
		req.setAttribute("result", result);
		req.getRequestDispatcher("sublistStudent.jsp").forward(req, resp);
	}
}
