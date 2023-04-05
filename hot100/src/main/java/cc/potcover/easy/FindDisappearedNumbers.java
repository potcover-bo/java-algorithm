package cc.potcover.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 */
public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] temp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]] = nums[i];
        }

        for (int i = 1; i < temp.length; i++) {
            if (temp[i] != i) {
                list.add(i);
            }
        }

        return list;
    }
}
