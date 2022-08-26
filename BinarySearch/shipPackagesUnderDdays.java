package BinarySearch;

// Link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

public class shipPackagesUnderDdays {
    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

    static int shipWithinDays(int[] weights, int days) {
        int s = 0;
        int e = totalWeightOfTotalCargo(weights);
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isCargoLoaded(weights, days, mid)) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    static Boolean isCargoLoaded(int[] arr, int days, int barrier) {
        int totalWeight = 0;
        int doneDays = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > barrier) {
                return false;
            } else if (totalWeight + arr[i] > barrier) {
                doneDays++;
                totalWeight = arr[i];
            } else {
                totalWeight += arr[i];
            }
        }
        if (doneDays > days) {
            return false;
        }
        return true;
    }

    static int totalWeightOfTotalCargo(int[] arr) {
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }
        return totalSum;
    }
}
