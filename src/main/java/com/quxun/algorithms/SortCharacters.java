package com.quxun.algorithms;

import java.util.*;

/**
 * Description: 根据字符出现频率排序 https://leetcode-cn.com/problems/sort-characters-by-frequency/description/
 * Created by quxiaozha on 2018-9-26 16:56.
 */
public class SortCharacters {
    public static String frequencySort(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return -(o1.getValue() - o2.getValue());
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> e:list){
            //System.out.println(e.getKey() + ">" +e.getValue());
            for(int i = 0; i < e.getValue(); i++){
                sb.append(e.getKey());
            }

        }

        return sb.toString();
    }

    public static String frequencySort2(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);//aaccffggghh
        String temp = new String(chars);
        int index = 0;
        List<String> list = new ArrayList<>();
        while (index < chars.length){
            char c = chars[index];
            int end = temp.lastIndexOf(c)+1;
            list.add(temp.substring(index,end));//[)
            index = end;
        }

        if(list.size() == 0 || list.size() == 1){
            return s;
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String sc : list) {
            sb.append(sc);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort2("ssss"));
        System.out.println(frequencySort("ascfeewqadsfddssasaxz"));

    }
}
