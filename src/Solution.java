import java.util.HashMap;

/**
 * Created by irrienberith on 14-10-16, 上午10:56.
 * All rights reserved.
 */
public class Solution {

    /* Given an array of integers, find two numbers such that they add up to a specific target number.
       The function twoSum should return indices of the two numbers such that they add up to the target,
       where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
       are not zero-based.*/

    public static void main(String[] args) {
        new Solution(args);
    }

    public Solution(String[] args) {

        System.out.println("LeetCode Q1:Two Sum.");

        int[] numbers = {230, 863, 916, 585, 981, 404, 316, 785, 88, 12, 70, 435, 384,
                778, 887, 755, 740, 337, 86, 92, 325, 422, 815, 650, 920, 125, 277, 336,
                221, 847, 168, 23, 677, 61, 400, 136, 874, 363, 394, 199, 863, 997, 794,
                587, 124, 321, 212, 957, 764, 173, 314, 422, 927, 783, 930, 282, 306, 506,
                44, 926, 691, 568, 68, 730, 933, 737, 531, 180, 414, 751, 28, 546, 60, 371,
                493, 370, 527, 387, 43, 541, 13, 457, 328, 227, 652, 365, 430, 803, 59, 858,
                538, 427, 583, 368, 375, 173, 809, 896, 370, 789};
        int target = 542;

        System.out.println("numbers:");
        System.out.print("{");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "");
            if (i < numbers.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}\n" + "target: \n" + target);
        int[] answer = twoSum(numbers, target);
        System.out.println("answer:");
        System.out.print("{");
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + "");
            if (i < answer.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");

    }

    public int[] twoSum(int[] numbers, int target) {
        //第一题最终依赖于网上的方法：使用HashMap
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int index = map.get(numbers[i]);
                result[0] = index+1 ;
                result[1] = i+1;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }

        return result;
    }

    //总结：
    // 1.循环次数优化
    // 2.边界条件优化
    // 3.代码长度<= 65535 Byte
    // 4.Hash

    //自评：不及格（10/100）


}
