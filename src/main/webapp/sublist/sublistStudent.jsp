<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生信息</title>
</head>
<%
    String context = request.getContextPath();
%>

<body>
<div style="margin-left: 100px; margin-top: 100px;">
    <c:if test="${fn:length(result.dataList) eq 0 }">
        <span>查询的结果不存在</span>
    </c:if>

    <c:if test="${fn:length(result.dataList) gt 0 }">
        <table border="1px" cellspacing="0px"
               style="border-collapse: collapse">
            <thead>
            <tr height="30">
                <th width="130">课程编号</th>
                <th width="130">课程名称</th>
            </tr>
            </thead>
            <c:forEach items="${result.dataList }" var="student">
                <tr>
                    <td><c:out value="${student.courseId }"></c:out></td>
                    <td><c:out value="${student.courseName }"></c:out></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>