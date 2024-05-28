package Week3;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {


    public static void main(String[] args){

        Queue<Integer> queue = new LinkedList<>();

        //adds First in First Out
        queue.add(67);
        queue.add(56);



        //will let me see the front value of the queue
        System.out.println("The front element is: " + queue.peek());

        //Remove element from the queue
        System.out.println(queue.poll());

        //check if it's empty
        System.out.println(queue.isEmpty());





            
        }


    }
    

