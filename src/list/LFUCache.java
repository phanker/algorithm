package list;

import java.util.*;

public class LFUCache<T> {
    Map<Integer,Map<String,T>> dateNodeMap;  // the frequency as key.
    Map<String,Integer> frequencyMap; //key -> frequency
    private int minFrequency;
    private int capability;
    private int size;


    public LFUCache(int capability){
        this.capability = capability;
        this.dateNodeMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public void add(String key,T t){
        //先查询频次缓存是否存在此key
        Integer frequency = frequencyMap.get(key);
        if(null == frequency){
            addItem(key,t);
        }else{
            //新增此数据的访问频次
            increaseFrequency(key,t,frequency);
        }
    }

    public T get(String key){
        Integer frequency = frequencyMap.get(key);
        if(null == frequency){
            return null;
        }else{
            Map<String, T> stringTMap = dateNodeMap.get(frequency);
            T t = stringTMap.get(key);
            increaseFrequency(key,t,frequency);
            return t;
        }
    }

    private void increaseFrequency(String key, T t,int oldFrequency) {
        Map<String,T> nodeMap = dateNodeMap.get(oldFrequency);
        //先删除旧数据
        nodeMap.remove(key);
        if(nodeMap.size() < 1 && oldFrequency == minFrequency){ //如果老的最小数据集已空，则需删除此数据集.新增最小访问次数集
            dateNodeMap.remove(oldFrequency);
            minFrequency++;
        }
        Map<String, T> destMap = dateNodeMap.get(++oldFrequency);
        if(null == destMap){
            destMap = new HashMap<>();
            dateNodeMap.put(oldFrequency,destMap);
        }
        destMap.put(key,t);
    }

    private void addItem(String key, T t) {
        size ++;
        if(size > capability){
            removeMinFrequencyNode();
        }
        frequencyMap.put(key,1);
        Map<String, T> dataTMap = dateNodeMap.get(1);
        if(dataTMap == null){
            dataTMap = new HashMap<>();
        }
        dataTMap.put(key,t);
        dateNodeMap.put(1,dataTMap);
    }

    private void removeMinFrequencyNode() {
        //先移除掉最小访问频次的数据  先删除keyfrequencyMap 在删除数据集合
        Map<String,T> dataTMap = dateNodeMap.get(minFrequency);
        dataTMap.forEach((k,v)->{
            frequencyMap.remove(k);
            size--;
        });
        dateNodeMap.remove(minFrequency);
        Set<Integer> set = dateNodeMap.keySet();

        if(null == set || set.size()<1){
            minFrequency = 0;
        }else {
            /**
             * 可以一步搞定
             *  minFrequency = set.stream().min((a, b) -> a.compareTo(b)).get();
             */
            while (set.iterator().hasNext()){ // O(x/n)
                Integer next = set.iterator().next();
                minFrequency = minFrequency>next ? next:minFrequency;
            }
        }
    }



}
