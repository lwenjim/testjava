package com.lwenjim.io;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) {
        copyDir(new File("/Users/jim/Workdata/testjava/src/main/java"), new File("/Users/jim/Workdata/testjava/resource"));
    }

    private static void copyDir(File srcFile, File descFile) {
        if (srcFile.isFile()) {
            FileInputStream fis = null;
            FileOutputStream fos = null;
            if (!descFile.isDirectory()) {
                System.out.println("目标地址不是目录");
                return;
            }
            String path = descFile.getAbsolutePath();
            if (!path.endsWith("/")) {
                path += "/";
            }
            path += srcFile.getName();
            System.out.println(path);
            try {
                fis = new FileInputStream(srcFile);
                fos = new FileOutputStream(path);
                byte[] buffer = new byte[1024 * 1024];
                int readCount = 0;
                while ((readCount = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, readCount);
                }
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
        File[] list = srcFile.listFiles();
        for (File file : list) {
            if (file.isDirectory()) {
                String path = descFile.getAbsolutePath();
                if (!path.endsWith("/")) {
                    path += "/";
                }
                path += file.getName();
                File dir = new File(path);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
//                System.out.println(path);
            }
            copyDir(file, descFile);
        }
    }

    private static void myDir() {
        File f = new File(".");
        for (File f2 : f.listFiles()) {
            System.out.println(f2.getName());
        }
    }

    private static void extracted() {
        File f = new File("./data.txt");
        System.out.println(f.getParent());
        long haoMiao = f.lastModified();
        Date time = new Date(haoMiao);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strTime = format.format(time);
        System.out.println(strTime);
        System.out.println(f.length());
    }
}
