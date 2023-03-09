package search;

public class BinarySearch {
    private BinarySearch(){}

    public static <E extends Comparable<E>> int searchRecur(E[] nums, E target) {
        return searchRecur(nums, 0, nums.length - 1, target);
    }

    private static <E extends Comparable<E>> int searchRecur(E[] nums, int l, int r, E target) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (nums[mid].compareTo(target) == 0 ){
            return mid;
        }else if (nums[mid].compareTo(target) > 0){
            return searchRecur(nums, l, mid - 1, target);
        }else {
            return searchRecur(nums, mid + 1, r, target);
        }
    }



    // 非递归
    public static <E extends Comparable<E>> int search(E[] nums, E target){
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid].compareTo(target) == 0){
                return mid;
            }else if (nums[mid].compareTo(target) > 0){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }

        return -1;
    }
}
