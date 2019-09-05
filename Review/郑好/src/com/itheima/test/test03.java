package com.itheima.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class test03 {
    public static void main(String[] args) {
        draw d1 = new draw();
        Thread t1 = new Thread(d1, "抽奖箱1");
        Thread t2 = new Thread(d1, "抽奖箱2");
        t1.start();
        t2.start();
    }
}

class draw implements Runnable {

    int[] lottery = {10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700};
    ArrayList<Integer> arr1 = new ArrayList<Integer>();
    ArrayList<Integer> arr2 = new ArrayList<Integer>();
    int i = 0;

    @Override
    public synchronized void run() {
        while (lottery.length > 0) {
            notify();
            i++;
            Random r = new Random();
            int num = r.nextInt(lottery.length);
            int ans = lottery[num];
            System.out.println(Thread.currentThread().getName() + "又产生了一个" + ans + "元大奖");

            if (i % 2 == 1) {
                arr1.add(ans);
            } else {
                arr2.add(ans);
            }

            int[] L2 = new int[lottery.length - 1];
            for (int i = 0; i < L2.length; i++) {
                if (i < num) {
                    L2[i] = lottery[i];
                } else {
                    L2[i] = lottery[i + 1];
                }
            }
            lottery = L2;
            try {
                wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer max1 = Collections.max(arr1);
        Integer max2 = Collections.max(arr2);
        int sum1 = 0, sum2 = 0;
        for (int j = 0; j < arr1.size(); j++) {
            sum1 += arr1.get(j);
            sum2 += arr2.get(j);
        }
        System.out.println("在此次抽奖过程中，抽奖箱1总共产生了6个奖项，分别为：" + arr1.toString().substring(1, arr1.toString().length() - 1) + "。最高奖项为:" + max1 + "元，总计额为" + sum1 + "元");
        System.out.println("在此次抽奖过程中，抽奖箱2总共产生了6个奖项，分别为：" + arr2.toString().substring(1, arr2.toString().length() - 1) + "。最高奖项为:" + max2 + "元，总计额为" + sum2 + "元");
        Integer max = max1 > max2 ? max1 : max2;
        System.out.println("在此次抽奖过程中,抽奖箱" + (arr1.contains(max) ? 1 : 2) + "中产生了最大奖项,该奖项金额为" + max + "元");
        System.exit(0);
    }
}

