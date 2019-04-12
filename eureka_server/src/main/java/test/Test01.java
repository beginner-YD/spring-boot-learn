package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Test01 {

    public static void main(String[] args) {
        int i=Integer.SIZE-3;
        System.out.println(i);
        Map<String,Object> map=new HashMap<>();
        map.put("张三",1);
        map.put("xsxsx",2323);
        map.put("张dwdw",232332323);
        Collection<Object> values = map.values();
        values.forEach(System.out::println);
        ArrayList<Object> list = new ArrayList<>(values);
        list.forEach(System.out::println);
        list.forEach((Object n)-> System.out.println(n));
        list.forEach(n-> System.out.println(n));
    }
}
