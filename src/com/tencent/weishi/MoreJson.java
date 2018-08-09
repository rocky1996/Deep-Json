package com.tencent.weishi;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MoreJson {
    public static void main(String[] args) {
        String JsonContext = new Util().ReadFile("d:\\json\\fan.json");
        JSONObject jsonObject = JSONObject.fromObject(JsonContext);
        Map<String, Object> map =jsonObject;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
}
