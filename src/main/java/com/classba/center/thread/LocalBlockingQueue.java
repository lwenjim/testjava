package com.classba.center.thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LocalBlockingQueue
{
	protected String name;

	public static void main(String[] args)
	{
		Long          Start = System.currentTimeMillis();
		String[]      list  = new String[]{"lwenjim", "lsongjiu", "jim", "jin"};
		BlockingQueue queue = new ArrayBlockingQueue(list.length);
		for (String name : list) {
			new Thread(() -> {
				for (int i = 0; i < 100; i++) {
					System.out.println(String.format("%s数字:%s", name, i));
				}
				queue.add("ok");
			}).start();
		}
		try {
			for (int i = 0; i < list.length; i++) {
				System.out.println(queue.take());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("耗时为:%sms", System.currentTimeMillis() - Start));
	}
}


