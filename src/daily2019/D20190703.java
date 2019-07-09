package daily2019;

/*
A fixed point in an array is an element whose value is equal to its index. Given a sorted array of distinct elements, return a fixed point, if one exists. Otherwise, return False.

For example, given [-6, 0, 2, 40], you should return 2. Given [1, 5, 7, 8], you should return False.



@easy
@Apple
@solved

 */
public class D20190703 {

    public static void main(String[] args) {
        System.out.println(fixedPoint(new int[]{-6, 0, 2, 40}));
        System.out.println(fixedPoint(new int[]{1, 5, 7, 8}));
    }

    public static boolean fixedPoint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) return true;
        }
        return false;
    }
}
