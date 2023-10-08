package com.stone.module3;

public class TestCal {
    public static void main(String[] args) {
//        double p1 =100000.0;
//        int m1 = 24;
//        double yr1 = 4.5;
//        double r1 = cal(p1, m1, yr1);
//        System.out.println("4.5% for 2 years: "+r1);
//
//        double p2 =100000.0;
//        int m2 = 12;
//        double yr2 = 6.0;
//        double r2 = cal(p2, m2, yr2);
//        System.out.println("6.0% for 1 years: " + r2);

        Cal c1 = new Cal(100000.0, 24, 4.5);
        double r1 = c1.Calculate();
        System.out.println("4.5% for 2 years: "+r1);

        Cal c2 = new Cal(100000.0, 12, 6.0);
        double r2 = c2.Calculate();
        System.out.println("6.0% for 1 years: " + r2);

    }


//    static double cal(double p,int m,double yr){
//        double mr = yr / 100.0 / 12;
//        double pow = Math.pow(1 + mr, m);
//        return m*p*mr*pow / (pow - 1);
//    }
}