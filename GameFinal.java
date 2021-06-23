import java.awt.geom.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
public class GameFinal
{
public static void main(String[] args)
{
EventQueue.invokeLater(new Runnable()
{
public void run()
{
ImageFrame frame = new ImageFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
}
});
}
}

class ImageFrame extends JFrame
{

public ImageFrame()
{
setTitle("ImageTest");
setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

final ImageComponent c1 = new ImageComponent();
add(c1);
this.addKeyListener(new KeyListener()
{
            
            public void keyTyped(KeyEvent e)
                  {
                      }

            @Override
            public void keyPressed(KeyEvent e) {
             c1.skey= e.getKeyChar(); if(e.getKeyChar()=='w')
                    {c1.fairyy-=10;c1.s="w.png";}
                if(e.getKeyChar()=='s')
                    {c1.fairyy+=10;c1.s="s.png";}
                if(e.getKeyChar()=='a')
                    {c1.fairyx-=10;c1.s="a.png";}
                if(e.getKeyChar()=='d')
                    {c1.fairyx+=10;c1.s="d.png";}
            }

            @Override
            public void keyReleased(KeyEvent e) {
             }
        });
}

public static final int DEFAULT_WIDTH = 1400;
public static final int DEFAULT_HEIGHT = 1000;

}
class ImageComponent extends JComponent
{
	public String s="s.png";
	public Float wr=100.0f;
	public int sx=0,sy=0;
	public int fairyx=0 ,fairyy=900;
	public int flagsun=0;
	public char skey='\0';
	public Float wl=100.0f;
	public int sunx=450,suny=0;
 	Date d=new Date();
	public long starttime=d.getTime();			
	public ImageComponent()
	{
	try
	{
		hsun = ImageIO.read(new File("tree2.png"));
		fairy = ImageIO.read(new File(s));
                bush = ImageIO.read(new File("bush1.png"));
		w1 = ImageIO.read(new File("w1.png"));
		spider = ImageIO.read(new File("spider.png"));
		bgimage = ImageIO.read(new File("Clouds.png"));
		bear = ImageIO.read(new File("bear.jpg"));
		star = ImageIO.read(new File("Star.png"));
		bud = ImageIO.read(new File("Bud.png"));
		flower = ImageIO.read(new File("FlowerPink.png"));
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
}
public void paintComponent(Graphics g)
{ 
	Graphics2D g2=( Graphics2D)g;
	int sunWidth = hsun.getWidth(this);
	System.out.println("sun w="+sunWidth);
	int sunHeight = hsun.getHeight(this);
	System.out.println("sun h="+sunHeight);
	int fairyWidth = fairy.getWidth(this);
	int fairyHeight = fairy.getHeight(this);
	//g.drawImage(bgimage,0,0,null);
	 if(d.getTime()- starttime>2000)
	{
		wr=wr-5.0f;
		starttime=d.getTime();
	}
	Rectangle2D rect = new Rectangle2D.Float(1280.0f,30.0f,30.0f,wr);
	g2.draw(rect);
	g2.setPaint(Color.BLUE);
	g2.fill(rect);
	//draw sun
	g.drawImage(hsun,sunx,suny,null);
	//draw fairy
	 g.drawImage(fairy, fairyx, fairyy, null); 
	//hitting sun
	 for( sx=fairyx; sx<=(fairyWidth+fairyx);sx++)
        {for(sy=fairyy;sy<=(fairyHeight+fairyy);sy++){
        if((sx>=sunx && sx<=(sunWidth+sunx))&& (fairyy>=sy && fairyy<=(sunHeight+suny)))
        {    flagsun=1;
		 if(wl>0.1f)
			wl=wl-0.1f;
		break;
        }

        }}
	if((skey=='w' || skey=='s') &&flagsun==1)
		{fairyy=suny+sunHeight+1;flagsun=0;}
	if((skey=='a' || skey=='d')&& flagsun==1)
		{fairyx=sunx+sunWidth;flagsun=0;}
	

        repaint();
        }
	private Image fairy,hsun,bush,w1,spider,bgimage,bear,star,bud,flower;
}	

