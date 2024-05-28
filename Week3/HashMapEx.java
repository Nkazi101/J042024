package Week3;

import java.util.HashMap;

public class HashMapEx {

    public static void main(String[] args){


        //dictionary/hashmap
        HashMap<String, Integer> dictionary = new HashMap<>();
        
        //adds a key-value pair to the HashMap
        dictionary.put("John", 1);
        dictionary.put("Michael", 2);
        dictionary.put("Sarah", 3);

        //retrieves the value associated with the specified key
        System.out.println(dictionary.get("John"));

        System.out.println(dictionary.entrySet());


    }
    
}
