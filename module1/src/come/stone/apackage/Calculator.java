package come.stone.apackage;

import java.text.NumberFormat;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        double p=inputAndCheckP();
        double mr=inputAndCheckMr();
        int m=inputAndCheckM();
        double payment =calculate(p,mr,m);
        printDetails(p,mr,m,payment);
    }


    static double inputAndCheckP(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入本金");
        double p = scanner.nextDouble();
        if(p<=0){
//            System.out.println("贷款金额必须>0");
//            throw new 异常类型("提示信息")
            throw new IllegalArgumentException("贷款金额必须>0");
        }
        return p;
    }
    static double inputAndCheckMr(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入年利率");
        double yr=scanner.nextDouble();
        if(yr<1||yr>36){
            throw new IllegalArgumentException("年利率必须是1-36");
        }
        double mr=yr/12/100;
        return mr;
    }
    static int inputAndCheckM(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入还款月数");
        int m=scanner.nextInt();
        if(m<1||m>360){
            throw new IllegalArgumentException("贷款月数必须是1-360");
        }
        return m;
    }

    static void printDetails(double p,double mr,int m,double payment){
        for (int i=0;i<m;i++){
            double payInterest=p*mr;
            double payPrincipal = payment-payInterest;
            p-=payPrincipal;
            System.out.println("月份："+(i+1));
            System.out.println("\t本月还款："+NumberFormat.getCurrencyInstance().format(payment));
            System.out.println("\t偿还本金："+NumberFormat.getCurrencyInstance().format(payPrincipal));
            System.out.println("\t偿还利息："+NumberFormat.getCurrencyInstance().format(payInterest));
            System.out.println("\t剩余本金："+NumberFormat.getCurrencyInstance().format(p));
        }
        System.out.println("总还款额："+NumberFormat.getCurrencyInstance().format(payment*m));
    }

    /**
     * 以等额本息的方式计算每月还款金额
     * @param p 本金
     * @param mr 月利率
     * @param m 还款月数
     * @return 每月还款金额
     */
    static double calculate(double p, double mr, int m){
        double pow=Math.pow(1+mr,m);
        return p*mr*pow/(pow-1);
    }
}
