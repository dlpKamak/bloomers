import java.io.IOException;
import javax.swing.*;                                                                                                                                       
import java.awt.*;                                                                                                                                          
import java.awt.event.*;          
import java.io.File;
import javax.imageio.ImageIO;
class Front extends JFrame implements MouseListener
{   
    public int x,y;
    public Front() throws IOException
    {
       
        setTitle("Front");
        setSize(700, 1400);
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
                    System.out.println("Start Game");
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
  
}
class ImageComponent extends JComponent
{
public ImageComponent()
	{
	try
	{ image = ImageIO.read(new File("Front.bmp"));
        }
        catch (IOException e)
	{
		e.printStackTrace();
	}
        
        }
    @Override
public void paintComponent(Graphics g)
{
    Graphics2D g2=( Graphics2D)g;
    g.drawImage(image,0,0,null);
}  
private Image image;
}
