package com.classba.center.stream;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayStream
{
	/**
	 * Arrays.stream
	 * Collection.stream
	 * Stream.of
	 * Stream.iterate
	 * Stream.generate
	 * SteamSupport.stream
	 * IntStream boxed(Integer对象)
	 * StreamBuilder build(返回流对象)
	 *
	 *
	 *
	 * optionnal 流 (和 null 说再见)
	 * @param args
	 */
	public static void main(String[] args)
	{
//		List list = Arrays.asList(
//				new Student("jack", "女", 2),
//				new Student("john", "男", 3),
//				new Student("lily", "女", 1),
//				new Student("lucy", "男", 0)
//		);
//		list.sort(Comparator.comparing(Student::getAge));
//		System.out.println(list);
//		list.sort(Comparator.comparing(Student::getAge).reversed());
//		System.out.println(list);

//		List list = Arrays.asList(
//				new Student("jack", "male", 12),
//				new Student("john", "male", 13),
//				new Student("lily", "female", 11),
//				new Student("david", "male", 14),
//				new Student("luck", "female", 13),
//				new Student("jones", "female", 15),
//				new Student("han", "male", 13),
//				new Student("alice", "female", 11),
//				new Student("li", "male", 12)
//		);
//		Map<String, List> groupMap = (Map<String, List>) list.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.groupingBy(Student::getSexual, Collectors.toList()));
//		System.out.println(groupMap.toString());


//		IntStream.rangeClosed(0, 5).forEach(System.out::println);

	}
}


class Student
{
	private String  name;
	private String  sexual;
	private Integer age;

	public Student(String name, String sexual, Integer age)
	{
		this.name   = name;
		this.sexual = sexual;
		this.age    = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSexual()
	{
		return sexual;
	}

	public void setSexual(String sexual)
	{
		this.sexual = sexual;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	@Override
	public String toString()
	{
		return "Student{" +
				"name='" + name + '\'' +
				", sexual='" + sexual + '\'' +
				", age=" + age +
				'}';

	}
}