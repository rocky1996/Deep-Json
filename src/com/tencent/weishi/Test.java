package com.tencent.weishi;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        String str = "{\n" +
//                "\t\"key_filter_desc_json\": \"{\\\"decoration\\\":\\\"\\\",\\\"name\\\":\\\"±ê×¼\\\",\\\"desc\\\":\\\"ºá»¬»»ÂË¾µ\\\",\\\"effects\\\":[0],\\\"flagID\\\":\\\"normal\\\",\\\"imageRes\\\":2130839029,\\\"inner\\\":true,\\\"isNew\\\":false,\\\"filterID\\\":1078,\\\"mask\\\":0,\\\"faceFeature\\\":0.5,\\\"defaultValue\\\":1.0,\\\"appVersion\\\":0,\\\"adjustValue\\\":0.0,\\\"progress\\\":0,\\\"status\\\":0,\\\"style\\\":0,\\\"adjustEditValue\\\":1.0,\\\"version\\\":0}\"\n" +
//                "}";
        //String str = "{\"key_filter_desc_json\":\"{\\\"decoration\\\":\\\"\\\",\\\"name\\\":\\\"±ê×¼\\\",\\\"desc\\\":\\\"ºá»¬»»ÂË¾µ\\\",\\\"effects\\\":[0],\\\"flagID\\\":\\\"normal\\\",\\\"imageRes\\\":2130839029,\\\"inner\\\":true,\\\"isNew\\\":false,\\\"filterID\\\":1078,\\\"mask\\\":0,\\\"faceFeature\\\":0.5,\\\"defaultValue\\\":1.0,\\\"appVersion\\\":0,\\\"adjustValue\\\":0.0,\\\"progress\\\":0,\\\"status\\\":0,\\\"style\\\":0,\\\"adjustEditValue\\\":1.0,\\\"version\\\":0}\"}";
        String JsonContext = new Util().ReadFile("d:\\json\\1532952591098");
        //System.out.println(JsonContext);
        JsonContext = JsonContext.replace("\\\"","'");
        JSONObject jsonObject = JSONObject.fromObject(JsonContext);
        Map<String, Object> map =jsonObject;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() +"£º"+entry.getValue());
        }
    }
}
