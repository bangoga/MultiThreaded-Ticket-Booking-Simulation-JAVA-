import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class reciever implements Runnable {
	private Queue sharedQueue;
	private ArrayList<Integer> database;
	
	/**
	   * Constructor for the reciever class
	   * @param Queue, the shared Queue between producer and consumer 
	   * @param ArrayList<Integer>, that is data structure saving all the unique integers saved in the queue   
	   */
	
	
	public reciever(Queue q,ArrayList<Integer> Al){
		sharedQueue=q;
		database=Al;
	}
	  /**
	   *  Adds to the database, only if the number that was generated doesn't exist before hand.
	   */
	
	@Override
	public void run(){
		try{
			for(int i=0;i<20;i++){
			if (!sharedQueue.isEmpty()){
				int value=sharedQueue.dequeue();
				System.out.println("Value in is : " + value);
				if (!database.contains(value)) // checks if the value is already used up 
				database.add(value);
			}
			Thread.sleep(1000);
			}
		}
		catch(InterruptedException exception)
		{
		}
	}
	
	
}
