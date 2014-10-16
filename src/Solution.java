/**
 * Created by irrienberith on 14-10-16.
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

//        int[] numbers = {230, 863, 916, 585, 981, 404, 316, 785, 88, 12, 70, 435, 384,
//                778, 887, 755, 740, 337, 86, 92, 325, 422, 815, 650, 920, 125, 277, 336,
//                221, 847, 168, 23, 677, 61, 400, 136, 874, 363, 394, 199, 863, 997, 794,
//                587, 124, 321, 212, 957, 764, 173, 314, 422, 927, 783, 930, 282, 306, 506,
//                44, 926, 691, 568, 68, 730, 933, 737, 531, 180, 414, 751, 28, 546, 60, 371,
//                493, 370, 527, 387, 43, 541, 13, 457, 328, 227, 652, 365, 430, 803, 59, 858,
//                538, 427, 583, 368, 375, 173, 809, 896, 370, 789};
//        int target = 542;

        int[] numbers = {591,955,829,805,312,83,764,841,12,744,104,773,627,306,731,539,349,
                811,662,341,465,300,491,423,569,405,508,802,500,747,689,506,129,325,918,606,
                918,370,623,905,321,670,879,607,140,543,997,530,356,446,444,184,787,199,614,
                685,778,929,819,612,737,344,471,645,726};
        int target = 789;

        quick(numbers);


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

        int[] answer = {0, 0};

        if (numbers == null || numbers.length < 2) {
            return null;
        }

        if (numbers.length < 20) {
            return getIndexs(1, numbers.length, numbers, target);
        }

        int length = numbers.length;
        int half = length / 2;

        for (int i = 1; i <= length; i++) {
            if (numbers[i - 1] <= target / 2 && numbers[i] >= target / 2) {
                half = i;
                System.out.println(numbers[i-1] + " " + numbers[i]);
                break;
            }
        }

        int key = length / 10;

        while (true) {
            int start = half - key;
            int end = half + key;

            answer = getIndexs(start, end, numbers, target);

            if (answer[0] != 0 && answer[1] != 0) {
                return answer;
            }
        }
    }


    private int[] getIndexs(int start, int end, int[] numbers, int target) {

        int answer[] = {0, 0};

        if (start < 1) {
            start = 1;
        }
        if (end > numbers.length) {
            end = numbers.length;
        }

        for (int i = start; i < end; i++) {
            for (int j = (start + end)/2; j <= end; j++) {
                if (numbers[i - 1] + numbers[j - 1] == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;

    }

    public int getMiddle(int[] list, int low, int high) {

        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {

            while (low < high && list[high] >= tmp) {
                high--;
            }

            list[low] = list[high];   //比中轴小的记录移到低端

            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }

        list[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置

    }

    public void _quickSort(int[] list, int low, int high) {

        if (low < high) {

            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            _quickSort(list, low, middle - 1);        //对低字表进行递归排序
            _quickSort(list, middle + 1, high);       //对高字表进行递归排序

        }
    }

    public void quick(int[] a2) {
        if (a2.length > 0) {    //查看数组是否为空
            _quickSort(a2, 0, a2.length - 1);
        }
    }

}
