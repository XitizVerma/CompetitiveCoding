package ProblemsAndSolutions;

import java.util.*;

class ArrayComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] arr1, int[] arr2) {
        return Integer.compare(arr1[0], arr2[0]);
    }
}

class ArrayManipulation {
    public static void main(String[] args) throws java.lang.Exception {
//        int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
//        octal(arr,3);
//
//        transpose(arr);

//        int []arr = {1,2,2,6,6,6,6,7,10};
//        findSpecialInteger(arr);

//        int []arr2 = {10,2,5,2};
//        maxProduct(arr2);

//        int [][]arr = {{1,0,0},{0,0,1},{1,0,0}};
//        numSpecial(arr);

//        int[][] arr = {{0,1,1},{1,0,1},{0,0,1}};
//        onesMinusZeros(arr);

//        int[] prices = {1,2,2};
//        int money = 3;
//        buyChoco(prices,money);

//        int[][] arr = {{8,7},{9,9},{7,4},{9,7}};
//        int[][] arr2 = {{15,69},{63,32},{100,34},{79,14},{97,33},{41,88},{68,27},{96,23},{88,52},{91,73},{66,18},{66,0},{0,87},{71,7},{64,42},{36,7},{73,50},{81,93},{88,8},{22,53},{90,8},{46,60},{74,1},{67,5},{55,91},{61,21},{33,46},{67,52},{13,100},{81,49},{35,57},{43,98},{69,11},{64,0},{56,54},{30,26},{41,92},{11,5},{54,13},{55,64},{11,4},{12,82},{19,41},{12,78},{100,29},{61,15},{45,72},{17,30},{85,69},{60,27},{86,93},{79,85},{40,90},{47,4},{83,37}};
//        maxWidthOfVerticalArea(arr2);

//        int[] g = {1,2,3}, s = {1,1};
//        findContentChildren(g,s);

//        int[] arr = {1,3,4,1,2,3,1};
//        findMatrix(arr);

//        String[] arr = {"011001",
//                        "000000",
//                        "010100",
//                        "001000"};
//        numberOfBeams(arr);

//        int[] arr = {2,3,3,2,2,4,2,3,4};
//        minOperations(arr);

//        int[][] arr = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
//        findWinners(arr);

//        int[] arr = {1, 2, 3, 1, 1, 1, 1};
//        int k=3;
//        longestSubarrayWithSumK(arr,k);
//
//        int[] arr = {1,-1,0}; int k = 0;
//        subarraySum(arr,k);

//        int[] arr = {1,3,4,8,7,9,3,5,1};
//        int k = 2;
//        divideArray(arr,k);

//        sequentialDigits(10,1000000000);

//        int[] arr1 = {1, 2, 2, 5};
//        int[] arr2 = {0, 1};
//        combine2IntArrays(arr1, arr2);

//        useVector();
//
//        int[] arr1 = {1,10,100}, arr2 = {1000};
//        longestCommonPrefix(arr1,arr2);

//        int arr[][] = {{1,2}};
//        findJudge(2,arr);

//        int[] arr = {1, 0, 1, 0, 1};
//        numSubarraysWithSum(arr, 2);

//        int[] arrtemp = {0,0,0,0,0};
//        numSubarraysWithSum(arrtemp,0);

        int[] nums = {1,3,2,3,3};
        countSubarrays(nums,2);
    }

    public static long countSubarrays(int[] nums, int k) {
        int maxi=-1;
        for(int i:nums)
            maxi=Math.max(maxi,i);
        int left=0,right=0,count=0,ans=0;
        while(right<nums.length || left>right){
            if(nums[right]==maxi)
                count++;
            while(count>=k){
                if(nums[left]==maxi){
                    count--;
                }
                ans+=nums.length-right;
                left++;
            }
            right++;
        }
        return ans;
    }


