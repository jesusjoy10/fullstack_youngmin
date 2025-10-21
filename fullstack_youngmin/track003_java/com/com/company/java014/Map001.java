package com.company.java014;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//1. 콜렉션프레임워크 - [배열]의 단점을 개선한 [객체]만 저장가능한 [동적배열]
//2. List, Set, Map
//List(기차) - index O, 중복허용 O, add, get(순서), size, remove(순서), contains
//Set(주머니) - index 순서x , 중복허용 x,  add, 향상된 for,iterator, size, remove(객체), contains
//Map(사전)  - key:value → entry  한쌍, put / get(key)  향상된 for,iterator / size / remove(객체) / contains

public class Map001 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("1: " + map);
        System.out.println("1: " + map.get("two"));
        System.out.println("1: " + map.size());
        System.out.println("1: " + map.remove("two"));
        System.out.println("1: " + map.containsKey("one"));

        for (Entry<String, Integer> one : map.entrySet()) {
            System.out.println(one.getKey() + "/" + one.getValue());
            
        }
        Iterator<Entry<String,Integer>>iter = map.entrySet().iterator();
        while(iter.hasNext()) {// 2) 처리대상 확인 [iter->one=1, three=3]}
        	Entry<String, Integer> temp = iter.next(); //[one=1]
        	System.out.println(temp.getKey() + "/" + temp.getValue());
        }
    }
}
