package com.stone.module4;

import java.util.ArrayList;

public class TestGeneric {
    public static void main(String[] args) {
        /*ArrayList list=new ArrayList(); //Object[]
        list.add(1); //int => Integer => Object
        list.add(2);
        list.add(3);
        list.add(4);

        int sum=0;
        for (Object e:list) {
            System.out.println(e);
            sum+=(int)e;
        }
        System.out.println(sum);*/

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int sum=0;
        for (Integer i:list) {
            sum +=i;
        }
        System.out.println(sum);

        ArrayList l1 = new ArrayList();
        l1.add("a");
        l1.add(1);

        ArrayList<String> l2=new ArrayList<>();
        l2.add("a");
//        l2.add(1);


    }
}
