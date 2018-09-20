package com.quxun.algorithms;

/**
 * Description:翻转字符串里的单词 https://leetcode-cn.com/problems/reverse-words-in-a-string/description/#
 * Created by quxiaozha on 2018-9-20 16:39.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        if(s.length()==0 || (!s.contains(" "))){
            return s;
        }
        String[] strings = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = strings.length - 1; i >= 0; i--) {
            if(!strings[i].equals("")){
                sb.append(strings[i]+" ");
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        System.out.println("result: ["+reverseWordsInAString.reverseWords("ssss")+"]");
    }
}
