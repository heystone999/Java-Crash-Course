package com.stone.module3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.NumberFormat;

@Controller
public class CalController {
    Calculator[] getCalculator(double p, int m, double yr){
        return new Calculator[]{
                new Calculator0(p,m,yr),
                new Calculator1(p,m,yr),
                new Calculator2(p,m,yr)
        };
    }

    
    @RequestMapping("/cal")
    @ResponseBody
    String[] cal(double yr,double p,int m, int type){
        check(p, m, yr, type);
        Calculator[] calculators = getCalculator(p, m, yr);
        Calculator c = calculators[type];

        return c.cal();
    }



    @RequestMapping("/details")
    @ResponseBody
    String[][] details(double p, int m, double yr, int type){
        check(p, m, yr, type);
        Calculator[] calculators = getCalculator(p, m, yr);
        Calculator c = calculators[type];

        return c.details();
    }



    static void check(double p, int m, double yr, int type){
        if(p<0){
            throw new IllegalArgumentException("贷款金额必须>0");
        }
        if(m<1||m>360){
            throw new IllegalArgumentException("贷款月份必须在1-360之间");
        }
        if(yr<1.0||yr>36.0){
            throw new IllegalArgumentException("年利率必须在1-36之间");
        }
        if(type !=0 && type !=1 && type!=2){
            throw new IllegalArgumentException("不支持的还款类型");
        }
    }
}
