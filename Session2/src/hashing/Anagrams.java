package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0 ; i < a.size(); i++){
            String sorted = getSortedStr(a.get(i));
            if(map.containsKey(sorted)){
                ArrayList<Integer> pair = map.get(sorted);
                pair.add(i+1);
            }else{
                ArrayList<Integer> initialVal = new ArrayList<>();
                initialVal.add(i+1);
                map.put(sorted,initialVal);
                result.add(initialVal);
            }
        }


        return result;
    }


    public static String getSortedStr(String s){
        char[] charArr = s.toLowerCase().toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}
