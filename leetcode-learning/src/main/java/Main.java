import java.util.*;

public class Main {
    /**
     * 无序、无重复元素、数组
     * <p>
     * 整型目标值
     * 出惨，下标
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 5};
        List<List<Integer>> lists = twoSum(arr, 5);
        System.out.println(lists.toString());
    }


    public static List<List<Integer>> twoSum(int[] arr, int num) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(num - arr[i]) && map.get(num - arr[i]) != i) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(i);
                integers.add(map.get(num - arr[i]));

                result.add(integers);
                map.remove(num - arr[i]);
                map.remove(arr[i]);
            }
        }

        return result;
    }


}
