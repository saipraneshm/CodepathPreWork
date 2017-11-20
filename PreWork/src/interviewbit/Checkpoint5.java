package interviewbit;

import java.util.Hashtable;
import java.util.List;

public class Checkpoint5 {

    public int longestConsecutive(final List<Integer> a) {
        Hashtable<Integer, Boolean> hashTable = new Hashtable<>();

        //Initializing the table with all values set to false
        //We shall change the boolean value once the array value has been visited
        for(Integer currentVal : a){
            hashTable.put(currentVal, false);
        }
        int longestSequence = 0;
        int sequenceCount = 1;
        for(Integer currentVal : a){
            if(hashTable.get(currentVal)) continue;
            int nextVal = currentVal + 1;
            int prevVal = currentVal - 1;

            if(hashTable.containsKey(nextVal) && hashTable.containsKey(prevVal)){
                while(hashTable.containsKey(nextVal)){
                    hashTable.put(nextVal,true);
                    nextVal++;
                    sequenceCount++;
                }
                while(hashTable.containsKey(prevVal)){
                    hashTable.put(prevVal,true);
                    prevVal--;
                    sequenceCount++;
                }
            }else if(hashTable.containsKey(nextVal) && !hashTable.containsKey(prevVal)){
                while(hashTable.containsKey(nextVal)){
                    hashTable.put(nextVal,true);
                    nextVal++;
                    sequenceCount++;
                }
            }else if(!hashTable.containsKey(nextVal) && hashTable.containsKey(prevVal)){
                while(hashTable.containsKey(prevVal)){
                    hashTable.put(prevVal,true);
                    prevVal--;
                    sequenceCount++;
                }
            }else{
                hashTable.put(currentVal,true);
            }

            if(sequenceCount > longestSequence){
                longestSequence = sequenceCount;
            }
            sequenceCount = 1;
        }
        return longestSequence;
    }

}
