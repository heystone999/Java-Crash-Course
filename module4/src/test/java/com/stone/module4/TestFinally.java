package com.stone.module4;


import java.io.Closeable;

public class TestFinally {
    public static void main(String[] args) {
        /*try {
            int i = 1 / 0;
            System.out.println(1);
        } catch (Exception e) {
            System.out.println(2);
        } finally {
            System.out.println(3);
        }*/

        /*Resource r=new Resource();
        try{
            System.out.println("use resource");
            int i=1/0;
        }catch(Exception e){
            System.out.println(e);
        }finally {
            r.close();
        }*/

        try(Resource r=new Resource()){
            System.out.println("use resource");
            int i=1/0;
        }catch (Exception e){
            System.out.println(e);
        }
    }
}


class Resource implements Closeable {
    @Override
    public void close(){
        System.out.println("release resource");
    }
}