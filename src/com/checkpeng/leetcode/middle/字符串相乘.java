package com.checkpeng.leetcode.middle;

public class 字符串相乘 {

    public static void main(String[] args) {
        System.out.println(multiply("789", "897"));
    }

    public static String multiply(String num1, String num2) {
        // 特殊情况
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int a = num1.length() - 1;
        int b = num2.length() - 1;
        int toUp = 0; // 进位
        for (int i = b; i >= 0; i--) {
            StringBuilder now = new StringBuilder();
            int bInt = num2.charAt(i) - '0'; // b此时要被乘的数字
            // 给b的数字后面补0
            for (int j = b - i; j > 0; j--) {
                now.append(0);
            }
            // 开始乘法
            for (int j = a; j >= 0 || toUp != 0; j--) {
                int aInt = j >= 0 ? num1.charAt(j) - '0' : 0;
                int temp = (aInt * bInt) + toUp;
                now.append(temp % 10);
                toUp = temp / 10;
            }
            ans = addString(ans, now.reverse().toString());
        }
        return ans;
    }


    /**
     * 字符串相加
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addString(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int toUp = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || toUp != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + toUp;
            ans.append(result % 10);
            toUp = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
