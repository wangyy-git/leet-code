package com.wanyy.ltd.datastructure.algorithm;

import java.util.*;

/**
 * 2）	目前并没有算法可以快速计算得到准备的值， 使用贪婪算法，则可以得到非常接近的解，并且效率高。选择策略上，因为需要覆盖全部地区的最小集合:
 * 3）	遍历所有的广播电台, 找到一个覆盖了最多未覆盖的地区的电台(此电台可能包含一些已覆盖的地区，但没有关系） 
 * 4）	将这个电台加入到一个集合中(比如ArrayList), 想办法把该电台覆盖的地区在下次比较时去掉。
 * 5）	重复第3步直到覆盖了全部的地区
 */
public class Greedy {
    public static void main(String[] args) {
        //记录电台
        Map<String, Set<String>> broadcasts = new HashMap<>();
        //各电台覆盖的范围
        Set<String> k1 = new HashSet<>();

        Set<String> k2 = new HashSet<>();
        k2.add("北京");
        k2.add("广州");
        k2.add("深圳");

        Set<String> k3 = new HashSet<>();
        k3.add("成都");
        k3.add("上海");
        k3.add("杭州");
        
        Set<String> k4 = new HashSet<>();
        k4.add("天津");
        k4.add("上海");

        Set<String> k5 = new HashSet<>();
        k5.add("杭州");
        k5.add("大连");
        
        broadcasts.put("k1",k1);
        broadcasts.put("k2",k2);
        broadcasts.put("k3",k3);
        broadcasts.put("k4",k4);
        broadcasts.put("k5",k5);
        
        //记录所有需要覆盖的地区 随着计算是会变动的
        Set<String> allAreas = new HashSet<>();

//        System.out.println(allAreas.toString());
        //存放选择的电台的集合
        List<String> select = new ArrayList<>();
        
        //定义一个临时集合 在遍历过程中 存放被遍历过程中电台覆盖度的地区和未覆盖的地区
        Set<String> tempSet = new HashSet<>();
        
        //保存在一次遍历中 能够覆盖最多尚未覆盖地区对应的key
        //如果maxKey 不为空就加入到select
        String maxKey;
        
        //allAreas.size() > 0 就说明还没有完全覆盖
        while (allAreas.size() > 0) {
            //每进行一次 maxKey置空
            maxKey = null;
            
            for (String key:broadcasts.keySet()){
                tempSet.clear();
                //当前能够覆盖的区域
                Set<String> area = broadcasts.get(key);
                tempSet.addAll(area);
                
                //求出 tempSet allAreas的交集，交集会被赋给tempSet
                tempSet.retainAll(allAreas);
                if (tempSet.size() > 0
                        //当前集合还为存值
                        //货值当前集合包含的未覆盖地区的数量比maxKey指向的集合地区还多
                        //后面这个选择条件体现了贪心算法
                    && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())){
                    //说明当前key还存在未覆盖地区
                    maxKey = key;
                }

            }

            if (maxKey != null) {
                select.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
            
            
        }

        System.out.println(select.toString());
    }
}
