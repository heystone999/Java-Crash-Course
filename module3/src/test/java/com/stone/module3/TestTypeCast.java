package com.stone.module3;

public class TestTypeCast {
    public static void main(String[] args) {
        /*
        1. 基本类型
        double<-float<-long<-int<-char
        double<-float<-long<-int<-short<-byte
        顺箭头 隐式转换(自动)
        逆箭头 强制转换 可能损失精度
        */
//        int c=1000;
//        byte d=(byte)c;
//        System.out.println(d); //-24

        /*
        2. 包装类型于基本类型
         */
//        int a=20;
//        Integer b=a;
//
//        Integer c=new Integer(30);
//        int d=c;

        /*
        3. 引用类型
            继承特点
            1)单继承，子类只能继承一个parent class
            2)Object是其他类型直接或间接的parent class，定义class时不写extends此类也是继承自Object
            3)child class与parent class、ancestor class之间，可以用is a表达

            顺箭头 [要符合is a] 隐式转换，向上转型，使用parent类型统一处理child类型
            逆箭头 [要符合is a] 强制转换，向下转型，将对象还原
         */
        Animal a=new Cat();//对象还是那个对象 只是用parent类型来代表了它
        Object b=new Cat();

//        Appliance c=new Cat();//不合法
        Cat c=(Cat)a;
//        Dog d=(Dog)a;//类型转换异常ClassCastException

        Cat e=(Cat)b;//可以
//        Dog f=(Dog)b;//不行 b本质是cat
        Animal g=(Animal) b;//可以


        Animal[] cats=new Animal[]{new Cat(),new Dog()};

        test(new Cat());
        test(new Dog());

        System.out.println(a.getClass());//获取它所代表对象的真正类型
        System.out.println(b.getClass());

//        检查是否符合is a关系
        System.out.println(a instanceof Cat);
        System.out.println(b instanceof Dog);
        System.out.println(b instanceof Animal);

        /*
        4. 不属于以上三种，借助转换方法
            String->int
         */
        String aa="1";
        String bb="2";
        System.out.println(Integer.parseInt(aa) + Integer.parseInt(bb));
//        System.out.println(a + b);
    }
    static void test(Animal cat){

    }
}


class Animal extends Object{
    void say(){}
}
class Cat extends Animal {
    @Override
    void say(){
        System.out.println("Meow");
    }
}
class Dog extends Animal {
    @Override//重写
    void say(){
        System.out.println("Woof");
    }
}
class Pig extends Animal{
    @Override
    void say(){
        System.out.println("Oink");
    }
}
class Appliance{}

