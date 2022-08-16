package noob_00;

import org.testng.annotations.Test;

import java.util.TreeMap;

/**
 * 哈希表和有序表
 */
public class HashMapAndTreeMap {
    public static void main(String[] args) {

    }

    /**
     * 1. 按值传递的HashMap
     * 2. 按引用传递的HashMap
     */

    @Test
    public static void AboutHashMap() {
        // 增删改查复杂度为O(1)
        // TreeMap 操作的复杂度为O(logN)
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "1");
        treeMap.put(2, "2");
        System.out.println(treeMap.get(1));
        System.out.println( treeMap.firstKey());
        System.out.println(treeMap.floorKey(2));
        System.out.println(treeMap.ceilingKey(2));
    }
}
