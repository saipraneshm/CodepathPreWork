package postsession.strings;


public class AtoI {

    public int atoi(final String a) {

        if(a == null || a.isEmpty()) return 0;

        //Removing the white spaces
        String cleansedString = a.trim();

        boolean isNegative = false;

        int startIndex = 0;

        //Check for garbage characters
        //if the fisrt character is not '-','+' or a numeric value then returning 0
        if(cleansedString.charAt(0) != '-' && cleansedString.charAt(0) != '+'){
            if(!isNumeric(cleansedString.charAt(0))) return 0;
        }

        //Keeping track of the sign
        if(cleansedString.charAt(0) == '-'){
            isNegative = true;
            startIndex++;
        }else if(cleansedString.charAt(0) == '+'){
            startIndex++;
        }

        Double sum = 0.0;

        for(int i = startIndex; i < cleansedString.length(); i++){
            if(!isNumeric( cleansedString.charAt(i))){
                break;
            }else{
                sum = sum * 10 + Integer.parseInt(cleansedString.charAt(i) + "");
            }
        }

        int result = 0;

        if(isNegative){
            sum = -sum;
        }

        if(sum < Integer.MIN_VALUE){
            result = Integer.MIN_VALUE;
        } else if(sum > Integer.MAX_VALUE){
            result = Integer.MAX_VALUE;
        }else{
            result = sum.intValue();
        }

        return result;
    }


    public boolean isNumeric(Character c){
        int charCode = (int) c;
        int zero = (int) '0';
        int nine = (int) '9';
        if(charCode >= zero && charCode <= nine){
            return true;
        }
        return false;
    }
}
