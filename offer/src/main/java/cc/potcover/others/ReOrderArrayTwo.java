package cc.potcover.others;

/**
 *
 JZ81 调整数组顺序使奇数位于偶数前面(二)
 */
public class ReOrderArrayTwo {

    public int[] reOrderArrayTwo (int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            while (left < array.length && array[left] % 2 != 0) {
                left++;
            }
            while (right >= 0 && array[right] % 2 == 0) {
                right--;
            }

            if (left < right) {
                int temp = array[left];
                array[left++] = array[right];
                array[right--] = temp;
            }
        }
        return array;
    }
}
