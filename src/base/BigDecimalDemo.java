package base;

import java.math.BigDecimal;

class BigDecimalDemo   
{  
    static final int location = 10; //小数点后位数  
    //加法 返回 num1+num2  
    public double add(double num1, double num2){  
        BigDecimal b1 = new BigDecimal(num1);  
        BigDecimal b2 = new BigDecimal(num2);  
        return b1.add(b2).doubleValue();  
    }  
    //减法 返回 num1-num2  
    public double sub(double num1, double num2){  
        BigDecimal b1 = new BigDecimal(num1);  
        BigDecimal b2 = new BigDecimal(num2);  
        return b1.subtract(b2).doubleValue();  
    }  
    //乘法 返回 num1*num2  
    public double mul(double num1, double num2){  
        BigDecimal b1 = new BigDecimal(num1);  
        BigDecimal b2 = new BigDecimal(num2);  
        return b1.multiply(b2).doubleValue();  
    }  
    //除法 返回 num1/num2  
    public double div(double num1, double num2){  
        return div(num1,num2,location);  
    }  
    //除法 返回num1/num2 自定义小数点后位数  
    public double div(double num1, double num2, int _location){  
        BigDecimal b1 = new BigDecimal(num1);  
        BigDecimal b2 = new BigDecimal(num2);  
        return b1.divide(b2,_location,BigDecimal.ROUND_HALF_UP).doubleValue();  
    }  
  
  
    public static void main(String[] args)   
    {  
        BigDecimalDemo bd = new BigDecimalDemo();  
        System.out.println(bd.add(12.123123,2));  //14.123123  
        System.out.println(bd.sub(12.123,5.1)); //7.023  
        System.out.println(bd.mul(9.99999,8.8888)); //88.887911112  
        System.out.println(bd.div(13,3));  //4.3333333333  小数点后10位  
        System.out.println(bd.div(13,3,20));  //4.333333333333333  小数点后15位  
  
        double b = 4.123123123123123123123123123;  //4.123123123123123   double小数点后15位  
        System.out.println(b);  
        
        System.out.println("x:"+bd.add(b, 411111111111112123123131111111111111123111111111111111111111111111111111111111111111111111111111111111111111111323231213133.11111111111111111111111111111111111111111111111111111111111111111));
        BigDecimal b2 = new BigDecimal(4.1231231231231231231231231231111111111111111111111111); //4.12312312312312290174531881348229944705963134765625  
        System.out.println("b2:"+b2);  
        System.out.println(bd.div(1, 3,20));
    }  
}  