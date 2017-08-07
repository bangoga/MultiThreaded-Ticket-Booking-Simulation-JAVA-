import java.util.*;

public class tryhard {
	public static void main(String[]args){
		
	Queue a= new Queue();	
	ArrayList<Integer> bookingData= new ArrayList<Integer>();
	
	Runnable run1 = new producer(a,1);
	Runnable run2 = new producer(a,2);
	Runnable run3= new reciever(a,bookingData);
	Runnable run4= new guiThread(bookingData);
	
	Thread t4=new Thread(run4);
	Thread t3=new Thread(run3);
	Thread t1= new Thread(run1);
	Thread t2= new Thread(run2);
	
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	
	}
}
