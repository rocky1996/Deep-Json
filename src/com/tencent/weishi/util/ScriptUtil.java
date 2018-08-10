package com.tencent.weishi.util;

import com.tencent.weishi.Util;
import net.sf.json.JSONObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class ScriptUtil {
    private Frame frame;
    private TextField tf1;
    private TextField tf2;
    private Button b1;
    private Button b2;
    private TextArea ta1;
    private TextArea ta2;
    private TextArea ta3;
    private Button b3;

    public ScriptUtil(){
        init();
    }

    public void init(){
        frame = new Frame("Json对比工具");
        frame.setBounds(300,100,600,900 );
        frame.setLayout(new FlowLayout());

        tf1 = new TextField(60);
        b1 = new Button("源序列化文件提交");
        tf2 = new TextField(60);
        b2 = new Button("反序列化文件提交");
        ta1 = new TextArea(25,35);
        ta2 = new TextArea(25,35);
        b3 = new Button("开始对比");
        ta3 = new TextArea(25,70);

        frame.add(tf1);
        frame.add(b1);
        frame.add(tf2);
        frame.add(b2);
        frame.add(ta1);
        frame.add(ta2);
        frame.add(ta3);
        frame.add(b3);

        myEvent();
        frame.setVisible(true);
    }

    private void myEvent(){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Jsonpath1 = tf1.getText();
                String JsonContext = ScriptUtil.ReadFile(Jsonpath1);
                JsonContext = JsonContext.replace("\\\"","'");
                JSONObject jsonObject = JSONObject.fromObject(JsonContext);
                Map<String, Object> map =jsonObject;
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    //System.out.println(entry.getKey() +"："+entry.getValue());\
                    ta1.append(entry.getKey()+"："+entry.getValue()+"\r\n");
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Jsonpath2 = tf2.getText();
                String JsonContext = ScriptUtil.ReadFile(Jsonpath2);
                JsonContext = JsonContext.replace("\\\"","'");
                JSONObject jsonObject = JSONObject.fromObject(JsonContext);
                Map<String, Object> map =jsonObject;
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    ta2.append(entry.getKey()+"："+entry.getValue()+"\r\n");
                }
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String JsonContext1 = new Util().ReadFile(tf1.getText());
                JsonContext1 = JsonContext1.replace("\\\"","'");
                JSONObject jsonObject1 = JSONObject.fromObject(JsonContext1);
                Map<String, Object> map1 =jsonObject1;

                String JsonContext2 = new Util().ReadFile(tf2.getText());
                JsonContext2 = JsonContext2.replace("\\\"","'");
                JSONObject jsonObject2 = JSONObject.fromObject(JsonContext2);
                Map<String, Object> map2 =jsonObject2;

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

//                java.util.List<String> list1 = new ArrayList<>();
//                List<String> list2 = new ArrayList<>();
//                HashMap<String,Object> hashMap1 = new HashMap<>();
//                HashMap<String,Object> hashMap2 = new HashMap<>();
//
//                for (Map.Entry<String, Object> entry1 : map1.entrySet()) {
//                    //list1.add(entry1.getKey());
//                    hashMap1.put(entry1.getKey(),entry1.getValue());
//                }
//
//                for (Map.Entry<String, Object> entry2 : map2.entrySet()) {
//                    //list2.add(entry2.getKey());
//                    hashMap2.put(entry2.getKey(),entry2.getValue());
//                }
//
//                List<String> keys1 = function(hashMap1);
//                //Set<String> keys1=hashMap1.keySet();
//                Iterator<String> iterator1=keys1.iterator();
//                while (iterator1.hasNext()){
//                    list1.add(iterator1.next());
//                }
//
//                List<String> keys2 = function(hashMap2);
//                //Set<String> keys2 = hashMap2.keySet();
//                Iterator<String> iterator2=keys2.iterator();
//                while (iterator2.hasNext()){
//                    list2.add(iterator2.next());
//                }
//
//                for(int i=0;i<list1.size();i++){
//                    System.out.println(list1.get(i));
//                }
//                for(int i=0;i<list2.size();i++){
//                    System.out.println(list2.get(i));
//                }

                for(int i=0;i<list2.size();i++){
                    if(list1.contains(list2.get(i))){
                        if(!hashMap1.get(list1.get(i)).equals(hashMap2.get(list2.get(i)))){
//                            System.out.println(hashMap1.get(list1.get(i)));
//                            System.out.println(hashMap2.get(list2.get(i)));
                            ta3.append("序列化json中的字段"+list1.get(i)+"对应的值与反序列化json中该字段对应的值不符，序列化中该字段对应的值是"+hashMap1.get(list1.get(i))+",而反序列化中该字段对应的值是"+hashMap2.get(list2.get(i)));
                        }
                    }else{
                        ta3.append("序列化json中并不存在反序列化json中的"+list2.get(i)+"字段");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new ScriptUtil();
    }

    public static String ReadFile(String path) {
        BufferedReader reader = null;
        String laststr = "";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
            reader = new BufferedReader(inputStreamReader);

            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }

    //遍历hashmap的所有key值
    public static List<String> function(HashMap<String,Object> map){
        List<String> list = new ArrayList<String>();
        Collection keys = map.keySet();
        for (Iterator iterator=keys.iterator(); iterator.hasNext();){
            Object key = iterator.next();
            list.add((String) key);
        }
        return list;
    }
}