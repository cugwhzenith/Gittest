package com.itheima.test;

import java.io.File;
import java.util.*;

public class test04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("其请输入一个文件夹绝对路径:");
        String path = sc.nextLine();
        File pathFile = new File(path);
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        ArrayList<String> fileList = findFile(pathFile);
        for (String s : fileList) {
            String[] split = s.split("\\.");
            hm.put(split[1],hm.containsKey(split[1])?hm.get(split[1])+1:1);
        }
        Set<Map.Entry<String, Integer>> es = hm.entrySet();
        for (Map.Entry<String, Integer> e : es) {
            System.out.println(e.getKey()+"类型的文件有"+e.getValue()+"个");
        }
    }
     static ArrayList<String>   findFile(File pathFile){
        File[] listFiles = pathFile.listFiles();
        ArrayList<String> list = new ArrayList<>();
        for (File file : listFiles) {
            if(file.isDirectory()){
                findFile(file);
            }else {
                list.add(file.getName());
            }
        }
        return list;
    }
}
