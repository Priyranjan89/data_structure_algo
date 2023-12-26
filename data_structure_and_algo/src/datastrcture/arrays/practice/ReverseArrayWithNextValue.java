package datastrcture.arrays.practice;

public class ReverseArrayWithNextValue {
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 4, 9, 8, 6};

        printArray(arr);
        reverseArr(arr);
        printArray(arr);

    }

    private static void printArray(int[] arr) {
        System.out.print(" Value of array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] reverseArr(int arr[]) {
        int temp = 0;

        for (int i = 0; i < arr.length; i = i+2) {
            if (i+1 < arr.length){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }

        }

        return arr;
    }
}
