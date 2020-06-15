package com.wanyy.ltd.datastructure.algorithm;

import java.util.Arrays;

public class KMPMatch {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(partMatchKMP("AABEAF")));
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        System.out.println(kmpMatch(str1,str2));
    }

    private static int kmpMatch(String str1,String str2){
        int[] part = partMatchKMP(str2);
        for (int i = 0,j=0; i < str1.length(); i++) {
            //核心点
            while (j>0 && str1.charAt(i) != str2.charAt(j)){
                j = part[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            //说明找到了
            if (j == str2.length()){
                return i-j+1;
            }
        }
        
        return -1;
    }
    /**
     * “部分匹配值”就是”前缀”和”后缀”的最长的共有元素的长度。以”ABCDABD”为例， 
     * －”A”的前缀和后缀都为空集，共有元素的长度为0； 
     * －”AB”的前缀为[A]，后缀为[B]，共有元素的长度为0； 
     * －”ABC”的前缀为[A, AB]，后缀为[BC, C]，共有元素的长度0； 
     * －”ABCD”的前缀为[A, AB, ABC]，
     *      后缀为[BCD, CD, D]，共有元素的长度为0； 
     * －”ABCDA”的前缀为[A, AB, ABC, ABCD]，
     *      后缀为[BCDA, CDA, DA, A]，共有元素为”A”，长度为1； 
     * －”ABCDAB”的前缀为[A, AB, ABC, ABCD, ABCDA]，
     *      后缀为[BCDAB, CDAB, DAB, AB, B]，共有元素为”AB”，长度为2； 
     * －”ABCDABD”的前缀为[A, AB, ABC, ABCD, ABCDA, ABCDAB]，
     *      后缀为[BCDABD, CDABD, DABD, ABD, BD, D]，共有元素的长度为0。
     *  结果为：
     *  ABCDABD
     *  0000120
     */
    public static int[] partMatchKMP(String dest){
        int[] part = new int[dest.length()];
        //如果字符串长度为1 则部分匹配值为0
        part[0] = 0;
        //aac
        for (int i=1,j=0;i<dest.length();i++){
            //dest.charAt(i) != dest.charAt(j)
            //需要从next[j-1]获取新的j
            //dest.charAt(i) == dest.charAt(j) 成立时退出
            while (j>0 && dest.charAt(i) != dest.charAt(j)){
                j = part[j-1];
            }
            //当满足相等时 部分匹配值+1
            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            part[i] = j;
        }
        return part;
    }
}
