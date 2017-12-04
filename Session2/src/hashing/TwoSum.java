package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    public ArrayList<Integer> twoSum(final List<Integer> a, int b) {

        HashMap<Integer,Integer> map = new HashMap<>();

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < a.size(); i++){
            int diff = b - a.get(i);
            if(map.containsKey(a.get(i))){
                result.add(map.get(a.get(i)));
                result.add(i+1);
                return result;
            }else{
                if(!map.containsKey(diff)) map.put(diff,i+1);
            }
        }

        return result;
    }

}
