package BinarySearchVariations;

public class BinarySearch {

    public static void main() {
        int[] arr = {1,2,3,6,8,99,103,1055,1077};
        System.out.println(helper(99,arr));
    }

    public static boolean helper(int target, int[] arr){
        int start = 0, end = arr.length-1;
        boolean flag = false;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == target){
                flag=true;
                break;
            }
            else if(arr[mid] < target){
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return flag;
    }

    public static int rotatedArrayBinarySearch(int target, int[] arr){
        int start = 0, end = arr.length-1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[start] < arr[mid]) { // left half is sorted
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {  // mid < end
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
