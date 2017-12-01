package postsession.arrays;

import java.util.ArrayList;


public class FirstMissingInteger {

    public int firstMissingPositive(ArrayList<Integer> a) {
        if(isNegativeArray(a)) return 1;


        //separate the negative integers from the positive integers
        int leftIndex = 0;
        for(int i = 0; i < a.size();i++ ){
            if(a.get(i) <= 0){
                int temp = a.get(i);
                a.set(i, a.get(leftIndex));
                a.set(leftIndex, temp);
                leftIndex++;
            }
        }

        int offset = leftIndex;

        for(int i = leftIndex; i < a.size(); i++){
            int absVal = Math.abs(a.get(i)) - 1 + offset;
            if(absVal < a.size() && a.get(absVal) > 0){
                a.set(absVal, -a.get(absVal));
            }
        }

        for(int i = leftIndex; i < a.size(); i++){
            if(a.get(i) > 0){
                return i-offset+1;
            }
        }


        return a.size()-offset+1;
    }

    //check whether the array contains at least one positive integer
    public boolean isNegativeArray(ArrayList<Integer> a){
        for(Integer val : a){
            if(val >= 0 )
                return false;
        }
        return true;
    }


}
