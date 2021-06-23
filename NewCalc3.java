import java.awt.*;
//import javax.swing.*;
import java.awt.event.*;
//import javax.swing.event.*;
import java.applet.*;

/*
 * <applet code= "NewCalc3" width = "500" height = "500" >
 * </applet>
 */

public class NewCalc3 extends Applet implements KeyListener
{
   TextField txtfield;
   double oper1 , oper2 , result;
   char ch;
   //public boolean on = true;
   Button btn1 , btn2 , btn3 , btn4 , btn5 , btn6 , btn7 , btn8 , btn9 , btn0;
   Button btndot , btnadd , btnsub , btnmul , btndiv , btnequ , btnmod;
   Button btnpow , btnac , btnclr;
   //Container cont;
   Panel textPanel , buttonpanel , labelpanel;

   public void init()
   {                     
      //cont = getContentPane();
      //cont.setLayout(new BorderLayout());

      Panel labelpanel = new Panel();
      Label lbltext1   = new Label( " Arithmetic Calculator" );
      labelpanel.add(lbltext1);
      //cont.add( "South", labelpanel );

      Panel textpanel = new Panel();
      txtfield        = new TextField(25);
      //txtfield.setHorizontalAlignment( SwingConstants.RIGHT );
      txtfield.addKeyListener( this );
      textpanel.add( txtfield );
      //cont.add( "North", textpanel );
      
      buttonpanel = new Panel();
      buttonpanel.setLayout( new GridLayout( 5 , 4 , 3 , 3 ) );

      btnpow = new Button( "OFF" );
      buttonpanel.add( btnpow );
      btnpow.addKeyListener( this );
      btnclr = new Button( "C" );
      buttonpanel.add( btnclr );
      btnclr.addKeyListener( this );
      btnac = new Button( "AC" );
      buttonpanel.add( btnac );     
      btnac.addKeyListener( this );
      btnequ = new Button( "=" );
      buttonpanel.add(btnequ);     
      btnequ.addKeyListener( this );

      btn1 = new Button( "1" );
      buttonpanel.add( btn1 );
      btn1.addKeyListener( this );
      btn2 = new Button( "2" );
      buttonpanel.add( btn2 );
      btn2.addKeyListener( this );
      btn3 = new Button( "3" );
      buttonpanel.add( btn3 );
      btn3.addKeyListener( this );
      btnmod = new Button( "%" );
      buttonpanel.add( btnmod );
      btnmod.addKeyListener( this );

      btn4 = new Button( "4" );
      buttonpanel.add( btn4 );
      btn4.addKeyListener( this );
      btn5 = new Button( "5" );
      buttonpanel.add( btn5 );
      btn5.addKeyListener( this );
      btn6 = new Button( "6" );
      buttonpanel.add( btn6 );
      btn6.addKeyListener( this );
      btndiv = new Button( "/" );
      buttonpanel.add( btndiv );
      btndiv.addKeyListener( this );

      btn7 = new Button( "7" );
      buttonpanel.add( btn7 );
      btn7.addKeyListener( this );
      btn8 = new Button( "8" );
      buttonpanel.add( btn8 );
      btn8.addKeyListener( this );
      btn9 = new Button( "9" );
      buttonpanel.add( btn9 );
      btn9.addKeyListener( this );
      btnmul = new Button( "*" );
      buttonpanel.add( btnmul );
      btnmul.addKeyListener( this );

      btndot = new Button( "." );
      buttonpanel.add( btndot );
      btndot.addKeyListener( this );
      btn0 = new Button( "0" );
      buttonpanel.add( btn0 );
      btn0.addKeyListener( this );
      btnadd = new Button( "+" );
      buttonpanel.add( btnadd );
      btnadd.addKeyListener( this );
      btnsub = new Button( "-" );
      buttonpanel.add( btnsub );
      btnsub.addKeyListener( this );

      //cont.add( "Center", buttonpanel );
   }

