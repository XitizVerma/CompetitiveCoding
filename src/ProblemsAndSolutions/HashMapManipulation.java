package ProblemsAndSolutions;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class HashMapManipulation {
    
    public static void main(String[] args){
        int[] arr = {1,10,4,5,5,3,2,3,8,2,2};
//        testHashMap(arr);
//        testTreeMap(arr);
//        testSortedMap(arr);
        testMap(arr);
    }

    private static void testHashMap(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(x -> map.put(x,map.getOrDefault(x,0)+1));
        System.out.println("Map" + ZonedDateTime.now());
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }

    private static void testTreeMap(int[] arr) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        Arrays.stream(arr).forEach(x -> treeMap.put(x,treeMap.getOrDefault(x,0)+1));
        System.out.println("TreeMap" + ZonedDateTime.now());
        for(Map.Entry<Integer,Integer> entry : treeMap.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }

    private static void testSortedMap(int[] arr) {
        SortedMap<Integer,Integer> sortedMap = new TreeMap<>();
        Arrays.stream(arr).forEach(x -> sortedMap.put(x,sortedMap.getOrDefault(x,0)+1));
        System.out.println("TreeMap" + ZonedDateTime.now());
        for(Map.Entry<Integer,Integer> entry : sortedMap.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }

    private static void testMap(int[] arr){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        Arrays.stream(arr).forEach(i -> hashMap.put(i,i));
        List<Integer> list = new ArrayList<>(hashMap.keySet());
        list.forEach(i -> System.out.println(i));
    }

    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i : nums)
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        int maxi=0,ans=0;
        for(Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            if(entry.getValue()>maxi){
                maxi = entry.getValue();
                ans=entry.getValue();
            }
            else if(entry.getValue()==maxi){
                ans+=entry.getValue();
            }
        }
        return ans;
    }

}
