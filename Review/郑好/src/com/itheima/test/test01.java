package com.itheima.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class test01 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date date = sdf.parse("2015-10-20");

        Scanner sc = new Scanner(System.in);
        System.out.println("输入你的日期：");
        String timeStr = sc.nextLine();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yy-MM-dd");
        Date date2 = sdf2.parse(timeStr);
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年-MM月-dd日是EE，是yyyy年的第DD天");
        String d3 = sdf3.format(date2);
        System.out.println(d3.toString());

    }
}
