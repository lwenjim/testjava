package com.classba.center.collectors;

public class LocalList
{
	/**
	 * toList
	 * toSet
	 * toMap
	 * toCollection
	 *
	 * @param args
	 */
	public static void main(String[] args)
	{
		ThreadLocal<String> local = new InheritableThreadLocal<>();
		local.get();
	}
}
