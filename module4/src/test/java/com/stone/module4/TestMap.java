package com.stone.module4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap {

    public static String find3(String key) {
        Map<String, String> map = new HashMap<>();
        map.put("bright", "xiaoming");
        map.put("white", "xiaobai");
        map.put("black", "xiaohei");

        map.put("black", "xiaoerhei");

        map.remove("black");

        map.entrySet();

        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.println("key "+e.getKey()+" value "+e.getValue());
        }
        return map.get(key);
    }

    public static String finad1(int key) {
        String[] array = new String[]{"xiaoming", "xiaobai", "xiaohei"};
        if (key < 0 || key >= array.length) {
            return null;
        }
        return array[key];
    }
    /*
    public static String find1(String value){
        String[] array =new String[]{"xiaoming","xiaobai","xiaohei"};
        for (String s: array) {
            if (s.equals(value)){
                return s;
            }
        }
        return null;
    }
     */

    public static String find2(String value) {
        List<String> list = List.of("xiaoming", "xiaobai", "xiaohei");
        for (String s : list) {
            if (s.equals(value)) {
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(find3("black"));
        System.out.println(find3("test"));
    }
}
