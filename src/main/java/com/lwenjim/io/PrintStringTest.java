package com.lwenjim.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintStringTest {
    public static void main(String[] args) {
        Logger.log("hello world");
    }
}


class Logger {
    public static void log(String data) {
        PrintStream ps2 = null;
        try {
            ps2 = new PrintStream(new FileOutputStream("data.txt", true));
            System.setOut(ps2);
            ps2.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps2 != null) {
                ps2.close();
            }
        }
        Date nowTime = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strTime = format.format(nowTime);
        System.out.println(strTime + data);
    }
}