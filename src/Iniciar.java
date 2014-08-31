import javax.swing.*;

/**
 * Created by erickchali on 8/29/14.
 */
public class Iniciar {

    public static void main(String args[]){
        CrearCuadros cc = new CrearCuadros();
        cc.setSize(750,500);
        cc.setResizable(false);
        cc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cc.setLocationRelativeTo(null);
        cc.setVisible(true);
    }
}
