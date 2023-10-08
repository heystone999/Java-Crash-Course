package com.stone.module3;

public class TestInterface3 {
    public static void main(String[] args) {
        M m = new N();
        m.m();
//        m.n();
    }
}


interface M{
    void m();
}

class N implements M{
    public String name;

    @Override
    public void m(){
        System.out.println("m");
    }

    public void n(){
        System.out.println("n");
    }
}