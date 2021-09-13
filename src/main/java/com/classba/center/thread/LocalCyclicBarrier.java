package com.classba.center.thread;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class LocalCyclicBarrier
{
	protected String name;

	public static void main(String[] args)
	{
		Long          Start   = System.currentTimeMillis();
		String[]      list    = new String[]{"lwenjim", "lsongjiu", "jim", "jin"};
		CyclicBarrier barrier = new CyclicBarrier(list.length + 1);
		for (String name : list) {
			new Thread(() -> {
				for (int i = 0; i < 100; i++) {
					System.out.println(String.format("%s数字:%s", name, i));
				}
				try {
					barrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();
		}
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("耗时为:%sms", System.currentTimeMillis() - Start));
	}
}


