package datastrcture.recursion;

public class ProductOfArray {

    public static long productOfArray(int A[], int N){
        if ( N<=0){
            return 1;
        }

        return (productOfArray(A,N-1)* A[N-1]);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int len = arr.length;
        System.out.println(productOfArray(arr, len));
    }
}
