public class Main {
    public static void main(String[] args) throws InterruptedException
    {
        Cenario cenario = new Cenario("Bola Doida");
        App app = new App();
        
        cenario.add(app);
        cenario.setSize(640, 480);
        cenario.setVisible(true);
        cenario.setDefaultCloseOperation();

        while(true)
        {
            app.moveBola(area);
            app.repaint();
            Thread.sleep(vel);
        }
}
