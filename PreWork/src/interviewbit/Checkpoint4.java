package interviewbit;


import java.util.ArrayList;

public class Checkpoint4 {

    public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
        ArrayList<Integer> resultList = new ArrayList<>(a);
        findNextGreatest(resultList, a);
        return resultList;
    }

    public void findNextGreatest(ArrayList<Integer> resultList, ArrayList<Integer> originalList) {
        int max = originalList.get(originalList.size()-1);
        resultList.set(resultList.size()-1,-1);
        for(int i = originalList.size() - 2; i >=0 ;i--){
            int currentVal = originalList.get(i);
            if(currentVal > max){
                max = currentVal;
            }
            int resultVal = resultList.get(i+1);
            int nextOriginalVal = originalList.get(i+1);

            if(nextOriginalVal > currentVal){
                resultList.set(i,nextOriginalVal);
            }else if(resultVal > currentVal){
                resultList.set(i,resultVal);
            }else{
                if(currentVal > max){
                    resultList.set(i,-1);
                }else{
                    boolean gotMax = false;
                    for(int k = i + 1; k < resultList.size() ;k++){
                        if(currentVal < originalList.get(k)){
                            resultList.set(i,originalList.get(k));
                            gotMax = true;
                            break;
                        }else if(currentVal < resultList.get(k)){
                            resultList.set(i,resultList.get(k));
                            gotMax = true;
                            break;
                        }
                    }
                    if(!gotMax){
                        resultList.set(i,-1);
                    }
                }
            }
        }
    }

}
