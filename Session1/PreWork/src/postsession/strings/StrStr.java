package postsession.strings;


public class StrStr {

    public int strStr(final String haystack, final String needle) {
        if(haystack.isEmpty() || needle.isEmpty()) return -1;
        if(haystack.length() == needle.length() && haystack.equals(needle)) return 0;

        int[] patternTable = patternTable(needle);

        int patternIndex = 0;
        int textIndex = 0;

        while(textIndex < haystack.length() && patternIndex < needle.length()){
            if(haystack.charAt(textIndex) == needle.charAt(patternIndex)){
                patternIndex++;
                textIndex++;
            }

            if(patternIndex == needle.length()){
                return (textIndex - patternIndex);
            }else if(textIndex < haystack.length()
                    && haystack.charAt(textIndex) != needle.charAt(patternIndex)){
                if(patternIndex != 0){
                    patternIndex = patternTable[patternIndex - 1];
                }else{
                    textIndex++;
                }
            }
        }

        return -1;
    }

    public int[] patternTable(String pattern){

        int[] patternArr = new int[pattern.length()];

        patternArr[0] = 0;

        int i = 1;
        int j = 0;
        while(i < pattern.length()){
            if(pattern.charAt(j) == pattern.charAt(i)){
                patternArr[i] = j + 1;
                i++;
                j++;
            }else{
                if(j == 0){
                    patternArr[i] = 0;
                    i++;
                }else{
                    j = patternArr[j-1];
                }
            }
        }
        return patternArr;
    }
}
