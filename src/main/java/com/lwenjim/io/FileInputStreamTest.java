package com.lwenjim.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamTest {
    /**
     * 文件专属
     * java.io.FileInputStream
     * java.io.FileOutputStream
     * java.io.Reader
     * java.io.Writer
     * <p>
     * 转换流
     * java.io.InputStreamReader
     * java.io.OutputStreamReader
     * <p>
     * 缓存专属
     * java.io.BufferedReader
     * java.io.BufferedWriter
     * java.io.BufferedInputStream
     * java.io.BufferedOutputStream
     * <p>
     * 数据流专属
     * java.io.DataInputStream
     * java.io.DataOutputStream
     * <p>
     * 标准输出流
     * java.io.PrintWriter
     * java.io.PrintStream
     * <p>
     * 对象专属流
     * java.io.ObjectInputStream
     * java.io.ObjectOutputStream
     *
     * @param args
     */
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream("data3.txt", true);
            fis = new FileInputStream("data.txt");
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while ((readCount = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, readCount);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void fileWrite() {
        try {
            FileOutputStream fos = new FileOutputStream("data2.txt", true);
            byte[] buffer = {97, 98, 99, 100};
            fos.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileRead() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("data.txt");
            byte[] buffer = new byte[fis.available()];
            int readCount = fis.read(buffer);
            System.out.printf("%s", new String(buffer, 0, readCount));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
