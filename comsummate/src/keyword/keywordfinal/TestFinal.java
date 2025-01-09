package keyword.keywordfinal;

public class TestFinal {
    static {
        System.out.println("静态代码块开始执行");
    }

    final String finalVar;
    String var;

    {
        System.out.println("代码块开始执行");
        finalVar = "123";
    }

    public TestFinal(String var) {
        System.out.println("构造函数开始执行");
        this.var = var;
    }

    public static void main(String[] args) {
        TestFinal testFinal = new TestFinal("123");
        System.out.println(testFinal.finalVar);
    }

}
