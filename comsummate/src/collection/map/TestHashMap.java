package collection.map;

import java.util.HashMap;
import java.util.HashSet;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("aa","aa");
        HashMap<Object, Object> map2 = new HashMap<>();
        if ((map=map2)!=null){
            System.out.println(map.hashCode());
            System.out.println(map2.hashCode());
        }
        System.out.println(map==map2);
        HashSet<Object> objects = new HashSet<>();
        objects.add("aa");
    }
}
