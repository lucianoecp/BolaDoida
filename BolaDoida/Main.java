import javax.swing.*;

public class Main {
   
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) throws InterruptedException
    {   
        JFrame area = new JFrame("Bola Doida");
        Figura figura = new Figura(640,480);
        Movimento app = new Movimento(area);
       
        area.add(app);
        area.setSize(figura.getLargura(), figura.getAltura());
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
