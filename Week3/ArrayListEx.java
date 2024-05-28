package Week3;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {


    public static void main(String[] args) {


        List<String> names = new ArrayList<>();

        //adding to an array list
        names.add("Star");
        names.add("Wondwosen");
        names.add("Cameron");
        names.add("Storm");

        //view the size of the array
        System.out.println(names.size());

        names.remove(0);

        System.out.println(names.get(0));

        System.out.println(names.get(1));




    }
    
}
