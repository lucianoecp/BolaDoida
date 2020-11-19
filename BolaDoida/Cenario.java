public class Cenario
{
    private int altura;
    private int largura; 

    public Cenario(int largura, int altura){
        
        this.altura = altura;
        this.largura = largura;
    }
    public int getAltura()
    {
        return this.altura;
    } 
    public int getLargura(){
        return this.largura;
    }
    public void setAltura(int altura)
    {
        this.altura = altura;
    }
    public void setLargura(int largura)
    {
        this.largura = largura;
    }
 }