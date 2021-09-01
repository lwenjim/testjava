package com.library;

import javax.servlet.http.HttpServletRequest;

public class Request
{
	protected HttpServletRequest req;

	public Request(HttpServletRequest req)
	{
		this.req = req;
	}

	protected String getParameter(String name)
	{
		if (req.getParameter(name) == null) {
			return "";
		}
		return req.getParameter(name);
	}

	public String getString(String name)
	{
		String value = getParameter(name);
		return value == null ? "" : value;
	}

	public long getLong(String name)
	{
		String value = getString(name);
		if (value == "") {
			return 0;
		}
		return Long.parseLong(value);
	}

	public int getInt(String name)
	{
		String value = getString(getParameter(name));
		return Integer.parseInt(value);
	}

	public int getInt(String name, int def)
	{
		String value = getString(getParameter(name));
		if ("".equals(value)) {
			return def;
		}
		return this.getInt(name);
	}
}
