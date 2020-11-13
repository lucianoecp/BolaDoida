import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class App extends JPanel
{

    public static void main(String[] args) throws InterruptedException
    {
        JFrame area = new JFrame("Bola Maluca");
        App app = new App();

        area.add(app);
        area.setSize(640, 480);
        area.setVisible(true);
        area.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
}