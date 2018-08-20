package com.xidian.algorithm.dp;


/**
 * 动态规划
 * 求两个字符串之间的最长子序列
 */
public class MaxCommonStr {
    // 数组用来存储两个字符串的最长公共子序列
    public static String[][] result = new String[10][15];

    public static void main(String[] args) {
        String strA = "sudjxidjs";
        String strB = "xidjxidpolkj";
        System.out.println(maxCommonStr(strA, strB));
        // System.out.println(strA.charAt(strA.length()-1));
    }

    /**
     * 获取两个字符串的最大公共子序列
     * 
     * @param strA
     * @param strB
     * @return
     */
    public static String maxCommonStr(String strA, String strB) {
        // 分别获取两个字符串的长度
        int lenA = strA.length();
        int lenB = strB.length();

        // 如果字符串strA的长度为1，那么如果strB包含字符串strA,则公共子序列为strA,否则为null
        if (lenA == 1) {
            if (strB.contains(strA)) {
                result[lenA - 1][lenA - 1] = strA;
            } else {
                result[lenA - 1][lenA - 1] = "";
            }
            return result[lenA - 1][lenA - 1];
        }

        // 如果字符串strB的长度为1，那么如果strA包含字符串strB,则公共子序列为strB,否则为null
        if (lenB == 1) {
            if (strA.contains(strB)) {
                result[lenA - 1][lenA - 1] = strB;
            } else {
                result[lenA - 1][lenA - 1] = "";
            }
            return result[lenA - 1][lenA - 1];
        }

        // 如果字符串strA的最后一位和strB的最后一位相同的话，
        if (strA.charAt(lenA - 1) == strB.charAt(lenB - 1)) {
            //先判断数组result[lenA - 2][lenB - 2] == null,这样可以减少一些重复运算
            if (result[lenA - 2][lenB - 2] == null) {
                //求strA和strB都去除最后一位剩余字符串的最大公共子序列f
                result[lenA - 2][lenB - 2] = maxCommonStr(strLenSub(strA), strLenSub(strB)) ;
            }
            //strA和strB的最大公共子序列就是他们各去除最后一位剩余字符串的最大公共子序列+strA或者strB的最后一位
            result[lenA-1][lenB-1] = result[lenA - 2][lenB - 2]+ strA.charAt(lenA - 1);
        } else {
            //否则
            if (result[lenA - 2][lenB-1] == null) {
                //计算strA去除最后一位后和strB的最大子序列
                result[lenA - 2][lenB-1] = maxCommonStr(strLenSub(strA), strB);
            }
            if (result[lenA-1][lenB - 2] == null) {
                //计算strB去除最后一位后和strA的最大子序列
                result[lenA-1][lenB - 2] = maxCommonStr(strA, strLenSub(strB));
            }
            //等于result[lenA - 2][lenB-1]和result[lenA-1][lenB - 2]中的最大数
            result[lenA-1][lenB-1] = max(result[lenA - 2][lenB-1], result[lenA-1][lenB - 2]);
        }
        return result[lenA-1][lenB-1];
    }
    
    /**
     * 使字符串去除最后一位，返回该新的字符串
     * @param str
     * @return
     */
    public static String strLenSub(String str) {
        return str.substring(0, str.length() - 1);
    }

    /**
     * 比较两个字符串长度，返回最长字符串 当两个字符串长度相等时，返回任意字符串
     * 
     * @param strA
     * @param strB
     * @return
     */
    public static String max(String strA, String strB) {
        if (strA == null && strB == null) {
            return "";
        } else if (strA == null) {
            return strB;
        } else if (strB == null) {
            return strA;
        }
        if (strA.length() > strB.length()) {
            return strA;
        } else {
            return strB;
        }
    }
}