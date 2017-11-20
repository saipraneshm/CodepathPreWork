package interviewbit;

import java.util.ArrayList;

public class Checkpoint2 {

    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int rectSize = a*2 - 1;
        for(int row = 0; row < rectSize; row++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int col = 0; col < rectSize; col++){
                temp.add(0);
            }
            result.add(row,temp);
        }

        int top = 0;
        int bottom = rectSize - 1;
        int left = 0;
        int right = rectSize - 1;

        int currentDirection = 0;

        while(left <= right && top <= bottom){
            ArrayList<Integer> rowList;
            if(currentDirection == 0){
                rowList = result.get(top);
                for(int i = left; i <= right; i++){
                    rowList.set(i,a);
                }
                result.set(top,new ArrayList<>(rowList));
                ++top;
            }else if(currentDirection == 1){
                for(int i = top; i <= bottom ; i++){
                    result.get(i).set(right,a);
                }
                --right;
            }else if(currentDirection == 2){
                rowList = result.get(bottom);
                for(int i = right; i >= left; i--){
                    rowList.set(i,a);
                }
                result.set(bottom,new ArrayList<>(rowList));
                --bottom;
            }else{
                for(int i = bottom; i >= top ; i--){
                    result.get(i).set(left,a);
                }
                ++left;
            }

            currentDirection++;
            currentDirection %= 4;
            if(currentDirection == 0){
                --a;
            }
        }

        return result;
    }

}
