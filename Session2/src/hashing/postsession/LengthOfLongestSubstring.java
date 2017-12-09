package hashing.postsession;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String a) {

        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;

        for(int i = 0, j = 0; j < a.length(); j++){
            if(map.containsKey(a.charAt(j))){
                i = Math.max(map.get(a.charAt(j)),i);
            }
            max = Math.max(max, j - i + 1);
            map.put(a.charAt(j), j+1);
        }
        return max;
    }
}
