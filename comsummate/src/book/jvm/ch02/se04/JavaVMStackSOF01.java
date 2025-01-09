package book.jvm.ch02.se04;

/**
 * VM Args：-Xss128k
 * @author zzm
 */
public class JavaVMStackSOF01 {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF01 oom = new JavaVMStackSOF01();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}