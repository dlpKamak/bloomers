import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class ArithmeticCalculator extends JFrame implements KeyListener
{
   JTextField txtfield;
   double oper1 , oper2 , result;
   char ch;
   public boolean on = true;
   JButton btn1 , btn2 , btn3 , btn4 , btn5 , btn6 , btn7 , btn8 , btn9 , btn0;
   JButton btndot , btnadd , btnsub , btnmul , btndiv , btnequ , btnmod;
   JButton btnpow , btnac , btnclr;
   Container cont;
   JPanel textPanel , buttonpanel , labelpanel;

   public ArithmeticCalculator()
   {                     
      cont = getContentPane();
      cont.setLayout(new BorderLayout());

      JPanel labelpanel = new JPanel();
      JLabel lbltext1   = new JLabel( " CASIO \t AC" );
      labelpanel.add(lbltext1);
      cont.add( "South", labelpanel );

      JPanel textpanel = new JPanel();
      txtfield         = new JTextField(25);
      txtfield.setHorizontalAlignment( SwingConstants.RIGHT );
      txtfield.addKeyListener( this );
      textpanel.add( txtfield );
      cont.add( "North", textpanel );
      
      buttonpanel = new JPanel();
      buttonpanel.setLayout( new GridLayout( 5 , 4 ) );

      btnpow = new JButton( "OFF" );
      buttonpanel.add( btnpow );
      btnpow.addKeyListener( this );
      btnclr = new JButton( "C" );
      buttonpanel.add( btnclr );
      btnclr.addKeyListener( this );
      btnac = new JButton( "AC" );
      buttonpanel.add( btnac ); 
      btnac.addKeyListener( this );
      btnmod = new JButton( "%" );
      buttonpanel.add( btnmod );
      btnmod.addKeyListener( this );    
          
      

      btn1 = new JButton( "7" );
      buttonpanel.add( btn1 );
      btn1.addKeyListener( this );
      btn2 = new JButton( "8" );
      buttonpanel.add( btn2 );
      btn2.addKeyListener( this );
      btn3 = new JButton( "9" );
      buttonpanel.add( btn3 );
      btn3.addKeyListener( this );
      btndiv = new JButton( "/" );
      buttonpanel.add( btndiv );
      btndiv.addKeyListener( this );
     

      btn4 = new JButton( "4" );
      buttonpanel.add( btn4 );
      btn4.addKeyListener( this );
      btn5 = new JButton( "5" );
      buttonpanel.add( btn5 );
      btn5.addKeyListener( this );
      btn6 = new JButton( "6" );
      buttonpanel.add( btn6 );
      btn6.addKeyListener( this );
      btnmul = new JButton( "*" );
      buttonpanel.add( btnmul );
      btnmul.addKeyListener( this );


      btn7 = new JButton( "1" );
      buttonpanel.add( btn7 );
      btn7.addKeyListener( this );
      btn8 = new JButton( "2" );
      buttonpanel.add( btn8 );
      btn8.addKeyListener( this );
      btn9 = new JButton( "3" );
      buttonpanel.add( btn9 );
      btn9.addKeyListener( this );
      btnsub = new JButton( "-" );
      buttonpanel.add( btnsub );
      btnsub.addKeyListener( this );
      
      btndot = new JButton( "." );
      buttonpanel.add( btndot );
      btndot.addKeyListener( this );
      btn0 = new JButton( "0" );
      buttonpanel.add( btn0 );
      btn0.addKeyListener( this );
      btnac.addKeyListener( this );
      btnequ = new JButton( "=" );
      buttonpanel.add(btnequ); 
      btnequ.addKeyListener( this );
      btnadd = new JButton( "+" );
      buttonpanel.add( btnadd );
      btnadd.addKeyListener( this );
      

      cont.add( "Center", buttonpanel );
   }
   public void keyTyped( KeyEvent ke )
   {
      char c = ke.getKeyChar();
      if( on )
      {
         if ( ! ( c >= '0' && c <= '9' ) )
            ke.consume();
      }
   }

   public void keyPressed( KeyEvent ke )
   {
      char c = ke.getKeyChar();
      if( on )
      {
         if ( c == '.' )
         {
            if( txtfield.getText().equals ( "" ) )
               txtfield.setText( txtfield.getText()+ "0." );
            else
               txtfield.setText( txtfield.getText() + "." );
         }
         else if ( c == 'a' )
         {
           oper1 = oper2 = result = 0.0;
           txtfield.setText( "" );
         }
         else if ( c == 'c' )
         {
           txtfield.setText( "" );
         }
         else if ( c == 'o' )
         {
           txtfield.setText( "" );
           oper1 = oper2 = result = 0.0;
           btnpow.setLabel( "ON" );
           on = false;
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
      }
   }

   public void keyReleased( KeyEvent ke )
   {
   }
}

public class FinalArithmeticCalc
{
   public static void main(String args[])
   {
      ArithmeticCalculator acalc = new ArithmeticCalculator();
      acalc.setTitle("ArithmeticCalculator");
      acalc.pack();
      acalc.setVisible(true);
      acalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
