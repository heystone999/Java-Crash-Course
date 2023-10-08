package com.stone.module2;
/*
    Array
    1. 类型[] 变量名=new 类型[长度]
    2. 类型[] 变量名=new 类型[]{元素1,元素2,...}
    3. 类型[] 变量名={元素1,元素2,...}
 */
public class TestArray {
    public static void main(String[] args) {
//        1. .................
        String[] a=new String[2];

        a[0]="hello";
        a[1]="world";

        System.out.println(a[0]);
        System.out.println(a[1]);

//        2. ...................
        String[] b=new String[]{"hello","world"};
        System.out.println(b[0]);
        System.out.println(b[1]);

//        3. ...................
        String[] c={"hello","world"};
        System.out.println(c[0]);
        System.out.println(c[1]);
    }
}
