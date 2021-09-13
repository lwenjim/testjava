package com.classba.center.thread;


import java.util.concurrent.CountDownLatch;

public class LocalCountDownLatch
{
	protected String name;

	public static void main(String[] args)
	{
		Long                 Start        = System.currentTimeMillis();
		String[]             list         = new String[]{"lwenjim", "lsongjiu", "jim", "jin"};
		int                  threadNumber = list.length;
		final CountDownLatch cdl          = new CountDownLatch(threadNumber);
		for (String name : list) {
			new Thread(() -> {
				for (int i = 0; i < 100; i++) {
					System.out.println(String.format("%s数字:%s", name, i));
				}
				cdl.countDown();
			}).start();
		}
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("耗时为:%sms", System.currentTimeMillis() - Start));
	}
}


