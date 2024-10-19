package com.my.datastrcture.binary.search;

/*You are given an array ‘pages’ of integer numbers. In this array, the ‘pages[i]’ represents the number of pages in the ‘i-th’ book. There are ‘m’ number of students, and the task is to allocate all the books to the students.

Allocate books in a way such that:

Each student gets at least one book.
Each book should be allocated to a student.
Book allocation should be in a contiguous manner.

You have to allocate the books to ‘m’ students such that the maximum number of pages assigned to a student is minimum.

Try to solve this problem on your own before moving on to further discussion here.

Let’s understand the problem statement through an example.

Example
Input
Number of books = 4 and Number of students = 2

pages[] = { 10,20,30,40}

Output
 60

Explanation
All possible ways of book allocation are shown in the below figure-

The minimum of the maximum number of pages assigned = min{90,70,60} = 60. Hence, the required answer is 60.

Analysis
We have to minimize the value of the maximum number of pages assigned to a student during the allocation.

If the maximum number of pages assigned to a student in a book allocation is a number x, then the number of pages assigned to every student is less than or equal to x.

We have to assign at least one book to every student, so there can’t be any allocation such that a student gets no books assigned.

While allocating the books, no book should be left out. In other words, we have to allocate every book given.

Allocate in a contiguous manner. Let's say; for example, you have to allocate three books to a student from pages[] = { 10,20,30,40}. Then, the possible allocations can be - {10,20,30} and {20,30,40}. You can’t allocate {10,30,40} as it is not contiguous.*/
public class BookAllocationProblem {
    public static void main(String[] args) {
      /*  int arr[] = {10, 20, 30, 40};
        int m = 2; //No. of students
        int n = 4;*/
        int n = 5;
        int arr[] = {7,2,5,10,8};
        int m = 2;
        System.out.println("The minimum value of the maximum number of pages in book allocation is: " + allocateBooks(arr, n, m));
    }

    public static int allocateBooks(int arr[], int n, int m){
        int start = 0;
        int sum = 0;

        for (int i = 0; i < n; i++){
            sum += arr[i];
        }

        int end = sum;
        int mid = start + (end - start)/2;
        int ans = -1;

        while (start <= end){
            if (isPossible(arr, n, m, mid)){
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            mid = start + (end - start)/2;
        }

        return ans;
    }

    public static boolean isPossible(int arr[], int n, int m, int mid){
        int studentCount = 1;
        int pageSum = 0;

        for (int i = 0; i < n; i++){

            if (pageSum + arr[i] <= mid){
                pageSum += arr[i];

            } else {
                studentCount++;
                if (studentCount > m || arr[i] > mid){
                    return false;
                }
                pageSum = arr[i];
            }
        }
        return true;
    }
}
