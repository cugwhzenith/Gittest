package com.itheima.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.nextLine();
        HashMap<String, Integer> hm = new HashMap<>();
        String[] sList = str.split("");
        for (String s : sList) {
            if(hm.containsKey(s)){
                hm.put(s,hm.get(s)+1);
            }else{
                hm.put(s,1);
            }
        }
        Set<Map.Entry<String, Integer>> es = hm.entrySet();
        String ans="";
        for (Map.Entry<String, Integer> e : es) {
            ans+=e.getKey()+"("+e.getValue()+")";
        }
        System.out.println(ans);
    }
}
