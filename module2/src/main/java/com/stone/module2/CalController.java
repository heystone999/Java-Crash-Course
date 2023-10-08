package com.stone.module2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.NumberFormat;

@Controller
public class CalController {
    /**
     * 以等额本息法计算还款总额和总利息
     * @param p 本金
     * @param m 月份
     * @param yr 年利率
     * @return [0]还款总额[1]总利息
     */
    static String[] cal0(double p,int m,double yr){
        double mr=yr/12/100.0;
        double pow = Math.pow(1+mr,m);
        double payment=p*mr*pow/(pow-1);
        return new String[]{
                NumberFormat.getCurrencyInstance().format(payment*m),
                NumberFormat.getCurrencyInstance().format(payment*m-p)
        };
    }
    
    
    @RequestMapping("/cal")
    @ResponseBody
    String[] cal(double yr,double p,int m, int type){
        check(p, m, yr, type);
        if(type==0){//等额本息
            return cal0(p,m,yr);
        }else {//等额本金
            return cal1(yr, p, m);
        }

    }

    private static String[] cal1(double yr, double p, int m) {
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


    @RequestMapping("/details")
    @ResponseBody
    String[][] details(double p, int m, double yr, int type){
        check(p, m, yr, type);
        if(type==0){
            return details0(p, m, yr);
        }else {
            return details1(p, m, yr);
        }
    }

    private static String[][] details1(double p, int m, double yr) {
        double payPrincipal = p / m;
        double mr= yr /12/100.0;
        String[][] a2=new String[m][];
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr;
            p -=payPrincipal;
            double payment=payPrincipal+payInterest;
            String[] row=new String[]{
                    (i+1)+"",
                    NumberFormat.getCurrencyInstance().format(payment),
                    NumberFormat.getCurrencyInstance().format(payPrincipal),
                    NumberFormat.getCurrencyInstance().format(payInterest),
                    NumberFormat.getCurrencyInstance().format(p)
            };
            a2[i]=row;
        }
        return a2;
    }

    private static String[][] details0(double p, int m, double yr) {
//            String[] row0=new String[]{"1","$123","$345","$6778","$1"};
//            String[] row1=new String[]{"2","$123","$345","$6778","$1"};
//            String[] row2=new String[]{"3","$123","$345","$6778","$0"};

        String[][] a2=new String[m][];
//            a2[0]=row0;
//            a2[1]=row1;
//            a2[2]=row2;

        double mr= yr /12/100.0;
        double pow = Math.pow(1+mr, m);
        double payment= p *mr*pow/(pow-1);//月供

        for (int i = 0; i< m; i++){
            double payInterest= p *mr;                //偿还利息
            double payPrincipal=payment-payInterest;//偿还本金
            p -=payPrincipal;                        //剩余本金
            String[] row=new String[]{
                    (i+1)+"",
                    NumberFormat.getCurrencyInstance().format(payment),
                    NumberFormat.getCurrencyInstance().format(payPrincipal),
                    NumberFormat.getCurrencyInstance().format(payInterest),
                    NumberFormat.getCurrencyInstance().format(p)
            };
            a2[i]=row;
        }
        return a2;
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
        if(type !=0 && type !=1){
            throw new IllegalArgumentException("不支持的还款类型");
        }
    }
}
