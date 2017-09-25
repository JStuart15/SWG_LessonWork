
import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jstuart15
 */
public class Queues {
    public static void main(String[] args) {
        Queue<String> transactions = new LinkedList();
        transactions.add("edit");
        transactions.add("remove");
                System.out.println("size of queue is now" + transactions.size());

                for (String t : transactions) {
                    System.out.println(t);
                
            
        }
        System.out.println(transactions.poll().toString());
        System.out.println("size of queue is now" + transactions.size());
        
                System.out.println("size of queue is now" + transactions.size());

        for (String t : transactions) {
            System.out.println(t);
            
        }
        
    }
    
}
