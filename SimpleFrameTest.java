import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.imageio.*;
public class SimpleFrameTest
{
public static void main(String[] args)
{
SimpleFrame frame = new SimpleFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
}
}

class SimpleFrame extends JFrame
{
public SimpleFrame()
{
setTitle("Ball in Frame");
setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
final DrawComponent c1 = new DrawComponent();
add(c1);
this.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
          //      throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void keyPressed(KeyEvent e) {
            //    throw new UnsupportedOperationException("Not supported yet.");
                if(e.getKeyChar()=='w')
                    c1.bally-=10;
                if(e.getKeyChar()=='s')
                    c1.bally+=10;
                if(e.getKeyChar()=='a')
                    c1.ballx-=10;
                if(e.getKeyChar()=='d')
                    c1.ballx+=10;
            }

            @Override
            public void keyReleased(KeyEvent e) {
              //  throw new UnsupportedOperationException("Not supported yet.");
            }
        });
}

public static final int DEFAULT_WIDTH = 300;
public static final int DEFAULT_HEIGHT = 200;
}

//Let’s work through this program, line by line.

class DrawComponent extends JComponent
{

public double ballx=50,bally=50,ballsize=20;
//Ellipse2D.Double cir;
Image chick=ImageIO.read(new File("YellowChick.png"));
//ballx=50;bally=50;ballsize=20;
public void paintComponent(Graphics g)
{
//Graphics2D g2d=(Graphics2D)g;  
        // cir = new Ellipse2D.Double(ballx,bally,(double)ballsize,(double)ballsize);
         if(ballx==-20)
             ballx=800;
         if(ballx==800)
             ballx=-20;
         if(bally==-20)
             bally=600;
         if(bally==600)
             bally=-20;
  //        cir = new Ellipse2D.Double(ballx,bally,(double)ballsize,(double)ballsize);
  //       g2d.setColor(Color.black);
 //        g2d.draw(cir);
 //        g2d.fill(cir);        
         g.drawImage(chick,0,0,null);
         repaint();
}
}
