package com.xidian.algorithm.dp;


/**
 * ��̬�滮
 * �������ַ���֮����������
 */
public class MaxCommonStr {
    // ���������洢�����ַ����������������
    public static String[][] result = new String[10][15];

    public static void main(String[] args) {
        String strA = "sudjxidjs";
        String strB = "xidjxidpolkj";
        System.out.println(maxCommonStr(strA, strB));
        // System.out.println(strA.charAt(strA.length()-1));
    }

    /**
     * ��ȡ�����ַ�������󹫹�������
     * 
     * @param strA
     * @param strB
     * @return
     */
    public static String maxCommonStr(String strA, String strB) {
        // �ֱ��ȡ�����ַ����ĳ���
        int lenA = strA.length();
        int lenB = strB.length();

        // ����ַ���strA�ĳ���Ϊ1����ô���strB�����ַ���strA,�򹫹�������ΪstrA,����Ϊnull
        if (lenA == 1) {
            if (strB.contains(strA)) {
                result[lenA - 1][lenA - 1] = strA;
            } else {
                result[lenA - 1][lenA - 1] = "";
            }
            return result[lenA - 1][lenA - 1];
        }

        // ����ַ���strB�ĳ���Ϊ1����ô���strA�����ַ���strB,�򹫹�������ΪstrB,����Ϊnull
        if (lenB == 1) {
            if (strA.contains(strB)) {
                result[lenA - 1][lenA - 1] = strB;
            } else {
                result[lenA - 1][lenA - 1] = "";
            }
            return result[lenA - 1][lenA - 1];
        }

        // ����ַ���strA�����һλ��strB�����һλ��ͬ�Ļ���
        if (strA.charAt(lenA - 1) == strB.charAt(lenB - 1)) {
            //���ж�����result[lenA - 2][lenB - 2] == null,�������Լ���һЩ�ظ�����
            if (result[lenA - 2][lenB - 2] == null) {
                //��strA��strB��ȥ�����һλʣ���ַ�������󹫹�������f
                result[lenA - 2][lenB - 2] = maxCommonStr(strLenSub(strA), strLenSub(strB)) ;
            }
            //strA��strB����󹫹������о������Ǹ�ȥ�����һλʣ���ַ�������󹫹�������+strA����strB�����һλ
            result[lenA-1][lenB-1] = result[lenA - 2][lenB - 2]+ strA.charAt(lenA - 1);
        } else {
            //����
            if (result[lenA - 2][lenB-1] == null) {
                //����strAȥ�����һλ���strB�����������
                result[lenA - 2][lenB-1] = maxCommonStr(strLenSub(strA), strB);
            }
            if (result[lenA-1][lenB - 2] == null) {
                //����strBȥ�����һλ���strA�����������
                result[lenA-1][lenB - 2] = maxCommonStr(strA, strLenSub(strB));
            }
            //����result[lenA - 2][lenB-1]��result[lenA-1][lenB - 2]�е������
            result[lenA-1][lenB-1] = max(result[lenA - 2][lenB-1], result[lenA-1][lenB - 2]);
        }
        return result[lenA-1][lenB-1];
    }
    
    /**
     * ʹ�ַ���ȥ�����һλ�����ظ��µ��ַ���
     * @param str
     * @return
     */
    public static String strLenSub(String str) {
        return str.substring(0, str.length() - 1);
    }

    /**
     * �Ƚ������ַ������ȣ�������ַ��� �������ַ����������ʱ�����������ַ���
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