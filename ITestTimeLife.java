import java.awt.geom.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
public class ITestTimeLife
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
            @Override
            public void keyTyped(KeyEvent e)
                  {
                      }

            @Override
            public void keyPressed(KeyEvent e) {
             c1.skey= e.getKeyChar(); if(e.getKeyChar()=='w')
                    {c1.y-=10;c1.s="w.png";}
                if(e.getKeyChar()=='s')
                    {c1.y+=10;c1.s="s.png";}
                if(e.getKeyChar()=='a')
                    {c1.x-=10;c1.s="a.png";}
                if(e.getKeyChar()=='d')
                    {c1.x+=10;c1.s="d.png";}
            }

            @Override
            public void keyReleased(KeyEvent e) {
             }
        });
}

public static final int DEFAULT_WIDTH = 900;
public static final int DEFAULT_HEIGHT = 900;

}

class ImageComponent extends JComponent
{
        public String s="s.png";
        public int count=1,count1=1;
	public int x=10 ,y=450;
        public int x1=0 ,y1=0;
	public String st1="";
        public String str1="";
	public int k=1;
        public int score =0;
	public Float wr=100.0f;public Float wl=100.0f;public char skey='\0'; 
        Date d=new Date();
	public long starttime=d.getTime();
	public ImageComponent()
	{
	try
	{	hsun = ImageIO.read(new File("HappySun.gif"));
		image = ImageIO.read(new File(s));
                bush = ImageIO.read(new File("bush1.png"));
	//System.out.println(d.getTime());	
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	}


public void paintComponent(Graphics g)
{ 
	Graphics2D g2=( Graphics2D)g;
        try
        {
        image = ImageIO.read(new File(s));
        }
        catch (IOException e)
	{
		e.printStackTrace();
	}Date d =new Date();
        if(d.getTime()- starttime>2000)
	{
		wr=wr-5.0f;
		starttime=d.getTime();
	}
	Rectangle2D rect = new Rectangle2D.Float(680.0f,30.0f,30.0f,wr);
	g2.draw(rect);
	g2.setPaint(Color.BLUE);
        int si = 200;
	g.drawImage(bush,x1,y1,null);
	g.drawImage(hsun,450,0,null);
        //for (;si<900;si=si+200)
        //{
             
        //}
	g2.fill(rect);if(wr==0.0f)count=0;
	if (image == null) return;
        int imageWidth = image.getWidth(this);
	int imageHeight = image.getHeight(this);
        int bushWidth = bush.getWidth(this);
	int bushHeight = bush.getHeight(this);
        int x2 , y2 ;
        boolean flag=true;int f=0;
        g.drawImage(image, x, y, null); 
        for( x2=x; x2<=(imageWidth+x);x2++)
        {for(y2=y;y2<=(imageHeight+y);y2++){
        if((x2>=x1 && x2<=(bushWidth+x1))&& (y>=y1 && y<=(bushHeight+y1)))
        {f=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}if((skey=='w' || skey=='s') &&f==1){y=y1+bushHeight+1;f=0;}if((skey=='a' || skey=='d')&& f==1){x=x1+bushWidth;f=0;}/*if (y>y1 && y<=(bushHeight+y1)&&f==1)
	{System.out.println("1");
		x=x1+bushWidth;
		f=0;
	}
	if(x>x1 && x<=(bushWidth+x1) && f==1)
	{
	System.out.println("2");
		y=y1+bushHeight+1;
		f=0;
	}*/
	Rectangle2D rect1 = new Rectangle2D.Float(680.0f,140.0f,30.0f,wl);
	g2.draw(rect1);
	g2.setPaint(Color.RED);
	g2.fill(rect1);//System.out.println(wl);
	if(wl <= 0.1f)
	{
                System.out.println("over");
		System.exit(0);
        }
	if(count==0 )
	{
                  System.out.println("over");JOptionPane.showMessageDialog( null, " GAME OVER ");System.exit(0);
	}
        score = (int)(wr+wl);
        str1= String.valueOf(score);   
        g.drawString(str1,500,30);
        repaint();
        }
	private Image image,hsun,bush;
}
