package array;

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {9,8,10,7,6,0,11};

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int count = 0;
        int count2 = 0;

        for(int i = arr.length - 1 ; i > 0 ; i--){
            for(int j = 0; j < i; j++){
                count++;
                if(arr[j] > arr[j + 1]){
                    count2++;
                    int temp;
                    temp = arr[ j ];
                    arr[ j ] = arr[j + 1];
                    arr[ j + 1 ] = temp;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println("比较次数：" + count);
        System.out.println("交换次数：" + count2);
    }
}
