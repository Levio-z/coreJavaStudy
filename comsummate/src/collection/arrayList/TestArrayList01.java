package collection.arrayList;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList01 {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Integer> list = new ArrayList<>();
        // 当设置了初始值的时候会执行最小扩容
        // 第一次直接扩充10
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
    }
}
