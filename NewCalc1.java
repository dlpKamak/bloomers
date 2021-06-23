import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*
 * <applet code= "NewCalc1" width = "500" height = "500" >
 * </applet>
 * */
public class NewCalc1 extends Applet implements KeyListener
{
   TextField txtResult;
   public String pressbut = "=";
   public boolean start    = true;
   public Double result = 0.0;
   public Double op1,op2;
   Button btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine;
   Button btnZero,btnPlus,btnMinus,btnStar,btnDiv,btnDot,btnEqual;
   public void init()
   {
      txtResult = new TextField(15);
      Panel txtPanel      = new Panel();
      Panel buttonPanel   = new Panel();
      btnOne   = new Button("1");
      btnTwo   = new Button("2");
      btnThree = new Button("3");
      btnFour  = new Button("4");
      btnFive  = new Button("5");
      btnSix   = new Button("6");
      btnSeven = new Button("7");
      btnEight = new Button("8");
      btnNine  = new Button("9");
      btnZero  = new Button("0");
      btnPlus  = new Button("+");
      btnMinus = new Button("-");
      btnStar  = new Button("*");
      btnDiv   = new Button("/");
      btnDot   = new Button(".");
      btnEqual = new Button("=");
      buttonPanel.setLayout(new GridLayout(4,4));
      txtPanel.add(txtResult);
      buttonPanel.add(btnOne);
      buttonPanel.add(btnTwo);
      buttonPanel.add(btnThree);
      buttonPanel.add(btnFour);
      buttonPanel.add(btnFive);
      buttonPanel.add(btnSix);
      buttonPanel.add(btnSeven);
      buttonPanel.add(btnEight);
      buttonPanel.add(btnNine);
      buttonPanel.add(btnZero);
      buttonPanel.add(btnPlus);
      buttonPanel.add(btnMinus);
      buttonPanel.add(btnStar);
      buttonPanel.add(btnDiv);
      buttonPanel.add(btnDot);
      buttonPanel.add(btnEqual);
      add(txtPanel);
      add(buttonPanel);
      btnOne.addKeyListener(this);
      btnTwo.addKeyListener(this);
      btnThree.addKeyListener(this);
      btnFour.addKeyListener(this);
      btnFive.addKeyListener(this);
      btnSix.addKeyListener(this);
      btnSeven.addKeyListener(this);
      btnEight.addKeyListener(this);
      btnNine.addKeyListener(this);
      btnZero.addKeyListener(this);
      btnPlus.addKeyListener(this);
      btnMinus.addKeyListener(this);
      btnStar.addKeyListener(this);
      btnDiv.addKeyListener(this);
      btnDot.addKeyListener(this);
      btnEqual.addKeyListener(this);
   }
   public void keyTyped(KeyEvent ke)
   {
      String r = String.valueOf(ke.getKeyChar());
      if(r.equals("0")||r.equals("1")||r.equals("2")||r.equals("3")||r.equals("4")||r.equals("5")||r.equals("6")||r.equals("7")||r.equals("8")||r.equals("9")||r.equals("."))
      {
         if(start)
         {
            txtResult.setText("");
            start = false;
         }
         txtResult.setText(txtResult.getText()+r);
      }
      else if(r.equals("+")||r.equals("*")||r.equals("/"))
      {
         pressbut = r;
         op1 = Double.parseDouble(txtResult.getText());
         start = true;
      }
      else if(r.equals("-"))
      {
         if(start)
         {
            txtResult.setText("-");
            start = false;
         }
         else
         {
            op1 = Double.parseDouble(txtResult.getText());
            start = true;
            pressbut = "-";
         }
      }
      else
      {
         op2 = Double.parseDouble(txtResult.getText());
         if(pressbut.equals("+"))
         {
            result = op1 + op2;
            txtResult.setText(""+result);
         }
         else if(pressbut.equals("-"))
         {
            result = op1 - op2;
            txtResult.setText(""+result);
         }
         else if(pressbut.equals("*"))
         {
            result = op1 * op2;
            txtResult.setText(""+result);
         }
         else if(pressbut.equals("/"))
         {
            result = op1 / op2;
            txtResult.setText(""+result);
         }
         else
         {
            result = op2;
            txtResult.setText(""+result);
         }
      }
   }
   public void stop()
   {}
   public void destroy()
   {}
   public void keyPressed(KeyEvent ke)
   {}
   public void keyReleased(KeyEvent ke)
   {}
}
         
          
       
