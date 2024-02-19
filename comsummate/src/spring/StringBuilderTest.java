package spring;

public class StringBuilderTest {
    public static void testInsert(){
        StringBuilder b =new StringBuilder("😀112");
        //索引位置前面
       b.insert(2,"2");
        System.out.println(b.toString());
    }

    public static void main(String[] args) {
        testInsert();
    }
}
