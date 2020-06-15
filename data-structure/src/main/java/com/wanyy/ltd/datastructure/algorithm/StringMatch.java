package com.wanyy.ltd.datastructure.algorithm;

public class StringMatch {

    public static void main(String[] args) {
        String str1= "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        System.out.println(violenceMatch(str1, str2));
        System.out.println(splitThenMatch(str1, str2));
        System.out.println(violenceMatchTeacher(str1, str2));
    }

    public static int violenceMatchTeacher(String str,String match){
        char[] char1 = str.toCharArray();
        char[] char2 = match.toCharArray();
        
        int i = 0,j=0;
        while (i<char1.length && j<char2.length){
            if (char1[i] == char2[j]){
                i++;j++;
            } else {
                i = i - (j-1);
                j = 0;
            }
        }
        return j == char2.length?i-j:-1;
    }
        /**
         * 采用暴力匹配
         */
    public static int violenceMatch(String str,String match){
        String[] origin = str.split("");
        String[] mat = match.split("");
        
        for (int i=0;i<origin.length - mat.length;i++){
            
            if (mat[0].equals(origin[i])){
                for (int j=0;j<mat.length;j++){
                    String or = origin[i + j];
                    if (mat[j].equals(or)){
                        if (j == mat.length-1 && mat[j].equals(or)){
                            System.out.println("完全匹配到了");
                            return i;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 现将大字符串拆分成对应小字符串数组，然后一一匹配
     */
    public static int splitThenMatch(String str,String match){
        for (int i = 0; i < str.length() - match.length(); i++) {
            String substring = str.substring(i, i + match.length());
            if (substring.equals(match)){
                return i;
            }
        }
        return -1;
    }
}
