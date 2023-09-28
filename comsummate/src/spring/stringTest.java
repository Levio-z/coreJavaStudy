package spring;


import com.sun.security.jgss.GSSUtil;

import java.nio.charset.StandardCharsets;
import java.util.stream.IntStream;

public class stringTest {
    public static void main(String[] args) {
        testCharAt();
        testCodePointAt();
        testOffsetByCodePoints();
        testCharAt2();
        testCompareTo();
        testCodePoints();
        testNewString();
        testIntToByte();
        testEquals();
        testEqualsIgnoreCase();
        testEqualsIgnoreCase2();
        testStartsWith();
        testIndexOf();
        testIndexOfInt();
        testCodePointCount();
        testReplace();

    }
    // 返回给定位置的代码单元。除非对底层的代码单元感兴趣，否则不需要调用这个方法。
    private static void print(int i) {
        System.out.println("测试开始"+i+"================================");
    }

    private static void printPlus(int i) {
        System.out.println("printPlus"+i+"================================");
    }
    public static void testCharAt(){
        print(1);
        String str = "\uD83D\uDE00123";
        char c1 = str.charAt(0);
        char c2 = str.charAt(1);
        char c3 = str.charAt(2);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }

    public static void testCharAt2(){
//        printPlus(1);
//        byte[] val = new byte[]{1,2};
//        Integer index =2;
//        assert index >= 0 && index < val.length : "Trusted caller missed bounds check";
    }
    // 返回给定位置的码点str.codePointAt(0)
    // 1.索引位置为高代理，返回完整码点
    // 2.索引位置为低代理，返回char值
    public static void testCodePointAt(){
        print(2);
        String str = "\uD83D\uDE00123";
        System.out.println(str.codePointAt(0));
        //128512=>128512-65536=>62976=>111101 ||
        // 10 0000 0000
        // 前面补0到16位:低代理位=>0000 0010 0000 0000
        // +DC00:=>0200+DC00=>DE00=>56832
        System.out.println(str.codePointAt(1));
        //56832
        System.out.println(str.codePointAt(2));
    }
   // 返回从startIndex代码点开始，位移cpCount后的码点索引。
    public static void testOffsetByCodePoints(){
        print(3);
        String str = "123";
        //56832
        System.out.println(str.codePointAt(str.offsetByCodePoints(0,1)));
    }
    // 返回从startIndex代码点开始，位移cpCount后的码点索引。
    public static void testCompareTo(){
        print(4);
        String str = "123";
        int c = "aa".compareTo("ac");
        int d = "ac".compareTo("accc");
        System.out.println(c);
        System.out.println(d);
    }
    // 测试CodePoints()
    public static void testCodePoints(){
        print(5);
        String str = "\uD83D\uDE00123";
        int[] ints = str.codePoints().toArray();
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    // new String(int[ ] codePoints, int offset, int count) 5.0
    // 用数组中从offset开始的count个码点构造一个字符串。
    public static void testNewString(){
        print(6);
        String str = "\uD83D\uDE00123";
        int[] ints = str.codePoints().toArray();
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        System.out.println(new String(ints,0,0));
    }
    // 测试int类型转换为字节数组
    public static void testIntToByte(){
        print(7);

        byte[] b = new byte[]{0};
        b[0] = (byte)(512+255);
        System.out.println(intToHex(b));
    }
    // 测试字节数组转化为16进制表示字符串
    public static  String intToHex(byte[] byteArray){
        StringBuilder hexStringBuffer = new StringBuilder();

        for (byte b : byteArray) {
            String hexString = String.format("%02X", b);
            hexStringBuffer.append(hexString);
        }
        return hexStringBuffer.toString();
    }
    public static void testEquals(){
        print(8);
        String str = "123";
        boolean equals = str.equals(str);
        System.out.println(equals);
    }

    public static void testEqualsIgnoreCase(){
        print(9);
        String str = "😀";
        boolean equals = str.equalsIgnoreCase(str);
        System.out.println(equals);
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            System.out.println((int)aChar);
            char c = Character.toUpperCase(aChar);
            System.out.println((int)c);
        }

    }
    public static void testEqualsIgnoreCase2(){
        int i = Character.toUpperCase(97);
        int i2 = Character.toUpperCase(65);
        System.out.println(i);
        System.out.println(i2);

    }

    public static void testStartsWith(){
        print(10);
        String a ="123";
        boolean b = a.startsWith("1");
        boolean b1 = a.endsWith("3");
        System.out.println(b);
        System.out.println(b1);
    }

    public static void testIndexOf() {
        print(11);
        String a ="123";
        int i = a.indexOf("2");
        System.out.println(i);
    }
    public static void testIndexOfFromIndex() {
        print(11);
        String a ="123";
        int i = a.indexOf("2",2);
        System.out.println(i);
    }

    public static void testIndexOfInt() {
        print(12);
        String a ="1😀12";
        int[] ints = a.codePoints().toArray();
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        //
        int i = a.indexOf(128512);
        System.out.println(i);
    }
    public static void testCodePointCount(){
        print(13);
        String a ="😀112";
        int codePointCount = a.codePointCount(0, a.length());
        System.out.println(codePointCount);
    }

    public static void testReplace(){
        print(14);
        String a ="😀112";
        String replace = a.replace("1", "2");
        System.out.println(replace);
    }


}
