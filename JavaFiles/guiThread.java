import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class guiThread implements Runnable  {
		private ArrayList<Integer> database;
		private JButton [] allSeats = new JButton[200];
		
		  /**
		   * Constructor for the guiThread
		   * @param ArrayList<Integer>, the database that saves all the booked seats
		   */
		
		public guiThread(ArrayList<Integer> Al){
			database=Al;
		}
		
		/**
		 * Produces a Gui that allows realtime booking of the seats manually. 
		 * 
		 * */
		
		public void run(){
			JPanel main = new JPanel();
			
			
			   main.setLayout(new GridLayout(1, 3,100,10));
			   
			/*Left Most Seats*/	
				 JPanel Left = new JPanel();
				 Left.setLayout(new GridLayout(30,2,2,2));
				 
				 Left.add(new JLabel("left Row"));
				 Left.add(new JLabel("\n"));
				 Left.add(new JLabel("\n"));
				 Left.add(new JLabel("\n"));
				 
				   
				 for (int i = 1; i <=50; i++){
					 final String buttonLabel1 = ""+i;
					 JButton seatButton1 = new JButton(buttonLabel1);
					 seatButton1.setName(buttonLabel1);
					 seatButton1.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent event)
					 {
						 int value = Integer.parseInt(seatButton1.getName());
						 seatButton1.setEnabled(false);
						 seatButton1.setLabel("Taken[3]");
						 JOptionPane.showMessageDialog(null, buttonLabel1 + " has been booked" );
						if (!database.contains(200*(3-1)+value)) // checks if the value is already used up 
						 database.add(200*(3-1)+value);
					 }
					 });
					 allSeats[i-1]=seatButton1;
					 Left.add(seatButton1);
				 }	  
				 

				 /*Middle Seats*/	

				 JPanel middle = new JPanel();
				 middle.setLayout(new GridLayout(30, 8,2,2));
				 
				 middle.add(new JLabel("Middle"));
				 middle.add(new JLabel("\n"));
				 middle.add(new JLabel("\n"));
				 middle.add(new JLabel("\n"));
				 middle.add(new JLabel("\n"));
				 middle.add(new JLabel("\n"));
				 middle.add(new JLabel("\n"));
				 middle.add(new JLabel("\n"));
				 
				 for (int i = 51; i <=150; i++){
					 final String buttonLabel1 = ""+i;
					 JButton seatButton1 = new JButton(buttonLabel1);
					 seatButton1.setName(buttonLabel1);
					 seatButton1.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent event)
					 {
						 int value = Integer.parseInt(seatButton1.getName());
						 seatButton1.setEnabled(false);
						 seatButton1.setLabel("Taken[3]");
						 JOptionPane.showMessageDialog(null, buttonLabel1 + " has been booked" );
						if (!database.contains(200*(3-1)+value)) // checks if the value is already used up 
						 database.add(200*(3-1)+value);
					 }
					 });
					 allSeats[i-1]=seatButton1;
					 middle.add(seatButton1);
				 }	  
				 
				 
				 /*Right Panel*/
				 
				 JPanel right = new JPanel();
				 right.setLayout(new GridLayout(30,2,2,2));
				 
				 right.add(new JLabel("Right"));
				 right.add(new JLabel("\n"));
				 right.add(new JLabel("\n"));
				 right.add(new JLabel("\n"));
				 
				 
				 for (int i = 151; i <=200; i++){
					 final String buttonLabel1 = ""+i;
					 JButton seatButton1 = new JButton(buttonLabel1);
					 seatButton1.setName(buttonLabel1);
					 seatButton1.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent event)
					 {
						 int value = Integer.parseInt(seatButton1.getName());
						 seatButton1.setEnabled(false);
						 seatButton1.setLabel("Taken[3]");
						 JOptionPane.showMessageDialog(null, buttonLabel1 + " has been booked" );
						if (!database.contains(200*(3-1)+value)) // checks if the value is already used up 
						 database.add(200*(3-1)+value);
					 }
					 });
					 allSeats[i-1]=seatButton1;
					 right.add(seatButton1);
				 }	 
					
			
				 
				 
				 
				 main.add(Left, BorderLayout.WEST);
				 main.add(middle, BorderLayout.CENTER);
				 main.add(right, BorderLayout.EAST);
				 
				 JFrame frame = new JFrame(); 
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				 frame.add(main);
				 	
				 
				 frame.pack();
				 frame.setVisible(true);   
				 
				//----------------Timer for refreshing---------------//
				 
				   Timer t = new Timer(100,new ActionListener() {
					   public void actionPerformed(ActionEvent event)
						 { 
						  for (int i = 1 ; i<=200 ; i++){
							  if(database.contains(i)){
							  allSeats[i-1].setEnabled(false);
							  allSeats[i-1].setLabel("Taken[1]");
							  }
							  
							  if(database.contains(200*(2-1)+i)){
								  allSeats[i-1].setEnabled(false);
								  allSeats[i-1].setLabel("Taken[2]");
								  }
							  
							  if(database.contains(200*(3-1)+i)){
								  allSeats[i-1].setEnabled(false);
								  allSeats[i-1].setLabel("Taken[3]");
								  }
						  }
						 }   
				   });t.start();
		}

}
