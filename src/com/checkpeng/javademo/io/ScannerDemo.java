package com.checkpeng.javademo.io;

import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取一行数据
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("")) {
                break;
            } else {
                System.out.println(s);
            }
        }
        // 按单词读取
        while (scanner.hasNext()) {
            String s = scanner.next();
            System.out.println(s);
        }
        scanner.close();

        // 按int读取生成数组
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
        }
    }
}
