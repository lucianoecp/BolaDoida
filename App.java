import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class App extends JPanel {
        
        private int numColisoes = 1;

        // lista de cores:
        private static final Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
                        Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE,
                        Color.YELLOW };

        public Color sorteiaCor() {
                Random gerador = new Random();
                int numAleatorio = gerador.nextInt(12);
                // getContentPane().setBackground(colors[numAleatorio]);

                return colors[numAleatorio];
        }

        public void alteraCorArena()
        {
            Random gerador = new Random();
            int numAleatorio = gerador.nextInt(12);
            this.setBackground(colors[numAleatorio]);
    
        }

        public static int size = (int) Math.floor(Math.random() * 50) + 30;

        // Bola com parametros aleatorios:
        int x = (int) Math.floor(Math.random() * 320 + size);
        int y = (int) Math.floor(Math.random() * 260 + size);
        int vx = (int) Math.floor((Math.random() * 5) +1);
        int vy = (int) Math.floor((Math.random() * 5) +1);

        private void moveBola(JFrame frame) {

                if (x + vx < 0) {
                        vx = 1;
                        alteraCorArena();
                        System.out.println("Colidiu! "+numColisoes++);
                        size = (int) Math.floor(Math.random() * 50) + 30;
                }

                else if (x + vx > getWidth() - size) {
                        vx = -1;
                        alteraCorArena();
                        System.out.println("Colidiu! "+numColisoes++);
                        size = (int) Math.floor(Math.random() * 50) + 30;
                }

                else if (y + vy < 0) {

                        vy = 1;
                        alteraCorArena();
                        System.out.println("Colidiu! "+numColisoes++);
                        size = (int) Math.floor(Math.random() * 50) + 30;
                }

                else if (y + vy > getHeight() - size) {
                        vy = -1;
                        alteraCorArena();
                        System.out.println("Colidiu! "+numColisoes++);
                        size = (int) Math.floor(Math.random() * 50) + 30;

                } else {
                        x += vx;
                        y += vy;

                }
        }

        @Override
        public void paint(Graphics g) {
                g.setColor(Color.BLUE);
                super.paint(g);
                g.fillOval(x, y, size, size);
        }

        public static void main(String[] args) throws InterruptedException {
                JFrame area = new JFrame("Bola Maluca");
                App app = new App();
                // app.setForeground(Color.BLUE);
                // app.setBackground(Color.BLACK);

                area.add(app);
                area.setSize(640, 480);
                area.setVisible(true);
                area.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                while (true) {
                        app.moveBola(area);
                        app.repaint();
                        Thread.sleep((int) Math.floor(Math.random() * 5)+1);
                }
        }
}
