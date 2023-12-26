package datastrcture.arrays.course;

public class MaxProductOfTwoInteger {

    public static String maxProduct(int arr[]){
        String pairs = "";
        int maxProd = 0;

        for (int i = 0; i<arr.length;i++){
            for (int j =i+1; j<arr.length;j++){
                int temp = arr[i]*arr[j];
                if (temp > maxProd){
                    maxProd = temp;
                    pairs = arr[i]+","+arr[j];
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int arr[] = {20,10,30,50,40,60};
        System.out.println(maxProduct(arr));
    }
}
