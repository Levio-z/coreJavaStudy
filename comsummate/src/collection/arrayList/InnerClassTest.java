package collection.arrayList;

public class InnerClassTest {
    // String 类型成员变量
    private String str ="123";
    // 静态内部类
     class InnerClass {
        public void print() {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        // 测试静态内部类();
        InnerClass test = new InnerClassTest().new InnerClass();
        test.print();

    }
}
