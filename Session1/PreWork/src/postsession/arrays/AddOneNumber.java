package postsession.arrays;

import java.util.ArrayList;
import java.util.List;


public class AddOneNumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {


        int carryOn = 1;
        for(int i = a.size()-1 ; i >=0 ;i--){
            int sum = carryOn + a.get(i);
            if(sum < 10){
                a.set(i,sum);
                carryOn = 0;
            }else{
                a.set(i, sum%10);
                carryOn = 1;
            }

        }
        if(carryOn > 0){
            a.add(0,1);
        }

        int index = 0;

        while(a.get(index) == 0 && index < a.size()){
            index++;
        }

        if(index < a.size()){
            List<Integer> result = a.subList(index, a.size());
            a = new ArrayList<>();
            a.addAll(result);
        }


        return a;
    }

}
