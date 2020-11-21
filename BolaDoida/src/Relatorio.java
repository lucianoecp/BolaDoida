package poo.anarquia.parkour;

import javax.swing.*;
import java.awt.*;

public class Relatorio extends JPanel
{
    JLabel lb;
    JLabel txt;


    public Relatorio()
    {
        lb = new JLabel("Número de colisoes: ");
        txt = new JLabel("0");
        this.setLayout(new BorderLayout());
        this.add(lb, BorderLayout.NORTH);
        this.add(txt, BorderLayout.SOUTH);
        this.setSize(new Dimension(640, 50));
        this.setOpaque(false);
    }

    public void setTxtCordenadas(int posX, int posY) 
    {
        this.lb.setText("Posição: ("+posX +", "+posY+")");
    }

    public void setTxtNumColisoes(int num) {
        this.txt.setText("Número de colisões: " + Integer.toString(num));
    }
}