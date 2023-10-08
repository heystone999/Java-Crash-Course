package com.stone.module3;

public class TestType {
    /*
    1. 基本类型primitive
        byte short int long float double char boolean
    2. 引用类型reference
        String
        byte[]
        int[]
        Phone(double String)
        Student
        Calculator
        包装类型Byte Short Integer Float Double Character Boolean
     */
    public static void main(String[] args) {
        Integer a = new Integer(10);
        int b=20;

        Student s1=new Student();
        s1.name="Zhang San";
// 当引用类型取值为null时，进一步使用它(调用methods，访问fields) NullPointerException空指针异常
        if(s1.name!=null){
            System.out.println("length of name: "+s1.name.length());
        }
    }
}