   /*public void actionPerformed( ActionEvent ae )
   {
      String s = ae.getActionCommand();
      if( on )
      {
         if ( s.equals ( "1" ) )
            txtfield.setText( txtfield.getText() + "1" );
         else if ( s.equals ( "2" ) )
            txtfield.setText( txtfield.getText() + "2" );
         else if ( s.equals ( "3" ) )
            txtfield.setText( txtfield.getText() + "3" );
         else if ( s.equals ( "4" ) )
            txtfield.setText( txtfield.getText() + "4" );
         else if ( s.equals ( "5" ) )
            txtfield.setText( txtfield.getText() + "5" );
         else if ( s.equals ( "6" ) )
            txtfield.setText( txtfield.getText() + "6" );
         else if ( s.equals ( "7" ) )
            txtfield.setText( txtfield.getText() + "7" );
         else if ( s.equals ( "8" ) )
            txtfield.setText( txtfield.getText() + "8" );
         else if ( s.equals ( "9" ) )
            txtfield.setText( txtfield.getText() + "9" );
         else if ( s.equals ( "0" ) )
            txtfield.setText( txtfield.getText() + "0" );
         else if ( s.equals ( "." ) )
         {
            if( txtfield.getText().equals ( "" ) )
               txtfield.setText( txtfield.getText()+ "0." );
            else
               txtfield.setText( txtfield.getText() + "." );
         }

         else if ( s.equals ( "AC" ) )
         {
           oper1 = oper2 = result = 0.0;
           txtfield.setText( "" );
         }
         else if ( s.equals ( "C" ) )
         {
           txtfield.setText( "" );
         }
         else if ( s.equals ( "OFF" ) )
         {
           txtfield.setText( "" );
           oper1 = oper2 = result = 0.0;
           btnpow.setLabel( "ON" );
           on = false;
         }

         else if ( s.equals ( "+" ) )
         {
            if ( ! ( txtfield.getText().equals ( "" ) ) )
            {
               oper1 = Double.parseDouble( txtfield.getText() );
               txtfield.setText( "" );
               ch = '+';
            }
         }
         else if ( s.equals ( "-" ) )
         {
            if ( ( txtfield.getText().equals ( "" ) ) || ( txtfield.getText().equals ( "-" ) ) )
               txtfield.setText( "-" );
            else
            {
               oper1 = Double.parseDouble( txtfield.getText() );
               txtfield.setText( "" );
               ch = '-';
            }
         }
         else if ( s.equals ( "*" ) )
         {
            if ( ! ( txtfield.getText().equals ( "" ) ) )
            {
               oper1 = Double.parseDouble( txtfield.getText() );
               txtfield.setText( "" );
               ch = '*';
            }
         }
         else if ( s.equals ( "/" ) )
         {
            if(!(txtfield.getText().equals ( "" ) ) )
            {
               oper1 = Double.parseDouble( txtfield.getText() );
               txtfield.setText( "" );
               ch = '/';
            }
         }
         else if ( s.equals ( "%" ) )
         {
            if ( ! ( txtfield.getText().equals ( "" ) ) )
            {
               oper1 = Double.parseDouble( txtfield.getText() );
               txtfield.setText( "" );
               ch = '%';
            }
         }
         else if ( s.equals ( "=" ) )
         {
            if ( ! ( txtfield.getText().equals ( "" ) ) )
            {
              oper2 = Double.parseDouble( txtfield.getText() );
               switch ( ch )
               {
                  case '+':
                     result = oper1 + oper2;
                     break;
                  case '-':
                     result = oper1 - oper2;
                     break;
                  case '*':
                     result = oper1 * oper2;
                     break;
                  case '/':
                     result = oper1 / oper2;
                     break;
                  case '%':
                     result = oper1 % oper2;
                     break;
                  default:
                     result=oper2;
                     break;
               }                                    
               txtfield.setText( "" );
               txtfield.setText( txtfield.getText() + result );
            }
         }
      }
      else
      {
         if ( s.equals ( "ON" ) )
         {
            btnpow.setLabel( "OFF" );
            on = true;
         }
      }
   }*/

   public void keyTyped( KeyEvent ke )
   {
      char c = ke.getKeyChar();
      //if( on )
      //{
        if ((c=='0') || (c=='1') || (c=='2') || (c=='3') || (c=='4') || (c=='5') || (c=='6') || (c=='7') || (c=='8') || (c=='9'))
            ke.consume();
  
      //}
   }

   public void keyPressed( KeyEvent ke )
   {
      char c = ke.getKeyChar();
      //if( on )
      //{
         if ( c == '.' )
         {
            if( txtfield.getText().equals ( "" ) )
               txtfield.setText( txtfield.getText()+ "0." );
            else
               txtfield.setText( txtfield.getText() + "." );
         }
         else if ( c == '+' )
         {
            if ( ! ( txtfield.getText().equals ( "" ) ) )
            {
               oper1 = Double.parseDouble( txtfield.getText() );
               txtfield.setText( "" );
               ch = '+';
            }
         }
         else if ( c == '-' )
         {
            if ( ( txtfield.getText().equals ( "" ) ) || ( txtfield.getText().equals ( "-" ) ) )
               txtfield.setText( "-" );
            else
            {
               oper1 = Double.parseDouble( txtfield.getText() );
               txtfield.setText( "" );
               ch = '-';
            }
         }
         else if ( c == '*' )
         {
            if ( ! ( txtfield.getText().equals ( "" ) ) )
            {
               oper1 = Double.parseDouble( txtfield.getText() );
               txtfield.setText( "" );
               ch = '*';
            }
         }
         else if ( c == '/' )
         {
            if(!(txtfield.getText().equals ( "" ) ) )
            {
               oper1 = Double.parseDouble( txtfield.getText() );
               txtfield.setText( "" );
               ch = '/';
            }
         }
         else if ( c == '%' )
         {
            if ( ! ( txtfield.getText().equals ( "" ) ) )
            {
               oper1 = Double.parseDouble( txtfield.getText() );
               txtfield.setText( "" );
               ch = '%';
            }
         }
         else if ( c == '=' )
         {
            if ( ! ( txtfield.getText().equals ( "" ) ) )
            {
              oper2 = Double.parseDouble( txtfield.getText() );
               switch ( ch )
               {
                  case '+':
                     result = oper1 + oper2;
                     break;
                  case '-':
                     result = oper1 - oper2;
                     break;
                  case '*':
                     result = oper1 * oper2;
                     break;
                  case '/':
                     result = oper1 / oper2;
                     break;
                  case '%':
                     result = oper1 % oper2;
                     break;
                  default:
                     result=oper2;
                     break;
               }                                    
               txtfield.setText( "" );
               txtfield.setText( txtfield.getText() + result );
            }
         }
      //}
   }

   public void keyReleased( KeyEvent ke )
   {
   }
}
/*
public class ArithmeticCalc
{
   public static void main(String args[])
   {
      ArithmeticCalculator acalc = new ArithmeticCalculator();
      acalc.setTitle("ArithmeticCalculator");
      acalc.pack();
      acalc.setVisible(true);
      acalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}*/
