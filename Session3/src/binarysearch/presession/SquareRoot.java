package binarysearch.presession;

public class SquareRoot {

    public int sqrt(int a) {

        int start = 1;
        int end = a;
        int res = 0;
        while(start <= end){
            int mid = start + (end - start)/ 2;
            if(mid <= a/mid){
                start = mid + 1;
                res = mid;
            }else{
                end = mid - 1;
            }
        }

        return res;
    }

}
