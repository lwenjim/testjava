package com.lwenjim.io;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class IoPropertiesTest {
    public static void main(String[] args) throws IOException {
        String path = Thread.currentThread().getContextClassLoader().getResource("userinfo.properties").getPath();
        System.out.println(path);

        FileReader reader = new FileReader("data.txt");

        Properties p = new Properties();
        p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("userinfo.properties"));

        System.out.println(p.getProperty("ClassName"));
    }
}
