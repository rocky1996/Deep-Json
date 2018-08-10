package com.tencent.weishi;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sf.json.JSONObject;

import java.util.*;

public class Compare {
    public static void main(String[] args) {
//        String JsonContext1 = new Util().ReadFile("d:\\json\\test1.json");
//        JsonContext1 = JsonContext1.replace("\\\"","'");
//
//        String JsonContext2 = new Util().ReadFile("d:\\json\\test2.json");
//        JsonContext2 = JsonContext2.replace("\\\"","'");
//
//        JsonParser parser1 = new JsonParser();
//        JsonObject obj1 = (JsonObject)parser1.parse(JsonContext1);
//
//        JsonParser parser2 = new JsonParser();
//        JsonObject obj2 = (JsonObject)parser2.parse(JsonContext2);
//
//        System.out.println(obj1.equals(obj2));

        String JsonContext1 = new Util().ReadFile("d:\\json\\rocky1.json");
        JsonContext1 = JsonContext1.replace("\\\"","'");
        JSONObject jsonObject1 = JSONObject.fromObject(JsonContext1);
        Map<String, Object> map1 =jsonObject1;

        String JsonContext2 = new Util().ReadFile("d:\\json\\rocky2.json");
        JsonContext2 = JsonContext2.replace("\\\"","'");
        JSONObject jsonObject2 = JSONObject.fromObject(JsonContext2);
        Map<String, Object> map2 =jsonObject2;

//        Collection values1 = map1
//        for(Object value:values1){
//            System.out.println("value:"+value);
//        }
//
//        Collection values2 = map2.values();
//        for(Object value:values2){
//            System.out.println("value:"+value);
//        }

        List<String> list1 = new ArrayList<>();
        //List<Object> listObject1 = new ArrayList<>();
        HashMap<String,Object> hashMap1 = new HashMap<>();
        List<String> list2 = new ArrayList<>();
        //List<Object> listObject2 = new ArrayList<>();
        HashMap<String,Object> hashMap2 = new HashMap<>();

        Set set1 = map1.keySet();
        Iterator site1 = set1.iterator();
        while(site1.hasNext()){
            Object key = site1.next();
            Object value = map1.get(key);
            list1.add((String) key);
            //listObject1.add(value);
            hashMap1.put((String)key,value);
        }

        Set set2 = map2.keySet();
        Iterator site2 = set2.iterator();
        while(site2.hasNext()){
            Object key = site2.next();
            Object value = map2.get(key);
            list2.add((String) key);
            //listObject2.add(value);
            hashMap2.put((String)key,value);
        }

//        for(int i=0;i<list1.size();i++){
//            System.out.println(list1.get(i));
//        }
//        for(int i=0;i<list2.size();i++){
//            System.out.println(list2.get(i));
//        }

        for(int i=0;i<list2.size();i++){
            if(list1.contains(list2.get(i))){
                if(!(hashMap1.get(list1.get(i)).equals(hashMap2.get(list2.get(i))))){
                    System.out.println("序列化json中的字段"+list1.get(i)+"对应的值与反序列化json中该字段对应的值不符，序列化中该字段对应的值是"+hashMap1.get(list1.get(i))+",而反序列化中该字段对应的值是"+hashMap2.get(list2.get(i)));
                }
            }else{
                System.out.println("不包括"+list2.get(i));
            }
        }

//        List<String> list1 = new ArrayList<>();
//        List<String> list2 = new ArrayList<>();
//        HashMap<String,Object> hashMap1 = new HashMap<>();
//        HashMap<String,Object> hashMap2 = new HashMap<>();
//
//        for (Map.Entry<String, Object> entry1 : map1.entrySet()) {
//            //list1.add(entry1.getKey());
//            hashMap1.put(entry1.getKey(),entry1.getValue());
//        }
//
//        for (Map.Entry<String, Object> entry2 : map2.entrySet()) {
//            //list2.add(entry2.getKey());
//            hashMap2.put(entry2.getKey(),entry2.getValue());
//        }
//
//        Set<String> keys1=hashMap1.keySet();
//        Iterator<String> iterator1=keys1.iterator();
//        while (iterator1.hasNext()){
//            list1.add(iterator1.next());
//        }
//
//        Set<String> keys2 = hashMap2.keySet();
//        Iterator<String> iterator2=keys2.iterator();
//        while (iterator2.hasNext()){
//            list2.add(iterator2.next());
//        }
//
//        for(int i=0;i<list2.size();i++){
//            if(list1.contains(list2.get(i))){
//                if(!(hashMap1.get(list1.get(i)).equals(hashMap2.get(list2.get(i))))){
//                    System.out.println("序列化json中的字段"+list1.get(i)+"对应的值与反序列化json中该字段对应的值不符，序列化中该字段对应的值是"+hashMap1.get(list1.get(i))+",而反序列化中该字段对应的值是"+hashMap2.get(list2.get(i)));
//                }
//            }else{
//                System.out.println("序列json中并不存在反序列化json中的"+list2.get(i)+"字段");
//            }
//        }
    }
}
