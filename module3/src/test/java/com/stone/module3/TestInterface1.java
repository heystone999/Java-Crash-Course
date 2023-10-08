package com.stone.module3;

public class TestInterface1 {
    public static void main(String[] args) {
        Duck d = new Duck();
        d.swim();
        d.fly();
    }
}

interface Swimmable{
    default void swim(){
        System.out.println("swim");
    }
}

interface Flyable{
    default void fly(){
        System.out.println("fly");
    }
}

class Duck implements Swimmable,Flyable{

}