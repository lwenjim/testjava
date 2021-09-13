package com.classba.center.thread;


public class LocalWhile
{
	protected String name;

	public static void main(String[] args)
	{
		Long     Start   = System.currentTimeMillis();
		String[] list    = new String[]{"lwenjim"};
		Thread[] threads = new Thread[list.length];
		int      index   = 0;
		for (String name : list) {
			threads[index] = new Thread(() -> {
				for (int i = 0; i < 100; i++) {
					System.out.println(String.format("%s 数字: %s", name, i));
				}
			});
			threads[index].start();
			index++;
		}
		for (int i = 0; i < threads.length; i++) {
			while (threads[i].getState() != Thread.State.TERMINATED) {
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(String.format("\n耗时为:%sms", System.currentTimeMillis() - Start));
	}
}


