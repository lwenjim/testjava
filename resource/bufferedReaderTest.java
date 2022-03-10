package com.lwenjim.io;

import java.io.*;

public class bufferedReaderTest {
    public static void main(String[] args) {
        BufferedWriter rd = null;
        FileOutputStream fos = null;
        FileWriter fw = null;
        try {
            fos = new FileOutputStream("data6.txt");
            fw = new FileWriter("data6.txt");
            rd = new BufferedWriter(new OutputStreamWriter(fos));
            rd.write("abc");
            rd.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rd != null) {
                try {
                    rd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
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

    private static void bufferReader() {
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new FileReader("data.txt"));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rd != null) {
                try {
                    rd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
