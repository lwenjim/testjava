package com.classba.center.classloader;

public class LocalClassLoader
{
	public static void main(String[] args)
	{
		try {
			Class clazz = (new ClassLoader1()).loadClass("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}

class ClassLoader1 extends ClassLoader
{

}
