package com.tencent.weishi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TextMap {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        map.put(1,2);
        map.put(2,3);
        map.put(3,4);
        map.put(4,4);
        Set<Integer> keys=map.keySet();
        Iterator<Integer> iterator1=keys.iterator();
        while (iterator1.hasNext()){
            System.out.print(iterator1.next() +", ");
        }
        System.out.println();
    }
}
