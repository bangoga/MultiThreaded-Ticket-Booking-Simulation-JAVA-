import java.util.*;
import java.util.concurrent.locks.*;

public class producer implements Runnable   {
	private Random ran= new Random();
	private int ID;
	private Queue sharedQueue;
	
	  /**
	   *  Constructor for the producer class, the expectation is only two automated producers are made
	   * code will have to be slightly changed for more.
	   * @param Queue, the shared Queue between producer and consumer 
	   * @param Int, that is the unique ID of the producer  
	   */
	
	public producer(Queue q,int PID){
		sharedQueue=q;
		ID=PID;
	}
	
	  /**
	   *  Each producer will create random numbers assigned to a certain ID of the producer, Only unique numbers
	   * are added to the shared Queue  
	   */
	
	@Override
	public void run(){

	try{
		for(int i=0;i<10;i++){
			if (!sharedQueue.isFull()){
				int randomAssignment = ran.nextInt(200 - 0 + 1) + 0;
				while(sharedQueue.contains(randomAssignment)||sharedQueue.contains(200*(getID()-1)+randomAssignment)){
					randomAssignment = ran.nextInt(200 - 0 + 1) + 0;
				}
				System.out.println("Producer:"+getID()+" Number " +randomAssignment);
				sharedQueue.enqueue(200*(getID()-1)+randomAssignment); // mutliple of Id saved
	
			}
			Thread.sleep(1000);
			}
		}

	catch(InterruptedException exception)
		{
		}
	}
	
	  /**
	   * @param nothing
	   * @return Integer ID, the unique id of the producer 
	   */
	
	
	public int getID(){
		return ID;
	}
	
	
}
