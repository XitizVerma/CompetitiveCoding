package Templates;

import java.util.Arrays;

public class Comparator {

    public static void main(String[] args){
        int[] arr1 = {1,4,3,2};
        int[] arr2 = {2,8,6,4};
        int[][] arrCombined = {{1,2,3,4},{1,3,4,2}}; //2*4 matrix
        for (int i = 0; i < arr1.length; i++) {
            arrCombined[i][0]=arr1[i];
            arrCombined[i][1]=arr2[i];
        }

        Arrays.sort(arrCombined, new ArrayComparator());

//        List<Pair> pairList = new ArrayList<>();
//        for (int i = 0; i < arr1.length; i++) {
//            pairList.add(new Pair(arr1[i],arr2[i]));
//        }
//        Collections.sort(pairList,new CustomComparator());
    }

}

class ArrayComparator implements java.util.Comparator<int[]>{

    @Override
    public int compare(int[] a1, int[] b1) {
        // Sort by ascending first index if not equal
        if(a1[0]!=b1[0])
            return Integer.compare(a1[0],b1[0]);
        // Sort by second index in descending order if first index is equal
        else
            return Integer.compare(b1[1],a1[1]);
    }
}
