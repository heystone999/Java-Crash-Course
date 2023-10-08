package com.stone.module4.service.impl;

import com.stone.module4.dto.Calculator;
import com.stone.module4.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

/**
 * 业务逻辑类 - 等额本金方式
 */
@Service
public class CalculatorService1 implements CalculatorService {
    @Override
    public String[] cal(Calculator c){
        double yr=c.getYr();
        int m=c.getM();
        double p=c.getP();

        double payPrincipal= p / m;//偿还本息
        double backup= p;
        double mr= yr /12/100.0;
        double payInterestTotal=0.0;
        for (int i = 0; i< m; i++){
            double payInterest= p *mr;
            p -=payPrincipal;
            payInterestTotal+=payInterest;
        }
        return new String[]{
                NumberFormat.getCurrencyInstance().format(backup + payInterestTotal),
                NumberFormat.getCurrencyInstance().format(payInterestTotal)
        };
    }

    @Override
    public String[][] details(Calculator c){
        int m = c.getM();
        double yr = c.getYr();
        double p = c.getP();

        double payPrincipal = p / m;
        double mr= yr /12/100.0;
        String[][] a2=new String[m][];
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr;
            p -=payPrincipal;
            double payment=payPrincipal+payInterest;

            a2[i]=createRow(i,payment,payPrincipal,payInterest,p);
        }
        return a2;
    }
}
