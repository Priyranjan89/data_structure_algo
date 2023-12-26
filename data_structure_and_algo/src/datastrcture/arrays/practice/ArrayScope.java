package datastrcture.arrays.practice;

public class ArrayScope {
    public static void main(String[] args) {
        int arr[] = {1,2,3};

        ArrayScope arrayScope = new ArrayScope();
        arrayScope.updateArr(arr);
        System.out.println();
        System.out.println("inside Main");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }

    }

    public void updateArr(int arr[]){
        arr[0] = 130;
        System.out.println("inside updateArr");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
