package com.tencent.weishi;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

public class MoreJson {
    public static void main(String[] args) {
//        String s2 = null;
//        String JsonContext = new Util().ReadFile("d:\\json\\fan.json");
//        JSONArray jsonArray = JSONArray.fromObject(JsonContext);
//        int size = jsonArray.size();
//        System.out.println("Size: " + size);
////        for(int  i = 0; i < size; i++){
////            JSONObject jsonObject = jsonArray.getJSONObject(i);
////            System.out.println("name=" + jsonObject.get("arg_param_guajian_list"));
////            System.out.println("package_name=" + jsonObject.get("arg_param_1frame_ts"));
////        }
        String JsonContext = new Util().ReadFile("d:\\json\\fan.json");
        JSONObject jsonObject = JSONObject.fromObject(JsonContext);
        Map<String, Object> map =jsonObject;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
}
