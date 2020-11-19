import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Movimento extends JPanel
{
    private int numColisoes = 0;
    private static int size = (int) Math.floor(Math.random() * 50) + 30;
    private static int vel = (int) Math.floor(Math.random() * 5) + 1;
    private int x = (int) Math.floor(Math.random() * (getWidth()/2));
    private int y = (int) Math.floor(Math.random() * (getHeight()/2));
    private int vx = (int) Math.floor((Math.random() * 5) +1);
    private int vy = (int) Math.floor((Math.random() * 5) +1);
    private boolean colidiu = false;
    private JFrame frame;
    public Movimento(JFrame frame)
    {
        this.frame = frame;
    }
    public int getVel(){
        return this.vel;
    }
    public void moveBolaDemo(JFrame frame)
    {
        x =  getWidth() - (size + 1);
        y =  getHeight()  - (size + 1);
    }

    public void moveBola (JFrame frame)
    {

        if ((x + vx < 0) && !colidiu)
        {
            vx = 1;
            x = 0;
            colidiu = true;
        }

        else if ((x + vx > getWidth() - (size + 1) ) && !colidiu)
        {
            vx = -1;
            x = getWidth() - (size+1);
            colidiu = true;
        }

        else if ((y + vy < 0)  && !colidiu) {
            vy = 1;
            y = 0;
            colidiu = true;
        }

        else if ((y + vy > getHeight() - (size + 1)) && !colidiu)
        {
            vy = -1;
            y = getHeight() - (size+1);
            colidiu = true;

        }else
        {
            x += vx;
            y += vy;
        }

        if (colidiu)
        {
            System.out.println("Número de colisões: "+(++numColisoes));
            alterarCores(frame);
            size = (int) Math.floor(Math.random() * 50) + 30;
            vel = (int) Math.floor(Math.random() * 5) + 1;
            colidiu = false;
        }
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.fillOval(x,y,size,size);
    }

    public void alterarCores(JFrame frame)
    {
        int n1=0, n2=0;
        Random gerador = new Random();

        // lista de cores:
       Color[] colors = {
                Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
                Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
                Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
        };

        // Garantir dois numeros distintos
        while(n1==n2){
            n1 = gerador.nextInt(13);
            n2 = gerador.nextInt(13);
        }

        this.setBackground(colors[n1]);
        this.setForeground(colors[n2]);
    }
    }

