package math;

import e.TestEnum;

public class TestMath {
    public static void main(String[] args) {
        //测试平方根
        double x = 4;
        double sqrt = Math.sqrt(x);
        System.out.println("1.sqrt=" + sqrt);
        //2.测试幂运算
        System.out.println("2.pow=" + Math.pow(2, 2));
        //3.测试floorMod
        int floorModResult = Math.floorMod(-19, 2);
        System.out.println("3.floorModResult=" + floorModResult);
        //4.常用的三角函数
        System.out.println("4.1.sin=" + Math.sin(Math.PI / 2));
        System.out.println("4.2.scos=" + Math.cos(0));
        System.out.println("4.3.stan=" + Math.tan(Math.PI / 4));
        System.out.println("4.4.satan=" + Math.atan(1) * 180 / Math.PI);
        System.out.println("4.5.satan=" + Math.atan2(1, 1) * 180 / Math.PI);
        //5.指数函数
        System.out.println("5.1.1.exp=" + Math.log(Math.exp(2)));
        //Math.exp(2) ->e的二次方
        System.out.println("5.1.2.exp=" + Math.log(Math.pow(Math.E, 2)));
        System.out.println("5.2.log=" + Math.log10(Math.pow(10, 2.0)));
        //6.强制类型转换
        double p = 3000000000.0;
        int doubleCastInt = (int) p;
        System.out.println("6.强制类型转换" + doubleCastInt);
        //7.四舍五入
        long round1 = Math.round(29.5);
        System.out.println("7.四舍五入" + round1);
        //8.截断
        Integer sourceInteger = 300;
        String binaryString = Integer.toBinaryString(sourceInteger);
        String substring = binaryString.substring(1);
        System.out.println("8.截断原值" + binaryString);
        int i = Integer.parseInt(substring, 2);
        System.out.println("8.截断中间值" + i);
        System.out.println("8.截断后值" + Integer.toBinaryString(i));
        //截断看到没有（byte）300的实际值为44
        //9.二元运算符
        Integer binaryOperator = 2;
        binaryOperator += binaryOperator;
        System.out.println("9.二元运算符" + binaryOperator);
        //10.三元运算符
        int m = 1;
        int n = 2;
        int min = m < n ? m : n;
        System.out.println("10.三元运算符" + min);
        //11.位运算符
        int number = 0b1100;
        int isRight = (number & 0b0100) / 0b0100;
        System.out.println("11.1.位运算符" + isRight);
        //11.2.左移和右移动
        Integer soureValue = 0b1100;
        Integer i1 = soureValue >> 1;
        System.out.println("11.2.1.右移" + i1);
        System.out.println("11.2.2.右移动后二进制" + Integer.toBinaryString(i1));
        Integer i2 = soureValue << 1;
        System.out.println("11.2.3.左移" + i2);
        System.out.println("11.2.4右移动后二进制" + Integer.toBinaryString(i2));
        Integer soureValue2 = -0b1100;
        String s = Integer.toBinaryString(soureValue2);
        System.out.println("11.2.5.负数的二进制" + s + "位数:" + s.length());
        int i3 = soureValue2 >> 1;
        System.out.println("11.2.6.负数的二进制>>右移" + i3);
        String s1 = Integer.toBinaryString(i3);
        System.out.println("11.2.7.>>右移后二进制" + s1 + "位数:" + s1.length());
        int i4 = soureValue2 >>> 1;
        System.out.println("11.2.8.负数的二进制>>>右移" + i4);
        //高位补0了
        //toBinaryString转换的时候不会显示二进制数前面的0
        String s2 = Integer.toBinaryString(i4);
        System.out.println("11.2.9.>>右移后二进制" + s2 + "位数:" + s2.length());
        //11.3 xor not
        Integer xorValue1 = 0b1100;
        Integer xorValue2 = 0b0000;
        Integer i5 = xorValue1 ^ xorValue2;
        Integer i6 = ~xorValue1;
        System.out.println("11.3.1xor:"+Integer.toBinaryString(i5));
        String s3 = Integer.toBinaryString(i6);
        System.out.println("11.3.2not:"+ s3 + "位数:" + s3.length());
        //12 运算符优先级
        Integer i7 = 0b1100 + 0b0011 >> 3;
        System.out.println("12 运算符优先级:"+Integer.toBinaryString(i7));

    }
}
