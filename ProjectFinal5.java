import java.awt.geom.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
public class ProjectFinal5
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
      {
        public void run()
        {
	  try{// Front f=new Front();f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          // f.setVisible(true);
           ImageFrame frame = new ImageFrame();
frame.setVisible(false);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setVisible(true);
    
        }catch(IOException ioe){}}
      });
   }
}
/*class Front extends JFrame implements MouseListener
{   
    public int x,y;
    public Front() throws IOException
    {
       
        setTitle("Front");
        setSize(1400, 800);
        final ImageComponent c1 = new ImageComponent();
        add(c1);
        this.addMouseListener(new MouseListener(){

            public void mouseClicked(MouseEvent e) 
            {
                x=e.getX();
                System.out.println(x);
                y=e.getY();
                System.out.println(y);
                if((x>=530)&&(x<=575)&&(y>=320)&&(y<=355))
                {
                    System.out.println("Start Game");c1.start=1;
                }
                else
                {
                    System.out.println("Nope");
                }
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
       
    }
    


    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
  
}*/
class ImageFrame extends JFrame implements MouseListener,keyListener
{

   public ImageFrame()
   {
      setTitle("ImageTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
      final ImageComponent c1 = new ImageComponent();
      add(c1);

   this.addMouseListener(new MouseListener(){

            public void mouseClicked(MouseEvent e) 
            {
                x=e.getX();
                System.out.println(x);
                y=e.getY();
                System.out.println(y);
                if((x>=530)&&(x<=575)&&(y>=320)&&(y<=355))
                {
                    System.out.println("Start Game");c1.start=1;
                }
                else
                {
                    System.out.println("Nope");
                }
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
       
    }
    


    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
      this.addKeyListener(new KeyListener(){
      
        public void keyTyped(KeyEvent ke)
	{        
	}

        public void keyPressed(KeyEvent ke) 
	{       
		c1.skey= ke.getKeyChar(); 
		if(ke.getKeyChar()=='w')
            	{c1.y-=10;c1.s="w.png";}
        	if(ke.getKeyChar()=='s')
            	{c1.y+=10;c1.s="s.png";}
        	if(ke.getKeyChar()=='a')
            	{c1.x-=10;c1.s="a.png";}
        	if(ke.getKeyChar()=='d')
        	{c1.x+=10;c1.s="d.png";}
	//System.out.println(c1.skey);
            }

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
	public String s="Glitter.png";
	public String witch="bd.png";
	public String snake1="snake.jpg";public String fwl="1.png",b1="Bee.bmp";;
        public int count=1,count1=1;
	public int x=0 ,y=600;
        public int bushy2=250 ,sp2x=280,sp2y=430,sf3=0,bushx2=140,sunx=510,suny=0,fs=0,x7=0,y7=0,bug2f=0,start=0;
	public int bushf=0,x2=0,y2=0,bush3=0,bush4=0,bush5=0,bush6=0,bush7=0,bush8=0,sp1x=1100,sp1y=500,sf2=0,boundry=0,boundry1=0,xb=0,yb=0;
	public int wx=900,wy=185,sx2=0,sy2=0,y5=0,score1=0,x5=0,bx=900,by=300,bf=0,fl1=0,fl2=0;
	public int shf1=0,stx=280,sty=490,fx2=550,fy2=600,sp3x=900,sp3y=450,sf4=0,kx=1200,ky=600,flowerc=1,bug3f=0;
	public int x3=350 ,y3=250,starx=350,shf=0,stary=250,x4=1200,y4=300,x6=0,y6=200,won=0,flx=450,fly=450,bugx=1200,bugy=300,bug2x=1200,bug2y=400,bug3x=1030,bug3y=350;
	public int fx=0,fy=0,wf=0,cf=0,wx1=0,wy1=0,bush9=0,hx=590,hy=450,shf2=0,cx=1225,cy=0,snakex=500,snakey=400,snakef=0,snake2x=700,snake2y=550,snake2f=0,bug1f=0;
	 boolean flag=true;
	 boolean flagstar=true,st3flag=true,flagfl=true,kflag=true,finish=false;
	boolean flagf=true,hflag=true;
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
	{	image1 = ImageIO.read(new File("Front.bmp"));
		hsun = ImageIO.read(new File("tree1.png"));
		image = ImageIO.read(new File(s));
                bush = ImageIO.read(new File("bush1.png"));
		bbush = ImageIO.read(new File("bush2.png"));
		spider = ImageIO.read(new File("Spider.png"));
		bgimage = ImageIO.read(new File("Final.png"));
		bear = ImageIO.read(new File("bear.jpg"));
		star = ImageIO.read(new File("Star.png"));
		bud = ImageIO.read(new File("Bud.png"));
		flower = ImageIO.read(new File("FlowerPink.png"));
		//castle =ImageIO.read(new File("Final.png"));
		heart =ImageIO.read(new File("Life.png"));
		key =ImageIO.read(new File("Key1.jpg"));
		final1=ImageIO.read(new File("Final.png"));
		over=ImageIO.read(new File("GameOver.bmp"));
		wong=ImageIO.read(new File("win.bmp"));
		front=ImageIO.read(new File("Front.bmp"));
		//snake=ImageIO.read(new File());
		/*fw1=ImageIO.read(new File("1.png"));System.out.println(1);
		fw2=ImageIO.read(new File("2.png"));System.out.println(2);
		fw3=ImageIO.read(new File("3.png"));System.out.println(3);
		fw4=ImageIO.read(new File("4.png"));System.out.println(4);
		fw5=ImageIO.read(new File("5.png"));System.out.println(5);*/
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	}



public void paintComponent(Graphics g)
{ 
	Graphics2D g2=( Graphics2D)g;if(start==0) g.drawImage(image1,0,0,null);else{ try{w1 = ImageIO.read(new File(witch));snake= ImageIO.read(new File(snake1));fwl1= ImageIO.read(new File(fwl));bug= ImageIO.read(new File(b1));}catch (IOException e)
	{
		e.printStackTrace();
	}
	int bgWidth = bgimage.getWidth(this);
	int bgHeight = bgimage.getHeight(this);if(start==0)g.drawImage(front,0,0,null);else{if(finish==false)g.drawImage(bgimage,0,0,null);else{g.drawImage(final1,0,0,null);}//g.drawImage(castle,cx,cy,null);//g.drawImage(girl,0,0,null);
	try
        {
        	image = ImageIO.read(new File(s)); 
        }
        catch (IOException e)
	{
		e.printStackTrace();
	}
		Date d =new Date();
        
        int si = 200;
	//moving witch
	
	if(wx==900)	
		f1=0;
	if(wx==1200)
		f1=1;
	if(f1==0)
		{wx=wx+5;witch="bd.png";
		}

	if(f1==1)
	{
		wx=wx-5;witch="ba.bmp";
	}
g.drawImage(w1,wx,wy,null);

	//moving snake
	
	if(snakex==500)	
		snakef=0;
	if(snakex==700)
		snakef=1;
	if(snakef==0)
		{snakex=snakex+2;snake1="snake.jpg";
		}

	if(snakef==1)
	{
		snakex=snakex-2;snake1="snake1.bmp";
	}
g.drawImage(snake,snakex,snakey,null);
	//moving snake2
	
	if(snake2x==700)	
		snake2f=0;
	if(snake2x==500)
		snake2f=1;
	if(snake2f==0)
		{snake2x=snake2x-2;snake1="snake1.bmp";
		}

	if(snake2f==1)
	{
		snake2x=snake2x+2;snake1="snake.jpg";
	}
g.drawImage(snake,snake2x,snake2y,null);
//moving bug1

	
	if(bugx==1030)	
		bug1f=0;
	if(bugx==1200)
		bug1f=1;
	if(bug1f==0)
		{bugx=bugx+2;b1="Bee 1.bmp";
		}

	if(bug1f==1)
	{
		bugx=bugx-2;b1="Bee.bmp";
	}g.drawImage(bug,bugx,bugy,null);
//bug2
//moving bug2

	
	if(bug2x==1030)	
		bug2f=0;
	if(bug2x==1200)
		bug2f=1;
	if(bug2f==0)
		{bug2x=bug2x+2;b1="Bee.bmp";
		}

	if(bug2f==1)
	{
		bug2x=bug2x-2;b1="Bee 1.bmp";
	}g.drawImage(bug,bug2x,bug2y,null);
//moving bug3

	
	if(bug3x==1030)	
		bug3f=0;
	if(bug3x==1200)
		bug3f=1;
	if(bug3f==0)
		{bug3x=bug3x+2;b1="Bee.bmp";
		}

	if(bug3f==1)
	{
		bug3x=bug3x-2;b1="Bee 1.bmp";
	}g.drawImage(bug,bug3x,bug3y,null);
	if (image == null) return;
        int imageWidth = image.getWidth(this);
	int imageHeight = image.getHeight(this);int starWidth = star.getWidth(this);
	int starHeight = star.getHeight(this);
        int bushWidth = bush.getWidth(this);
	int bushHeight = bush.getHeight(this);
        int spiderWidth = spider.getWidth(this);
	int spiderHeight = spider.getHeight(this);int x2 , y2 ;int hsunWidth = hsun.getWidth(this);
	int hsunHeight = hsun.getHeight(this);
	int bearWidth = bear.getWidth(this);
	int bearHeight = bear.getHeight(this);
	int keyWidth = key.getWidth(this);
	int keyHeight = key.getHeight(this);int snakeWidth = snake.getWidth(this);
	int snakeHeight = snake.getHeight(this);
	int budWidth = bud.getWidth(this);
	int budHeight = bud.getHeight(this);int sunWidth = hsun.getWidth(this);int heartWidth = heart.getWidth(this);
	int heartHeight = heart.getHeight(this);int bbushWidth = bbush.getWidth(this);
	int bbushHeight = bbush.getHeight(this);
	int sunHeight = hsun.getHeight(this);System.out.println("bush "+bbushWidth);
	int bugWidth = bug.getWidth(this);
	int bugHeight = bug.getHeight(this);
       int f=0; g.drawImage(bbush, 0, 105, null);
	g.drawImage(bbush,225, 105, null);
	g.drawImage(bbush,450, 105, null); 
	g.drawImage(bbush,800, 105, null);
	 g.drawImage(bbush,1000, 105, null);
	if(finish==false){g.drawImage(bbush,1225, 105, null);}
	g.drawImage(bush,0, 450, null);
	g.drawImage(bush,280, 590, null);
	  g.drawImage(bush,bushx2,bushy2,null);
	g.drawImage(bear,bx,by,null);
        g.drawImage(image, x, y, null); 
	g.drawImage(hsun,sunx,suny,null);	
		
	if(x<0)x=0;if(y<0)y=0;
	if(x+imageWidth>1400)x=1400-imageWidth;
	if(y+imageHeight>700)y=700-imageHeight;
	//hitting sun
 for( x7=x; x7<=(imageWidth+x);x7++)
        {for(y7=y;y7<=(imageHeight+y);y7++){
        if((x7>=sunx && x7<=(sunWidth+sunx))&& (y>=y7 && y<=(sunHeight+suny)))
        {fs=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }

        }}if((skey=='w' || skey=='s') &&fs==1){y=suny+sunHeight+1;fs=0;}if((skey=='a' || skey=='d')&& f==1){x=sunx+sunWidth;fs=0;}


//hitting bush1
        for( x2=x; x2<=(imageWidth+x);x2++)
        {for(y2=y;y2<=(imageHeight+y);y2++){
        if((x2>=0 && x2<=(bushWidth+0))&& (y>=105 && y<=(bushHeight+105)))
        {f=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}if(skey=='w'&&f==1)
		{y=105+bushHeight+1;f=0;}
	 if( skey=='s' && f==1)
		{y=105-bushHeight-1;f=0;}
	if(skey=='a'&& f==1)
		{x=0+bushWidth+1;f=0;}
	if( skey=='d'&& f==1)
		{x=0-bushWidth-1;f=0;}
	//hitting bush2
	
        for( x2=x; x2<=(imageWidth+x);x2++)
        {for(y2=y;y2<=(imageHeight+y);y2++){
        if((x2>=bushx2 && x2<=(bushWidth+bushx2))&& (y>=bushy2 && y<=(bushHeight+bushy2)))
        {bushf=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}if(skey=='w'&&bushf==1)
		{y=bushy2+bushHeight+1;bushf=0;}
	 if( skey=='s' && bushf==1)
		{y=bushy2-bushHeight-1;bushf=0;}
	if(skey=='a'&& bushf==1)
		{x=bushx2+bushWidth+1;bushf=0;}
	if( skey=='d'&& bushf==1)
		{x=bushx2-bushWidth-1;bushf=0;}
//hitting bush3
        for( x2=x; x2<=(imageWidth+x);x2++)
        {for(y2=y;y2<=(imageHeight+y);y2++){
        if((x2>=225 && x2<=(bushWidth+225))&& (y>=105 && y<=(bushHeight+105)))
        {bush3=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}if(skey=='w'&&bush3==1)
		{y=105+bushHeight+1;bush3=0;}
	 if( skey=='s' && bush3==1)
		{y=105-bushHeight-1;bush3=0;}
	if(skey=='a'&& bush3==1)
		{x=225+bushWidth+1;bush3=0;}
	if( skey=='d'&& bush3==1)
		{x=225-bushWidth-1;bush3=0;}	
//hitting bush4

        for( x2=x; x2<=(imageWidth+x);x2++)
        {for(y2=y;y2<=(imageHeight+y);y2++){
        if((x2>=450 && x2<=(bushWidth+450))&& (y>=105 && y<=(bushHeight+105)))
        {bush4=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}if(skey=='w'&&bush4==1)
		{y=105+bushHeight+1;bush4=0;}
	 if( skey=='s' && bush4==1)
		{y=105-bushHeight-1;bush4=0;}
	if(skey=='a'&& bush4==1)
		{x=450+bushWidth+1;bush4=0;}
	if( skey=='d'&& bush4==1)
		{x=450-bushWidth-1;bush4=0;}
	
	
	//hitting bush5
	

        for( x2=x; x2<=(imageWidth+x);x2++)
        {for(y2=y;y2<=(imageHeight+y);y2++){
        if((x2>=800 && x2<=(bushWidth+800))&& (y>=105 && y<=(bushHeight+105)))
        {bush5=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}
	if(skey=='w'&&bush5==1)
		{y=105+bushHeight+1;bush5=0;}
	 if( skey=='s' && bush5==1)
		{y=105-bushHeight-1;bush5=0;}
	if(skey=='a'&& bush5==1)
		{x=800+bushWidth+1;bush5=0;}
	if( skey=='d'&& bush5==1)
		{x=800-bushWidth-1;bush5=0;}
		
	//hitting bush6
	

        for( x2=x; x2<=(imageWidth+x);x2++)
        {for(y2=y;y2<=(imageHeight+y);y2++){
        if((x2>=1000 && x2<=(bushWidth+1000))&& (y>=105 && y<=(bushHeight+105)))
        {bush6=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}
	if(skey=='w'&&bush6==1)
		{y=105+bushHeight+1;bush6=0;}
	 if( skey=='s' && bush6==1)
		{y=105-bushHeight-1;bush6=0;}
	if(skey=='a'&& bush6==1)
		{x=1000+bushWidth+1;bush6=0;}
	if( skey=='d'&& bush6==1)
		{x=1000-bushWidth-1;bush6=0;}
//hitting bush7	
if(finish==false){for( x2=x; x2<=(imageWidth+x);x2++)
        {for(y2=y;y2<=(imageHeight+y);y2++){
        if((x2>=1225 && x2<=(bushWidth+1225))&& (y>=105 && y<=(bushHeight+105)))
        {bush7=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}
	if(skey=='w'&&bush7==1)
		{y=105+bushHeight+1;bush7=0;}
	 if( skey=='s' && bush7==1)
		{y=105-bushHeight-1;bush7=0;}
	if(skey=='a'&& bush7==1)
		{x=1225+bushWidth+1;bush7=0;}
	if( skey=='d'&& bush7==1)
		{x=1225-bushWidth-1;bush7=0;}}
//hitting bush8	
for( x2=x; x2<=(imageWidth+x);x2++)
        {for(y2=y;y2<=(imageHeight+y);y2++){
        if((x2>=0 && x2<=(bushWidth+0))&& (y>=450 && y<=(bushHeight+450)))
        {bush8=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}
	if(skey=='w'&&bush8==1)
		{y=450+bushHeight+1;bush8=0;}
	 if( skey=='s' && bush8==1)
		{y=450-bushHeight-1;bush8=0;}
	if(skey=='a'&& bush8==1)
		{x=0+bushWidth+1;bush8=0;}
	if( skey=='d'&& bush8==1)
		{x=0-bushWidth-1;bush8=0;}
//hitting bush9	
for( x2=x; x2<=(imageWidth+x);x2++)
        {for(y2=y;y2<=(imageHeight+y);y2++){
        if((x2>=280 && x2<=(bushWidth+280))&& (y>=590 && y<=(bushHeight+590)))
        {bush9=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}
	if(skey=='w'&&bush9==1)
		{y=590+bushHeight+1;bush9=0;}
	 if( skey=='s' && bush9==1)
		{y=590-bushHeight-1;bush9=0;}
	if(skey=='a'&& bush9==1)
		{x=280+bushWidth+1;bush9=0;}
	if( skey=='d'&& bush9==1)
		{x=280-bushWidth-1;bush9=0;}		
//hitting witch

	for(wx1=x; wx1<=(imageWidth+x);wx1++)
        {for(wy1=y;wy1<=(imageHeight+y);wy1++){
        if((wx1>=wx && wx1<=(imageWidth+wx))&& (y>=wy && y<=(imageHeight+wy)))
        {wf=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}
	if(skey=='w'&& wf==1){y=wy+imageHeight+1;wf=0;} if(skey=='s' && wf==1){y=wy-imageHeight-1;wf=0;}if(skey=='a'&& wf==1){x=wx+imageWidth+1;wf=0;} if(skey=='d'&& wf==1){x=wx-imageWidth-1;wf=0;}
//hitting snake

	for(wx1=x; wx1<=(imageWidth+x);wx1++)
        {for(wy1=y;wy1<=(imageHeight+y);wy1++){
        if((wx1>=snakex && wx1<=(snakeWidth+snakex))&& (y>=snakey && y<=(snakeHeight+snakey)))
        {wf=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}
	if(skey=='w'&& wf==1){y=snakey+imageHeight+1;wf=0;} if(skey=='s' && wf==1){y=snakey-imageHeight-1;wf=0;}if(skey=='a'&& wf==1){x=snakex+imageWidth+1;wf=0;} if(skey=='d'&& wf==1){x=snakex-imageWidth-1;wf=0;}
//hitting snake2

	for(wx1=x; wx1<=(imageWidth+x);wx1++)
        {for(wy1=y;wy1<=(imageHeight+y);wy1++){
        if((wx1>=snake2x && wx1<=(snakeWidth+snake2x))&& (y>=snake2y && y<=(snakeHeight+snake2y)))
        {wf=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}
	if(skey=='w'&& wf==1){y=snake2y+imageHeight+1;wf=0;} if(skey=='s' && wf==1){y=snake2y-imageHeight-1;wf=0;}if(skey=='a'&& wf==1){x=snake2x+imageWidth+1;wf=0;} if(skey=='d'&& wf==1){x=snake2x-imageWidth-1;wf=0;}
//hitting bug
for(wx1=x; wx1<=(imageWidth+x);wx1++)
        {for(wy1=y;wy1<=(imageHeight+y);wy1++){
        if((wx1>=bugx && wx1<=(bugWidth+bugx))&& (y>=bugy && y<=(bugHeight+bugy)))
        {wf=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}
	if(skey=='w'&& wf==1){y=bugy+imageHeight+1;wf=0;} if(skey=='s' && wf==1){y=bugy-imageHeight-1;wf=0;}if(skey=='a'&& wf==1){x=bugx+imageWidth+1;wf=0;} if(skey=='d'&& wf==1){x=bugx-imageWidth-1;wf=0;}
//hitting bug2
for(wx1=x; wx1<=(imageWidth+x);wx1++)
        {for(wy1=y;wy1<=(imageHeight+y);wy1++){
        if((wx1>=bug2x && wx1<=(bugWidth+bug2x))&& (y>=bug2y && y<=(bugHeight+bug2y)))
        {wf=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}
	if(skey=='w'&& wf==1){y=bug2y+imageHeight+1;wf=0;} if(skey=='s' && wf==1){y=bug2y-imageHeight-1;wf=0;}if(skey=='a'&& wf==1){x=bug2x+imageWidth+1;wf=0;} if(skey=='d'&& wf==1){x=bug2x-imageWidth-1;wf=0;}
//hitting bug3
for(wx1=x; wx1<=(imageWidth+x);wx1++)
        {for(wy1=y;wy1<=(imageHeight+y);wy1++){
        if((wx1>=bug3x && wx1<=(bugWidth+bug3x))&& (y>=bug3y && y<=(bugHeight+bug3y)))
        {wf=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}
	if(skey=='w'&& wf==1){y=bug3y+imageHeight+1;wf=0;} if(skey=='s' && wf==1){y=bug3y-imageHeight-1;wf=0;}if(skey=='a'&& wf==1){x=bug3x+imageWidth+1;wf=0;} if(skey=='d'&& wf==1){x=bug3x-imageWidth-1;wf=0;}
	//star collection
	for( s1=x; s1<=(imageWidth+x);s1++)
        {for(s2=y;s2<=(imageHeight+y);s2++){
        if((s1>=x4 && s1<=(starWidth+x4))&& (y>=y4 && y<=(starHeight+y4)))
        {
		flag=false;break;
        }
        }}
	if(flag==true)
		{g.drawImage(star, x4, y4, null);}
	else
	{
	score1=score+100;
		g.drawImage(image, x, y, null);
	
}
//collecting star 2
	for( s1=x; s1<=(imageWidth+x);s1++)
        {for(s2=y;s2<=(imageHeight+y);s2++){
        if((s1>=starx && s1<=(starWidth+starx))&& (y>=stary && y<=(starHeight+stary)))
        {		flagstar=false;break;
        }
        }}
	if(flagstar==true)
		{g.drawImage(star, starx, stary, null);}
	else
	{
score1=score+100;	
g.drawImage(image, x, y, null);
	
}
//collecting star 3
for( s1=x; s1<=(imageWidth+x);s1++)
        {for(s2=y;s2<=(imageHeight+y);s2++){
        if((s1>=stx && s1<=(starWidth+stx))&& (y>=sty && y<=(starHeight+sty)))
        {
		st3flag=false;break;
        }
        }}
	if(st3flag==true)
	{g.drawImage(star, stx, sty, null);}
	else
	{
	score1=score+100;	
g.drawImage(image, x, y, null);
	
}
//collecting life

for( s1=x; s1<=(imageWidth+x);s1++)
        {for(s2=y;s2<=(imageHeight+y);s2++){
        if((s1>=hx && s1<=(heartWidth+hx))&& (y>=hy && y<=(heartHeight+hy)))
        {
		hflag=false;break;
        }
        }}
	if(hflag==true)
	{	g.drawImage(heart, hx, hy, null);}
	else
	{
	score1=score+100;
g.drawImage(image, x, y, null);
	
}
//collecting key

for( s1=x; s1<=(imageWidth+x);s1++)
        {for(s2=y;s2<=(imageHeight+y);s2++){
        if((s1>=kx && s1<=(keyWidth+kx))&& (y>=ky && y<=(keyHeight+ky)))
        {
		kflag=false;break;
        }
        }}
	if(kflag==true){
		g.drawImage(key, kx, ky, null);
	}
	else
	{
	System.out.println("Key Collected");
	score1=score+100;won=1;finish=true;
//g.drawImage(image, x, y, null);
//g.drawImage(final1, 0, 0, null);
g.drawImage(image, x, y, null);		
}
//moving spider
g.drawImage(spider,x3,y3,null);if(x3==350)f2=0;
if(x3==500)
f2=1;
if(f2==0){x3=x3+1;
}

if(f2==1)
{
x3=x3-1;

}
//moving spider2

g.drawImage(spider,sp1x,sp1y,null);if(sp1x==1100)sf2=0;
if(sp1x==1180)
sf2=1;
if(sf2==0){sp1x=sp1x+1;
}

if(sf2==1)
{
sp1x=sp1x-1;

}
//moving spider3

g.drawImage(spider,sp2x,sp2y,null);if(sp2y==430)sf3=0;
if(sp2y==500)
sf3=1;
if(sf3==0){sp2y=sp2y+1;
}

if(sf3==1)
{
sp2y=sp2y-1;

}
//moving spider4

g.drawImage(spider,sp3x,sp3y,null);if(sp3y==450)sf4=0;
if(sp3y==600)
sf4=1;
if(sf4==0){sp3y=sp3y+1;
}

if(sf4==1)
{
sp3y=sp3y-1;

}
//hitting spider
        for( sx2=x; sx2<=(imageWidth+x);sx2++)
        {for(sy2=y;sy2<=(imageHeight+y);sy2++){
        if((sx2>=x3 && sx2<=(spiderWidth+x3))&& (y>=y3 && y<=(spiderHeight+y3)))
        {sf=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}if(skey=='w'&&sf==1)
		{y=y3+spiderHeight+1;sf=0;}
	 if( skey=='s' && sf==1)
		{y=y3-spiderHeight-1;sf=0;}
	if(skey=='a'&& sf==1)
		{x=x3+spiderWidth+1;sf=0;}
	if( skey=='d'&& sf==1)
		{x=x3-spiderWidth-1;sf=0;}
//hitting spider2

        for( sx2=x; sx2<=(imageWidth+x);sx2++)
        {for(sy2=y;sy2<=(imageHeight+y);sy2++){
        if((sx2>=sp1x && sx2<=(spiderWidth+sp1x))&& (y>=sp1y && y<=(spiderHeight+sp1y)))
        {shf=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}if(skey=='w'&&shf==1)
		{y=sp1y+spiderHeight+1;shf=0;}
	 if( skey=='s' && shf==1)
		{y=sp1y-spiderHeight-1;shf=0;}
	if(skey=='a'&& shf==1)
		{x=sp1x+spiderWidth+1;shf=0;}
	if( skey=='d'&& shf==1)
		{x=sp1x-spiderWidth-1;shf=0;}
//hitting spider3

        for( sx2=x; sx2<=(imageWidth+x);sx2++)
        {for(sy2=y;sy2<=(imageHeight+y);sy2++){
        if((sx2>=sp2x && sx2<=(spiderWidth+sp2x))&& (y>=sp2y && y<=(spiderHeight+sp2y)))
        {shf1=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}if(skey=='w'&&shf1==1)
		{y=sp2y+spiderHeight+1;shf1=0;}
	 if( skey=='s' && shf1==1)
		{y=sp2y-spiderHeight-1;shf1=0;}
	if(skey=='a'&& shf1==1)
		{x=sp2x+spiderWidth+1;shf1=0;}
	if( skey=='d'&& shf1==1)
		{x=sp2x-spiderWidth-1;shf1=0;}
//hitting spider4

        for( sx2=x; sx2<=(imageWidth+x);sx2++)
        {for(sy2=y;sy2<=(imageHeight+y);sy2++){
        if((sx2>=sp3x && sx2<=(spiderWidth+sp3x))&& (y>=sp3y && y<=(spiderHeight+sp3y)))
        {shf2=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}if(skey=='w'&&shf2==1)
		{y=sp3y+spiderHeight+1;shf2=0;}
	 if( skey=='s' && shf2==1)
		{y=sp3y-spiderHeight-1;shf2=0;}
	if(skey=='a'&& shf2==1)
		{x=sp3x+spiderWidth+1;shf2=0;}
	if( skey=='d'&& shf2==1)
		{x=sp3x-spiderWidth-1;shf2=0;}
//hitting bear
	for( x5=x; x5<=(imageWidth+x);x5++)
        {for(y5=y;y5<=(imageHeight+y);y5++){
        if((x5>=bx && x5<=(bearWidth+bx))&& (y>=by && y<=(bearHeight+by)))
        {bf=1; if(wl>0.1f)
		wl=wl-0.1f;
		break;
        }
        }}
	if(skey=='w'&& bf==1){y=by+bearHeight+1;bf=0;} if(skey=='s' && bf==1){y=by-imageHeight-1;bf=0;}if(skey=='a'&& bf==1){x=bx+bearWidth+1;bf=0;} if(skey=='d'&& bf==1){x=bx-imageWidth-1;bf=0;}
	
	//drawing flower 1
	for( fl1=x;fl1<=(imageWidth+x);fl1++)
        {for(fl2=y;fl2<=(imageHeight+y);fl2++){
        if((fl1>=x6 && fl1<=(budWidth+x6))&& (y>=y6 && y<=(budHeight+y6)))
        {
		flagf=false;
		break;
        }
        }}
	if(flagf==true){score1=score+100;
		g.drawImage(bud,x6,y6, null);
	}
	else
	{
	g.drawImage(flower,x6,y6, null);
	
	}/*if(flowerc==1)fwl="1.png";if(flowerc==2)fwl="2.png";if(flowerc==3)fwl="3.png";if(flowerc==4)fwl="4.png";if(flowerc==5)fwl="5.png";if(flowerc==6)flowerc=1;
	g.drawImage(fwl1,flx,fly, null);*//*System.out.println(1);
	g.drawImage(fw2,flx,fly, null);System.out.println(2);
		
	g.drawImage(fw3,flx,fly, null);System.out.println(3);
		
	g.drawImage(fw4,flx,fly, null);System.out.println(4);
		
	g.drawImage(fw5,flx,fly, null);System.out.println(5);*/
	//drawing flower 2
	for( fl1=x;fl1<=(imageWidth+x);fl1++)
        {for(fl2=y;fl2<=(imageHeight+y);fl2++){
        if((fl1>=fx2 && fl1<=(budWidth+fx2))&& (y>=fy2 && y<=(budHeight+fy2)))
        {
		flagfl=false;
		break;
        }
        }}
	if(flagfl==true){score1=score+100;
		g.drawImage(bud,fx2,fy2, null);
	}
	else
	{
	g.drawImage(flower,fx2,fy2, null);
	
	}

Rectangle2D rect1 = new Rectangle2D.Float(1000.0f,10.0f,wl,40.0f);
	g2.draw(rect1);
	g2.setPaint(Color.RED);g.drawString("LIFE",950,20);
	g2.fill(rect1);//System.out.println(wl);
	if(wl <= 0.1f)
	{g.drawImage(over,0,0,null);
                System.out.println("over");
		System.exit(0);
        }
	if(count==0 )
	{
                  System.out.println("over");JOptionPane.showMessageDialog( null, " GAME OVER ");System.exit(0);
	}
        score = (int)(wr+wl);
        str1= String.valueOf(score1);   
        g.drawString("SCORE",450,30);g.drawString(str1,500,30);
	if(d.getTime()- starttime>2000)
	{
		wr=wr-1.0f;
		starttime=d.getTime();
	}if(wr==0.0f){g.drawImage(over,0,0,null);
                System.out.println("over");
		System.exit(0);
        }
	Rectangle2D rect = new Rectangle2D.Float(1150.0f,10.0f,wr,40.0f );
	g2.draw(rect);
	g2.setPaint(Color.BLUE);g2.fill(rect);g.drawString("TIME",1110,20);if(wr==0.0f)count=0;
	//JOptionPane.showMessageDialog( null, " GAME OVER you won ");System.exit(0);}
	/*for(xb=x;xb<=x+imageWidth;xb++)	
	{if(xb>1400)
		boundry=1;break;}
	if(boundry==1)
		x=x-imageWidth;
	for(yb=y;yb<=y+imageHeight;yb++)	
	{if(yb>1000)
		boundry1=1;break;}
	if(boundry1==1)
		y=y-imageHeight;*/
	//if(won==1)
	if(finish==true)
	{
		//int imageWidth = image.getWidth(this);
	//int imageHeight = image.getHeight(this);
	//g.drawImage(final1,0,0,null);g.drawImage(image,x,y,null);//reaching castle
	for( sx2=x; sx2<=(imageWidth+x);sx2++)
        {for(sy2=y;sy2<=(imageHeight+y);sy2++){
        if((sx2>=cx && sx2<=(100+cx))&& (y>=cy && y<=(110+cy)))
        {if(won==1)cf=1;
		break; 
        }
        }}
	if(cf==1)
	{g.drawImage(wong,0,0,null);System.out.println("won");}	}flowerc++;}}
        repaint();
        }
	private Image image,hsun,bush,w1,spider,bgimage,bear,star,bud,flower,castle,heart,key,bbush,final1,over,snake,fwl1,bug,wong,front,image1;
}

