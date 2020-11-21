package poo.anarquia.parkour;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel
{
    Bola bl;
    Quadrado qd;
    Oval ov;
    Retangulo rt;

    private int largura = 128, altura = 76;
    private static int escala;

    private int posX = (int) Math.floor(Math.random() * largura/1.5);
    private int posY = (int) Math.floor(Math.random() * altura/1.5);
    private int velX = (int) Math.floor(Math.random() * 5) + 1;
    private int velY = (int) Math.floor(Math.random() * 5) + 1;

    private int diametro = (int) Math.floor(Math.random() * 30) + 30;

    private static int velocidade;
    private static int numColisoes = 0;
    private static int maxX, maxY;

    // 0 - Quadrado, 1 - Bola, 2 - Retangulo, 3 - Oval
    private static int forma;

    private Color corFundo;
    private static final Color corFundoInicial = Color.BLACK;

    private Color corFigura;
    private static final Color corFiguraInicial = Color.WHITE;

    private boolean colidiu = false;

    private Timer m_timer;

    Game(int escala)
    {
        this.setSize(largura * escala, altura * escala);

    }

    public void setNumColisoes()
    {
        this.numColisoes++;
    }
    public int getNumColisoes()  { return numColisoes; }

    

    public void setDiametro() {
        this.diametro = (int) Math.floor(Math.random() * 40) + 30;;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setForma()
    {
        this.forma = (int) Math.floor(Math.random() * 4);
    }
    public int getForma()
    {
        return forma;
    }

    public void setVelocidade()
    {
        this.velocidade = (int) Math.floor(Math.random() * 4) + 2;
    }
    public int getVelocidade()
    {
        return velocidade;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }


    public void movimento()
    {
        setLimites(getWidth(), getHeight());

        this.posX += velX;
        this.posY += velY;

        if(posX+velX < 0 && !colidiu)
        {
            velX = 1;
            posX = velocidade;
            colidiu = true;
        }
        else if ((posX + velX) > maxX && !colidiu)
        {
            velX = -1;
            posX = maxX - velocidade;
            colidiu = true;
        }
        else if ((posY + velY) < 0 && !colidiu)
        {
            velY = 1;
            posY = velocidade;
            colidiu = true;
        }
        else if((posY + velY) > maxY && !colidiu)
        {
            velY = -1;
            posY = maxY - velocidade;
            colidiu = true;
        }


        if(colidiu)
        {
            setNumColisoes();
            setCorFundo();
            setCorFigura();
            setForma();
            setVelocidade();
            setDiametro();
            setFormas();

            System.out.println(getNumColisoes()+"\n("+getPosX()+", "+getPosY()+")");

            //reset
            colidiu = false;
        }
    }

    public void setLimites(int largura,  int altura) {
        maxX = largura  - getDiametro();
        maxY = altura - getDiametro();
    }

    public void setAnimation(boolean turnOnOff)
    {
        if (turnOnOff) {
            m_timer.start();
        } else {
            m_timer.stop();
        }
    }

    public void setFormas()
    {
        this.bl = new Bola(diametro);
        this.rt = new Retangulo(diametro);
        this.qd = new Quadrado(diametro);
        this.ov = new Oval(diametro);

    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        if(getForma() == 0) // Quadrado
        {
            g.fillOval(posX,posY, qd.getLado(), qd.getLado());
        }
        else if (getForma() == 1) // Retangulo
        {
            g.fillRect(posX,posY, rt.l, rt.L);
        }
        else if (getForma() == 2) // Oval
        {
            g.fillOval(posX, posY, ov.getL(), ov.getH());
        }
        else // Bola
        {
            g.fillOval(posX,posY, bl.getDiametro(),bl.getDiametro());
        }

    }
}
