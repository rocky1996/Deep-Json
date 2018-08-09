package com.tencent.weishi;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.Map;

public class TestMain {
 //   public static void main(String[] args) {
//        String JsonContext = new Util().ReadFile("d:\\json\\fan.json");
//        JSONArray jsonArray = JSONArray.fromObject(JsonContext);
//		/*String s= java.net.URLDecoder.decode(JsonContext, "utf-8");
//		JSONObject jsonArray = new JSONObject();*/
//
//        int size = jsonArray.size();
//        System.out.println("Size: " + size);
//        for(int  i = 0; i < size; i++){
//            JSONObject jsonObject = jsonArray.getJSONObject(i);
//            System.out.println("name=" + jsonObject.get("name"));
//            System.out.println("package_name=" + jsonObject.get("package_name"));
//            System.out.println("check_version=" + jsonObject.get("check_version"));
//        }
//        String JsonContext = new Util().ReadFile("d:\\json\\fan.json");
//        String jsonStr = JsonContext;
//        jsonStr = jsonStr.replace("\\\"", "'");
//        JSONObject json1=JSONObject.fromObject(jsonStr);
//        Map<String, Object> map =json1;
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            System.out.println(entry.getKey()+entry.getValue());
//            System.out.println(entry.getKey());
//            if(!(entry.getValue().getClass().equals(Object[].class))){
//                System.out.println(entry.getKey());
//            }
//            System.out.println(entry.getValue());
//
//            if(isArray(entry.getValue())){
//                System.out.println(entry.getKey());
//            }

//        }
//    }
//
//    public static boolean isArray(Object obj) {
//        if(obj == null) {
//            return false;
//        }
//        return obj.getClass().isArray();
//    }

//    public static void main(String[] args) {
//        String JsonContext = new Util().ReadFile("d:\\json\\fan.json");
//        JSONObject jsonObject=JSONObject.fromObject(JsonContext);
//        TestMain.getAllKey(jsonObject);
//    }
//
//    /**
//     * 判断某个Json字符串是否为一个Json数组
//     * @param jsonObject
//     * @return
//     */
//    public static Boolean isArrayOrObject(String jsonObject){
//        String type=JSONObject.fromObject(jsonObject).get("type").toString();
//        if(type.equals("object") || type.equals("array")){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    /**
//     * 判断某个Json字符串是否为一个标准的Json字符串
//     * @param jsonString
//     * @return
//     */
//    public static Boolean isJsonObject(String jsonString){
//        try{
//            JSONObject.fromObject(jsonString);
//            return true;
//        }catch (Exception e){
//            return false;
//        }
//    }
//
//    /**
//     * 从未知的JsonArray中获取LinkedList
//     * @return
//     */
//    public static LinkedList<LinkedList<String>> getLinkedListFromJsonArray(String jsonArrayStr){
//
//        LinkedList<LinkedList<String>> linkedList=null;
//        if(jsonArrayStr!=null && jsonArrayStr.length()>0){
//            JSONArray jsonArray=JSONArray.fromObject(jsonArrayStr);
//            linkedList=new LinkedList<LinkedList<String>>();
//            for(int i=0;i<jsonArray.size();i++){
//                JSONArray array=JSONArray.fromObject(jsonArray.get(i));
//                LinkedList<String> internalList=new LinkedList<String>();
//                for(int j=0;j<array.size();j++){
//                    internalList.add(array.get(j).toString());
//                }
//                linkedList.add(internalList);
//            }
//        }
//        return linkedList;
//    }
//
//    /**
//     * 递归读取所有的key，某些限制可以自己除去，核心部分
//     * @param jsonObject
//     */
//    public static void getAllKey(JSONObject jsonObject){
//        Iterator<String> keys=jsonObject.keys();
//        while(keys.hasNext()){
//            String key=keys.next();
//            if(isJsonObject(jsonObject.get(key).toString())){
//                if(!key.equals("properties") && !isArrayOrObject(jsonObject.get(key).toString())) {
//                    System.out.println(key);
//                }
//                JSONObject innerObject=JSONObject.fromObject(jsonObject.get(key));
//                getAllKey(innerObject);
//            }
//        }
//    }


//    public void  analysisJson(Object objJson) {
//        //如果obj为json数组
//        if (objJson instanceof JSONArray) {
//            JSONArray objArray = (JSONArray) objJson;
//            for (int i = 0; i < objArray.size(); i++) {
//                analysisJson(objArray.get(i));
//            }
//        }else if(objJson instanceof JSONObject){
//            JSONObject jsonObject = (JSONObject)objJson;
////            Iterator it = jsonObject.keys();
////            while(it.hasNext()){
////                String key = it.next().toString();
////                Object object = jsonObject.get(key);
////                //如果得到的是数组
////                if(object instanceof JSONArray){
////                    JSONArray objArray = (JSONArray)object;
////                    analysisJson(objArray);
////                }
////                //如果key中是一个json对象
////                else if(object instanceof JSONObject){
////                    analysisJson((JSONObject)object);
////                }
////                //如果key中是其他
////                else{
////                    System.out.println("["+key+"]:"+object.toString()+" ");
////                }
////            }
//            Map<String, Object> map =jsonObject;
//            for (Map.Entry<String, Object> entry : map.entrySet()) {
//                System.out.println(entry.getKey() +"："+entry.getValue());
//            }
//
//        }
//    }

    public static void main(String[] args) {
//        TestMain test = new TestMain();
//        String JsonContext = new Util().ReadFile("d:\\json\\text.json");
//        JSONObject jsonObject = JSONObject.fromObject(JsonContext);
//        test.analysisJson(jsonObject);
        String JsonContext = new Util().ReadFile("d:\\json\\text.json");
        System.out.println(JsonContext);
//        JsonContext.replace("\\\"","'");
//        JSONObject jsonObject = JSONObject.fromObject(JsonContext);
//        Map<String, Object> map =jsonObject;
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            System.out.println(entry.getKey() +"："+entry.getValue());
//        }
    }
}
