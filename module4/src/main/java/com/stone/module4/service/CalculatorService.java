package com.stone.module4.service;

import com.stone.module4.dto.Calculator;

import java.text.NumberFormat;

public interface CalculatorService {
    String[] cal(Calculator c);

    String[][] details(Calculator c);

    default String[] createRow(int i, double payment, double payPrincipal, double payInterest, double p){
        String[] row=new String[]{
                (i+1)+"",
                NumberFormat.getCurrencyInstance().format(payment),
                NumberFormat.getCurrencyInstance().format(payPrincipal),
                NumberFormat.getCurrencyInstance().format(payInterest),
                NumberFormat.getCurrencyInstance().format(p)
        };
        return row;
    }
}
