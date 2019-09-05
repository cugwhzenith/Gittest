package com.itheima.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

public class test05 {
    static HashMap<String, String> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        System.out.println("-----------欢迎光临黑马商城-----------");
        System.out.println("1、登录");
        System.out.println("2、注册");
        System.out.println("3、退出");
        System.out.println("输入你的选择:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                exit();
                break;
        }
    }

    static void login() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入账号：");
        String u = sc.nextLine();
        System.out.println("输入密码：");
        String p = sc.nextLine();
        if (hm.containsKey(u)) {
            System.out.println("welcome");
            System.out.println("-----------商品操作-----------");
            System.out.println("1、添加商品");
            System.out.println("2、查询商品");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addGoods();
                    break;
                case 2:
                    queryGoods();
                    break;

            }

        } else {
            System.out.println("你应该注册");
            register();
        }
    }

    static void register() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的注册账号：");
        String u = sc.nextLine();
        System.out.println("输入密码：");
        String p = sc.nextLine();
        if(hm.containsKey(u)){
            System.out.println("用户已存在");
            register();
        }else{
            hm.put(u,p);
        }
        System.out.println("已注册请登录");
        login();
    }

    static void addGoods() throws IOException {
        Scanner sc = new Scanner(System.in);
        FileWriter fw = new FileWriter("郑好\\src\\com\\itheima\\test\\goods.txt");
        System.out.println("请输入商品名称：");
        String n = sc.nextLine();
        System.out.println("输入商品价格：");
         int p = sc.nextInt();
        Properties pro = new Properties();
        pro.setProperty(n,p+"");
        pro.store(fw,"goods information");
        fw.close();
    }

    static void queryGoods() throws IOException {
        Scanner sc = new Scanner(System.in);
        FileReader fr = new FileReader("郑好\\src\\com\\itheima\\test\\goods.txt");
        Properties pro = new Properties();
        pro.load(fr);
        fr.close();
        System.out.println("请输入要查询的商品名称：");
        String name = sc.nextLine();
        boolean flag=true;
        for (Object o : pro.keySet()) {
            if(o.equals(name)){
                System.out.println("商品价格："+pro.getProperty(name));
                flag=false;
                break;
            }
        }
        if (flag){
            System.out.println("没有此商品信息");
        }
    }

    static void exit() {
        System.exit(0);
    }
}

class user {
    private String userName;
    private String passWord;

    public user(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public user() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}

class goods {
    private String name;
    private int price;

    public goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public goods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}