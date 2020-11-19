import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
   
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) throws InterruptedException
    {   
        JFrame area = new JFrame("Bola Doida");
        Bola bola = new Bola(640,480);
        Movimento app = new Movimento(area);
       
        area.add(app);
        area.setSize(bola.getLargura(), bola.getAltura());
        area.setVisible(true);
        area.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true)
        {
            app.moveBola(area);
            app.repaint();
            Thread.sleep(app.getVel());
        }
}
}
