package com.stone.module4.controller;

import com.stone.module4.dto.Calculator;
import com.stone.module4.service.CalculatorService;
import com.stone.module4.service.impl.CalculatorService0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {
//    private CalculatorService[] array=new CalculatorService[]{
//            new CalculatorService0(),
//            new CalculatorService1(),
//            new CalculatorService2()
//    };

    public CalculatorController() {
    }

    @Autowired
    CalculatorService[] array;

    @Autowired
    CalculatorService0 s0;


    @RequestMapping("/cal")
    @ResponseBody
    /**
     * cal?p=100000.0&m=10&yr=6.0&type=0
     *
     *情况1: 有无参构造
     * Calculator c=new Calculator();
     * c.setP(100000.0);
     * c.setM(10);
     * c.setYr(6.0);
     *
     * 情况2: 没有无参构造
     * new Calculator(100000.0,10,6.0);
     *
     * cal(0,c)
     */
    String[] cal(int type, Calculator c) {
        check(c.getP(), c.getM(), c.getYr(), type);
        CalculatorService service = array[type];
        return service.cal(c);
    }

    @RequestMapping("/details")
    @ResponseBody
    String[][] details(int type, Calculator c) {
        check(c.getP(), c.getM(), c.getYr(), type);
        CalculatorService service = array[type];
        return service.details(c);
    }

    static void check(double p, int m, double yr, int type) {
        if (p <= 0) {
            throw new IllegalArgumentException("贷款金额必须>0");
        }
        if (m < 1 || m > 360) {
            throw new IllegalArgumentException("贷款月份必须在1-360之间");
        }
        if (yr < 1.0 || yr > 36.0) {
            throw new IllegalArgumentException("年利率必须在1-36之间");
        }
        if (type != 0 && type != 1 && type != 2) {
            throw new IllegalArgumentException("不支持的还款类型");
        }
    }
}
