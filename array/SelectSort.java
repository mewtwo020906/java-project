package array;

import java.util.Arrays;

/*
选择排序：
    每一次从这堆参与比较的数据当中找出最小值，
    拿着这个最小值和最前面的元素交换位置。

    选择排序比冒泡排序好在：每一次的交换位置都是有意义的。
 */
public class SelectSort {
    public static void main(String[] args) {

        int[] arr = {9,8,10,7,6,0,11};
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        int count = 0;
        int count2 = 0;

        for(int i = 0; i < arr.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < arr.length; j++){
                count++;
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i){
                count2++;
                int temp;
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }

        System.out.println("比较次数：" + count);
        System.out.println("交换次数：" + count2);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
