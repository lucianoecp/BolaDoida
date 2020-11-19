import javax.swing.*;

public class Main {
   
    public static void main(String[] args) throws InterruptedException
    {   
        JFrame area = new JFrame("Bola Doida");
        Arena figura = new Arena(640,480);
        Game app = new Game(area);
       
        area.add(app);
        area.setSize(figura.getLargura(), figura.getAltura());
        area.setVisible(true);
        area.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true)
        {
            app.moveFigura(area);
            app.repaint();
            Thread.sleep(app.getVel());
        }
}
}
