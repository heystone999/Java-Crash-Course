package com.stone.module4;

public class TestThrows {
    public static void main(String[] args) throws Exception {
        test3(0.0);
    }

    public static void test1(double p) {
        if(p<=0.0){
            throw new IllegalArgumentException("本金必须大于0");
        }
        System.out.println(2);
    }

    public static void test2(double p){
        if(p<=0.0){
            try {
                throw new Exception("本金必须大于0");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(2);
    }

    public static void test3(double p) throws Exception {
        if(p<=0.0){
            throw new Exception("本金必须大于0");
        }
        System.out.println(2);
    }
}
