package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //sortTest();
        segmentTreeTest();
    }

    //线段树测试
    private static void segmentTreeTest() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        SegmentTree<Integer> segTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segTree);
    }


    // 排序测试
    private static void sortTest() {
        BST<Integer> bst = new BST<>();
        //int[] nums = {5, 3, 6, 8, 4, 2};
        //for (int num : nums) {
        //    bst.add(num);
        //}
        //bst.preOrderRecur();
        //System.out.println();
        //bst.preOrder();

        //bst.inOrderRecur();
        //System.out.println();
        //bst.inOrder();

        //bst.levelOrder();
        Random random = new Random();
        int n = 1000;

        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        List<Integer> list = new ArrayList<>();

        while (!bst.isEmpty()) {
            list.add(bst.removeMin());
        }
        System.out.println(list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("removeMin test completed.");
    }
}
