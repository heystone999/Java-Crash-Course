package com.stone.module3;
/*
    precondition
    1. 用parent类型代表child类对象
    2. child类和parent类得有相同的say方法，方法重写
 */
public class TestAnimal {
    public static Animal[] getAnimals(){
        return new Animal[]{
                new Cat(),
                new Dog(),
                new Pig(),
        };
    }

    public static void main(String[] args) {
        Animal[] animals=getAnimals();
        for (int i = 0; i < animals.length; i++) {
            Animal a=animals[i];
            a.say();
        }
    }
}


