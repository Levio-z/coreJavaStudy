package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collection {
    public static void main(String[] args) {
        java.util.Collection<String> x = new ArrayList<>();
        x.add("a");
        x.add(null);
        x.add(null);
        List<String> y = new ArrayList<>();
        y.add(null);

        boolean b = x.containsAll(y);
        System.out.println(b);
    }
}
