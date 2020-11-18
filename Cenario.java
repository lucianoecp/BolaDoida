import javax.swing.*;
public class Cenario extends JPanel{
    private JFrame area;
    public Cenario(String name){
        this.area =new JFrame(name);
    }
    public void adicionarObjeto(App app){
        this.area.add(app);
    }
    public void setSize(int height,int width){
        this.area.setSize(width, height);
    }   
    public void setVisible(boolean visibilidade){
        this.area.setVisible(true);
    }
    public void setDefaultCloseOperation(int operation){
        this.area.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
    
}
