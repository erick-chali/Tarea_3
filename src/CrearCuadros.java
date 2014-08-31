import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by erickchali on 8/29/14.
 */
public class CrearCuadros extends JFrame implements ActionListener {
    JPanel p1,p2,p3,sp1,sp2;
    String[] dimensiones = {"Selecciona una dimension","4","5","6","7","8","9","10"};
    JComboBox squareSize;
//    JButton[][] cajitas;
    JTextField[][] cajitas;
    JLabel[][] lienzos;
    JButton pintar,limpiar;
    JLabel titulo,demo;
    int numCom;
    public CrearCuadros(){
        super("Pintar cuadritos");
        this.setLayout(new FlowLayout());
        squareSize = new JComboBox(dimensiones);
        squareSize.setSelectedIndex(1);
        squareSize.addActionListener(this);

        titulo = new JLabel("Dimension de la matriz cuadrada");

        pintar = new JButton("Colorear");
        pintar.addActionListener(this);

        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setPreferredSize(new Dimension(300, 400));
//        p1.setBackground(Color.darkGray);

        p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.setPreferredSize(new Dimension(300, 400));
//        p2.setBackground(Color.darkGray);

        p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p3.setPreferredSize(new Dimension(500, 100));

        p3.add(titulo);
        p3.add(squareSize);
        p3.add(pintar);



        this.add(p3);
        this.add(p1);
        this.add(p2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        JComboBox cb = (JComboBox)e.getSource();
        String dimen = (String)squareSize.getSelectedItem();
        if(e.getSource()==squareSize){
            try{

                int n=0,w=0,h=0;
                sp1 = new JPanel();
                sp1.setLayout(new FlowLayout());
                sp2 = new JPanel();
                sp2.setLayout(new FlowLayout());
                sp1.removeAll();
                sp1.repaint();
                sp2.removeAll();
                sp2.repaint();
                p1.removeAll();
                p1.repaint();
                p2.removeAll();
                p2.repaint();

                n = Integer.parseInt(dimen);
                numCom = n;
                w=(28*(n+1));
                h=(30*(n+1));
                sp1.setPreferredSize(new Dimension(w,h));
                cajitas = new JTextField[n][n];
                for (int x =0;x<n;x++){
                    for (int y =0;y<n;y++){
                        cajitas[x][y] = new JTextField();
                        cajitas[x][y].setPreferredSize(new Dimension(25, 25));
                        sp1.add(cajitas[x][y]);
                        sp1.validate();
                        sp1.repaint();
                    }
                }
                p1.add(sp1);
                p1.validate();
                p1.repaint();

                sp2.setPreferredSize(new Dimension(w,h));
                lienzos = new JLabel[n][n];
                for (int v =0;v<n;v++){
                    for (int z =0;z<n;z++){
                        lienzos[v][z] = new JLabel(" ");
                        lienzos[v][z].setPreferredSize(new Dimension(25, 25));
                        lienzos[v][z].setBackground(Color.white);
                        lienzos[v][z].setOpaque(true);

                        sp2.add(lienzos[v][z]);
                        sp2.validate();
                        sp2.repaint();
                    }
                }
                p2.add(sp2);
                p2.validate();
                p2.repaint();
                this.validate();
                this.repaint();
            }catch(Exception ex){

            }
        }else if(e.getSource()==pintar){
            for(int x=0 ; x < numCom ; x++){
                for(int y=0 ; y < numCom ; y++){
                    try{
                        int comparacion = Integer.parseInt(cajitas[x][y].getText().toString());
                        if(comparacion == 0){
                            lienzos[x][y].setBackground(Color.white);
                            lienzos[x][y].setOpaque(true);
                        }else if(comparacion == 1){
                            lienzos[x][y].setBackground(Color.red);
                            lienzos[x][y].setOpaque(true);
                        }else if(comparacion == 2){
                            lienzos[x][y].setBackground(Color.blue);
                            lienzos[x][y].setOpaque(true);
                        }else if(comparacion == 3){
                            lienzos[x][y].setBackground(Color.yellow);
                            lienzos[x][y].setOpaque(true);
                        }else if(comparacion > 3){
                            lienzos[x][y].setBackground(Color.green);
                            lienzos[x][y].setOpaque(true);
                        }
                    }catch(Exception ex){
                        lienzos[x][y].setBackground(Color.black);
                        lienzos[x][y].setOpaque(true);
                    }

                }

            }
        }
    }
}
