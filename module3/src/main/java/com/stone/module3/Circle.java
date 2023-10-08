package com.stone.module3;

public class Circle {
    double r;
    static double pi=Math.PI;

    public Circle(double r) {
        this.r = r;
    }

    double area(){
        return pi*r*r;
    }
}
