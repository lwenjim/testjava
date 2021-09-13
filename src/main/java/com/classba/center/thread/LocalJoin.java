package com.classba.center.thread;


import java.util.ArrayList;
import java.util.List;

public class LocalJoin
{
	protected String name;

	public static void main(String[] args)
	{
		Long         Start     = System.currentTimeMillis();
		String[]     list      = new String[]{"lwenjim", "lsongjiu", "jim", "jin"};
		List<Thread> container = new ArrayList<>();
		for (String name : list) {
			Thread t = new Thread(() -> {
				for (int i = 0; i < 100; i++) {
					System.out.println(String.format("%s数字:%s", name, i));
				}
			});
			t.start();
			container.add(t);
		}
		for (Thread t : container) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(String.format("耗时为:%sms", System.currentTimeMillis() - Start));
	}
}


