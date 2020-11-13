import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class App extends JPanel
{
  
    public static int size = 50;


    //Bola com parametros aleatorios:
    int x =0;
    int y =0;
    int vx = 5;
    int vy = 5;

    private void moveBola (JFrame frame)
    {
        
        if (x + vx < 0)
        {
            vx = 1;          
        }

        else if (x + vx > getWidth() - size )
        {
            vx = -1;
        }

        else if (y + vy < 0) {

            vy = 1;
        }

        else if (y + vy > getHeight()  - size)
        {
            vy = -1;

        }else
        {
            x += vx;
            y += vy;

        }
    }

    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.BLUE);
        super.paint(g);
        g.fillOval(x,y,size,size);
    }


    public static void main(String[] args) throws InterruptedException
    {
        JFrame area = new JFrame("Bola Maluca");
        App app = new App();
        // app.setForeground(Color.BLUE);
        // app.setBackground(Color.BLACK);

        area.add(app);
        area.setSize(640, 480);
        area.setVisible(true);
        area.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        while(true)
        {
            app.moveBola(area);
            app.repaint();
            Thread.sleep(5);
        }
    }
}