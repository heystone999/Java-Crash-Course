package com.stone.module3;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle(1);
        Circle.pi=3;
        Circle c2 = new Circle(2);
        Circle.pi=4;
        System.out.println(c1.area());
        System.out.println(c2.area());
    }
}
