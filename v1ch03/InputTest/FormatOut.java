import java.util.Date;

public class FormatOut {
    public static void main(String[] args) {
        double x= -10000.0/3.0;
        double y= 1000000;
        System.out.println(x);

        Integer integer =20555;

        //8个字符的宽度和小数点后两个字符的精度打印x
        System.out.println("定点浮点数");
        System.out.printf("%8.2f%<a",x);
        System.out.println("十进制整数");
        System.out.printf("%d",integer);
        System.out.println("十六进制整数");
        System.out.printf("%x",integer);
        System.out.println("指数浮点数");
        System.out.printf("%8.2e",x);
        System.out.println("通用浮点数");
        System.out.printf("%g",y);
        System.out.println("十六进制浮点数");
        System.out.printf("%8.2a",65.0);

        System.out.println("时间");


        Date now = new Date();
        System.out.printf("当前日期：%tY-%tm-%td%n", now, now, now);
        System.out.printf("当前时间：%tH:%tM:%tS%n", now, now, now);
        System.out.printf("今天是星期：%tA%n", now);
        System.out.printf("现在是：%tI:%tM %tp%n", now, now, now);

        System.out.printf("现在是：%tc", now);
    }
}
