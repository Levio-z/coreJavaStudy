package spring;

public class springFormat {
    public static void main(String[] args) {
        //+号的用法
        String str;
        str = String.format("数字的正负表示：%+d %d %+d %d",8,8,-8,-8);
        System.out.println(str);
        //左右对齐默认都是填充空格
        //-的用法 字符串放在最左边，右边位数不够补充空格
        str = String.format("左对齐：%-6d",8);
        System.out.println(str+"aaaa");
        //0的用法，默认右对齐，默认在左边补充空格
        str = String.format("%06d",8);
        System.out.println("缺位补零：aaaa"+str);
        //' '空格的用法
        str = String.format("缺位补空格：% 6d",8);
        System.out.println(str);
        str = String.format("缺位补空格：% 6d",-8);
        System.out.println(str);
        //,的用法
        str = String.format("数字分组：%,d",123456789);
        System.out.println(str);
        //(的用法
        str = String.format("括号用法：%(d",-8888);
        System.out.println(str);
        str = String.format("括号用法：%(d",8888);
        System.out.println(str);
        //#的用法 十进制转换为16进制输出
        str = String.format("#括号用法(十六进制)：%#x",12);
        System.out.println(str);
        str = String.format("#括号用法(八进制)：%#o",12);
        System.out.println(str);
        //<的用法
        str = String.format("<括号用法：%f %<3.1f",3.14,3.2);
        //"%<3.1f"作用的对象是前一个"%f"所作用的对象
        System.out.println(str);
        //具体来说，它表示输出一个宽度为1（如果需要的话，会自动在前面填充空格），小数保留5位的浮点数.输出位数包含小数点
        str = String.format("%010.5f",3.14);
        //"%<3.1f"作用的对象是前一个"%f"所作用的对象
        System.out.println("xx"+str+"xx");
    }
}
