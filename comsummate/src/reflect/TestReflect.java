package reflect;
public class TestReflect {
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 获取Class对象的三种方式
        System.out.println("根据类名:  \t" + TestUser.class);
        System.out.println("根据对象:  \t" + new TestUser().getClass());
        System.out.println("根据全限定类名:\t" + Class.forName("reflect.TestUser"));
        // 常用的方法
        Class<TestUser> userClass = TestUser.class;
        System.out.println("获取全限定类名:\t" + userClass.getName());
        System.out.println("获取类名:\t" + userClass.getSimpleName());
        System.out.println("实例化:\t" + userClass.newInstance());
    }
}
