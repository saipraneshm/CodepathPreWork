
public class StringReverse {

    public String reverseWords(String a) {
        if(a == null || a.isEmpty()) return a;
        String[] splitArr = a.split(" ");
        StringBuilder sbr = new StringBuilder();
        for(int i = splitArr.length - 1; i >=0 ; i-- ){
            sbr.append(splitArr[i]).append(" ");
        }

        return sbr.toString().trim();
    }
}
