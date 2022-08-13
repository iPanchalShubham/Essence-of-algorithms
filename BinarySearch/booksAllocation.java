package BinarySearch;
// Problem link: https://www.codingninjas.com/codestudio/problems/allocate-books_1090540
public class booksAllocation {
    public static void main(String[] args) {
        int[] arr = {
                3, 1, 10, 6, 5

        };
        System.out.println(allocateBooks(arr, 5));
    }

    static int allocateBooks(int[] arr, int noOfStudents) {
        int s = 0;
        int e = sumOfAllPages(arr);
        int mid = (s + e) / 2;

        int ans = 0;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (isAllocationPossible(arr, mid, noOfStudents)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    static Boolean isAllocationPossible(int[] arr, int barrier, int noOfStudents) {
        int doneStuds = 1;
        int pages = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > barrier)
                return false;
            if (pages + arr[i] > barrier) {
                doneStuds++;
                pages = arr[i];
            } else {
                pages += arr[i];
            }
        }
        if (doneStuds > noOfStudents) {
            return false;
        }
        return true;

    }

    static int sumOfAllPages(int[] arr) {
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }
        return totalSum;
    }
}
