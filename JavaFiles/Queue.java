/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kmohsi
 */
import java.util.*;
import java.util.concurrent.locks.*;

public class Queue {
	private Integer last;
	private Integer max = 15;
    private ArrayList<Integer> queue= new ArrayList<Integer>();
    
    /**
     * @param nothing
	 * @return first Integer in the queue 
	 */
    
    public Integer first(){
        return queue.get(0);
    }
    
    /**
	 * @param nothing
	 * @return last Integer in queue
	 */
    
    public Integer last(){
        return queue.get(queue.size());	
    }
    
    /**
	 * @param Integer value do be added to the queue to the first user that requests.
	 * @return nothing
	 */
    
    public void enqueue(Integer value) throws InterruptedException {
    		queueLock.lock();
    		try{
    			while(qsize()==max){
    				spaceAvailableCondition.await();	
    			}
    			queue.add(value);
    			valueAvailableCondition.signalAll();
    		}
    		finally{
    			queueLock.unlock();
    		}
    }
    
    /**
	 * @param nothing
	 * @return Integer value in the queue to the first user that requests.
	 */
    
    public Integer dequeue() throws InterruptedException{
    	queueLock.lock();
    	try{
    	 while (qsize()== 0){
    		 valueAvailableCondition.await();
    	 }
    	if(queue.size()-1>=0){
    		last = queue.get(queue.size()-1);
    		queue.remove(queue.size()-1);
    	}
    	spaceAvailableCondition.signalAll();
        return last;
    	}
    	finally{
    		queueLock.unlock();
    	}
    }
    
    /**
	 * @param nothing
	 * @return integer elements in the queue
	 */
    
    public int qsize(){
        return queue.size();
    }
    
    /**
  	 * @param nothing
  	 * @return Boolean true if queue is full and false if its not.
  	 */
    
    
    public boolean isFull(){
    	return qsize()==max;
    }
    
    /**
  	 * @param nothing
  	 * @return Boolean true if queue is empty and false if its not.
  	 */
    
    public boolean isEmpty(){
    	return qsize()==0;
    }
    
    /**
  	 * @param Integer that needs to be checked 
  	 * @return Boolean true if queue has Integer a and false if does not.
  	 */
    
    public boolean contains(int a){
    	if (queue.contains(a)){
    		return true;
    	}
    	return false;
    }
    
    private Lock queueLock = new ReentrantLock();
    private Condition spaceAvailableCondition = queueLock.newCondition();
    private Condition valueAvailableCondition = queueLock.newCondition();
    
}
