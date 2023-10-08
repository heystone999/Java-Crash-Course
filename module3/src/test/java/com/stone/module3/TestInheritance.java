package com.stone.module3;

public class TestInheritance {
    public static void main(String[] args) {
        B b=new B("Zhang San");
        System.out.println(b.name);
        b.test();

//        C c=new C();
//        c.test();
    }
}


class A{
    String name;

    public A(String name) {
        this.name = name;
    }


    void test(){
        System.out.println("parent class A test");
    }
}

class B extends A{
    B(String name) {
        super(name);
    }
}


class C extends A{
    public C(String name) {
        super(name);
    }
}