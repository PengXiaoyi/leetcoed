package com.checkpeng.leetcode;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ccy = 300;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.equals("")) {
                break;
            }
            String[] split = s.split(",");
            int bookPrice = Integer.valueOf(split[0]);
            int preDays = Integer.valueOf(split[1]);
            int reDays = Integer.valueOf(split[2]);
            // 钱少于当前书钱时，跳过借阅
            if (ccy < bookPrice) {
                continue;
            }
            int price = Math.min(bookPrice,getPrice(bookPrice, preDays, reDays));
            ccy -= price;
        }
        System.out.println(ccy);
    }

    public static int getPrice(int bookPrice, int preDays, int reDats) {
        int price = 0;
        if (reDats > 15) {
            price += get15Price(bookPrice, reDats);
            price += getLowPrice(bookPrice, 15);
        } else {
            price += getLowPrice(bookPrice, reDats);
        }
        if (reDats > preDays) {
            price += (reDats - preDays);
        }
        return price;
    }

    public static int get15Price(int bookPrice, int reDats) {
        int days = reDats - 15;
        if (bookPrice < 50) {
            return days;
        } else if (bookPrice >= 50 && bookPrice < 100) {
            return 2 * days;
        } else {
            return 3 * days;
        }
    }

    public static int getLowPrice(int bookPrice, int reDats) {
        int days = reDats;
        if (bookPrice < 50) {
            return days;
        } else if (bookPrice >= 50 && bookPrice < 100) {
            return 3 * days;
        } else {
            return 5 * days;
        }
    }
}