    public static void octal(int arr[][], int n) {
        int sum;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum += arr[j][i];
            }
            checkOctal(sum, ans);
        }
        Collections.sort(ans);
        for (Integer a : ans) {
            System.out.println(a);
        }
    }

    private static void checkOctal(int decimalNumber, List<Integer> ans) {
        String octalNumber = "";
        int copy = decimalNumber;
        while (decimalNumber > 0) {
            int remainder = decimalNumber % 8;
            decimalNumber /= 8;
            octalNumber = remainder + octalNumber;
        }
        if (!octalNumber.contains("1"))
            ans.add(copy);
    }

    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    public static int findSpecialInteger(int[] arr) {
        double max = arr.length * 0.25;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : arr) {
            map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
            if (map.get(i) > max)
                return i;
        }
        return 1;
    }

    public static int maxProduct(int[] nums) {
        int a = nums[0], b = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= a) {
                b = a;
                a = nums[i];
            } else
                b = Math.max(b, nums[i]);
        }
        return --a * --b;
    }

    public static int numSpecial(int[][] mat) {
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                if (mat[i][j] == 1)
                    row[i]++;
        for (int j = 0; j < mat[0].length; j++)
            for (int i = 0; i < mat.length; i++)
                if (mat[i][j] == 1)
                    col[j]++;
        int ans = 0;
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1)
                    ans++;
        return ans;
    }

    public static int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1)
                    row[i]++;
        for (int j = 0; j < n; j++)
            for (int i = 0; i < m; i++)
                if (grid[i][j] == 1)
                    col[j]++;
        int ans[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = 2 * (row[i] + col[j]) - m - n;
            }
        }
        return ans;
    }

    public static int buyChoco(int[] prices, int money) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < first) {
                second = first;
                first = price;
            } else {
                second = Math.min(second, price);
            }
        }
        return (first + second > money) ? money : money - first - second;
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, new ArrayComparator());
        int ans = 0, prev = points[0][0];
        for (int i = 1; i < points.length; i++) {
            ans = Math.max(ans, points[i][0] - prev);
            prev = points[i][0];
        }
        return ans;
    }

