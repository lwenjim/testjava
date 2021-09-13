package com.classba.library;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class DynamicCall
{
	public static void main(String[] args)
	{
		IUserDao invoker = (IUserDao) new Invoker().getInstance(IUserDao.class);
		System.out.println(invoker.getUserName());
	}
}

interface IUserDao
{
	public String getUserName();
}


class Invoker
{
	public Object getInstance(Class<?> cls)
	{
		MethodProxy invocationHandler = new MethodProxy();
		Object      newProxyInstance  = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler);
		return (Object) newProxyInstance;
	}
}

class MethodProxy implements InvocationHandler
{
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		if (Object.class.equals(method.getDeclaringClass())) {
			try {
				return method.invoke(this, args);
			} catch (Throwable t) {
				t.printStackTrace();
			}
		} else {
			return run(method, args);
		}
		return null;
	}

	public Object run(Method method, Object[] args)
	{
		return "method call success!";
	}
}

