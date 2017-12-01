package presession;

import java.util.ArrayList;

public class LongestCommonPrefix {

    public String longestCommonPrefix(ArrayList<String> a) {
        if(a.size() == 1) return a.get(0);
        int commonPrefixLength = Integer.MAX_VALUE;
        for(int i = 0; i < a.size()-1; i++){
            int temp = lengthOfCommonPrefix(a.get(i), a.get(i+1));

            if(temp == 0 || temp == -1) return "";
            commonPrefixLength = Math.min(temp, commonPrefixLength);
        }
        return a.get(0).substring(0,commonPrefixLength);
    }

    public int lengthOfCommonPrefix(String s1 ,String s2){
        if(s1.length() == 0 || s2.length() == 0) return -1;
        int s1Index = 0;
        int s2Index = 0;
        int count = 0;
        while(s1Index < s1.length()
                && s2Index < s2.length()
                && s1.charAt(s1Index) == s2.charAt(s2Index)){
            count++;
            s1Index++;
            s2Index++;
        }

        return count;
    }

}
