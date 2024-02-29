package v1.ch03;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/***
 * 3.7.3 文件输入与输出
 */
public class ch03m7m3 {
    public static void main(String[] args) throws IOException {
        testScanner();
        testPrintWriter();
    }

    /**
     *   文件读取
     */
    public static void testScanner() throws IOException {
        System.out.println(Paths.get("1.txt").toAbsolutePath());
        Scanner in = new Scanner(Paths.get("1.txt"),"UTF-8");
        System.out.println(in.nextLine());

        // 可以构造一个带有字符串参数的Scanner，但这个Scanner将字符串解释为数据，而不是文件名。例如，如果调用：
    }
    /**
     * PrintWriter 文件写入
     */
    public static void testPrintWriter() throws IOException {
        // 构造PrintWriter对象 如果文件不存在创建该对象
        PrintWriter writer = new PrintWriter("2.txt", "UTF-8");
        writer.print("Hello, world!");
        writer.println();
        writer.printf("The number is %d.", 123);
        writer.flush();
    }
}
