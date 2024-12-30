package Medium;

import java.util.*;

public class Challenge380_InsertDeleteGetRandom {
        public static void main(String[] args) {
            RandomizedSet randomizedSet = new RandomizedSet();
    
            System.out.println(randomizedSet.insert(1)); // Inserts 1. Should return true.
            System.out.println(randomizedSet.remove(2)); // Tries to remove 2. Should return false.
            System.out.println(randomizedSet.insert(2)); // Inserts 2. Should return true.
            System.out.println(randomizedSet.getRandom()); // Should return either 1 or 2 randomly.
            System.out.println(randomizedSet.remove(1)); // Removes 1. Should return true.
            System.out.println(randomizedSet.insert(2)); // Tries to insert 2 again. Should return false.
            System.out.println(randomizedSet.getRandom()); // Should always return 2 since it's the only element left.
        
    }
    
}


class RandomizedSet{

    private List<Integer> values; //list to store values
    private Map<Integer, Integer> valueToIndex; //Map to store value to index mapping 
    private Random random; //Random generator;

public RandomizedSet(){
    values = new ArrayList<>();
    valueToIndex = new HashMap<>();
    random = new Random();
}

public boolean insert(int val){
if(valueToIndex.containsKey(val)){
    return false;//value already exists
}

//add the value to the list and map its elements
values.add(val);
valueToIndex.put(val, values.size()-1);
return true;

}

public boolean remove(int val){
if(!valueToIndex.containsKey(val)){
    return false;//doesnt exists
}
int index  = valueToIndex.get(val); //find values using hashmap
int lastValue = values.get(values.size()-1); // find lastValue to swap with 
    //get the index from the value to remove

    values.set(index, lastValue);
    valueToIndex.put(lastValue, index);


    //remove the last value from the list and map 
    values.remove(values.size()-1);
    valueToIndex.remove(val);

    return true;

}

public int getRandom(){
//generate a random index and return the value at that index

int randomIndex = random.nextInt(values.size());
return values.get(randomIndex);
}



}
