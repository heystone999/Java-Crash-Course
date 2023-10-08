package com.stone.module3.encapsulation;

import java.sql.SQLOutput;

/**
 * JavaBean 规范
 * 1. private fields，public methods来访问private fields: get set is
 * 2  最好提供一个无参的构造
 * 3. 最好实现一个接口Serializable
 */

public class TestJavaBean {
    public static void main(String[] args) {
        Teacher t = new Teacher("Zhang",false);
        System.out.println(t.getName());
        System.out.println(t.isMarried());

        t.setMarried(true);
        System.out.println(t.isMarried());
    }
}

class Teacher{
    private String name;
    private boolean married;
    private int age;

    public Teacher(String name,boolean married){
        this.name=name;
        this.married=married;
    }

    public Teacher(){

    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public boolean isMarried(){
        return this.married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}