//    public void temp(){
//        Pair pair = new Pair(1,2);
//    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i;
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i : nums) {
            freq.put(i, Objects.isNull(freq.get(i)) ? 1 : freq.get(i) + 1);
            if (freq.get(i) > ans.size()) {
                ans.add(new ArrayList<>());
            }
            ans.get(freq.get(i) - 1).add(i);
        }
        return ans;
    }

    public static int numberOfBeams(String[] bank) {
        int temp = 0, prev = 0, count, ans = 0, n = bank[0].length();
        for (String row : bank) {
            count = 0;
            for (int i = 0; i < n; i++) {
                if (row.charAt(i) == '1')
                    count++;
            }
            if (count == 0)
                continue;
            ans += prev * count;
            prev = count;
        }
        return ans;
    }

    public static int minOperations(int[] nums) {
        Arrays.sort(nums);
        reverse(nums);
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1)
                return -1;
            ans += entry.getValue() / 3;
            if (entry.getValue() % 3 != 0)
                ans++;
        }
        return ans;
    }

    public static void reverse(int[] nums) {
        int i = 0, n = nums.length - 1, temp = 0;
        while (i < n) {
            temp = nums[i];
            nums[i++] = nums[n];
            nums[n--] = temp;
        }
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> hashLoss = new HashMap<>();
        for (int[] entry : matches) {
            hashLoss.put(entry[1], hashLoss.getOrDefault(entry[1], 0) + 1);
            hashLoss.put(entry[0], hashLoss.getOrDefault(entry[0], 0));
        }
        List<Integer> winners = new ArrayList<>();
        List<Integer> loseOnlyOne = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hashLoss.entrySet()) {
            if (entry.getValue() == 0)
                winners.add(entry.getKey());
            else if (entry.getValue() == 1)
                loseOnlyOne.add(entry.getKey());
        }
        List<List<Integer>> ans = new ArrayList<>();
        Collections.sort(winners);
        Collections.sort(loseOnlyOne);
        ans.add(winners);
        ans.add(loseOnlyOne);
        return ans;
    }

    public static int longestSubarrayWithSumK(int[] a, long k) {

        //Array = [1, 2, 3, 1, 1, 1, 1]           k=3
        //Prefix Sum = [1, 3, 6, 7, 8, 9, 10]

        int sum = 0, ans = 0;
        int[] prefix = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            prefix[i] = sum;
        }
        int i = 0, j = 1;
        while (i < j && j != a.length) {
            if (prefix[j] - prefix[i] == k) {
                ans = Math.max(ans, j - i);
                j++;
            } else if (prefix[j] - prefix[i] < k) {
                j++;
            } else
                i++;
        }
        return ans;
    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int sum = 0, ans = 0;
        hash.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans += hash.getOrDefault(sum - k, 0);
            hash.put(sum, hash.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n % 3 != 0)
            return new int[0][0];
        int[][] arr = new int[n / 3][3];
        int div;
        boolean flag = true;
        for (int i = 0; i < n; i += 3) {
            div = i / 3;
            arr[div][0] = nums[i];
            arr[div][1] = nums[i + 1];
            arr[div][2] = nums[i + 2];
            if (arr[div][2] - arr[div][0] > k) {
                flag = false;
                break;
            }
        }
        return flag ? arr : new int[0][0];
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String base = "123456789";
        int power = (int) Math.log10(low) + 1;
        int temp = 0;
        while (temp < high && temp != Integer.parseInt(base)) {
            for (int i = 0; i <= base.length() - power; i++) {
                temp = Integer.parseInt(base.substring(i, i + power));
                if (temp > high)
                    break;
                if (temp > low)
                    ans.add(temp);
            }
            power++;
        }
        return ans;
    }

    public static int[] rearrangeArray(int[] nums) {
//        Input: nums = [3,1,-2,-5,2,-4]
//        Output: [3,-2,1,-5,2,-4]
        int i = 0, j = 1, n = nums.length;
        int[] ans = new int[n];
        for (int num : nums) {
            if (num > 0) {
                ans[i] = num;
                i += 2;
            } else {
                ans[j] = num;
                j += 2;
            }
        }
        return ans;
    }

    public static void anilSort(List<Object> objectList, int[] arr) {
        //i = 1 ,2, 3, 4, 5, 6, 7, 8
        //remove j = 1, 3
        int j = 0, k = 0;
        for (int i = 0; i < objectList.size(); ) {
            if (i == j) {
                j++;
            } else {
                objectList.set(k, objectList.get(i));
            }
        }
    }

    public static int[] combine2IntArrays(int[] input1, int[] input2) {
        int[] ans = new int[input1.length + input2.length];
        int i = 0;
        for (; i < input1.length; i++)
            ans[i] = input1[i];
        for (int j = 0; j < input2.length; j++)
            ans[i + j] = input2[j];
        Arrays.sort(ans);
        return ans;
    }

    public static void useVector() {
        String[] arr = {"A", "B", "C"};
        Vector<String> vector = new Vector<>(Arrays.asList(arr));
        vector.get(1);
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> hashSet = new HashSet<>();
        for (int i : arr1) {
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                hashSet.add(str.substring(0, j + 1));
            }
        }
        int ans = 0;
        for (int i : arr2) {
            String str = String.valueOf(i);
            for (int j = ans; j < str.length(); j++) {
                if (hashSet.contains(str.substring(0, j + 1)))
                    ans = j + 1;
            }
        }
        return ans;
    }

    public static int findJudge(int n, int[][] trust) {
        int[] ds = new int[n + 1];
        for (int[] arr : trust) {
            ds[arr[0]]--;
            ds[arr[1]]++;
        }
        for (int i = 0; i <= n; i++)
            if (ds[i] == n - 1)
                return i;
        return -1;
    }

    public static int numSubarraysWithSumm(int[] nums, int goal) {
        int i = 0, j = 1, sum = nums[0], n = nums.length, count = 0;
        while (i < j) {
            if (sum == goal) {
                count++;
                if (j != n) {
                    sum += nums[j];
                    j++;
                } else {
                    sum -= nums[i];
                    i++;
                }
            } else if (sum < goal) {
                if (j != n) {
                    sum += nums[j];
                    j++;
                } else
                    break;
            } else {
                sum -= nums[i];
                i++;
            }
        }
        return count;
    }

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i : arr)
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        HashSet<Integer> set = new HashSet<>();
        for (int i : hash.values()) {
            if (set.contains(i))
                return false;
            set.add(i);
        }
        return true;
    }

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int sum = 0, distinctSum = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            sum += i;
            hashSet.add(i);
        }
        for (Integer i : hashSet)
            distinctSum += i;
        int[] ans = new int[2];
        ans[0] = sum - distinctSum;
        ans[1] = expectedSum - distinctSum;
        return ans;
    }

    public int getCommon(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] == nums2[j])
                return nums1[i];
            else if (nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        return -1;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for (int it : nums1)
            hashSet.add(it);
        for (int it : nums2) {
            if (hashSet.contains(it)) {
                ans.add(it);
                hashSet.remove(it);
            }
        }
        int[] ansArray = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            ansArray[i] = ans.get(i);
        return ansArray;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length,count=0,j;
        int[] prefixSum = new int[n+1];
        prefixSum[0]=0;
        prefixSum[1]=nums[0];
        for (int i = 1; i < n; i++)
            prefixSum[i+1]=prefixSum[i]+nums[i];
        for(int i=0;i<n;i++){
            j=n;
            while(i<j){
                if(prefixSum[j]-prefixSum[i]==goal)
                    count++;
                j--;
            }
        }
        return count;
    }

}

