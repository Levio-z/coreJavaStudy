package collection.arrayList;

public class OuterClass {
    private int privateVar = 10; // 私有成员变量

    public class InnerClass {
        public void accessPrivateVar() {
            System.out.println(privateVar); // 错误：(编译时) 无法访问私有成员
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.accessPrivateVar(); // 这将导致编译错误
    }
}