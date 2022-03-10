package com.lwenjim.io;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        FileWriter fw = null;
        FileReader fr = null;
        try {
            fr = new FileReader("data.txt");
            fw = new FileWriter("data5.txt", true);
            char[] buffer = new char[1024];
            int readCount = 0;
            while ((readCount = fr.read(buffer)) != -1) {
                fw.write(buffer, 0, readCount);
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw == null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void fileWrite() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("data4.txt", true);
            char[] chars = {'a', 'b'};
            fw.write(chars);
            String data = "我是高手";
            fw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void fileRead() {
        FileReader fr = null;
        try {
            fr = new FileReader("data.txt");
            char[] buffer = new char[1024];
            int i = 0;
            while ((i = fr.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
