package poo.anarquia.parkour;

public class Retangulo
{
    int l, L;

    public Retangulo(int tamanho)
    {
        this.l = (int) (tamanho/1.5);
        this.L = tamanho;
    }

    public int getLadoMenor ()
    {
        return l;
    }

    public int getLadoMaior ()
    {
        return L;
    }
}