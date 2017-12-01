package postsession.arrays;


import java.util.ArrayList;

public class NextPermutation {

    public void nextPermutation(ArrayList<Integer> a) {

        int firstIndex = 0;

        for(int i = a.size() -1; i > 0 ;i--){
            if(a.get(i) >a.get(i-1)){
                firstIndex = i-1;
                break;
            }
        }

        int secondIndex = 0;

        for(int i = a.size()-1; i > firstIndex ; i--){
            if(a.get(i) > a.get(firstIndex)){
                secondIndex = i;
                break;
            }
        }

        if(firstIndex == 0 && secondIndex == 0){
            reverse(a,0, a.size()-1);
        }

        int temp = a.get(firstIndex);
        a.set(firstIndex,a.get(secondIndex));
        a.set(secondIndex,temp);

        reverse(a, firstIndex+1, a.size()-1);


    }

    public void reverse(ArrayList<Integer> a, int left, int right){
        while(left < right){
            int temp = a.get(left);
            a.set(left, a.get(right));
            a.set(right, temp);
            left++;
            right--;
        }
    }

}
