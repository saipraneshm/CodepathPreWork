package hashing.postsession;


import java.util.HashMap;

public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {

        if(numerator == 0) return "0";

        StringBuilder sbr = new StringBuilder();

        //Check for negative or positive
        sbr.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "" );

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        sbr.append(num/den);

        num %= den;

        if(num == 0) return sbr.toString();

        //Adding the fraction part
        sbr.append(".");

        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
        map.put(num, sbr.length());

        while( num != 0 ){
            num *= 10;
            sbr.append(num / den);
            num %= den;
            if(map.containsKey(num)){
                int index = map.get(num);
                sbr.insert(index,"(");
                sbr.append(")");
                break;
            }else{
                map.put(num,sbr.length());
            }
        }

        return sbr.toString();

    }
}
