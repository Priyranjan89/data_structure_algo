package datastrcture.codestudio;



public class DuplicateInArray2ndSolution {
    public static void main(String[] args) {
        int arr[] = {6, 3, 1, 5, 4, 3, 2};
        int duplicateValue = findDuplicate(arr);

        System.out.println("Duplicate value in Array: "+duplicateValue);
    }

    public static int findDuplicate(int arr[]) {
        int ans = 0;

        //XOR ing all array elements
        for(int i = 0; i<arr.length; i++ ) {
            ans = ans^arr[i];
        }

        //XOR [1, n-1]
        for(int i = 1; i<arr.length;i++ ) {
            ans = ans^i;
        }
        return ans;
    }
}
