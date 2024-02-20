import java.util.Scanner;

public class InputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建 Scanner 对象来读取标准输入流（键盘输入）
        
        System.out.print("请输入一个双精度浮点数：");
        if (scanner.hasNextDouble()) { // 检查输入中是否有下一个双精度浮点数
            double num = scanner.nextDouble(); // 从输入流中读取双精度浮点数
            System.out.println("你输入的双精度浮点数是：" + num);
        } else {
            System.out.println("输入不是双精度浮点数！");
        }
        
        scanner.close(); // 关闭 Scanner 对象

        System.out.println(Double.MAX_VALUE);
    }
}