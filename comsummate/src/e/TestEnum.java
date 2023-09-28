package e;

import java.util.stream.IntStream;

public enum TestEnum {
    AA(6),
    BB(7);
    private int a;

    public int getA() {
        return a;
    }

    TestEnum(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        String a = "😀a";
        //1.length
        System.out.println("1.代码单元数" + a.length());
        //2.码点数量
        int codePointCount = a.codePointCount(0, a.length());
        System.out.println("2.码点数量" + codePointCount);
        //3.返回指定位置的代码单元
        char c = a.charAt(0);
        System.out.println("3.返回指定位置的代码单元" + (int)c);
        //4.要想得到第i个码点，应该使用下列语句
        int i = a.offsetByCodePoints(0, 0);
        int i1 = a.codePointAt(i);
        System.out.println("4.要想得到第i个码点，应该使用下列语句" + i1);
        //5.遍历码点
        int[] ints = a.codePoints().toArray();
        System.out.println("5.遍历码点开始" + ints);
        for ( int j=0;j<ints.length;j++){
            System.out.println("5.遍历码点" + ints[j]);
        }
        System.out.println("5.遍历码点结束" + ints);
        //6.码点转字符串
        System.out.println("5.码点数组转字符串"+new String(ints,0,ints.length));
    }
}
