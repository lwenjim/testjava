package com.lwenjim.io;

import java.io.*;
import java.util.ArrayList;

/**
 * 对象的序列化和反序列化
 */
public class ObjectOutputStreamTest{
    public static void main(String[] args) {
        unSerialize();
//        ArrayList
    }

    private static void unSerialize() {
        ObjectInputStream oos = null;
        try {
            oos = new ObjectInputStream(new FileInputStream("data7.txt"));
            try {
                System.out.println(oos.readObject());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void serialize() {
        Student s = new Student();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("data7.txt"));
            oos.writeObject(s);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Student implements Serializable {
    private static final long serialVersionUID = 3962226750610983125L;

    /**
     * java 虚拟机 识别一个类 首先根据类名 然后再根据 serialVersionUID
     */
//    private static final long serialVersionUID = 8683452581122892189L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String name;
    transient int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}