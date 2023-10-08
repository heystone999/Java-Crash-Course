package com.stone.module4;

public class TestTry {
    public static void main(String[] args) {
        System.out.println(1);
        try {
            test(0.00);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println(3);
        }

        public static void test( double p){
            if (p <= 0.0) {
                throw new IllegalArgumentException("本金必须大于0");
            }
            System.out.println(2);
        }
    }