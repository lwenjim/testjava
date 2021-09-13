package com.classba.center.thread;


public class LocalSynchronized
{
	protected String name;

	public static void main(String[] args)
	{
		Long     Start = System.currentTimeMillis();
		String[] list  = new String[]{"lwenjim"};
		Object[] lock  = new Object[list.length];
		for (String name : list) {
			Thread t = new Thread(() -> {
				for (int i = 0; i < 100; i++) {
					System.out.println(String.format("%s数字:%s", name, i));
				}
				synchronized (lock) {
					lock.notify();
				}
			});
			t.start();
		}
		try {
			for (int i = 0; i < list.length; i++) {
				synchronized (lock) {
					lock.wait();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("耗时为:%sms", System.currentTimeMillis() - Start));
	}
}


