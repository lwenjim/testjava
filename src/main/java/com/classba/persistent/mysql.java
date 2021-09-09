package com.classba.persistent;

import redis.clients.jedis.Jedis;

public class mysql
{
	public static void main(String[] args)
	{
		Jedis jedis = new Jedis();
		jedis.set("num", "1");
		new Demo().start();
		new Demo().start();
	}
}


class Demo extends Thread
{
	public void run()
	{
		Jedis jedis1 = new Jedis();
		for (int i = 0; i < 100; i++) {
			int num = Integer.parseInt(jedis1.get("num"));
			num = num + 1;
			jedis1.set("num", num + "");
			System.out.println(jedis1.get("num"));
		}
	}
}