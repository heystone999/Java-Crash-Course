package com.stone.module2;

public class TestArray2 {
    public static void main(String[] args) {
//        1. 数组长度
//        String[] a=new String[]{"Beijing","Shanghai","Shenzhen"};
//        String[] a=new String[3];//String[]元素的默认值是null
        int[] a=new int[3];//int[]元素的默认值是0; double[] 0.0; boolean[] false
        System.out.println("length: "+a.length);
//        2. 数组越界
//        System.out.println(a[3]);//ArrayIndexOutOfBoundsException 数组索引越界异常
//        3. 遍历数组
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
//        4. 默认值
    }
}
