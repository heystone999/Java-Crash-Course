package com.stone.module3;

public class Cal {
    double principal;
    int month;
    double yearRate;

    public Cal(double principal, int month, double yearRate) {
        this.principal = principal;
        this.month = month;
        this.yearRate = yearRate;
    }

    double Calculate(){
        double monthRate= yearRate/100.0/12;
        double pow=Math.pow(1+monthRate,month);
        return month*principal*monthRate*pow/(pow-1);
    }

}

