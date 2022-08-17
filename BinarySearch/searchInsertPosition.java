package BinarySearch;

// LINK_TO_THE_PROBLEM: https://leetcode.com/problems/search-insert-position
/**
 * Search Insert Position Or CeilingOfANum.
 */
public class searchInsertPosition {

    public static void main(String[] args) {
        int[] arr = {
                0, 1, 2, 6, 8, 9, 10
        };
        System.out.println(findPosition(arr, 3));
    }

    static int findPosition(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] > target) {
                e = mid - 1;
            } else if (arr[mid] < target) {
                s = mid + 1;
            } else {
                return mid;
            }
        }
        return s;
    }
}
// Q1) why the bounds are set the way they are set ?
// Ans: The bounds has been set in order to traverse the array. ie: s = 0, for
// index:0 and e = arr.length-1 for the last index of the array.

// Q2) while loop condition ?
// Ans: As we want to stop our loop whenever our s (start) and e (end) pointers
// crosses eachother.

/*
Q3) why s <= e ?
 Ans: Imagine the scenario when it would happen. It would be like, e (end)
 will say that as your mid is (arr[mid] > target) greater than target, so it
 must be somewhere in the left then e = mid-1; the same goes with s (start)
 hence mid+1; [***Important part***] after some time your s will be somewhere
 in the array.
*/

/*
 * lets say the target is 6. (find position for 6).
 * then now here mid will be at '5'. As it is smaller then the target the ---> s = mid+1
 * 
 * x x x 5 7 9 x x x
 *       s e
 * After s = mid+1
 * 
 *         s
 * x x x 5 7 9 x x x
 *         e
 * 
 * Now mid will be at '7'. As it is greater then the target then e = mid - 1;
 * 
 *         s
 * x x x 5 7 9 x x x
 *       e
 * CONDITION VIOLATED;
 */
/*
  Q4) why return s (start) or the lower bound ?
    Ans: We know some stuff that is for granted that is, we know that all elements before s will be smaller than target that is what we saw in the above answer of Q3).

    hence, s is the only index which can give us the position of just the greater number than target.  
  
 */
