package array;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] array = {152,134,15,347,645,234,233,3465};

        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int index = binarySearch(array,233);
        System.out.println(index == -1 ? "该元素不存在":"该元素下标为：" + index);
    }

    public static int binarySearch(int[] array, int k) {

        int begin = 0;
        int end = array.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;

            if(k > array[mid]){
                begin = mid + 1;
            }else if(k < array[mid]){
                end = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
