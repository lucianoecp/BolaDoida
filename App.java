import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class App extends JPanel
{
    private int numColisoes = 1;

    // lista de cores:
    private static final Color[] colors = {
            Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
            Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
            Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };

    public Color sorteiaCor()
    {
        Random gerador = new Random();
        int numAleatorio = gerador.nextInt(12);

        return colors[numAleatorio];
    }

    public void alteraCorArena()
    {
        Random gerador = new Random();
        int numAleatorio = gerador.nextInt(12);
        this.getRootPane().setBackground(colors[numAleatorio]);

    }

    public static int size = (int) Math.floor(Math.random() * 50) + 30;


    //Bola com parametros aleatorios:
    int x = (int) Math.floor(Math.random() * 320 + size);
    int y = (int) Math.floor(Math.random() * 260 + size);
    int vx = (int) Math.floor((Math.random() * 5) +1);
    int vy = (int) Math.floor((Math.random() * 5) +1);

    private void moveBola (JFrame frame)
    {
        Random gerador = new Random();

        if (x + vx < 0)
        {
            alterarCores(frame);
            size = (int) Math.floor(Math.random() * 50) + 30;

            vx = 1;
            System.out.println("Colidiu! "+numColisoes++);

            
        }

        else if (x + vx > getWidth() - size )
        {
            alterarCores(frame);
            size = (int) Math.floor(Math.random() * 50) + 30;

            vx = -1;
            System.out.println("Colidiu! "+numColisoes++);

        }

        else if (y + vy < 0) {

            alterarCores(frame);
            size = (int) Math.floor(Math.random() * 50) + 30;

            vy = 1;
            System.out.println("Colidiu! "+numColisoes++);

        }

        else if (y + vy > getHeight()  - size)
        {
            alterarCores(frame);
            size = (int) Math.floor(Math.random() * 50) + 30;

            vy = -1;
            System.out.println("Colidiu! "+numColisoes++);

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
        JFrame area = new JFrame("Bola Doida");
        App app = new App();

        area.add(app);
        area.setSize(640, 480);
        area.setVisible(true);
        area.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        while(true)
        {
            app.moveBola(area);
            app.repaint();
            Thread.sleep((int) Math.floor(Math.random() * 5)+1);
        }
    }
}
