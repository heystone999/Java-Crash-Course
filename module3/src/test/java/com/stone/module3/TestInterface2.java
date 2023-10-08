package com.stone.module3;

public class TestInterface2 {
    public static void main(String[] args) {
        E[] array = new E[]{
                new F(),
                new G()
        };
        for (int i = 0; i < array.length; i++) {
            E e=array[i];
            e.e();
        }
    }
}

interface E{
//    默认method
//    default void e(){
//        System.out.println("e");
//    }

//    抽象方法
    public abstract void e();
}

/*
    public > protected > 默认 > private
 */
class F implements E{
    @Override
    public void e(){
        System.out.println("f");
    }
}

class G implements E{
    @Override
    public void e(){
        System.out.println("g");
    }
}