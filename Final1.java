import java.awt.geom.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
public class Final1
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

public static final int DEFAULT_WIDTH = 1400;
public static final int DEFAULT_HEIGHT = 1000;

}

class ImageComponent extends JComponent
{
	public int f1=0,f2=0,sf=0,s2=0,s1=0;     
	public String s="s.png";
        public int count=1,count1=1;
	public int x=10 ,y=445;
        public int x1=250 ,y1=140,sunx=450,suny=0,fs=0,x7=0,y7=0;
	public int x2=1050 ,y2=0,sx2=0,sy2=0,y5=0,x5=0,bx=0,by=0,bf=0,fl1=0,fl2=0;
	public int x3=350 ,y3=250,x4=1200,y4=300,x6=0,y6=500,fx=0,fy=0;
	 boolean flag=true;
	boolean flagf=true;
	public String st1="";
        public String str1="";
	public int k=1;
        public int score =0;
	public Float wr=100.0f;
	public Float wl=100.0f;
	public char skey='\0';
	public Float sl=100.0f; 
        Date d=new Date();
	public long starttime=d.getTime();
	public ImageComponent()
	{
	try
	{	//Graphics g;
		hsun = ImageIO.read(new File("tree1.png"));
		image = ImageIO.read(new File(s));
                bush = ImageIO.read(new File("bush1.png"));
		w1 = ImageIO.read(new File("bw.png"));
		spider = ImageIO.read(new File("spider.png"));
		bgimage = ImageIO.read(new File("Untitled.png"));
		bear = ImageIO.read(new File("bear.jpg"));
		star = ImageIO.read(new File("Star.png"));
		bud = ImageIO.read(new File("Bud.png"));
		flower = ImageIO.read(new File("FlowerPink.png"));
	//System.out.println(d.getTime());	
	
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	}


public void paintComponent(Graphics g)
{ 
	Graphics2D g2=( Graphics2D)g;int bgWidth = bgimage.getWidth(this);//System.out.println("f w"+imageWidth);
	int bgHeight = bgimage.getHeight(this);g.drawImage(bgimage,0,0,null);
	for (int i = 0; i * bgWidth <= getWidth(); i++)
		for (int j = 0; j * bgHeight <= getHeight(); j++)
			if (i + j > 0)
				g.copyArea(0, 0, bgWidth, bgHeight, i * bgWidth, j * bgHeight);
        try
        {
        	image = ImageIO.read(new File(s)); 
        }
        catch (IOException e)
	{
		e.printStackTrace();
	}
		Date d =new Date();
        if(d.getTime()- starttime>2000)
	{
		wr=wr-5.0f;
		starttime=d.getTime();
	}
	Rectangle2D rect = new Rectangle2D.Float(1180.0f,30.0f,30.0f,wr);
	g2.draw(rect);
	g2.setPaint(Color.BLUE);
        int si = 200;

	g.drawImage(w1,x2,y2,null);
	if(y2==0)	
		f1=0;
if(y2==500)
f1=1;
if(f1==0){y2=y2+1;//System.out.println(y2);
}

if(f1==1)
{
y2=y2-1;
//System.out.println(y2);
}
g.drawImage(spider,x3,y3,null);if(x3==350)f2=0;
if(x3==500)
f2=1;
if(f2==0){x3=x3+1;//System.out.println(x3);
}

if(f2==1)
{
x3=x3-1;
//System.out.println(x3);
}
//}
	g.drawImage(hsun,sunx,suny,null);
        //for (;si<900;si=si+200)
        //{
             
        //}
	g2.fill(rect);if(wr==0.0f)count=0;
	if (image == null) return;
        int imageWidth = image.getWidth(this);
	int imageHeight = image.getHeight(this);
	int starWidth = star.getWidth(this);
	int starHeight = star.getHeight(this);
        int bushWidth = bush.getWidth(this);
	int bushHeight = bush.getHeight(this);
        int spiderWidth = spider.getWidth(this);
	int spiderHeight = spider.getHeight(this);int x2 , y2 ;int hsunWidth = hsun.getWidth(this);
	int hsunHeight = hsun.getHeight(this);
	int bearWidth = bear.getWidth(this);
	int bearHeight = bear.getHeight(this);
	int budWidth = bud.getWidth(this);
	int budHeight = bud.getHeight(this);int sunWidth = hsun.getWidth(this);
	int sunHeight = hsun.getHeight(this);
       int f=0; g.drawImage(bush, 0, 0, null); 
        g.drawImage(image, x, y, null); 
	//hitting sun
 for( x7=x; x7<=(imageWidth+x);x7++)
        {for(y7=y;y7<=(imageHeight+y);y7++){
        if((x7>=sunx && x7<=(sunWidth+sunx))&& (y>=y7 && y<=(sunHeight+suny)))
        {fs=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }

        }}if((skey=='w' || skey=='s') &&fs==1){y=suny+sunHeight+1;fs=0;}if((skey=='a' || skey=='d')&& f==1){x=sunx+sunWidth;fs=0;}

//hitting bush
        for( x2=x; x2<=(imageWidth+x);x2++)
        {for(y2=y;y2<=(imageHeight+y);y2++){
        if((x2>=x1 && x2<=(bushWidth+x1))&& (y>=y1 && y<=(bushHeight+y1)))
        {f=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}if((skey=='w' || skey=='s') &&f==1){y=y1+bushHeight+1;f=0;}if((skey=='a' || skey=='d')&& f==1){x=x1+bushWidth;f=0;}
	//hitting spider
        for( sx2=x; sx2<=(imageWidth+x);sx2++)
        {for(sy2=y;sy2<=(imageHeight+y);sy2++){
        if((sx2>=x3 && sx2<=(spiderWidth+x3))&& (y>=y3 && y<=(spiderHeight+y3)))
        {sf=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}if((skey=='w' || skey=='s') && sf==1){y=y3+spiderHeight+1;sf=0;}if((skey=='a' || skey=='d')&& sf==1){x=x3+spiderWidth;sf=0;}
	
	Rectangle2D rect1 = new Rectangle2D.Float(1180.0f,140.0f,30.0f,wl);
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
	//star collection
	for( s1=x; s1<=(imageWidth+x);s1++)
        {for(s2=y;s2<=(imageHeight+y);s2++){
        if((s1>=x4 && s1<=(starWidth+x4))&& (y>=y4 && y<=(starHeight+y4)))
        {//sf=1; //if(wl>0.1f)
		//wl=wl-0.1f;
		flag=false;break;
        }
        }}
	if(flag==true)
		g.drawImage(star, x4, y4, null);
	else
	{
	g.drawImage(bgimage, x, y, null);g.drawImage(image, x, y, null);
	
}
g.drawImage(bear,900,300,null);//hitting bear
	for( x5=x; x5<=(imageWidth+x);x5++)
        {for(y5=y;y5<=(imageHeight+y);y5++){
        if((x5>=bx && x5<=(bearWidth+bx))&& (y>=by && y<=(bearHeight+by)))
        {bf=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}if((skey=='w' || skey=='s') && bf==1){y=by+bearHeight+1;bf=0;}if((skey=='a' || skey=='d')&& bf==1){x=bx+bearWidth;bf=0;}
	g.drawImage(bush,x1,y1,null);
	//flower
	for( fl1=x;fl1<=(imageWidth+x);fl1++)
        {for(fl2=y;fl2<=(imageHeight+y);fl2++){
        if((fl1>=x6 && fl1<=(budWidth+x6))&& (y>=y6 && y<=(budHeight+y6)))
        {//bf=1; //if(wl>0.1f)
		//wl=wl-0.1f;
		flagf=false;System.out.println("f1");
		break;
        }
        }}
	if(flagf==true){
		g.drawImage(bud,x6,y6, null);System.out.println("1");}
	else
	{System.out.println("2");
	g.drawImage(flower,x6,y6, null);//g.drawImage(image,0,0, null);
	
	}

        repaint();
        }
	private Image image,hsun,bush,w1,spider,bgimage,bear,star,bud,flower;
}
