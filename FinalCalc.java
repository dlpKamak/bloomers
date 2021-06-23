import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ArithmeticCalculator extends JFrame implements KeyListener
{
   JButton buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,buttonSix,buttonSeven,buttonEight;
   JButton buttonNine,buttonZero,buttonPlus,buttonMinus,buttonMul,buttonDiv,buttondot,buttonEqual,buttonClear,buttonoff,buttonac,buttonmod;
   JTextField txtDisplay;
   JPanel panel,bpanel;
   public Double result= 0.0;
   public boolean start=true,minus=true;
   public String lastButton="=";
   public Double operand;
    public ArithmeticCalculator()
    {
       setSize(300,330);
       setTitle("ArithmeticCalculator");
       setLayout(null);
       panel = new JPanel();
       bpanel = new JPanel();
       txtDisplay = new JTextField(30);
       buttonOne = new JButton("1");
       buttonTwo = new JButton("2");
       buttonThree = new JButton("3");
       buttonFour = new JButton("4");
       buttonFive = new JButton("5");
       buttonSix = new JButton("6");
       buttonSeven = new JButton("7");
       buttonEight = new JButton("8");
       buttonNine = new JButton("9");
       buttonZero = new JButton("0");
       buttonPlus = new JButton("+");
       buttonMinus = new JButton("-");
       buttonMul = new JButton("*");
       buttonDiv = new JButton("/");
       buttonEqual = new JButton("=");
       buttondot = new JButton(".");
       buttonmod = new JButton("%");
       buttonClear = new JButton("CLEAR");
       buttonoff = new JButton("OFF");
       buttonac = new JButton("AC");
       panel.setLayout(null);
       txtDisplay.setBounds(10,10,120,30);
       panel.add(txtDisplay);
       //buttonClear.setBounds(130,10,80,30); 
       bpanel.setLayout(new GridLayout(5,4));
       bpanel.add(buttonZero);
       bpanel.add(buttonOne);
       bpanel.add(buttonTwo);
       bpanel.add(buttonThree);
       bpanel.add(buttonFour);
       bpanel.add(buttonFive);
       bpanel.add(buttonSix);
       bpanel.add(buttonSeven);
       bpanel.add(buttonEight);
       bpanel.add(buttonNine);
       bpanel.add(buttonPlus);
       bpanel.add(buttonMinus);
       bpanel.add(buttonMul);
       bpanel.add(buttonDiv);
       bpanel.add(buttondot);
       bpanel.add(buttonEqual);
       panel.add(buttonClear);
       //buttonoff.setBounds(200,10,80,30);
       panel.add(buttonoff);
       panel.add(buttonac);
       panel.add(buttonmod);
       panel.setBounds(0,10,300,40);
       add(panel);
       bpanel.setBounds(10,50,280,250);
       add(bpanel);
       buttonOne.addKeyListener(this);
       buttonZero.addKeyListener(this);
       buttonTwo.addKeyListener(this);
       buttonThree.addKeyListener(this);
       buttonFour.addKeyListener(this);
       buttonFive.addKeyListener(this);
       buttonSix.addKeyListener(this);
       buttonSeven.addKeyListener(this);
       buttonEight.addKeyListener(this);
       buttonNine.addKeyListener(this);
       buttonPlus.addKeyListener(this);
       buttonMinus.addKeyListener(this);
       buttonMul.addKeyListener(this);
       buttonDiv.addKeyListener(this);
       buttondot.addKeyListener(this);
       buttonmod.addKeyListener(this);
       buttonEqual.addKeyListener(this);
       buttonClear.addKeyListener(this);
       buttonac.addKeyListener(this);
    }
     public void keyTyped(KeyEvent ke) 
   {
        String buttonPressed = String.valueOf(ke.getKeyChar());
        if (buttonPressed.equals("0")||buttonPressed.equals("1")||buttonPressed.equals("2")||buttonPressed.equals("3")||
            buttonPressed.equals("4")||buttonPressed.equals("5")||buttonPressed.equals("6")||buttonPressed.equals("7")||
            buttonPressed.equals("8")||buttonPressed.equals("9")||buttonPressed.equals("."))
        {
              if ( start )
              {
                  txtDisplay.setText("");
                  start = false;
                  minus=false;
              }
              txtDisplay.setText(txtDisplay.getText()+buttonPressed);
        }
       
        else
        {
            if (buttonPressed.equals("-") && start && minus )
            {
                txtDisplay.setText("-");
                start = false;
                minus = false;
            }
            else
            {
                start = true;
                operand = Double.parseDouble(txtDisplay.getText());
                calculate();
                lastButton = buttonPressed;
               
             }
         }
         if (buttonPressed.equals("r"))//inorder to clear the display press "r"
         {
             txtDisplay.setText("");
         }
         if (buttonPressed.equals("o"))//inorder to off the calculator press"o"
         {
             setVisible(false);
         }
         if (buttonPressed.equals("a"))//inorder to clear the display press "r"
         {
             txtDisplay.setText("0");
         }
      }
      public void calculate()
      {
          if (lastButton.equals("+"))
               result += operand;
          else if (lastButton.equals("-"))
               result -= operand;
          else if (lastButton.equals("*"))
               result *= operand;
          else if (lastButton.equals("/"))
               result /= operand;
          else if (lastButton.equals("%"))
               result %= operand;
          else
               result = operand;
          txtDisplay.setText(""+result);
       }
            
            
    public void keyPressed(KeyEvent ke)
    {}
  
    public void keyReleased(KeyEvent ke)
    {}
}
public class FinalCalc
{
   public static void main(String[] args)
   {
      ArithmeticCalculator ac = new ArithmeticCalculator();
      ac.setVisible(true);
      ac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}













