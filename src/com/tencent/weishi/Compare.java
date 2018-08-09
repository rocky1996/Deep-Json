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

        String JsonContext1 = new Util().ReadFile("d:\\json\\test1.json");
        JsonContext1 = JsonContext1.replace("\\\"","'");
        JSONObject jsonObject1 = JSONObject.fromObject(JsonContext1);
        Map<String, Object> map1 =jsonObject1;

        String JsonContext2 = new Util().ReadFile("d:\\json\\test2.json");
        JsonContext2 = JsonContext2.replace("\\\"","'");
        JSONObject jsonObject2 = JSONObject.fromObject(JsonContext2);
        Map<String, Object> map2 =jsonObject2;

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        HashMap<String,Object> hashMap1 = new HashMap<>();
        HashMap<String,Object> hashMap2 = new HashMap<>();

        for (Map.Entry<String, Object> entry1 : map1.entrySet()) {
            //list1.add(entry1.getKey());
            hashMap1.put(entry1.getKey(),entry1.getValue());
        }

        for (Map.Entry<String, Object> entry2 : map2.entrySet()) {
            //list2.add(entry2.getKey());
            hashMap2.put(entry2.getKey(),entry2.getValue());
        }

//        for(int i=0;i<list2.size();i++){
//            if(list1.contains(list2.get(i))){
//
//            }else{
//
//            }
//        }

        Set<String> keys1=hashMap1.keySet();
        Iterator<String> iterator1=keys1.iterator();
        while (iterator1.hasNext()){
            list1.add(iterator1.next());
        }

        Set<String> keys2 = hashMap2.keySet();
        Iterator<String> iterator2=keys2.iterator();
        while (iterator2.hasNext()){
            list2.add(iterator2.next());
        }

        for(int i=0;i<list2.size();i++){
            if(list1.contains(list2.get(i))){
                if(!(hashMap1.get(list1.get(i)).equals(hashMap2.get(list2.get(i))))){
//                    System.out.println(hashMap1.get(list1.get(i)));
//                    System.out.println(hashMap2.get(list2.get(i)));
                    System.out.println("序列化json中的字段"+list1.get(i)+"对应的值与反序列化json中该字段对应的值不符，序列化中该字段对应的值是"+hashMap1.get(list1.get(i))+",而反序列化中该字段对应的值是"+hashMap2.get(list2.get(i)));
                }
            }else{
                System.out.println("序列json中并不存在反序列化json中的"+list2.get(i)+"字段");
            }
        }
    }
}
