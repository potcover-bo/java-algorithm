package basic;

public class LineSearch {
    //私有 不支持自己构造
    private LineSearch(){}
    public static <E> int search(E[] data, E target){
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }
}
