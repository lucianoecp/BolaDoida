import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class App extends JPanel
{
    private int numColisoes = 1;

    public static int size = (int) Math.floor(Math.random() * 50) + 30;

    static int vel = (int) Math.floor(Math.random() * 5) + 1;


    //Bola com parametros aleatorios:
    int x = (int) Math.floor(Math.random() * (getWidth()/2));
    int y = (int) Math.floor(Math.random() * (getHeight()/2));
    int vx = (int) Math.floor((Math.random() * 5) +1);
    int vy = (int) Math.floor((Math.random() * 5) +1);

    boolean colidiu = false;

    private void moveBola (JFrame frame)
    {
        Random gerador = new Random();

        if ((x + vx < 0) && !colidiu)
        {
            vx = 1;
            x = 0;
            colidiu = true;
        }

        else if ((x + vx > getWidth() - (size-1) ) && !colidiu)
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

        else if ((y + vy > getHeight()  - (size-1)) && !colidiu)
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
            System.out.println("Número de colisões: "+(numColisoes++));
            alterarCores(frame);
            size = (int) Math.floor(Math.random() * 50) + 30;
            vel = (int) Math.floor(Math.random() * 5) + 1;
            colidiu = false;
        }
    }

    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.BLUE);
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

        while(n1==n2){
            n1 = gerador.nextInt(12);
            n2 = gerador.nextInt(12);
        }

        this.setBackground(colors[n1]);
        this.setForeground(colors[n2]);
    }

    public static void main(String[] args) throws InterruptedException
    {
        JFrame area = new JFrame("Bola Maluca");
        App app = new App();

        area.add(app);
        area.setSize(640, 480);
        area.setVisible(true);
        area.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true)
        {
            app.moveBola(area);
            app.repaint();
            Thread.sleep(vel);
        }
    }
}

