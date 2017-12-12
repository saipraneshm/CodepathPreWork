package binarysearch;

import java.util.List;

/**
 * Created by saip92 on 12/11/2017.
 */
public class RotatedSortedArraySearch {


    public int search(final List<Integer> a, int b) {

        int left = 0;
        int right = a.size()-1;

        while(left <= right){
            int mid = (left + right)/2;
            if(a.get(mid) == b){
                return mid;
            }else if(a.get(mid) <= a.get(right)){
                if(b > a.get(mid) && b <= a.get(right)){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else if(a.get(left) <= a.get(mid)){
                if(b >= a.get(left) && b < a.get(mid)){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

}
