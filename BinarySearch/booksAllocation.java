package BinarySearch;

// Problem link: https://www.codingninjas.com/codestudio/problems/allocate-books_1090540
public class booksAllocation {
    public static void main(String[] args) {
        int[] arr = {
                3, 1, 10, 6, 5

        };
        System.out.println(allocateBooks(arr, 5));
    }

    // Starting off
    static int allocateBooks(int[] arr, int noOfStudents) {
        // Defining that range, i talked about
        int s = 0;
        int e = sumOfAllBooks(arr);
        // It is natural intuition that our answer would somewhere lie in this range
        // So, let's go for the middle point.

        // Our middle point is very important here as it'll act as the max no. of pages
        // to be allocated.
        int mid = (s + e) / 2;
        // Variable to store the potential answers.
        int ans = 0;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (isAllocationPossible(arr, mid, noOfStudents)) {
                // If the allocation is possible that means all the books have allocated successfully to all the students.
                // Store this answer as a potential answer. 
                ans = mid;
                // But also check if we get a smaller number as we have to minimize the number ( Acc to the 4th statement)
                e = mid - 1;
            } else {
                // If allocation is not possible then elliminate the number upto min and increase the barrier.
                s = mid + 1;
            }
        }
        // return our answer
        return ans;
    }

    static Boolean isAllocationPossible(int[] arr, int barrier, int noOfStudents) {
        // Students that already got their books
        int doneStuds = 1;
        int pages = 0;
        for (int i = 0; i < arr.length; i++) {
            // if our barrier is greater than the no. of pages of any book that means that book can't be allocated we need to increase the bearrier.
            if (arr[i] > barrier)
                return false;
             // If the total number of pages allocated is greater than the barrier then allocation the allocation to that student is finished move ahead to the next student.
            if (pages + arr[i] > barrier) {
                // Increase the number of students that got their books.
                doneStuds++;
                pages = arr[i];
            } else {
                // keep allocating pages.
                pages += arr[i];
            }
        }
        /*
         meaning of (doneStuds > noOfStudents) : It means that the barrier that we've
         defined to be the maximum no. of pages is not enough because we're moving
         ahead after allocating less books, as compared to the book that student
         should get so that all book get allocated.
         As you can look at above code.

         */ if (doneStuds > noOfStudents) {
            return false;
        }
        return true;

    }

    static int sumOfAllBooks(int[] arr) {
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }
        return totalSum;
    }
}

/*
 * Q) Why this is binary search problem ?
 * Ans: Thinking of the solution, i can think about the answer in a particular
 * range.
 * like, what is minimum no. of pages that can be allocated to students, its
 * simply the smallest number in the array (i.e arr[1]) and what is the maximum
 * number of pages i can allot to a student sum of the whole array (i.e 25).
 * Now you can intuitively feel that there is a range in which your answer lies.
 */

/*
 * 1• Every student must get atleast one book.
 * 2• At least one book should be allocated to each student.
 * 3• Books should be allocated in a contigous fashion.
 * 4• Allocate books in such a manner that the maximum no. of books allocated
 * out all possible combinations of books allocation should be minimum.
 * 
 * -> from the first line we say that m (no. of students) <= (no. of books.)
 */
