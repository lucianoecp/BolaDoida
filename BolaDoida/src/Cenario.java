package poo.anarquia.parkour;

import javax.swing.*;
import java.awt.*;

public class Cenario extends JFrame
{

    private static boolean PlayON = false;

    public Cenario(Game g, Relatorio r)
    {
        super("Bola Doida");

        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.YELLOW);

        r.setPreferredSize(new Dimension(160, 40));
        g.setPreferredSize(new Dimension(640, 400));


        this.setLayout(new FlowLayout());


        this.add(r);
        this.add(g);


        this.setVisible(true);

    }
}