package poo.anarquia.parkour;

public class Main
{

    public static void main(String[] args) throws InterruptedException
    {
        Game app = new Game(5);
        Relatorio rel = new Relatorio();
        Cenario area = new Cenario(app, rel);

        while(true)
        {
            app.movimento();
            app.repaint();
            rel.setTxtNumColisoes(app.getNumColisoes());
            rel.setTxtCordenadas(app.getPosX(), app.getPosY());
            Thread.sleep(app.getVelocidade());
        }
    }
}
