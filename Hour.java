import javax.swing.*; 
import java.awt.event.*; 
import java.sql.*; 
class DigitalFrame extends JFrame implements ActionListener 
{ 
   JPanel p1; 
   JTextField hourTxt,minuteTxt,secondTxt; 
   JLabel lblSecond,lblMinute,lblHour,lblTitle;  
   JButton reset;  
   public DigitalFrame() 
   { 
      setSize(300,300);  
      p1 = new JPanel(); 
      //p1.setLayout(null); 
      lblTitle = new JLabel("DigitalClock"); 
      p1.add(lblTitle); 
      lblTitle.setBounds(10,10,100,30); 
      lblHour = new JLabel("HOUR"); 
      lblHour.setBounds(30,30,100,30); 
      lblMinute = new JLabel("MINUTE");
      lblSecond = new JLabel("SECONDS");
      hourTxt = new JTextField(20);
      minuteTxt = new JTextField(20);
      secondTxt = new JTextField(20);
      //txtName.setBounds(130,10,100,30); 
      //txtName.setBounds(30,30,10,10); 
      reset = new JButton("RESET");
      //display.setBounds(130,200,100,30); 
      //display.setBounds(40,70,10,10);                                               
      p1.add(lblHour);                                             
      p1.add(lblMinute);
      p1.add(lblSecond);
      p1.add(hourTxt);
      p1.add(minuteTxt);                                                
      p1.add(secondTxt);        
      p1.add(reset);                                       
      reset.addActionListener(this); 
      add(p1);       
   } 
   public void actionPerformed(ActionEvent ae) 
   { 
      //try 
      //{ 
        hourTxt.setText(""+00);
        minuteTxt.setText(""+00);
        secondTxt.setText(""+00); 
      //}  
     
    /*catch(SQLException se) 
    { 
	System.out.println("SQL Exception " + se); 
    } 
    catch(ClassNotFoundException cnfe) 
    { 
	System.out.println("SQL Exception" + cnfe); 
    } */
   } 
} 
 
class Hour implements Runnable
{
   public Thread t1;
   private int count1;
   public Hour()
   {
      t1       = new Thread(this,"Hour Thread");
      count1 = 0;
      t1.start();
   }
   public void run()
   {
      try
      {
         count1++;
         hourTxt.setText(count1);
         Thread.sleep(3600);
      }
      catch(InterruptedException ie)
      {
         System.out.println("Interrupted Exception being thrown" + ie);
      }
   }
}
class Minute implements Runnable
{
   public Thread t2;
   private int count2;
   public Hour()
   {
      t2       = new Thread(this,"Minute Thread");
      count2 = 0;
      t2.start();
   }
   public void run()
   {
      try
      {
         count2++;
         minuteTxt.setText(count2);
         Thread.sleep(60);
      }
      catch(InterruptedException ie)
      {
         System.out.println("Interrupted Exception being thrown" + ie);
      }
   }
}
class Second implements Runnable
{
   public Thread t3;
   private int count3;
   public Hour()
   {
      t3       = new Thread(this,"Second Thread");
      count3 = 0;
      t3.start();
   }
   public void run()
   {
      try
      {
         count3++;
         secondTxt.setText(count3);
         Thread.sleep(0);
      }
      catch(InterruptedException ie)
      {
         System.out.println("Interrupted Exception being thrown" + ie);
      }
   }
}

public class DigitalClock 
{ 
   public static void main(String[] args) 
   { 
  
      DigitalFrame df = new DigitalFrame(); 
      df.setTitle("Digital Clock"); 
      df.setVisible(true); 
      df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  } 
} 
