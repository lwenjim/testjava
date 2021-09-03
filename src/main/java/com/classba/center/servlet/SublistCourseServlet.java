package com.classba.center.servlet;

import com.classba.center.Constant;
import com.classba.center.Pager;
import com.classba.center.model.Course;
import com.classba.center.service.SublistCourseServiceImpl;
import com.classba.library.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "SublistCourseServlet", value = "sublist/SublistServlet")
public class SublistCourseServlet extends HttpServlet
{
	protected SublistCourseServiceImpl service = new SublistCourseServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	{
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		try {
			Request       newReq = new Request(req);
			Course        course = new Course(newReq.getLong("course_id"), newReq.getString("course_name"));
			Pager<Course> result = service.findCourse(course, getPage(newReq), getPageSize(newReq));
			req.setAttribute("result", result);
			req.getRequestDispatcher("sublistStudent.jsp").forward(req, resp);
		} catch (ServletException | IOException exception) {
			try {
				resp.getOutputStream().write(exception.getMessage().getBytes(StandardCharsets.UTF_8));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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