package poo.anarquia.parkour;

public class Oval
{
    int l, h;

    public Oval(int tamanho)
    {
        this.l = tamanho;
        this.h = (int)(tamanho/2);
    }

    public int getH() {
        return h;
    }

    public int getL() {
        return l;
    }
}
